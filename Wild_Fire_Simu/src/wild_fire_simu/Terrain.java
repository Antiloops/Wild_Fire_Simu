/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wild_fire_simu;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author louis
 */
public class Terrain {
    
    private Random random = new Random();
    
    public Case[][] Grille_Terrain; // Grille du terrain // type sera suremment modifié
    public int Temps_Terrain;  //Ittération de la partie
    public String Densite_Terrain; //Dentsité de vegetation du terrain
    
    
    public Terrain(int Temps_Terrain,String Densite_Terrain){ //Constructeur
        this.Temps_Terrain = Temps_Terrain;
        this.Densite_Terrain = Densite_Terrain;
    }
    
    // methode permettant de convertir le type de densité en une probabilité expoitable plus tard
    public int Conversion(String densite){ // methode permettant de convertir le type de densité en une probabilité expoitable plus tard
        int probabilite=0;
        if("Clairsemée".equalsIgnoreCase(densite)){ // comment ne plus se préoccuper des majuscules ?
            probabilite= 50; 
        }else if ("Espacée".equalsIgnoreCase(densite)){
            probabilite= 75;
        }else if("Touffue".equalsIgnoreCase(densite)){
            probabilite=90;
        }else if("Continue".equalsIgnoreCase(densite)){
            probabilite= 100;
        }
        return probabilite;
    }
    
    
    // cette méthode initialise un tableau de dimension longueur x largeur dans lequel on fixe l'humidité de chaque case
    public void CreaTableau(int humidite, int longueur, int largeur){ 
        Case[][] tableau;
        boolean ValCorrect = false; //Booleen qui est faux quand les 
        while(ValCorrect == false){
            try{
                ValCorrect = true;
                tableau=new Case[longueur][largeur];
                for (int i=0;i<longueur;i++){ 
                    for(int j=0;j<largeur;j++){
                        Case temp = new Case(humidite);
                        tableau[i][j] = temp;
                    }
                }
            }catch(ArrayIndexOutOfBoundsException ex){ //Si la boucle for dépasse le nombre de case de la grille, on envoit un message d'erreur
                ValCorrect = false;
                System.out.println(" CreaTableau() -> Un problème d'indice est survenu");
                throw ex;
            }if(ValCorrect){
                System.out.println(" CreaTableau() -> La tableau a bien été créé");
            }
            this.Grille_Terrain = tableau;
        }
    }
    
    //Methode qui permet d'initialiser la végétation du terrain
    public void Affec_Vege(int Proba){
        boolean AffectCorrect = false;
        try{
            AffectCorrect = true;
            for(int i=0;i<this.Grille_Terrain.length;i++){
                for(int j=0;j<this.Grille_Terrain[0].length;j++){
                    boolean Vege = getBooleenRandom(Proba);
                    Case Temp = this.Grille_Terrain[i][j];
                    Temp.Vegetation_Case = Vege;
                }
            }
        }catch(ArrayIndexOutOfBoundsException ex){ //Si la boucle for dépasse le nombre de case de la grille, on envoit un message d'erreur
            AffectCorrect = false;
            System.out.println(" Affec_Vege() -> Un problème d'indice est survenu");
            throw ex;
        }if(AffectCorrect){
            System.out.println(" Affec_Vege() -> La Vegetation a bien été Affectée à la grille");
        }
    }
    
    public void Depart_Feu(int nb_depart){// cette méthode initialise la/les  position du feu 
        Random random=new Random();
        int longueur = this.Grille_Terrain.length;;
        int largeur = this.Grille_Terrain[0].length;;
        for(int i=0;i<nb_depart;i++){
            int x=random.nextInt(longueur);
            int y=random.nextInt(largeur); 
            if (this.Grille_Terrain[x][y].Combustion_Case != 1 && this.Grille_Terrain[x][y].Vegetation_Case == true){
                this.Grille_Terrain[x][y].Combustion_Case = 1;
                this.Grille_Terrain[x][y].Brulure_Case = "A";
                this.Grille_Terrain[x][y].Vegetation_Case = false;
            }
        }
    }
    
    //Methode permettant de réaliser la propagation du feu
    public void Propa_Feu(int[][] Repartition,int Vent_Force){
        for(int i=0;i<this.Grille_Terrain.length;i++){ //On parcourt la grille du terrain
            for(int j=0;j<this.Grille_Terrain[0].length;j++){
                
                boolean Condamne; //Condition de propagation du feu
                int Position_X = i-3; //Coordonnees de la case sur la grille correspondant à la première de la grille de propagation
                int Position_Y = j-3;
                
                if(this.Grille_Terrain[i][j].Brulure_Case.equalsIgnoreCase("A")){ //On verifie si la case est en état : enflammé 
                    for(int a=0;a<Repartition.length;a++){  //On parcourt la grille de Repartion pour avoir les probabilités de combustion d'une case
                        Position_X++;
                        for(int b=0;b<Repartition[0].length;b++){
                            Position_Y++;
                            double Proba_Case = 0;
                            try{
                                if(this.Grille_Terrain[Position_X][Position_Y].Vegetation_Case == true && this.Grille_Terrain[Position_X][Position_Y].Condamne_Case == false){
                                    Proba_Case = 0.5*(1+2*Vent_Force)*(this.Grille_Terrain[Position_X][Position_Y].Humidite_Case/100)*(Repartition[a][b]/100); //Calcul de la probabilite de combustion
                                }
                            }catch(ArrayIndexOutOfBoundsException ex){
                                System.out.println("Erreur d'indice");
                                throw ex;
                            }
                            Condamne = getBooleenRandomDouble(Proba_Case); //On teste si la case va bruler
                            if(Condamne = true){
                                this.Grille_Terrain[Position_X][Position_Y].Condamne_Case = true;
                            }
                        }         
                    }
                
                if(this.Grille_Terrain[i][j].Brulure_Case.equalsIgnoreCase("BC")){ //On verifie si la case est en état : brulé chaud
                    for(int a=0;a<Repartition.length;a++){  //On parcourt la grille de Repartion pour avoir les probabilités de combustion d'une case
                        Position_X++;
                        for(int b=0;b<Repartition[0].length;b++){
                            Position_Y++;
                            double Proba_Case = 0;
                            try{
                                if(this.Grille_Terrain[Position_X][Position_Y].Vegetation_Case == true && this.Grille_Terrain[Position_X][Position_Y].Condamne_Case == false){
                                    Proba_Case = (this.Grille_Terrain[Position_X][Position_Y].Humidite_Case/100)*(Repartition[a][b]/100); //Calcul de la probabilite de combustion
                                }
                            }catch(ArrayIndexOutOfBoundsException ex){
                                System.out.println("Erreur d'indice");
                                throw ex;
                            }
                            Condamne = getBooleenRandomDouble(Proba_Case); //On teste si la case va bruler
                            if(Condamne = true){
                                this.Grille_Terrain[Position_X][Position_Y].Condamne_Case = true;
                            }
                        }         
                    }
                }
                    
                }
                
            }
        }
        Iteration();
    }
    
    
    /*public void Propa_Feu_Nul(){ // méthode qui propage le feu à chaque itération pour un vent nul
        boolean crame; // ce boolean est vrai quand une case prend feu, faux sinon
        for (int i=0;i<this.Grille_Terrain.length;i++){
            for (int j=0;j<this.Grille_Terrain[0].length;j++){ // on parcours le tableau
                
                if (this.Grille_Terrain[i][j].Vegetation_Case!=false && this.Grille_Terrain[i][j].Combustion_Case==1){ // on vérifie que la case est crammable et qu'elle soit en feu
                  
                    for (int a=-1;a<2;a++){ // on fait le test pour les 3 cases de 1% du haut
                        crame=getBooleenRandom(1);
                        if (crame==true){
                            this.Grille_Terrain[i-2][j+a].Condamne_Case=true; // si le test est réussi la case est condamnée
                        }
                    }
                    for (int b=-1;b<2;b++){ // on fait le test pour les 3 cases de 1% de gauche
                        crame=getBooleenRandom(1);
                        if (crame==true){
                            this.Grille_Terrain[i+b][j-2].Condamne_Case=true; 
                        }
                    }
                    for (int c=-1;c<2;c++){ // on fait le test pour les 3 cases de 1% du bas
                        crame=getBooleenRandom(1);
                        if (crame==true){
                            this.Grille_Terrain[i+2][j+c].Condamne_Case=true; 
                        }
                    }
                    for (int d=-1;d<2;d++){ // on fait le test pour les 3 cases de 1% de droite
                        crame=getBooleenRandom(1);
                        if (crame==true){
                            this.Grille_Terrain[i+d][j+2].Condamne_Case=true; 
                        }
                    }
                    
                    // on fait le test pour les cases avec 20% de risque
                    
                    crame=getBooleenRandom(20); 
                    if (crame==true){
                            this.Grille_Terrain[i-1][j-1].Condamne_Case=true; //case en haut à gauche
                        }
                    crame=getBooleenRandom(20); 
                    if (crame==true){
                            this.Grille_Terrain[i+1][j-1].Condamne_Case=true; //case en bas à gauche
                        }
                    crame=getBooleenRandom(20); 
                    if (crame==true){
                            this.Grille_Terrain[i+1][j+1].Condamne_Case=true; //case en bas à droite
                    }
                            crame=getBooleenRandom(20); 
                    if (crame==true){
                            this.Grille_Terrain[i-1][j+1].Condamne_Case=true; //case en haut à droite
                    }
                    
                    // on fait le test pour les cases à 30% de risque
                    
                    crame=getBooleenRandom(30); 
                    if (crame==true){
                            this.Grille_Terrain[i-1][j].Condamne_Case=true; //case en haut
                    }
                    crame=getBooleenRandom(30); 
                    if (crame==true){
                            this.Grille_Terrain[i][j-1].Condamne_Case=true; //case à gauche
                    }
                    crame=getBooleenRandom(30); 
                    if (crame==true){
                            this.Grille_Terrain[i+1][j].Condamne_Case=true; //case en bas
                    }
                    crame=getBooleenRandom(30); 
                    if (crame==true){
                            this.Grille_Terrain[i][j+1].Condamne_Case=true; //case à droite
                    }
                }
                    
            }
        }
    }*/
    
    //Methode renvoyant une booleen aléatoire en fonction d'un pourcentage mis en argument 
    public boolean getBooleenRandom(int Proba){
        int a;
        Random t = new Random();
        // random integers in [0, 100]
        a=t.nextInt(100);
        if (a>Proba){
            return false;
        }
        else{
            return true; 
        }
    }
    
    //Methode renvoyant une booleen aléatoire en fonction d'un pourcentage mis en argument !!VERSION FLOAT!!
    public boolean getBooleenRandomDouble(double Proba){
        int a;
        Random t = new Random();
        // random integers in [0, 100]
        a=t.nextInt(100);
        if (a>Proba*100){
            return false;
        }
        else{
            return true; 
        }
    }
    
    // methode qui permet de transformer les cases condamnées en cases qui brûlent, de plus les cases déjà en feu mais pas encore réduit en cendre voient leur état de combustion augmenter de 1
    public void Iteration(){
        for (int i = 0;i<this.Grille_Terrain.length;i++){
            for (int j = 0;j<this.Grille_Terrain.length;j++){
                
                if(this.Grille_Terrain[i][j].Condamne_Case == true && this.Grille_Terrain[i][j].Brulure_Case == ""){
                    this.Grille_Terrain[i][j].Combustion_Case ++;
                    this.Grille_Terrain[i][j].Vegetation_Case = false;
                    this.Grille_Terrain[i][j].Brulure_Case = "A";
                }
                
                else if(this.Grille_Terrain[i][j].Brulure_Case == "A" && this.Grille_Terrain[i][j].Combustion_Case >= 1 && this.Grille_Terrain[i][j].Combustion_Case <= 2){
                    this.Grille_Terrain[i][j].Combustion_Case ++;
                }
                
                else if(this.Grille_Terrain[i][j].Brulure_Case == "A" && this.Grille_Terrain[i][j].Combustion_Case == 3){
                    this.Grille_Terrain[i][j].Combustion_Case ++;
                    this.Grille_Terrain[i][j].Brulure_Case = "BC";
                }
                
                else if(this.Grille_Terrain[i][j].Brulure_Case == "A" && this.Grille_Terrain[i][j].Combustion_Case > 3){
                    Boolean Refroidit = getBooleenRandom(40);
                    if(Refroidit == true){
                        this.Grille_Terrain[i][j].Brulure_Case = "BF";
                    }
                }
            }
        }
    }
}
