/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms;

import javafx.beans.property.SimpleStringProperty;


public class NewItem {
    
    private final SimpleStringProperty ID;
    private final SimpleStringProperty Name;
    private final SimpleStringProperty Price;
    private final SimpleStringProperty CatName;
    private final SimpleStringProperty Quantity;
    
    public NewItem(String id, String name, String price, String quantity, String catName){
        this.ID = new SimpleStringProperty(id);
        this.Name = new SimpleStringProperty(name);
        this.Price = new SimpleStringProperty(price);
        this.Quantity = new SimpleStringProperty(quantity);
        this.CatName = new SimpleStringProperty(catName);
    }
    public String getID(){
         return ID.get();
    }
    public String getName(){
         return Name.get();
    }
    public String getPrice(){
         return Price.get();
    }
    public String getQuantity(){
         return Quantity.get();
    }
    public String getCatName(){
         return CatName.get();
    }   
    public void setID(String id){
         ID.set(id);
    }
    public void setName(String name){
         Name.set(name);
    }
    public void setPrice(String price){
         Price.set(price);
    }
    public void setQuantity(String quantity){
         Price.set(quantity);
    }
    public void setCatName(String catName){
         CatName.set(catName);
    }  
}
