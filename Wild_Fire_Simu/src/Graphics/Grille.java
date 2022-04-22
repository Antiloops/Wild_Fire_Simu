/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graphics;

import java.awt.Color;
import wild_fire_simu.Case;
import wild_fire_simu.Terrain;
import wild_fire_simu.Vent;

/**
 *
 * @author ASUS
 */
public class Grille { // classe Grille, correspond à notre tableau
    
    // attributs
    private Case[][] grilleColors; // notre tableau de type case
    private static final Color[] tabColor=new Color[]{Color.BLUE,Color.GREEN,Color.RED,Color.YELLOW,Color.BLACK}; //tableau des différentes couleurs avec lesquelles on pourra colorier notre grille 
    
    
    // constructeur
    public Grille(Terrain terrain){ 
        
        this.grilleColors = terrain.getGrille();
        
    }
    // change numéro dans notre tableau, transforme les "" en cramé donc en "A"...
    public void changeColor(Terrain land, Vent wind){ 
        land.Propa_Feu(wind.getRepartition(), wind.getForce()); // on fait appelle à notre méthode propagation feu
    }
    
    public Color getCellColor(int x,int y){ // on créer des methodes get car nos attributs sont privés
                                            // cette méthode permet de retourner en entier en fonction de la lettre qui correspond à l'état de combustion de la case
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
        return tabColor[a]; // retourne la couleur correspondante au numéro de l'élément dans la grilleColors
    }
    
    public Case[][] getGrilleColors(){ // on créer des methodes get car nos attributs sont privés
        return this.grilleColors;
    }
}
