/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wild_fire_simu;

/**
 *
 * @author Louis SAVIGNAC et Mathis LOPEZ
 */
public class Case {
    
    //Initialisation des attributs 
    private Boolean Vegetation_Case;
    private int Combustion_Case;
    private String Brulure_Case = "";
    private int Humidite_Case;
    private boolean Condamne_Case;
    
    //Constructeur   
    public  Case (int Humidite_Case){
        this.Humidite_Case = Humidite_Case;
    }
    
    //Getter -> Methodes qui retourne les attributs de la case : la vegatation, la niveau de combustion ou le risque
    public Boolean getVegetation(){
        return this.Vegetation_Case;
    }
    
    public int getCombustion(){
        return this.Combustion_Case;
    }
    
    public String getBrulure(){
        return this.Brulure_Case;
    }
    
    public int getHumidite(){
        return this.Humidite_Case;
    }
    
    public Boolean getCondamne(){
        return this.Condamne_Case;
    }
    
    //Setter -> Methodes qui modifie les attributs de la case par un argument en entree pour : la vegetation, la combustion ou le risque
    public void setVegetation(Boolean Vegetation_Case){
        this.Vegetation_Case = Vegetation_Case;
    }
    
    public void setCombustion(int Combustion_Case){
        this.Combustion_Case = Combustion_Case;
    }
    
    public void setBrulure(String Brulure_Case){
        this.Brulure_Case = Brulure_Case;
    }
    
    public void setHumidite(int Humidite_Case){
        this.Humidite_Case = Humidite_Case;
    }
    
    public void setCondamne(Boolean Condamne_Case){
        this.Condamne_Case = Condamne_Case;
    }
    
}
