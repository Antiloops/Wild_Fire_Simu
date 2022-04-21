/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graphics;

import java.awt.Color;
import wild_fire_simu.Case;
import wild_fire_simu.Terrain;

/**
 *
 * @author ASUS
 */
public class Grille {
    private Case[][] grilleColors;
    //private int[][] grilleColors;
    private static final Color[] tabColor=new Color[]{Color.BLUE,Color.GREEN,Color.RED,Color.YELLOW,Color.BLACK}; //tableau des différentes couleurs avec lesquelles on pourra colorier notre grille 
    
    public Grille(){
        //Terrain terrain=new Terrain();
        Fenetre.terrain.CreaTableau(50, 5000, 5000);
        this.grilleColors=Fenetre.terrain.getGrille();
        
        //this.grilleColors = new Case[300][300];//tab notre vrai tableau , dimension 300x300 a modifier en fonction de la taille de notre tableau
        //this.grilleColors[100][50]=1;//CETTE LIGNE EST UN TEST
    }
    public void changeColor(){ // change numéro dans notre tableau, transforme les 0 en cramé donc en 1...
        
    }
    public Color getCellColor(int x,int y){ // on créer des methodes get car nos attributs sont privés
        int a=10 ;
        if (grilleColors[x][y].getBrulure().equals("X")){
            a=0;
        }
        else if (grilleColors[x][y].getBrulure().equals("")){
            a=1;
        }
        else if (grilleColors[x][y].getBrulure().equals("A")){
            a=2;
        }
        else if (grilleColors[x][y].getBrulure().equals("C")){
            a=3;
        }
        else if (grilleColors[x][y].getBrulure().equals("F")){
            a=4;
        }
        return tabColor[a];
        //return tabColor[grilleColors[x][y]]; // retourne la couleur correspondante au numéro de l'élément dans la grilleColors
    }
    public Case[][] getGrilleColors(){ // on créer des methodes get car nos attributs sont privés
        return this.grilleColors;
    }
}
