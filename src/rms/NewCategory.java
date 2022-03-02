/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Ezwad_Ze
 */
public class NewCategory {
    
    private final SimpleStringProperty ID;
    private final SimpleStringProperty Name;
    private final SimpleStringProperty Desc;
    
    public NewCategory(String id, String name, String desc){
        this.ID = new SimpleStringProperty(id);
        this.Name = new SimpleStringProperty(name);
        this.Desc = new SimpleStringProperty(desc);
    }
    public String getID(){
         return ID.get();
    }
    public String getName(){
         return Name.get();
    }
    public String getDesc(){
         return Desc.get();
    }
    
    public void setID(String id){
         ID.set(id);
    }
    public void setName(String name){
         Name.set(name);
    }
    public void setDesc(String desc){
         Desc.set(desc);
    }     
    
    
}
