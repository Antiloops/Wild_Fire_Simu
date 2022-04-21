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
public class Vent {
    
    //Initialisation des attributs     
    private String Sens_Vent;   
    private int Force_Vent;
    private int[][] Repartition_Vent;
    
    //Constructeur  
    public Vent(String sens,int force){ 
        this.Sens_Vent = sens;
        this.Force_Vent = force;
    }
    
    //Getter -> Méthodes qui retourne les attributs de la case : le sens du vent, la force et le tableau de répartition du vent
    public String getSens(){
        return this.Sens_Vent;
    }
    
    public int getForce(){
        return this.Force_Vent;
    }
    
    public int[][] getRepartition(){
        return this.Repartition_Vent;
    }
    
    //Setter -> Méthodes qui modifie les attributs de la case par un argument en entrée pour : le sens du vent, la force et le tableau de répartition du vent
    public void setSens(String Sens_Vent){
        this.Sens_Vent = Sens_Vent;
    }
    
    public void setForce(int Force_Vent){
        this.Force_Vent = Force_Vent;
    }
    
    public void setRepartition(int[][] Repartition_Vent){
        this.Repartition_Vent = Repartition_Vent;
    }
    
    
    public void Rotation_Matrice_AntiHoraire(int[][] OldRepartition){ //Méthode permettant de tourner un tableau de taille nxn dans le sens antihoraire 
        int[][] NewRepartition = new int[7][7]; //Création d'un tableau temporaire
        for(int i=0;i<NewRepartition.length;i++){   //Parcours du tableau 
            for(int j=0;j<NewRepartition[0].length;j++){
                NewRepartition[j][6-i] = OldRepartition[i][j];  //Affectation des probabilités dans la nouvelle matrice.
            }
        }
        this.Repartition_Vent = NewRepartition; 
    }
    
    public void Rotation_Matrice_Horaire(int[][] OldRepartition){   //Méthode permettant de tourner une matrice de taille nxn dans le sens horaire
        int[][] NewRepartition = new int[7][7]; //Création d'un tableau temporaire
        for(int i=0;i<NewRepartition.length;i++){   //Parcours du tableau
            for(int j=0;j<NewRepartition[0].length;j++){
                NewRepartition[6-j][i] = OldRepartition[i][j];  //Affectation des probabilités dans la nouvelle matrice.
            }
        }
        this.Repartition_Vent = NewRepartition;
    }
    
    public void Rotation_Matrice_180(int[][] OldRepartition){   //Méthode permettant de tourner un tableau de taille nxn dans de 180 degrés
        int[][] NewRepartition = new int[7][7]; //Création d'un tableau temporaire
        for(int i=0;i<NewRepartition.length;i++){   //Parcours du tableau
            for(int j=0;j<NewRepartition[0].length;j++){
                NewRepartition[j][6-i] = OldRepartition[j][i];  //Affectation des probabilités dans la nouvelle matrice.
            }
        }
        this.Repartition_Vent = NewRepartition;
    }
    
    
    
    //Methode qui retourne la carte de probabilite de la probagation du feu en fonction des attributs de Vent
    public void Repartion_Vent(){
        int[][] Repartition = new int[7][7];
        if(this.Force_Vent == 0){
            Repartition[0][0] = 0; Repartition[0][1] = 0; Repartition[0][2] = 0; Repartition[0][3] = 0; Repartition[0][4] = 0; Repartition[0][5] = 0; Repartition[0][6] = 0;
            Repartition[1][0] = 0; Repartition[1][1] = 0; Repartition[1][2] = 1; Repartition[1][3] = 1; Repartition[1][4] = 1; Repartition[1][5] = 0; Repartition[1][6] = 0;
            Repartition[2][0] = 0; Repartition[2][1] = 1; Repartition[2][2] = 20; Repartition[2][3] = 30; Repartition[2][4] = 20; Repartition[2][5] = 1; Repartition[2][6] = 0;
            Repartition[3][0] = 0; Repartition[3][1] = 1; Repartition[3][2] = 30; Repartition[3][3] = 0; Repartition[3][4] = 30; Repartition[3][5] = 1; Repartition[3][6] = 0;
            Repartition[4][0] = 0; Repartition[4][1] = 1; Repartition[4][2] = 20; Repartition[4][3] = 30; Repartition[4][4] = 20; Repartition[4][5] = 1; Repartition[4][6] = 0;
            Repartition[5][0] = 0; Repartition[5][1] = 0; Repartition[5][2] = 1; Repartition[5][3] = 1; Repartition[5][4] = 1; Repartition[5][5] = 0; Repartition[5][6] = 0;
            Repartition[6][0] = 0; Repartition[6][1] = 0; Repartition[6][2] = 0; Repartition[6][3] = 0; Repartition[6][4] = 0; Repartition[6][5] = 0; Repartition[6][6] = 0;
        }
        else if(this.Force_Vent == 1){
            Repartition[0][0] = 0; Repartition[0][1] = 0; Repartition[0][2] = 0; Repartition[0][3] = 0; Repartition[0][4] = 0; Repartition[0][5] = 0; Repartition[0][6] = 0;
            Repartition[1][0] = 0; Repartition[1][1] = 0; Repartition[1][2] = 0; Repartition[1][3] = 0; Repartition[1][4] = 0; Repartition[1][5] = 0; Repartition[1][6] = 0;
            Repartition[2][0] = 0; Repartition[2][1] = 0; Repartition[2][2] = 10; Repartition[2][3] = 20; Repartition[2][4] = 10; Repartition[2][5] = 0; Repartition[2][6] = 0;
            Repartition[3][0] = 0; Repartition[3][1] = 0; Repartition[3][2] = 30; Repartition[3][3] = 0; Repartition[4][3] = 30; Repartition[3][5] = 0; Repartition[3][6] = 0;
            Repartition[4][0] = 0; Repartition[1][4] = 0; Repartition[2][4] = 30; Repartition[3][4] = 40; Repartition[4][4] = 30; Repartition[4][5] = 0; Repartition[4][6] = 0;
            Repartition[5][0] = 0; Repartition[1][5] = 0; Repartition[5][2] = 2; Repartition[5][3] = 5; Repartition[5][4] = 2; Repartition[5][5] = 0; Repartition[5][6] = 0;
            Repartition[6][0] = 0; Repartition[6][1] = 0; Repartition[6][2] = 0; Repartition[6][3] = 0; Repartition[6][4] = 0; Repartition[5][6] = 0; Repartition[6][6] = 0;
        }
        else if(this.Force_Vent == 2){
            Repartition[0][0] = 0; Repartition[0][1] = 0; Repartition[0][2] = 0; Repartition[0][3] = 0; Repartition[0][4] = 0; Repartition[0][5] = 0; Repartition[0][6] = 0;
            Repartition[1][0] = 0; Repartition[1][1] = 0; Repartition[1][2] = 0; Repartition[1][3] = 0; Repartition[1][4] = 0; Repartition[1][5] = 0; Repartition[1][6] = 0;
            Repartition[2][0] = 0; Repartition[2][1] = 0; Repartition[2][2] = 5; Repartition[2][3] = 10; Repartition[2][4] = 5; Repartition[2][5] = 0; Repartition[2][6] = 0;
            Repartition[3][0] = 0; Repartition[3][1] = 0; Repartition[3][2] = 25; Repartition[3][3] = 0; Repartition[3][4] = 25; Repartition[3][5] = 0; Repartition[3][6] = 0;
            Repartition[4][0] = 0; Repartition[4][1] = 0; Repartition[4][2] = 40; Repartition[4][3] = 40; Repartition[4][4] = 40; Repartition[4][5] = 0; Repartition[4][6] = 0;
            Repartition[5][0] = 0; Repartition[5][1] = 0; Repartition[5][2] = 5; Repartition[5][3] = 10; Repartition[5][4] = 5; Repartition[5][5] = 0; Repartition[5][6] = 0;
            Repartition[6][0] = 0; Repartition[6][1] = 0; Repartition[6][2] = 0; Repartition[6][3] = 1; Repartition[6][4] = 0; Repartition[6][5]  = 0; Repartition[6][6] = 0;
        }
        
        else if(this.Force_Vent == 3){
            Repartition[0][0] = 0; Repartition[0][1] = 0; Repartition[0][2] = 0; Repartition[0][3] = 0; Repartition[0][4] = 0; Repartition[0][5] = 0; Repartition[0][6] = 0;
            Repartition[1][0] = 0; Repartition[1][1] = 0; Repartition[1][2] = 0; Repartition[1][3] = 0; Repartition[1][4] = 0; Repartition[1][5] = 0; Repartition[1][6] = 0;
            Repartition[2][0] = 0; Repartition[2][1] = 0; Repartition[2][2] = 0; Repartition[2][3] = 0; Repartition[2][4] = 0; Repartition[2][5] = 0; Repartition[2][6] = 0;
            Repartition[3][0] = 0; Repartition[3][1] = 0; Repartition[3][2] = 10; Repartition[3][3] = 0; Repartition[3][4] = 10; Repartition[3][5] = 0; Repartition[3][6] = 0;
            Repartition[4][0] = 0; Repartition[4][1] = 0; Repartition[4][2] = 50; Repartition[4][3] = 70; Repartition[4][4] = 50; Repartition[4][5] = 0; Repartition[4][6] = 0;
            Repartition[5][0] = 0; Repartition[5][1] = 0; Repartition[5][2] = 20; Repartition[5][3] = 30; Repartition[5][4] = 20; Repartition[5][5] = 0; Repartition[5][6] = 0;
            Repartition[6][0] = 0; Repartition[6][1] = 0; Repartition[6][2] = 1; Repartition[6][3] = 5; Repartition[6][4] = 1; Repartition[6][5]  = 0; Repartition[6][6] = 0;
        }
        /*if(this.Force_Vent == 0){
            Repartition[0][0] = 0; Repartition[1][0] = 0; Repartition[2][0] = 0; Repartition[3][0] = 0; Repartition[4][0] = 0; Repartition[5][0] = 0; Repartition[6][0] = 0;
            Repartition[0][1] = 0; Repartition[1][1] = 0; Repartition[2][1] = 1; Repartition[3][1] = 1; Repartition[4][1] = 1; Repartition[5][1] = 0; Repartition[6][1] = 0;
            Repartition[0][2] = 0; Repartition[1][2] = 1; Repartition[2][2] = 20; Repartition[3][2] = 30; Repartition[4][2] = 20; Repartition[5][2] = 1; Repartition[6][2] = 0;
            Repartition[0][3] = 0; Repartition[1][3] = 1; Repartition[2][3] = 30; Repartition[3][3] = 0; Repartition[4][3] = 30; Repartition[5][3] = 1; Repartition[6][3] = 0;
            Repartition[0][4] = 0; Repartition[1][4] = 1; Repartition[2][4] = 20; Repartition[3][4] = 30; Repartition[4][4] = 20; Repartition[5][4] = 1; Repartition[6][4] = 0;
            Repartition[0][5] = 0; Repartition[1][5] = 0; Repartition[2][5] = 1; Repartition[3][5] = 1; Repartition[4][5] = 1; Repartition[5][5] = 0; Repartition[6][5] = 0;
            Repartition[0][6] = 0; Repartition[1][6] = 0; Repartition[2][6] = 0; Repartition[3][6] = 0; Repartition[4][6] = 0; Repartition[5][6] = 0; Repartition[6][6] = 0;
        }
        else if(this.Force_Vent == 1){
            Repartition[0][0] = 0; Repartition[1][0] = 0; Repartition[2][0] = 0; Repartition[3][0] = 0; Repartition[4][0] = 0; Repartition[5][0] = 0; Repartition[6][0] = 0;
            Repartition[0][1] = 0; Repartition[1][1] = 0; Repartition[2][1] = 0; Repartition[3][1] = 0; Repartition[4][1] = 0; Repartition[5][1] = 0; Repartition[6][1] = 0;
            Repartition[0][2] = 0; Repartition[1][2] = 0; Repartition[2][2] = 10; Repartition[3][2] = 20; Repartition[4][2] = 10; Repartition[5][2] = 0; Repartition[6][2] = 0;
            Repartition[0][3] = 0; Repartition[1][3] = 0; Repartition[2][3] = 30; Repartition[3][3] = 0; Repartition[4][3] = 30; Repartition[5][3] = 0; Repartition[6][3] = 0;
            Repartition[0][4] = 0; Repartition[1][4] = 0; Repartition[2][4] = 30; Repartition[3][4] = 40; Repartition[4][4] = 30; Repartition[5][4] = 0; Repartition[6][4] = 0;
            Repartition[0][5] = 0; Repartition[1][5] = 0; Repartition[2][5] = 2; Repartition[3][5] = 5; Repartition[4][5] = 2; Repartition[5][5] = 0; Repartition[6][5] = 0;
            Repartition[0][6] = 0; Repartition[1][6] = 0; Repartition[2][6] = 0; Repartition[3][6] = 0; Repartition[4][6] = 0; Repartition[5][6] = 0; Repartition[6][6] = 0;
        }
        else if(this.Force_Vent == 2){
            Repartition[0][0] = 0; Repartition[1][0] = 0; Repartition[2][0] = 0; Repartition[3][0] = 0; Repartition[4][0] = 0; Repartition[5][0] = 0; Repartition[6][0] = 0;
            Repartition[0][1] = 0; Repartition[1][1] = 0; Repartition[2][1] = 0; Repartition[3][1] = 0; Repartition[4][1] = 0; Repartition[5][1] = 0; Repartition[6][1] = 0;
            Repartition[0][2] = 0; Repartition[1][2] = 0; Repartition[2][2] = 5; Repartition[3][2] = 10; Repartition[4][2] = 5; Repartition[5][2] = 0; Repartition[6][2] = 0;
            Repartition[0][3] = 0; Repartition[1][3] = 0; Repartition[2][3] = 25; Repartition[3][3] = 0; Repartition[4][3] = 25; Repartition[5][3] = 0; Repartition[6][3] = 0;
            Repartition[0][4] = 0; Repartition[1][4] = 0; Repartition[2][4] = 40; Repartition[3][4] = 40; Repartition[4][4] = 40; Repartition[5][4] = 0; Repartition[6][4] = 0;
            Repartition[0][5] = 0; Repartition[1][5] = 0; Repartition[2][5] = 5; Repartition[3][5] = 10; Repartition[4][5] = 5; Repartition[5][5] = 0; Repartition[6][5] = 0;
            Repartition[0][6] = 0; Repartition[1][6] = 0; Repartition[2][6] = 0; Repartition[3][6] = 1; Repartition[4][6] = 0; Repartition[5][6] = 0; Repartition[6][6] = 0;
        }
        
        else if(this.Force_Vent == 3){
            Repartition[0][0] = 0; Repartition[1][0] = 0; Repartition[2][0] = 0; Repartition[3][0] = 0; Repartition[4][0] = 0; Repartition[5][0] = 0; Repartition[6][0] = 0;
            Repartition[0][1] = 0; Repartition[1][1] = 0; Repartition[2][1] = 0; Repartition[3][1] = 0; Repartition[4][1] = 0; Repartition[5][1] = 0; Repartition[6][1] = 0;
            Repartition[0][2] = 0; Repartition[1][2] = 0; Repartition[2][2] = 0; Repartition[3][2] = 0; Repartition[4][2] = 0; Repartition[5][2] = 0; Repartition[6][2] = 0;
            Repartition[0][3] = 0; Repartition[1][3] = 0; Repartition[2][3] = 10; Repartition[3][3] = 0; Repartition[4][3] = 10; Repartition[5][3] = 0; Repartition[6][3] = 0;
            Repartition[0][4] = 0; Repartition[1][4] = 0; Repartition[2][4] = 50; Repartition[3][4] = 70; Repartition[4][4] = 50; Repartition[5][4] = 0; Repartition[6][4] = 0;
            Repartition[0][5] = 0; Repartition[1][5] = 0; Repartition[2][5] = 20; Repartition[3][5] = 30; Repartition[4][5] = 20; Repartition[5][5] = 0; Repartition[6][5] = 0;
            Repartition[0][6] = 0; Repartition[1][6] = 0; Repartition[2][6] = 1; Repartition[3][6] = 5; Repartition[4][6] = 1; Repartition[5][6] = 0; Repartition[6][6] = 0;
        }*/
        if(this.Sens_Vent.equalsIgnoreCase("nord")){
            this.Repartition_Vent = Repartition;    //On assigne directement la Repartition à Repartition_Vent
        }
        else if(this.Sens_Vent.equalsIgnoreCase("sud")){
            Rotation_Matrice_180(Repartition);      //On tourne la matrice Repartition de 180d et on l'assigne à Repartition_Vent
        }
        else if(this.Sens_Vent.equalsIgnoreCase("est")){
            Rotation_Matrice_Horaire(Repartition);  //On tourne la matrice Repartition dans le sens horaire et on l'assigne à Repartition_Vent
        }
        else if(this.Sens_Vent.equalsIgnoreCase("ouest")){
            Rotation_Matrice_AntiHoraire(Repartition);  //On tourne la matrice Repartition dans le sens antihoraire et on l'assigne à Repartition_Vent
        }
    }
}
