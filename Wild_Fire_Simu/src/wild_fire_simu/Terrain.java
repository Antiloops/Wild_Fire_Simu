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
 * @author Louis SAVIGNAC et Mathis LOPEZ
 */
public class Terrain {
   //yes 
             
    private Random random = new Random();
    
    private Case[][] Grille_Terrain; // Grille du terrain // type sera suremment modifié
    private int Temps_Terrain;  //Ittération de la partie
    private String Densite_Terrain; //Dentsité de vegetation du terrain
    
    
    public Terrain(int Temps_Terrain){ //Constructeur
        this.Temps_Terrain = Temps_Terrain;
    }
    
    //Getter -> Méthodes qui retourne les attributs de la case : la vegatation, la niveau de combustion ou le risque
    public Case[][] getGrille(){
        return this.Grille_Terrain;
    }
    
    public int getTemps(){
        return this.Temps_Terrain;
    }
    
    public String getDensite(){
        return this.Densite_Terrain;
    }
    
    //Setter -> Méthodes qui modifie les attributs de la case par un argument en entrée pour : la vegetation, la combustion ou le risque
    public void setCase(Case[][] Grille_Terrain){
        this.Grille_Terrain = Grille_Terrain;
    }
    
    public void setCombustion(int Temps_Terrain){
        this.Temps_Terrain = Temps_Terrain;
    }
    
    public void setDensite(String Densite_Terrain){
        this.Densite_Terrain = Densite_Terrain;
    }
    
    // cette méthode initialise un tableau de dimension longueur x largeur dans lequel on fixe l'humidité de chaque case
    public void CreaTableau(int humidite, int longueur, int largeur){ 
        Case[][] tableau;
        boolean ValCorrect = false;         //Booleen qui est faux quand les 
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
            }catch(ArrayIndexOutOfBoundsException ex){      //Si la boucle for dépasse le nombre de case de la grille, on envoit un message d'erreur
                ValCorrect = false;
                System.out.println(" CreaTableau() -> Un problème d'indice est survenu");
                throw ex;
            }if(ValCorrect){
                System.out.println(" CreaTableau() -> La tableau a bien été créé");
            }
            this.Grille_Terrain = tableau;
        }
    }
    
    //Methode qui permet d'initialiser la végétation du terrain sans graine de génération
    public void Affec_Vege(int Repartition, int feature_size){
        float Noise_Repartition = Convertisseur(Repartition);
        boolean AffectCorrect = false;      //Variable de vérification de la bonne mise en place du programme
        OpenSimplexNoise noise = new OpenSimplexNoise();     //Création d'un objet de la classe OpenSimplexNoise
        try{    //
            AffectCorrect = true;
            for(int i=0;i<this.Grille_Terrain.length;i++){      //Parcours de la grille du terrain 
                for(int j=0;j<this.Grille_Terrain[0].length;j++){
                    double value = noise.eval(i / feature_size, j / feature_size);  //On utilise la méthode eval de OpenSimplexNoise pour retourner une valeur comprise entre -1 et 1 
                    if(value > Noise_Repartition){
                        this.Grille_Terrain[i][j].setVegetation(false);
                    }
                    if(value <= Noise_Repartition){
                        this.Grille_Terrain[i][j].setVegetation(true);
                    }
                }
            }
        }catch(ArrayIndexOutOfBoundsException ex){       //Si la boucle for dépasse le nombre de case de la grille, on envoit un message d'erreur
            AffectCorrect = false;
            System.out.println(" Affec_Vege() -> Un problème d'indice est survenu");
            throw ex;
        }if(AffectCorrect){
            System.out.println(" Affec_Vege() -> La Vegetation a bien été Affectée à la grille");
        }
    }
    
    //Methode qui permet d'initialiser la végétation du terrain avec graine de génération
    public void Affec_Vege(int Repartition, int feature_size, int Seed){
        float Noise_Repartition = Convertisseur(Repartition);
        boolean AffectCorrect = false;      //Variable de vérification de la bonne mise en place du programme
        OpenSimplexNoise noise = new OpenSimplexNoise(Seed);     //Création d'un objet de la classe OpenSimplexNoise
        try{    //
            AffectCorrect = true;
            for(int i=0;i<this.Grille_Terrain.length;i++){      //Parcours de la grille du terrain 
                for(int j=0;j<this.Grille_Terrain[0].length;j++){
                    double value = noise.eval(i / feature_size, j / feature_size);
                    if(value > Noise_Repartition){
                        this.Grille_Terrain[i][j].setVegetation(false);
                    }
                    if(value <= Noise_Repartition){
                        this.Grille_Terrain[i][j].setVegetation(true);
                    }
                }
            }
        }catch(ArrayIndexOutOfBoundsException ex){       //Si la boucle for dépasse le nombre de case de la grille, on envoit un message d'erreur
            AffectCorrect = false;
            System.out.println(" Affec_Vege() -> Un problème d'indice est survenu");
            throw ex;
        }if(AffectCorrect){
            System.out.println(" Affec_Vege() -> La Vegetation a bien été Affectée à la grille");
        }
    }
    
    //Méthode initialisant la/les  position du feu 
    public void Depart_Feu(int nb_depart){      
        Random random=new Random();
        int longueur = this.Grille_Terrain.length;;
        int largeur = this.Grille_Terrain[0].length;;
        for(int i=0;i<nb_depart;i++){
            int x=random.nextInt(longueur);
            int y=random.nextInt(largeur); 
            if (this.Grille_Terrain[x][y].getCombustion() < 1 && this.Grille_Terrain[x][y].getBrulure() == "" && this.Grille_Terrain[x][y].getVegetation() == true){
                this.Grille_Terrain[x][y].setCombustion(1);
                this.Grille_Terrain[x][y].setBrulure("A");
                this.Grille_Terrain[x][y].setVegetation(false);
                System.out.println(x+" ; "+y);
            }
        }
    }
    
    //Methode permettant de réaliser la propagation du feu
    public void Propa_Feu(int[][] Repartition,int Vent_Force){
        for(int i=0;i<this.Grille_Terrain.length;i++){ //On parcourt la grille du terrain
            for(int j=0;j<this.Grille_Terrain[0].length;j++){
                
               
                
                boolean Condamne; //Condition de propagation du feu
                int Position_X = i; //Coordonnees de la case sur la grille correspondant à la première de la grille de propagation
                int Position_Y = j;
                
                //System.out.println("i = " + i + " | j = " + j + " | Position_X = " + Position_X + " | Position_Y = " + Position_Y);
                
                if(this.Grille_Terrain[i][j].getBrulure().equalsIgnoreCase("A")){ //On verifie si la case est en état : enflammé 
                    //System.out.println("i = " + i + " | j = " + j + " | Position_X = " + Position_X + " | Position_Y = " + Position_Y);
                    Position_X = Position_X-4;
                    Position_Y = Position_Y-4;
                    for(int a=0;a<Repartition.length;a++){  //On parcourt la grille de Repartion pour avoir les probabilités de combustion d'une case
                        Position_X++; //On parcourt en même temps la grille du terrain pour faire le tirage de la condamnation d'une case
                        for(int b=0;b<Repartition[0].length;b++){
                            Position_Y++;
                            float Proba_Case = 0;
                            try{
                                if(this.Grille_Terrain[Position_X][Position_Y].getVegetation() == true && this.Grille_Terrain[Position_X][Position_Y].getCondamne() == false){ //On effectue le tirage uniquement sur les cases avec forêt non condamnée
                                    Proba_Case = (this.Grille_Terrain[Position_X][Position_Y].getHumidite()/100.0f)*(Repartition[a][b]/100.0f); //Calcul de la probabilite de combustion
                                }
                            }catch(ArrayIndexOutOfBoundsException ex){ //Si les coordonnées de la case indiquent qu'elle est à l'extérieur du terrain alors on retourne une erreur et on continue
                            }finally{
                                //System.out.print("Position_1 = " + Position_X + " | Position_2 = " + Position_Y + " | Proba_Case = " + Proba_Case);
                            }
                            Condamne = getBooleenRandomDouble(Proba_Case); //On teste si la case va être condamnée
                            //System.out.println(" | Condamne = " + Condamne);
                            if(Condamne == true){
                                try{
                                    this.Grille_Terrain[Position_X][Position_Y].setCondamne(true); // On condamne la case définitivement
                                }catch(ArrayIndexOutOfBoundsException ex){
                                }finally{
                                }
                            }
                        }
                        Position_Y = j-4;
                    }
                }
                
                if(this.Grille_Terrain[i][j].getBrulure().equalsIgnoreCase("C")){ //On verifie si la case est en état : brulé chaud
                    //System.out.println("i = " + i + " | j = " + j + " | Position_X = " + Position_X + " | Position_Y = " + Position_Y);
                    Position_X = Position_X-4;
                    Position_Y = Position_Y-4;
                    for(int a=0;a<Repartition.length;a++){  //On parcourt la grille de Repartion pour avoir les probabilités de combustion d'une case
                        Position_X++;
                        for(int b=0;b<Repartition[0].length;b++){
                            Position_Y++;
                            double Proba_Case = 0;
                            try{
                                if(this.Grille_Terrain[Position_X][Position_Y].getVegetation() == true && this.Grille_Terrain[Position_X][Position_Y].getCondamne() == false){
                                    Proba_Case = 0.08*(1+2*Vent_Force)*(this.Grille_Terrain[Position_X][Position_Y].getHumidite()/100.0f)*(Repartition[a][b]/100.0f); //Calcul de la probabilite de combustion
                                }
                            }catch(ArrayIndexOutOfBoundsException ex){//Si les coordonnées de la case indiquent qu'elle est à l'extérieur du terrain alors on retourne une erreur et on continue
                            }finally{
                                //System.out.print("Position_1 = " + Position_X + " | Position_2 = " + Position_Y + " | Proba_Case = " + Proba_Case);
                            }
                            Condamne = getBooleenRandomDouble(Proba_Case); //On teste si la case va être condamné
                            //System.out.println(" | Condamne = " + Condamne);
                            if(Condamne == true){
                                try{
                                    this.Grille_Terrain[Position_X][Position_Y].setCondamne(true); // On condamne la case définitivement
                                }catch(ArrayIndexOutOfBoundsException ex){
                                }finally{
                                }
                            }
                        }
                        Position_Y = j-4;
                    }
                }
            }
        }
        Iteration();
    }
    
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
    
    public float Convertisseur(int proba){ // cette méthode prend en argument une probabilité et renvoie un réel compris entre -1 et 1
        float y;
        y=(proba*2/100)-1;
        return y;
    }
    
    // methode qui permet de transformer les cases condamnées en cases qui brûlent, de plus les cases déjà en feu mais pas encore réduit en cendre voient leur état de combustion augmenter de 1
    public void Iteration(){
        for (int i = 0;i<this.Grille_Terrain.length;i++){ //On parcourt la grille du terrain
            for (int j = 0;j<this.Grille_Terrain.length;j++){
                
                if(this.Grille_Terrain[i][j].getVegetation() == true && this.Grille_Terrain[i][j].getBrulure().equalsIgnoreCase("") && this.Grille_Terrain[i][j].getCondamne() == true){ //Si la case est condamné alors on la passe en état enflammé
                    this.Grille_Terrain[i][j].setCombustion(this.Grille_Terrain[i][j].getCombustion()+1);
                    this.Grille_Terrain[i][j].setVegetation(false);
                    this.Grille_Terrain[i][j].setBrulure("A");
                }
                
                else if(this.Grille_Terrain[i][j].getBrulure().equalsIgnoreCase("A") && this.Grille_Terrain[i][j].getCombustion() == 1){ //Si la case est enflammé alors on la passe en état brûlé chaud
                    this.Grille_Terrain[i][j].setCombustion(this.Grille_Terrain[i][j].getCombustion()+1);
                }
                
                else if(this.Grille_Terrain[i][j].getBrulure().equalsIgnoreCase("A") && this.Grille_Terrain[i][j].getCombustion() == 2){ //Si la case est enflammé alors on la passe en état brûlé chaud
                    this.Grille_Terrain[i][j].setCombustion(this.Grille_Terrain[i][j].getCombustion()+1);
                    this.Grille_Terrain[i][j].setBrulure("C");
                }
                
                else if(this.Grille_Terrain[i][j].getBrulure().equalsIgnoreCase("C") && this.Grille_Terrain[i][j].getCombustion() == 3){ //Au bout de deux itérations, une case enflammée devient une case brûlé chaud
                    this.Grille_Terrain[i][j].setCombustion(this.Grille_Terrain[i][j].getCombustion()+1);
                }
                
                else if(this.Grille_Terrain[i][j].getBrulure().equalsIgnoreCase("C") && this.Grille_Terrain[i][j].getCombustion() > 3){ //Une case en état brûlé chaud a 40% de chance de devenir une case en état brûlé froid
                    this.Grille_Terrain[i][j].setCombustion(this.Grille_Terrain[i][j].getCombustion()+1);
                    Boolean Refroidit = getBooleenRandom(40);
                    if(Refroidit == true){
                        this.Grille_Terrain[i][j].setBrulure("F");
                    }
                }
            }
        }
    }
}
