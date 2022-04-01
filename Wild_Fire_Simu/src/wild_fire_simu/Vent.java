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
    
    //Getter -> Méthodes qui retourne les attributs de la case : la vegatation, la niveau de combustion ou le risque
    public String getSens_Vent(){
        return this.Sens_Vent;
    }
    
    public int getForce_Vent(){
        return this.Force_Vent;
    }
    
    public int[][] getRepartition(){
        return this.Repartition_Vent;
    }
    
    //Setter -> Méthodes qui modifie les attributs de la case par un argument en entrée pour : la vegetation, la combustion ou le risque
    public void setSens_Vent(String Sens_Vent){
        this.Sens_Vent = Sens_Vent;
    }
    
    public void setForce_Vent(int Force_Vent){
        this.Force_Vent = Force_Vent;
    }
    
    public void setCombustion(int[][] Repartition_Vent){
        this.Repartition_Vent = Repartition_Vent;
    }
    
    //Methode qui retourne la carte de probabilite de la probagation du feu en fonction des attributs de Vent
    public void Repartion_Vent(){
        int[][] Repartition = new int[7][7];
        if(this.Force_Vent == 0){
            Repartition[0][0] = 0; Repartition[1][0] = 0; Repartition[2][0] = 0; Repartition[3][0] = 0; Repartition[4][0] = 0; Repartition[5][0] = 0; Repartition[6][0] = 0;
            Repartition[0][1] = 0; Repartition[1][1] = 0; Repartition[2][1] = 1; Repartition[3][1] = 1; Repartition[4][1] = 1; Repartition[5][1] = 0; Repartition[6][1] = 0;
            Repartition[0][2] = 0; Repartition[1][2] = 1; Repartition[2][2] = 20; Repartition[3][2] = 30; Repartition[4][2] = 20; Repartition[5][2] = 1; Repartition[6][2] = 0;
            Repartition[0][3] = 0; Repartition[1][3] = 1; Repartition[2][3] = 30; Repartition[3][3] = 0; Repartition[4][3] = 30; Repartition[5][3] = 1; Repartition[6][3] = 0;
            Repartition[0][4] = 0; Repartition[1][4] = 1; Repartition[2][4] = 20; Repartition[3][4] = 30; Repartition[4][4] = 20; Repartition[5][4] = 1; Repartition[6][4] = 0;
            Repartition[0][5] = 0; Repartition[1][5] = 0; Repartition[2][5] = 1; Repartition[3][5] = 1; Repartition[4][5] = 1; Repartition[5][5] = 0; Repartition[6][5] = 0;
            Repartition[0][6] = 0; Repartition[1][6] = 0; Repartition[2][6] = 0; Repartition[3][6] = 0; Repartition[4][6] = 0; Repartition[5][6] = 0; Repartition[6][6] = 0;
        }
        if("nord".equalsIgnoreCase(this.Sens_Vent)){
            if(this.Force_Vent == 1){
                Repartition[0][0] = 0; Repartition[1][0] = 0; Repartition[2][0] = 0; Repartition[3][0] = 0; Repartition[4][0] = 0; Repartition[5][0] = 0; Repartition[6][0] = 0;
                Repartition[0][1] = 0; Repartition[1][1] = 0; Repartition[2][1] = 0; Repartition[3][1] = 0; Repartition[4][1] = 0; Repartition[5][1] = 0; Repartition[6][1] = 0;
                Repartition[0][2] = 0; Repartition[1][2] = 0; Repartition[2][2] = 10; Repartition[3][2] = 20; Repartition[4][2] = 10; Repartition[5][2] = 0; Repartition[6][2] = 0;
                Repartition[0][3] = 0; Repartition[1][3] = 0; Repartition[2][3] = 30; Repartition[3][3] = 0; Repartition[4][3] = 30; Repartition[5][3] = 0; Repartition[6][3] = 0;
                Repartition[0][4] = 0; Repartition[1][4] = 0; Repartition[2][4] = 30; Repartition[3][4] = 40; Repartition[4][4] = 30; Repartition[5][4] = 0; Repartition[6][4] = 0;
                Repartition[0][5] = 0; Repartition[1][5] = 0; Repartition[2][5] = 2; Repartition[3][5] = 5; Repartition[4][5] = 2; Repartition[5][5] = 0; Repartition[6][5] = 0;
                Repartition[0][6] = 0; Repartition[1][6] = 0; Repartition[2][6] = 0; Repartition[3][6] = 0; Repartition[4][6] = 0; Repartition[5][6] = 0; Repartition[6][6] = 0;
            }
            if(this.Force_Vent == 2){
                Repartition[0][0] = 0; Repartition[1][0] = 0; Repartition[2][0] = 0; Repartition[3][0] = 0; Repartition[4][0] = 0; Repartition[5][0] = 0; Repartition[6][0] = 0;
                Repartition[0][1] = 0; Repartition[1][1] = 0; Repartition[2][1] = 0; Repartition[3][1] = 0; Repartition[4][1] = 0; Repartition[5][1] = 0; Repartition[6][1] = 0;
                Repartition[0][2] = 0; Repartition[1][2] = 0; Repartition[2][2] = 5; Repartition[3][2] = 10; Repartition[4][2] = 5; Repartition[5][2] = 0; Repartition[6][2] = 0;
                Repartition[0][3] = 0; Repartition[1][3] = 0; Repartition[2][3] = 25; Repartition[3][3] = 0; Repartition[4][3] = 25; Repartition[5][3] = 0; Repartition[6][3] = 0;
                Repartition[0][4] = 0; Repartition[1][4] = 0; Repartition[2][4] = 40; Repartition[3][4] = 40; Repartition[4][4] = 40; Repartition[5][4] = 0; Repartition[6][4] = 0;
                Repartition[0][5] = 0; Repartition[1][5] = 0; Repartition[2][5] = 5; Repartition[3][5] = 10; Repartition[4][5] = 5; Repartition[5][5] = 0; Repartition[6][5] = 0;
                Repartition[0][6] = 0; Repartition[1][6] = 0; Repartition[2][6] = 0; Repartition[3][6] = 1; Repartition[4][6] = 0; Repartition[5][6] = 0; Repartition[6][6] = 0;
            }
            if(this.Force_Vent == 3){
                Repartition[0][0] = 0; Repartition[1][0] = 0; Repartition[2][0] = 0; Repartition[3][0] = 0; Repartition[4][0] = 0; Repartition[5][0] = 0; Repartition[6][0] = 0;
                Repartition[0][1] = 0; Repartition[1][1] = 0; Repartition[2][1] = 0; Repartition[3][1] = 0; Repartition[4][1] = 0; Repartition[5][1] = 0; Repartition[6][1] = 0;
                Repartition[0][2] = 0; Repartition[1][2] = 1; Repartition[2][2] = 0; Repartition[3][2] = 0; Repartition[4][2] = 0; Repartition[5][2] = 1; Repartition[6][2] = 0;
                Repartition[0][3] = 0; Repartition[1][3] = 1; Repartition[2][3] = 10; Repartition[3][3] = 0; Repartition[4][3] = 10; Repartition[5][3] = 1; Repartition[6][3] = 0;
                Repartition[0][4] = 0; Repartition[1][4] = 1; Repartition[2][4] = 50; Repartition[3][4] = 70; Repartition[4][4] = 50; Repartition[5][4] = 1; Repartition[6][4] = 0;
                Repartition[0][5] = 0; Repartition[1][5] = 0; Repartition[2][5] = 20; Repartition[3][5] = 30; Repartition[4][5] = 20; Repartition[5][5] = 0; Repartition[6][5] = 0;
                Repartition[0][6] = 0; Repartition[1][6] = 0; Repartition[2][6] = 1; Repartition[3][6] = 5; Repartition[4][6] = 1; Repartition[5][6] = 0; Repartition[6][6] = 0;
            }
        }
        if("sud".equalsIgnoreCase(this.Sens_Vent)){
            if(this.Force_Vent == 1){
                Repartition[0][0] = 0; Repartition[1][0] = 0; Repartition[2][0] = 0; Repartition[3][0] = 0; Repartition[4][0] = 0; Repartition[5][0] = 0; Repartition[6][0] = 0;
                Repartition[0][1] = 0; Repartition[1][1] = 0; Repartition[2][1] = 2; Repartition[3][1] = 5; Repartition[4][1] = 2; Repartition[5][1] = 0; Repartition[6][1] = 0;
                Repartition[0][2] = 0; Repartition[1][2] = 0; Repartition[2][2] = 30; Repartition[3][2] = 40; Repartition[4][2] = 30; Repartition[5][2] = 0; Repartition[6][2] = 0;
                Repartition[0][3] = 0; Repartition[1][3] = 0; Repartition[2][3] = 30; Repartition[3][3] = 0; Repartition[4][3] = 30; Repartition[5][3] = 0; Repartition[6][3] = 0;
                Repartition[0][4] = 0; Repartition[1][4] = 0; Repartition[2][4] = 10; Repartition[3][4] = 20; Repartition[4][4] = 10; Repartition[5][4] = 0; Repartition[6][4] = 0;
                Repartition[0][5] = 0; Repartition[1][5] = 0; Repartition[2][5] = 0; Repartition[3][5] = 0; Repartition[4][5] = 0; Repartition[5][5] = 0; Repartition[6][5] = 0;
                Repartition[0][6] = 0; Repartition[1][6] = 0; Repartition[2][6] = 0; Repartition[3][6] = 0; Repartition[4][6] = 0; Repartition[5][6] = 0; Repartition[6][6] = 0;
            }
            if(this.Force_Vent == 2){
                Repartition[0][0] = 0; Repartition[1][0] = 0; Repartition[2][0] = 0; Repartition[3][0] = 1; Repartition[4][0] = 0; Repartition[5][0] = 0; Repartition[6][0] = 0;
                Repartition[0][1] = 0; Repartition[1][1] = 0; Repartition[2][1] = 5; Repartition[3][1] = 10; Repartition[4][1] = 5; Repartition[5][1] = 0; Repartition[6][1] = 0;
                Repartition[0][2] = 0; Repartition[1][2] = 0; Repartition[2][2] = 40; Repartition[3][2] = 50; Repartition[4][2] = 40; Repartition[5][2] = 0; Repartition[6][2] = 0;
                Repartition[0][3] = 0; Repartition[1][3] = 0; Repartition[2][3] = 25; Repartition[3][3] = 0; Repartition[4][3] = 25; Repartition[5][3] = 0; Repartition[6][3] = 0;
                Repartition[0][4] = 0; Repartition[1][4] = 0; Repartition[2][4] =5; Repartition[3][4] = 10; Repartition[4][4] = 5; Repartition[5][4] = 0; Repartition[6][4] = 0;
                Repartition[0][5] = 0; Repartition[1][5] = 0; Repartition[2][5] = 0; Repartition[3][5] = 0; Repartition[4][5] = 0; Repartition[5][5] = 0; Repartition[6][5] = 0;
                Repartition[0][6] = 0; Repartition[1][6] = 0; Repartition[2][6] = 0; Repartition[3][6] = 1; Repartition[4][6] = 0; Repartition[5][6] = 0; Repartition[6][6] = 0;
            }
            if(this.Force_Vent == 3){
                Repartition[0][0] = 0; Repartition[1][0] = 0; Repartition[2][0] = 1; Repartition[3][0] = 5; Repartition[4][0] = 1; Repartition[5][0] = 0; Repartition[6][0] = 0;
                Repartition[0][1] = 0; Repartition[1][1] = 0; Repartition[2][1] = 20; Repartition[3][1] = 30; Repartition[4][1] = 20; Repartition[5][1] = 0; Repartition[6][1] = 0;
                Repartition[0][2] = 0; Repartition[1][2] = 0; Repartition[2][2] = 50; Repartition[3][2] = 70; Repartition[4][2] = 50; Repartition[5][2] = 0; Repartition[6][2] = 0;
                Repartition[0][3] = 0; Repartition[1][3] = 0; Repartition[2][3] = 10; Repartition[3][3] = 0; Repartition[4][3] = 10; Repartition[5][3] = 0; Repartition[6][3] = 0;
                Repartition[0][4] = 0; Repartition[1][4] = 0; Repartition[2][4] = 0; Repartition[3][4] = 0; Repartition[4][4] = 0; Repartition[5][4] = 1; Repartition[6][4] = 0;
                Repartition[0][5] = 0; Repartition[1][5] = 0; Repartition[2][5] = 0; Repartition[3][5] = 0; Repartition[4][5] = 0; Repartition[5][5] = 0; Repartition[6][5] = 0;
                Repartition[0][6] = 0; Repartition[1][6] = 0; Repartition[2][6] = 0; Repartition[3][6] = 0; Repartition[4][6] = 0; Repartition[5][6] = 0; Repartition[6][6] = 0;
            }
        }
        if("est".equalsIgnoreCase(this.Sens_Vent)){
            if(this.Force_Vent == 1){
                Repartition[0][0] = 0; Repartition[1][0] = 0; Repartition[2][0] = 0; Repartition[3][0] = 0; Repartition[4][0] = 0; Repartition[5][0] = 0; Repartition[6][0] = 0;
                Repartition[0][1] = 0; Repartition[1][1] = 0; Repartition[2][1] = 0; Repartition[3][1] = 0; Repartition[4][1] = 0; Repartition[5][1] = 0; Repartition[6][1] = 0;
                Repartition[0][2] = 0; Repartition[1][2] = 2; Repartition[2][2] = 30; Repartition[3][2] = 30; Repartition[4][2] = 10; Repartition[5][2] = 0; Repartition[6][2] = 0;
                Repartition[0][3] = 0; Repartition[1][3] = 5; Repartition[2][3] = 40; Repartition[3][3] = 0; Repartition[4][3] = 20; Repartition[5][3] = 0; Repartition[6][3] = 0;
                Repartition[0][4] = 0; Repartition[1][4] = 2; Repartition[2][4] = 30; Repartition[3][4] = 30; Repartition[4][4] = 10; Repartition[5][4] = 0; Repartition[6][4] = 0;
                Repartition[0][5] = 0; Repartition[1][5] = 0; Repartition[2][5] = 0; Repartition[3][5] = 0; Repartition[4][5] = 0; Repartition[5][5] = 0; Repartition[6][5] = 0;
                Repartition[0][6] = 0; Repartition[1][6] = 0; Repartition[2][6] = 0; Repartition[3][6] = 0; Repartition[4][6] = 0; Repartition[5][6] = 0; Repartition[6][6] = 0;
            }
            if(this.Force_Vent == 2){
                Repartition[0][0] = 0; Repartition[1][0] = 0; Repartition[2][0] = 0; Repartition[3][0] = 0; Repartition[4][0] = 0; Repartition[5][0] = 0; Repartition[6][0] = 0;
                Repartition[0][1] = 0; Repartition[1][1] = 0; Repartition[2][1] = 5; Repartition[3][1] = 0; Repartition[4][1] = 0; Repartition[5][1] = 0; Repartition[6][1] = 0;
                Repartition[0][2] = 0; Repartition[1][2] = 5; Repartition[2][2] = 40; Repartition[3][2] = 25; Repartition[4][2] = 5; Repartition[5][2] = 0; Repartition[6][2] = 0;
                Repartition[0][3] = 1; Repartition[1][3] = 10; Repartition[2][3] = 50; Repartition[3][3] = 0; Repartition[4][3] = 10; Repartition[5][3] = 0; Repartition[6][3] = 0;
                Repartition[0][4] = 0; Repartition[1][4] = 5; Repartition[2][4] =40; Repartition[3][4] = 25; Repartition[4][4] = 5; Repartition[5][4] = 0; Repartition[6][4] = 0;
                Repartition[0][5] = 0; Repartition[1][5] = 0; Repartition[2][5] = 0; Repartition[3][5] = 0; Repartition[4][5] = 0; Repartition[5][5] = 0; Repartition[6][5] = 0;
                Repartition[0][6] = 0; Repartition[1][6] = 0; Repartition[2][6] = 0; Repartition[3][6] = 0; Repartition[4][6] = 0; Repartition[5][6] = 0; Repartition[6][6] = 0;
            }
            if(this.Force_Vent == 3){
                Repartition[0][0] = 0; Repartition[1][0] = 0; Repartition[2][0] = 0; Repartition[3][0] = 0; Repartition[4][0] = 0; Repartition[5][0] = 0; Repartition[6][0] = 0;
                Repartition[0][1] = 0; Repartition[1][1] = 0; Repartition[2][1] = 0; Repartition[3][1] = 0; Repartition[4][1] = 0; Repartition[5][1] = 0; Repartition[6][1] = 0;
                Repartition[0][2] = 1; Repartition[1][2] = 20; Repartition[2][2] = 50; Repartition[3][2] = 10; Repartition[4][2] = 0; Repartition[5][2] = 0; Repartition[6][2] = 0;
                Repartition[0][3] = 5; Repartition[1][3] = 30; Repartition[2][3] = 70; Repartition[3][3] = 0; Repartition[4][3] = 0; Repartition[5][3] = 0; Repartition[6][3] = 0;
                Repartition[0][4] = 1; Repartition[1][4] = 20; Repartition[2][4] = 50; Repartition[3][4] = 10; Repartition[4][4] = 0; Repartition[5][4] = 1; Repartition[6][4] = 0;
                Repartition[0][5] = 0; Repartition[1][5] = 0; Repartition[2][5] = 0; Repartition[3][5] = 0; Repartition[4][5] = 0; Repartition[5][5] = 0; Repartition[6][5] = 0;
                Repartition[0][6] = 0; Repartition[1][6] = 0; Repartition[2][6] = 0; Repartition[3][6] = 0; Repartition[4][6] = 0; Repartition[5][6] = 0; Repartition[6][6] = 0;
            }
        }
        if("ouest".equalsIgnoreCase(this.Sens_Vent)){
            if(this.Force_Vent == 1){
                Repartition[0][0] = 0; Repartition[1][0] = 0; Repartition[2][0] = 0; Repartition[3][0] = 0; Repartition[4][0] = 0; Repartition[5][0] = 0; Repartition[6][0] = 0;
                Repartition[0][1] = 0; Repartition[1][1] = 0; Repartition[2][1] = 0; Repartition[3][1] = 0; Repartition[4][1] = 0; Repartition[5][1] = 0; Repartition[6][1] = 0;
                Repartition[0][2] = 0; Repartition[1][2] = 0; Repartition[2][2] = 10; Repartition[3][2] = 30; Repartition[4][2] = 30; Repartition[5][2] = 2; Repartition[6][2] = 0;
                Repartition[0][3] = 0; Repartition[1][3] = 0; Repartition[2][3] = 20; Repartition[3][3] = 0; Repartition[4][3] = 40; Repartition[5][3] = 5; Repartition[6][3] = 0;
                Repartition[0][4] = 0; Repartition[1][4] = 0; Repartition[2][4] = 10; Repartition[3][4] = 30; Repartition[4][4] = 30; Repartition[5][4] = 2; Repartition[6][4] = 0;
                Repartition[0][5] = 0; Repartition[1][5] = 0; Repartition[2][5] = 0; Repartition[3][5] = 0; Repartition[4][5] = 0; Repartition[5][5] = 0; Repartition[6][5] = 0;
                Repartition[0][6] = 0; Repartition[1][6] = 0; Repartition[2][6] = 0; Repartition[3][6] = 0; Repartition[4][6] = 0; Repartition[5][6] = 0; Repartition[6][6] = 0;
            }
            if(this.Force_Vent == 2){
                Repartition[0][0] = 0; Repartition[1][0] = 0; Repartition[2][0] = 0; Repartition[3][0] = 0; Repartition[4][0] = 0; Repartition[5][0] = 0; Repartition[6][0] = 0;
                Repartition[0][1] = 0; Repartition[1][1] = 0; Repartition[2][1] = 0; Repartition[3][1] = 0; Repartition[4][1] = 0; Repartition[5][1] = 0; Repartition[6][1] = 0;
                Repartition[0][2] = 0; Repartition[1][2] = 0; Repartition[2][2] = 5; Repartition[3][2] = 25; Repartition[4][2] = 40; Repartition[5][2] = 5; Repartition[6][2] = 0;
                Repartition[0][3] = 0; Repartition[1][3] = 0; Repartition[2][3] = 10; Repartition[3][3] = 0; Repartition[4][3] = 50; Repartition[5][3] = 10; Repartition[6][3] = 1;
                Repartition[0][4] = 0; Repartition[1][4] = 0; Repartition[2][4] = 5; Repartition[3][4] = 25; Repartition[4][4] = 40; Repartition[5][4] = 5; Repartition[6][4] = 0;
                Repartition[0][5] = 0; Repartition[1][5] = 0; Repartition[2][5] = 0; Repartition[3][5] = 0; Repartition[4][5] = 0; Repartition[5][5] = 0; Repartition[6][5] = 0;
                Repartition[0][6] = 0; Repartition[1][6] = 0; Repartition[2][6] = 0; Repartition[3][6] = 0; Repartition[4][6] = 0; Repartition[5][6] = 0; Repartition[6][6] = 0;
            }
            if(this.Force_Vent == 3){
                Repartition[0][0] = 0; Repartition[1][0] = 0; Repartition[2][0] = 0; Repartition[3][0] = 0; Repartition[4][0] = 0; Repartition[5][0] = 0; Repartition[6][0] = 0;
                Repartition[0][1] = 0; Repartition[1][1] = 0; Repartition[2][1] = 0; Repartition[3][1] = 0; Repartition[4][1] = 0; Repartition[5][1] = 0; Repartition[6][1] = 0;
                Repartition[0][2] = 0; Repartition[1][2] = 0; Repartition[2][2] = 0; Repartition[3][2] = 10; Repartition[4][2] = 50; Repartition[5][2] = 20; Repartition[6][2] = 1;
                Repartition[0][3] = 0; Repartition[1][3] = 0; Repartition[2][3] = 0; Repartition[3][3] = 0; Repartition[4][3] = 70; Repartition[5][3] = 30; Repartition[6][3] = 5;
                Repartition[0][4] = 0; Repartition[1][4] = 0; Repartition[2][4] = 0; Repartition[3][4] = 10; Repartition[4][4] = 50; Repartition[5][4] = 20; Repartition[6][4] = 1;
                Repartition[0][5] = 0; Repartition[1][5] = 0; Repartition[2][5] = 0; Repartition[3][5] = 0; Repartition[4][5] = 0; Repartition[5][5] = 0; Repartition[6][5] = 0;
                Repartition[0][6] = 0; Repartition[1][6] = 0; Repartition[2][6] = 0; Repartition[3][6] = 0; Repartition[4][6] = 0; Repartition[5][6] = 0; Repartition[6][6] = 0;
            }
        }
        this.Repartition_Vent = Repartition;
    }
}
