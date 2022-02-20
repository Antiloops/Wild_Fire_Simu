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
public class Case {
    
    //Initialisation des attributs 
    public Boolean Vegetation_Case;
    public int Combustion_Case;
    public String Brulure_Case;
    public int Humidite_Case;
    public boolean Condamne_Case;
                    //Rajouter un attribut pour les ittération de combustion 
    
    //Constructeur   
    public  Case (int Humidite_Case){
        this.Humidite_Case = Humidite_Case;
    }
    
    //Getter -> Méthodes qui retourne les attributs de la case : la vegatation, la niveau de combustion ou le risque
    public Boolean getVegetation(){
        return this.Vegetation_Case;
    }
    
    public int getCombustion(){
        return this.Combustion_Case;
    }
    
    
    //Setter -> Méthodes qui modifie les attributs de la case par un argument en entrée pour : la vegetation, la combustion ou le risque
    public void setVegetation(Boolean Vegetation){
        this.Vegetation_Case = Vegetation;
    }
    
    public void setCombustion(int Combustion){
        this.Combustion_Case = Combustion;
    }

}
