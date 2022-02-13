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
    
    public Case[][] Grille_Terrain; // type sera suremment modifié
    public int Temps_Terrain; 
    public String Densite_Terrain;
    
    
    public Terrain(int Temps_Terrain,String Densite_Terrain){ //Constructeur
        this.Temps_Terrain = Temps_Terrain;
        this.Densite_Terrain = Densite_Terrain;
    }
    
    // methode permettant de convertir le type de densité en une probabilité expoitable plus tard
    public int Conversion(String densite){
        int probabilite=0;
        if("Clairsemée".equals(densite)){ // comment ne plus se préoccuper des majuscules ?
            probabilite= 50; 
        }else if ("Espacée".equals(densite)){
            probabilite= 75;
        }else if("Touffue".equals(densite)){
            probabilite=90;
        }else if("Continue".equals(densite)){
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
                        Case temp=new Case(humidite);
                        tableau[i][j]=temp;
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
    
    public void Depart_Feu(int nb_depart){// cette méthode initialise la/les  position du feu 
        Random random=new Random();
        int longueur;
        int largeur;
        longueur=this.Grille_Terrain.length;
        largeur=this.Grille_Terrain[0].length;
        for(int i=0;i<nb_depart;i++){
            int x=random.nextInt(longueur);
            int y=random.nextInt(largeur);
            if (this.Grille_Terrain[x][y].Combustion_Case!=1 && this.Grille_Terrain[x][y].Vegetation_Case==true){
            this.Grille_Terrain[x][y].Combustion_Case=1;
            }
        }
    }
}
