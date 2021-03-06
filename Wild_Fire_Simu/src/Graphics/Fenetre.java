/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Graphics;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import wild_fire_simu.Terrain;
import wild_fire_simu.Vent;

/**
 * 
 * Auteurs : Louis Savignac et Mathis Lopez 
 */
public class Fenetre extends javax.swing.JFrame {

    private grillePanel grPanel;
    private Timer t;
    public Fenetre() {
        initComponents();
    }
    
    public class Tache extends TimerTask {
        public void run(){
            grPanel.getGr1().changeColor(terrain,wind); 
            grPanel.repaint();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jButton_Demarrer = new javax.swing.JButton();
        jButton_GeneTerrain = new javax.swing.JButton();
        jLabel_Taille = new javax.swing.JLabel();
        jTextField_Longueur = new javax.swing.JTextField();
        jTextField_Largeur = new javax.swing.JTextField();
        jLabel_Humidité = new javax.swing.JLabel();
        jSlider_Humidité = new javax.swing.JSlider();
        jLabel_Vege = new javax.swing.JLabel();
        jSlider_Pourcentage_Vegetation = new javax.swing.JSlider();
        jLabel_Grain = new javax.swing.JLabel();
        jSlider_Grain = new javax.swing.JSlider();
        jLabel_Graine = new javax.swing.JLabel();
        jTextField_Graine = new javax.swing.JTextField();
        jLabel_Direction_Vent = new javax.swing.JLabel();
        jRadioButton_Nord = new javax.swing.JRadioButton();
        jRadioButton_Sud = new javax.swing.JRadioButton();
        jRadioButton_Est = new javax.swing.JRadioButton();
        jRadioButton_Ouest = new javax.swing.JRadioButton();
        jLabel_Force_Vent = new javax.swing.JLabel();
        jSlider_ForceVent = new javax.swing.JSlider();
        jLabel_Nb_Depart = new javax.swing.JLabel();
        jTextField_NbDepart = new javax.swing.JTextField();
        jButton_Annuler = new javax.swing.JButton();
        jButton_Quitter = new javax.swing.JButton();
        jLabel_Longueur = new javax.swing.JLabel();
        jLabel_Largeur = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_Message = new javax.swing.JTextArea();
        jLabel_Message = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton_Demarrer.setBackground(new java.awt.Color(20, 60, 222));
        jButton_Demarrer.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_Demarrer.setForeground(new java.awt.Color(240, 240, 240));
        jButton_Demarrer.setText("Demarrer");
        jButton_Demarrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DemarrerActionPerformed(evt);
            }
        });

        jButton_GeneTerrain.setBackground(new java.awt.Color(0, 230, 0));
        jButton_GeneTerrain.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton_GeneTerrain.setForeground(new java.awt.Color(0, 0, 222));
        jButton_GeneTerrain.setText("Générer terrain");
        jButton_GeneTerrain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GeneTerrainActionPerformed(evt);
            }
        });

        jLabel_Taille.setText("Taille :");

        jTextField_Longueur.setText("800");

        jTextField_Largeur.setText("600");

        jLabel_Humidité.setText("Humidité :");

        jSlider_Humidité.setMajorTickSpacing(10);
        jSlider_Humidité.setMinorTickSpacing(2);
        jSlider_Humidité.setPaintLabels(true);
        jSlider_Humidité.setPaintTicks(true);
        jSlider_Humidité.setSnapToTicks(true);

        jLabel_Vege.setText("Pourcentage de végétation :");

        jSlider_Pourcentage_Vegetation.setMajorTickSpacing(10);
        jSlider_Pourcentage_Vegetation.setMinorTickSpacing(2);
        jSlider_Pourcentage_Vegetation.setPaintLabels(true);
        jSlider_Pourcentage_Vegetation.setPaintTicks(true);
        jSlider_Pourcentage_Vegetation.setSnapToTicks(true);

        jLabel_Grain.setText("Grain :");

        jSlider_Grain.setMajorTickSpacing(10);
        jSlider_Grain.setMaximum(90);
        jSlider_Grain.setMinorTickSpacing(2);
        jSlider_Grain.setPaintLabels(true);
        jSlider_Grain.setPaintTicks(true);
        jSlider_Grain.setSnapToTicks(true);

        jLabel_Graine.setText("Graine :");

        jTextField_Graine.setText("1");

        jLabel_Direction_Vent.setText("direction du vent :");

        buttonGroup1.add(jRadioButton_Nord);
        jRadioButton_Nord.setSelected(true);
        jRadioButton_Nord.setText("Nord");
        jRadioButton_Nord.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        buttonGroup1.add(jRadioButton_Sud);
        jRadioButton_Sud.setText("Sud");

        buttonGroup1.add(jRadioButton_Est);
        jRadioButton_Est.setText("Est");

        buttonGroup1.add(jRadioButton_Ouest);
        jRadioButton_Ouest.setText("Ouest");

        jLabel_Force_Vent.setText("force du vent :");

        jSlider_ForceVent.setMajorTickSpacing(1);
        jSlider_ForceVent.setMaximum(3);
        jSlider_ForceVent.setPaintLabels(true);
        jSlider_ForceVent.setPaintTicks(true);
        jSlider_ForceVent.setSnapToTicks(true);

        jLabel_Nb_Depart.setText("nombre de départ de feu :");

        jTextField_NbDepart.setText("1");

        jButton_Annuler.setBackground(new java.awt.Color(240, 140, 0));
        jButton_Annuler.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton_Annuler.setForeground(new java.awt.Color(0, 0, 0));
        jButton_Annuler.setText("Annuler");
        jButton_Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AnnulerActionPerformed(evt);
            }
        });

        jButton_Quitter.setBackground(new java.awt.Color(222, 0, 0));
        jButton_Quitter.setText("Quitter");
        jButton_Quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_QuitterActionPerformed(evt);
            }
        });

        jLabel_Longueur.setText("longueur :");

        jLabel_Largeur.setText("largeur :");

        jTextArea_Message.setColumns(20);
        jTextArea_Message.setForeground(new java.awt.Color(222, 0, 0));
        jTextArea_Message.setRows(5);
        jTextArea_Message.setText("Les messages d'erreurs s'afficheront ici");
        jScrollPane1.setViewportView(jTextArea_Message);

        jLabel_Message.setText("Message :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_Message)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 198, Short.MAX_VALUE)
                        .addComponent(jButton_Quitter, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel_Grain)
                            .addComponent(jLabel_Humidité)
                            .addComponent(jLabel_Vege)
                            .addComponent(jLabel_Taille)
                            .addComponent(jLabel_Graine)
                            .addComponent(jLabel_Direction_Vent)
                            .addComponent(jLabel_Force_Vent)
                            .addComponent(jLabel_Nb_Depart))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSlider_Pourcentage_Vegetation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSlider_Humidité, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSlider_Grain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel_Longueur)
                                            .addComponent(jTextField_Longueur, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(24, 24, 24)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel_Largeur)
                                            .addComponent(jTextField_Largeur)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jTextField_Graine, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jTextField_NbDepart, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jSlider_ForceVent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jRadioButton_Nord, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jRadioButton_Sud, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jRadioButton_Ouest, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jRadioButton_Est, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jButton_GeneTerrain, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_Annuler, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_Demarrer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Longueur)
                    .addComponent(jLabel_Largeur))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Taille, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Longueur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Largeur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSlider_Humidité, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Humidité, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_Vege)
                            .addComponent(jSlider_Pourcentage_Vegetation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSlider_Grain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_Grain)
                        .addGap(50, 50, 50)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Graine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Graine))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_Direction_Vent)
                            .addComponent(jRadioButton_Nord)
                            .addComponent(jRadioButton_Sud)
                            .addComponent(jRadioButton_Ouest)
                            .addComponent(jRadioButton_Est)
                            .addComponent(jButton_Demarrer, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_Force_Vent)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jSlider_ForceVent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_Annuler, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_NbDepart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_Nb_Depart))
                        .addGap(42, 42, 42)
                        .addComponent(jButton_GeneTerrain, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_Message)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(287, 287, 287)
                        .addComponent(jButton_Quitter, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 49, 49))
        );

        jSlider_Pourcentage_Vegetation.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // bouton pour lancer une simulation
    private void jButton_DemarrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DemarrerActionPerformed
        jTextArea_Message.selectAll();
        jTextArea_Message.replaceSelection("SIMULATION EN COURS");
        if(DemarrageOK == true){
            terrain.Depart_Feu(Nb_Depart); // on lance Nb_Depart departs de feu
            t = new Timer(); 
            t.schedule(new Tache(), 0, 100); // on execute notre tache toutes les 100ms
            DemarrageOK = false;
        }
    }//GEN-LAST:event_jButton_DemarrerActionPerformed

    // bouton de la génération du terrain
    private void jButton_GeneTerrainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GeneTerrainActionPerformed

        //Recuperation des valeurs pour la simulation
        
        //Recuperation Longueur
        try{
            Initialisation = true;
            Longueur = Integer.parseInt(jTextField_Longueur.getText()); //On recupere la valeur de la longueur dans le text field
            if(Longueur < 20){   //Si la longueur du terrain est inferieur a 20 alors le tableau est trop petit
                jTextArea_Message.selectAll();
                jTextArea_Message.replaceSelection("LONGUEUR : \nLa valeur n'est pas un entier ou le nombre est trop long");    //On affiche un message d'erreur
                Initialisation = false; //On empêche la simulation de se lancer
            }
            }catch (NumberFormatException ex){  //Dans le cas d'une exceptition on execute la boucle suivante
                jTextArea_Message.selectAll();
                jTextArea_Message.replaceSelection("LONGUEUR : \nLa valeur n'est pas un entier ou le nombre est trop long");    //On affiche un message d'erreur
                Initialisation = false;  //On empêche la simulation de se lancer
                //throw ex;   
            }
            //Recuperation Largeur
            try{
                Largeur = Integer.parseInt(jTextField_Largeur.getText());   //On recupere la valeur de la largeur dans le text field
                if(Largeur < 20){   //Si la largeur du terrain est inferieur a 20 alors le tableau est trop petit
                    jTextArea_Message.selectAll();
                    jTextArea_Message.replaceSelection("LARGEUR : \nLa valeur n'est pas un entier ou le nombre est trop long");    //On affiche un message d'erreur
                    Initialisation = false; //On empêche la simulation de se lancer
                }
            }catch (NumberFormatException ex){  //Dans le cas d'une exceptition on execute la boucle suivante
                jTextArea_Message.selectAll();
                jTextArea_Message.replaceSelection("LARGEUR : \nLa valeur n'est pas un entier ou le nombre est trop long");    //On affiche un message d'erreur
                Initialisation = false; //On empêche la simulation de se lancer
                //throw ex;    
            }
            //Recuperation Humidite
            Humidite = jSlider_Humidité.getValue();
            //Recuperation Pourcentage de Vegetation
            Pourcentage_Vegetation = jSlider_Pourcentage_Vegetation.getValue();
            //Recuperation Grain
            Grain = jSlider_Grain.getValue();
            //Recuperation Graine de generation
            try{
                Graine = Integer.parseInt(jTextField_Graine.getText());   //On recupere la valeur de la graine dans le text field
                if(Graine < 0){   //Si la graine est négative alors on ne lance pas la simulation
                    jTextArea_Message.selectAll();
                    jTextArea_Message.replaceSelection("GRAINE : \nLa valeur ne peut pas être négative");    //On affiche un message d'erreur
                    Initialisation = false; //On empêche la simulation de se lancer
                }
            }catch (NumberFormatException ex){  //Dans le cas d'une exceptition on execute la boucle suivante
                jTextArea_Message.selectAll();
                jTextArea_Message.replaceSelection("GRAINE : \nLa valeur n'est pas un entier ou le nombre est trop long");    //On affiche un message d'erreur
                Initialisation = false; //On empêche la simulation de se lancer
                //throw ex;    
            }
            //Recuperation Direction du vent
            if(jRadioButton_Nord.isSelected()){ //On regarder quel radionbutton est selectionner sur la fenêtre
                Direction_Vent = "NORD";
            }
            else if(jRadioButton_Sud.isSelected()){
                Direction_Vent = "SUD";
            }
            else if(jRadioButton_Est.isSelected()){
                Direction_Vent = "EST";
            }
            else if(jRadioButton_Ouest.isSelected()){
                Direction_Vent = "OUEST";
            }
            else{   //Si aucun n'est selectionné alors on envoie un message et on empeche l'initialisation
                jTextArea_Message.selectAll();
                jTextArea_Message.replaceSelection("DIRECTION_VENT : \nIl faut selectionner une direction");
                Initialisation = false;
            }
            //Recuperation Force du vent
            Force_Vent = jSlider_ForceVent.getValue();
            //Recuperation nombre de depart de feu
            try{
                Nb_Depart = Integer.parseInt(jTextField_NbDepart.getText());   //On recupere le nombre de depart de feu dans le text field
                if(Nb_Depart < 0){   //Si le nombre est négatif alors on ne lance pas la simulation
                    jTextArea_Message.selectAll();
                    jTextArea_Message.replaceSelection("NB_DEPART : \nLa valeur ne peut pas être négative");    //On affiche un message d'erreur
                    Initialisation = false; //On empêche la simulation de se lancer
                }
            }catch (NumberFormatException ex){  //Dans le cas d'une exceptition on execute la boucle suivante
                jTextArea_Message.selectAll();
                jTextArea_Message.replaceSelection("NB_DEPART : \nLa valeur n'est pas un entier ou le nombre est trop long");    //On affiche un message d'erreur
                Initialisation = false; //On empêche la simulation de se lancer
                //throw ex;    
            }
        
        //Initialisation du terrain        
        if(Initialisation == true){
            terrain.CreaTableau(Humidite, Longueur, Largeur); //Creation du terrain
            terrain.Affec_Vege(Pourcentage_Vegetation, Grain, Graine); //Affectation de la vegetation
            wind = new Vent(Direction_Vent, Force_Vent); //Initialisation du vent
            grPanel = new grillePanel(terrain); //Creation du panel de simulation
            this.add(grPanel); // on ajoute à notre fenêtre notre panel
            grPanel.repaint(); // on repaint notre panel pour mettre à jour les couleurs du nouveau panel
            DemarrageOK = true; // notre boolean devient vrai ce qui permet de lancer une simulation
            //On masque tous les components qui ne sont pas utiles dans la partie simulation et affiche ceux qui le sont
            jLabel_Taille.setVisible(false);
            jLabel_Longueur.setVisible(false);
            jLabel_Largeur.setVisible(false);
            jLabel_Humidité.setVisible(false);
            jLabel_Vege.setVisible(false);
            jLabel_Grain.setVisible(false);
            jLabel_Graine.setVisible(false);
            jLabel_Direction_Vent.setVisible(false);
            jLabel_Force_Vent.setVisible(false);
            jLabel_Nb_Depart.setVisible(false);
            jTextField_Longueur.setVisible(false);
            jTextField_Largeur.setVisible(false);
            jTextField_Graine.setVisible(false);
            jTextField_NbDepart.setVisible(false);
            jSlider_Humidité.setVisible(false);
            jSlider_Pourcentage_Vegetation.setVisible(false);
            jSlider_Grain.setVisible(false);
            jSlider_ForceVent.setVisible(false);
            jRadioButton_Nord.setVisible(false);
            jRadioButton_Sud.setVisible(false);
            jRadioButton_Est.setVisible(false);
            jRadioButton_Ouest.setVisible(false);
            jButton_Annuler.setVisible(true);
            jButton_Demarrer.setVisible(true);
            jButton_GeneTerrain.setVisible(false);
            this.setSize(terrain.getGrille().length + 190,terrain.getGrille()[0].length + 200);
            jTextArea_Message.selectAll();
            jTextArea_Message.replaceSelection("TERRAIN INITIALISE");
        }
        
    }//GEN-LAST:event_jButton_GeneTerrainActionPerformed

    private void jButton_AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AnnulerActionPerformed
        t.cancel();
        t.purge();  //On arrête le processus de calcul de propagation
        this.remove(grPanel); //On retire le panel de la fenêtre
        DemarrageOK = true;
        //On masque les buttons qui ne sont pas utiles pour l'initialisation et on affiche ceux qui le sont
        jLabel_Taille.setVisible(true);
        jLabel_Longueur.setVisible(true);
        jLabel_Largeur.setVisible(true);
        jLabel_Humidité.setVisible(true);
        jLabel_Vege.setVisible(true);
        jLabel_Grain.setVisible(true);
        jLabel_Graine.setVisible(true);
        jLabel_Direction_Vent.setVisible(true);
        jLabel_Force_Vent.setVisible(true);
        jLabel_Nb_Depart.setVisible(true);
        jTextField_Longueur.setVisible(true);
        jTextField_Largeur.setVisible(true);
        jTextField_Graine.setVisible(true);
        jTextField_NbDepart.setVisible(true);
        jSlider_Humidité.setVisible(true);
        jSlider_Pourcentage_Vegetation.setVisible(true);
        jSlider_Grain.setVisible(true);
        jSlider_ForceVent.setVisible(true);
        jRadioButton_Nord.setVisible(true);
        jRadioButton_Sud.setVisible(true);
        jRadioButton_Est.setVisible(true);
        jRadioButton_Ouest.setVisible(true);
        jButton_Annuler.setVisible(false);
        jButton_Demarrer.setVisible(false);
        jButton_GeneTerrain.setVisible(true);
        this.pack();
        jTextArea_Message.selectAll();
        jTextArea_Message.replaceSelection("SIMULATION TERMINEE");
    }//GEN-LAST:event_jButton_AnnulerActionPerformed

    private void jButton_QuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_QuitterActionPerformed
        System.exit(0);
        
    }//GEN-LAST:event_jButton_QuitterActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // attributs : 
    private int Humidite;
    private int Longueur;
    private int Largeur;
    private int Pourcentage_Vegetation;
    private int Grain;
    private long Graine;
    private String Direction_Vent;
    private int Force_Vent;
    private int Nb_Depart;
    static Terrain terrain =new Terrain();  
    static Vent wind;
    boolean DemarrageOK = false;
    boolean Initialisation = true;
    
    public static void main(String args[]) {
        Fenetre window = new Fenetre();
        window.setVisible(true);
        window.jButton_Annuler.setVisible(false);
        window.jButton_Demarrer.setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jButton_Annuler;
    private javax.swing.JButton jButton_Demarrer;
    private javax.swing.JButton jButton_GeneTerrain;
    private javax.swing.JButton jButton_Quitter;
    private javax.swing.JLabel jLabel_Direction_Vent;
    private javax.swing.JLabel jLabel_Force_Vent;
    private javax.swing.JLabel jLabel_Grain;
    private javax.swing.JLabel jLabel_Graine;
    private javax.swing.JLabel jLabel_Humidité;
    private javax.swing.JLabel jLabel_Largeur;
    private javax.swing.JLabel jLabel_Longueur;
    private javax.swing.JLabel jLabel_Message;
    private javax.swing.JLabel jLabel_Nb_Depart;
    private javax.swing.JLabel jLabel_Taille;
    private javax.swing.JLabel jLabel_Vege;
    private javax.swing.JRadioButton jRadioButton_Est;
    private javax.swing.JRadioButton jRadioButton_Nord;
    private javax.swing.JRadioButton jRadioButton_Ouest;
    private javax.swing.JRadioButton jRadioButton_Sud;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider_ForceVent;
    private javax.swing.JSlider jSlider_Grain;
    private javax.swing.JSlider jSlider_Humidité;
    private javax.swing.JSlider jSlider_Pourcentage_Vegetation;
    private javax.swing.JTextArea jTextArea_Message;
    private javax.swing.JTextField jTextField_Graine;
    private javax.swing.JTextField jTextField_Largeur;
    private javax.swing.JTextField jTextField_Longueur;
    private javax.swing.JTextField jTextField_NbDepart;
    // End of variables declaration//GEN-END:variables
}
