/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import wild_fire_simu.Terrain;

/**
 *
 *  Auteurs : Louis Savignac et Mathis Lopez 
 */
public class grillePanel extends javax.swing.JPanel {  // classe de notre panel sur lequel on affichera notre grille

    //Attribut
    private Grille gr1; 
    
    //Constructeur , prend en argument un Terrain
    public grillePanel(Terrain land) { 
        gr1 = new Grille(land);  //Affectation du terrain dans l'attribut de la classe
        this.setSize(new Dimension(land.getGrille().length,land.getGrille()[0].length)); // la taille du panel correspond aux dimensions de notre grille
        initComponents();
    }
    
    //Getter
    public Grille getGr1(){ 
        return gr1;// cette méthode renvoie notre grille
    }
    
    public void paint(Graphics g){
        for(int x = 0; x < gr1.getGrilleColors().length; x++){
            for(int y = 0; y < gr1.getGrilleColors()[0].length; y++){
                g.setColor(gr1.getCellColor(x, y)); // on récupère lélément aux coordonées x et y de notre grille et on regarde à quelle couleur ça correspond
                g.fillRect(x, y, 1, 1); // on colorie un rectangle de longueur 1 et de largeur 1 au niveau de la case, c'est à dire un pixel
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1155, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 696, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
