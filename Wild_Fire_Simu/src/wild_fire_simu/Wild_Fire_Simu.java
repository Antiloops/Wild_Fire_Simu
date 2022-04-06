/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wild_fire_simu;

import java.util.Scanner;

/**
 *
 * @author louis
 */
public class Wild_Fire_Simu {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        // test methode Conversion
        /*
        Terrain terrain1=new Terrain(0,"touffue");
         float x=terrain1.Conversion(terrain1.Densite_Terrain);
         System.out.println(x);
        
        // test ok
        
         */
        
        // test creation tableau
        /*
        int longueur;
        int largeur;
        Scanner sc = new Scanner(System.in);
        
         Terrain terrain1=new Terrain(0,"Continue");
         System.out.println("entrez une longueur");
         longueur=sc.nextInt();
         System.out.println("entrez une largeur"); // attention ordre longueur puis largeur ou l'inverse ?
         largeur=sc.nextInt();
         
         terrain1.CreaTableau(10, longueur, largeur);
         for (int i=0;i<longueur;i++){ // attention avec l'ordre longueur largeur je suis pas sur de mon coup
            for(int j=0;j<largeur;j++){
         System.out.println(terrain1.Grille_Terrain[i][j].Humidite_Case);
            }
         }
         //test ok (à vérifier pcq méthode modifiée entre temps)
         */
        
        
        /*
        
        //Test méthode getBooleenRandom() JUSTE TEST POUR LA METHODE SOLO
        Terrain terter1 = new Terrain(0,"oui");
        boolean Proba;
        for(int i=0;i<10;i++){
           Proba = terter1.getBooleenRandom(30);
           System.out.println(Proba);
        }
        */

        /*
        //Test méthode getBooleenRandom() TEST AFFECT_VEGE 
        
        Terrain terter2 = new Terrain(0,"Clairsemée");
        terter2.CreaTableau(14,15,15);
        int Densite = terter1.Conversion(terter1.Densite_Terrain);
        terter1.Affec_Vege(Densite);
        
        System.out.println(terter1.Grille_Terrain.length);
        System.out.println(terter1.Grille_Terrain[0].length);
        
        for(int i=0;i<terter1.Grille_Terrain.length;i++){
            System.out.print(i + "|");
            for(int j=0;j<terter1.Grille_Terrain[0].length;j++){
                System.out.print(j+ "" + terter1.Grille_Terrain[i][j].Vegetation_Case + " ");
            }
            System.out.println(" ");
        }
        */
        
        /*
        //test Depart_Feu
         
         Terrain terrain1=new Terrain(0,"Continue");
         
         int longueur;
         int largeur;
        
         Scanner sc = new Scanner(System.in);
         
         System.out.println("entrez une longueur");
         longueur=sc.nextInt();
         System.out.println("entrez une largeur"); // attention ordre longueur puis largeur ou l'inverse ?
         largeur=sc.nextInt();
         
         terrain1.CreaTableau(10, longueur, largeur);
         terrain1.Depart_Feu(1);
         for (int i=0;i<longueur;i++){ // attention avec l'ordre longueur largeur je suis pas sur de mon coup
            for(int j=0;j<largeur;j++){
         System.out.print(" "+terrain1.Grille_Terrain[i][j].Combustion_Case);
         }
            System.out.println("\n");
         }
         //test ok
        */
        
        /*//Test de la gestion d'erreur 
        Terrain terter3 = new Terrain(0,"Clairsemée");
        terter3.CreaTableau(14,15,15);
        int Densite = terter3.Conversion(terter3.Densite_Terrain);
        terter3.Affec_Vege(Densite);*/
        
        Terrain Foret = new Terrain(0,"Touffue");
        Foret.CreaTableau(3,10,10);
        int Densite = Foret.Conversion(Foret.getDensite());
        Foret.Affec_Vege(Densite);
        
        Foret.Depart_Feu(1);
        
        for(int i=0;i<Foret.getGrille().length;i++){
                for(int j=0;j<Foret.getGrille()[0].length;j++){
                    if(Foret.getGrille()[i][j].getVegetation() == false && Foret.getGrille()[i][j].getCombustion() == 0){
                        System.out.print("X" + " ");
                    }
                    else if(Foret.getGrille()[i][j].getVegetation() == true && Foret.getGrille()[i][j].getCombustion() == 0){
                        System.out.print("^" + " ");
                    }
                    else{
                        System.out.print(Foret.getGrille()[i][j].getBrulure() + " ");
                    }
                }
                System.out.println("|");
            }
            System.out.println("");
        
        Vent wind = new Vent("nord",3);
        wind.Repartion_Vent();
        
        for(int a=0;a<20;a++){
            Foret.Propa_Feu(wind.getRepartition(),wind.getForce());
            System.out.println("Iteration " + a);
            for(int i=0;i<Foret.getGrille().length;i++){
                for(int j=0;j<Foret.getGrille()[0].length;j++){
                    if(Foret.getGrille()[i][j].getVegetation() == false && Foret.getGrille()[i][j].getCombustion() == 0){
                        System.out.print("X" + " ");
                    }
                    else if(Foret.getGrille()[i][j].getVegetation() == true && Foret.getGrille()[i][j].getCombustion() == 0){
                        System.out.print("^" + " ");
                    }
                    else{
                        System.out.print(Foret.getGrille()[i][j].getBrulure() + " ");
                    }
                }
                System.out.println("|");
            }
            System.out.println("");
            try{
                 Thread.sleep(500);
            }catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
        }  
       
    }
}
