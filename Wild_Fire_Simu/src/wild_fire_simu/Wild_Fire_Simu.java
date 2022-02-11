/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wild_fire_simu;

/**
 *
 * @author louis
 */
public class Wild_Fire_Simu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Test méthode getBooleenRandom()
        Terrain ter1 = new Terrain(0,"oui");
        boolean Proba;
        for(int i=0;i<10;i++){
           Proba = ter1.getBooleenRandom(30);
           System.out.println(Proba);
        }
        
        //Test méthode getBooleenRandom()
        Terrain terter1 = new Terrain(0,"Clairsemée");
        terter1.CreaTableau(14,15,15);
        int Densite = terter1.Conversion(terter1.Densite_Terrain);
        terter1.Affec_Vege(Densite);
        
        System.out.println(terter1.Grille_Terrain.length);
        System.out.println(terter1.Grille_Terrain[0].length);
        
        for(int i=0;i<terter1.Grille_Terrain.length;i++){
            System.out.print(i + "|");
            for(int j=0;j<terter1.Grille_Terrain[0].length;j++){
                System.out.print(j+ "" + terter1.Grille_Terrain[i][j].Vegetation_Case + " ");
            }
            System.out.println("");
        }
    }
}
