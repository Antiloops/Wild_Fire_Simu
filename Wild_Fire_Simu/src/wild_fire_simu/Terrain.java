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
    
    private Case[][] Grille_Terrain; // Grille du terrain // type sera suremment modifie
    //private int Temps_Terrain;  //Itteration de la partie
    private String Densite_Terrain; //Dentsite de vegetation du terrain
    
    
    public Terrain(){ //Constructeur
        
    }
    
    //Getter -> Methodes qui retourne les attributs de la case : la vegatation, la niveau de combustion ou le risque
    public Case[][] getGrille(){
        return this.Grille_Terrain;
    }
    
    
    
    public String getDensite(){
        return this.Densite_Terrain;
    }
    
    //Setter -> Methodes qui modifie les attributs de la case par un argument en entree pour : la vegetation, la combustion ou le risque
    public void setCase(Case[][] Grille_Terrain){
        this.Grille_Terrain = Grille_Terrain;
    }
    
    
    
    public void setDensite(String Densite_Terrain){
        this.Densite_Terrain = Densite_Terrain;
    }
    
    // cette methode initialise un tableau de dimension longueur x largeur dans lequel on fixe l'humidite de chaque case
    public void CreaTableau(int humidite, int longueur, int largeur){
        boolean ValCorrect = false;         //Booleen qui est faux quand la création du tableau ne s'est pas faite correctement 
        while(ValCorrect == false){
            try{
                ValCorrect = true;
                this.Grille_Terrain = new Case[longueur][largeur];      //Initialisation des dimensions du tableau
                for(int i=0;i<longueur;i++){ 
                    for(int j=0;j<largeur;j++){
                        Case temp = new Case(humidite);
                        this.Grille_Terrain[i][j] = temp;    //Affectation de l'humidite de chaque case
                    }
                }
            }catch(ArrayIndexOutOfBoundsException ex){      //Si la boucle for depasse le nombre de case de la grille, on envoit un message d'erreur
                ValCorrect = false;
                System.out.println(" CreaTableau() -> Un probleme d'indice est survenu");
                throw ex;
            }if(ValCorrect){
                System.out.println(" CreaTableau() -> La tableau a bien ete cre");
            }
        }
    }
    
    //Methode qui permet d'initialiser la vegetation du terrain sans graine de generation
    public void Affec_Vege(int Repartition, double feature_size){
        float Noise_Repartition = Convertisseur(Repartition);
        boolean AffectCorrect = false;      //Variable de verification de la bonne mise en place du programme
        OpenSimplexNoise noise = new OpenSimplexNoise();     //Creation d'un objet de la classe OpenSimplexNoise
        try{    
            AffectCorrect = true;
            for(int i=0;i<this.Grille_Terrain.length;i++){      //Parcours de la grille du terrain 
                for(int j=0;j<this.Grille_Terrain[0].length;j++){
                    double value = noise.eval(i / feature_size, j / feature_size);  //On utilise la methode eval de OpenSimplexNoise pour retourner une valeur comprise entre -1 et 1 en fonction des coordonnées
                    if(value > Noise_Repartition){  //Si la valeur obtenue est superieure a la limite definie alors c'est une case non-inflammable
                        this.Grille_Terrain[i][j].setVegetation(false);
                        this.Grille_Terrain[i][j].setBrulure("X");
                    }
                    if(value <= Noise_Repartition){ //Si la valeur obtenue est inferieure a la limite definie alors c'est une case de foret
                        this.Grille_Terrain[i][j].setVegetation(true);
                    }
                }
            }
        }catch(ArrayIndexOutOfBoundsException ex){       //Si la boucle for depasse le nombre de case de la grille, on envoit un message d'erreur
            AffectCorrect = false;
            System.out.println(" Affec_Vege() -> Un probleme d'indice est survenu");
            throw ex;
        }if(AffectCorrect){
            System.out.println(" Affec_Vege() -> La Vegetation a bien ete Affectee à la grille");
        }
    }
    
    //Methode qui permet d'initialiser la vegetation du terrain avec graine de generation
    public void Affec_Vege(int Repartition, double feature_size, long Seed){
        float Noise_Repartition = Convertisseur(Repartition);
        boolean AffectCorrect = false;      //Variable de verification de la bonne mise en place du programme
        OpenSimplexNoise noise = new OpenSimplexNoise(Seed);     //Creation d'un objet de la classe OpenSimplexNoise et initialisation de la graine de generation
        try{    //
            AffectCorrect = true;
            for(int i=0;i<this.Grille_Terrain.length;i++){      //Parcours de la grille du terrain 
                for(int j=0;j<this.Grille_Terrain[0].length;j++){
                    double value = noise.eval(i / feature_size, j / feature_size);  //On utilise la methode eval de OpenSimplexNoise pour retourner une valeur comprise entre -1 et 1 en fonction des coordonnées et de la graine de génération
                    if(value > Noise_Repartition){  //Si la valeur obtenue est superieure a la limite definie alors c'est une case non-inflammable
                        this.Grille_Terrain[i][j].setVegetation(false);
                        this.Grille_Terrain[i][j].setBrulure("X");
                    }
                    if(value <= Noise_Repartition){ //Si la valeur obtenue est inferieure a la limite definie alors c'est une case de foret
                        this.Grille_Terrain[i][j].setVegetation(true);
                        this.Grille_Terrain[i][j].setBrulure("");
                    }
                }
            }
        }catch(ArrayIndexOutOfBoundsException ex){       //Si la boucle for depasse le nombre de case de la grille, on envoit un message d'erreur
            AffectCorrect = false;
            System.out.println(" Affec_Vege() -> Un probleme d'indice est survenu");
            throw ex;
        }if(AffectCorrect){
            System.out.println(" Affec_Vege() -> La Vegetation a bien ete Affectee à la grille");
        }
    }
    
    //Methode initialisant la/les  position du feu 
    public void Depart_Feu(int nb_depart){      
        Random random = new Random();   //Creation d'un objet de la classe Random
        int longueur = this.Grille_Terrain.length;
        int largeur = this.Grille_Terrain[0].length;
        for(int i=0;i<nb_depart;i++){
            int x=random.nextInt(longueur); //On tire une valeur de longueur aléatoire 
            int y=random.nextInt(largeur);  //On tire une valeur de largeur aléatoire 
            while(this.Grille_Terrain[x][y].getVegetation() == false){  //tant que la case est non-inflammable alors on ne pose pas de départ de feu
                x=random.nextInt(longueur);
                y=random.nextInt(largeur); 
            }
            this.Grille_Terrain[x][y].setCombustion(1);  //On affecte à la case valide obtenue les conditions de départ de combustion 
            this.Grille_Terrain[x][y].setBrulure("A");
            this.Grille_Terrain[x][y].setVegetation(false);
        }
    }
    
    //Methode permettant de realiser la propagation du feu
    public void Propa_Feu(int[][] Repartition,int Vent_Force){
        for(int i=0;i<this.Grille_Terrain.length;i++){  //On parcourt la grille du terrain
            for(int j=0;j<this.Grille_Terrain[0].length;j++){
                boolean Condamne;   //Condition de propagation du feu
                int Position_X = i;     //Coordonnees de la case sur la grille correspondant à la premiere de la grille de propagation
                int Position_Y = j;
                if(this.Grille_Terrain[i][j].getBrulure().equalsIgnoreCase("A")){   //On verifie si la case est en etat : enflamme 
                    Position_X = Position_X-4;
                    Position_Y = Position_Y-4;
                    for(int a=0;a<Repartition.length;a++){      //On parcourt la grille de Repartion pour avoir les probabilites de combustion d'une case
                        Position_X++;   //On parcourt en même temps la grille du terrain pour faire le tirage de la condamnation d'une case
                        for(int b=0;b<Repartition[0].length;b++){
                            Position_Y++;
                            float Proba_Case = 0;
                            try{
                                if(this.Grille_Terrain[Position_X][Position_Y].getVegetation() == true && this.Grille_Terrain[Position_X][Position_Y].getCondamne() == false){  //On effectue le tirage uniquement sur les cases avec forêt non condamnee
                                    Proba_Case = (this.Grille_Terrain[Position_X][Position_Y].getHumidite()/100.0f)*(Repartition[a][b]/100.0f); //Calcul de la probabilite de combustion
                                }
                            }catch(ArrayIndexOutOfBoundsException ex){  //Si les coordonnees de la case indiquent qu'elle est à l'exterieur du terrain alors on retourne une erreur et on continue
                            }finally{
                            }
                            Condamne = getBooleenRandomDouble(Proba_Case);  //On teste si la case va être condamnee
                            if(Condamne == true){
                                try{
                                    this.Grille_Terrain[Position_X][Position_Y].setCondamne(true);  // On condamne la case definitivement
                                }catch(ArrayIndexOutOfBoundsException ex){
                                }finally{
                                }
                            }
                        }
                        Position_Y = j-4;
                    }
                }
                
                if(this.Grille_Terrain[i][j].getBrulure().equalsIgnoreCase("C")){ //On verifie si la case est en etat : brule chaud
                    Position_X = Position_X-4;
                    Position_Y = Position_Y-4;
                    for(int a=0;a<Repartition.length;a++){  //On parcourt la grille de Repartion pour avoir les probabilites de combustion d'une case
                        Position_X++;
                        for(int b=0;b<Repartition[0].length;b++){
                            Position_Y++;
                            double Proba_Case = 0;
                            try{
                                if(this.Grille_Terrain[Position_X][Position_Y].getVegetation() == true && this.Grille_Terrain[Position_X][Position_Y].getCondamne() == false){
                                    Proba_Case = 0.001*(1+2*Vent_Force)*(this.Grille_Terrain[Position_X][Position_Y].getHumidite()/100.0f)*(Repartition[a][b]/100.0f); //Calcul de la probabilite de combustion
                                }
                            }catch(ArrayIndexOutOfBoundsException ex){//Si les coordonnees de la case indiquent qu'elle est à l'exterieur du terrain alors on retourne une erreur et on continue
                            }finally{
                            }
                            Condamne = getBooleenRandomDouble(Proba_Case); //On teste si la case va être condamne
                            if(Condamne == true){
                                try{
                                    this.Grille_Terrain[Position_X][Position_Y].setCondamne(true); // On condamne la case definitivement
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
    
    
    //Methode renvoyant une booleen aleatoire en fonction d'un pourcentage mis en argument 
    public boolean getBooleenRandom(int Proba){
        if(Proba != 0.0){
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
        else{
            return false;
        }
    }
    
    
    //Methode renvoyant une booleen aleatoire en fonction d'un pourcentage mis en argument !!VERSION FLOAT!!
    public boolean getBooleenRandomDouble(double Proba){
        if(Proba != 0.0){
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
        else{
            return false;
        }
    }
    
    //Methode prenant en argument une probabilite et renvoie un reel compris entre -1 et 1
    public float Convertisseur(int proba){ 
        float y;
        System.out.println(proba);
        y=(proba*2.0f/100.0f)-1.0f;
        System.out.println(y);
        return y;
    }
    
    //Methode permettant de transformer les cases condamnees en cases qui brûlent, de plus les cases dejà en feu mais pas encore reduit en cendre voient leur etat de combustion augmenter de 1
    public void Iteration(){
        for (int i = 0;i<this.Grille_Terrain.length;i++){ //On parcourt la grille du terrain
            for (int j = 0;j<this.Grille_Terrain.length;j++){
                
                if(this.Grille_Terrain[i][j].getVegetation() == true && this.Grille_Terrain[i][j].getBrulure().equalsIgnoreCase("") && this.Grille_Terrain[i][j].getCondamne() == true){ //Si la case est condamne alors on la passe en etat enflamme
                    this.Grille_Terrain[i][j].setCombustion(this.Grille_Terrain[i][j].getCombustion()+1);
                    this.Grille_Terrain[i][j].setVegetation(false);
                    this.Grille_Terrain[i][j].setBrulure("A");
                }
                
                else if(this.Grille_Terrain[i][j].getBrulure().equalsIgnoreCase("A") && this.Grille_Terrain[i][j].getCombustion() == 1){ //Si la case est enflamme alors on la passe en etat brûle chaud
                    this.Grille_Terrain[i][j].setCombustion(this.Grille_Terrain[i][j].getCombustion()+1);
                }
                
                else if(this.Grille_Terrain[i][j].getBrulure().equalsIgnoreCase("A") && this.Grille_Terrain[i][j].getCombustion() == 2){ //Si la case est enflamme alors on la passe en etat brûle chaud
                    this.Grille_Terrain[i][j].setCombustion(this.Grille_Terrain[i][j].getCombustion()+1);
                    this.Grille_Terrain[i][j].setBrulure("C");
                }
                
                else if(this.Grille_Terrain[i][j].getBrulure().equalsIgnoreCase("C") && this.Grille_Terrain[i][j].getCombustion() == 3){ //Au bout de deux iterations, une case enflammee devient une case brûle chaud
                    this.Grille_Terrain[i][j].setCombustion(this.Grille_Terrain[i][j].getCombustion()+1);
                }
                
                else if(this.Grille_Terrain[i][j].getBrulure().equalsIgnoreCase("C") && this.Grille_Terrain[i][j].getCombustion() > 3){ //Une case en etat brûle chaud a 40% de chance de devenir une case en etat brûle froid
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
