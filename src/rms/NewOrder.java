/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms;

import javafx.beans.property.SimpleStringProperty;

public class NewOrder {
    
    protected final SimpleStringProperty ID;
    protected final SimpleStringProperty Name;
    protected final SimpleStringProperty Quantity;
    protected final SimpleStringProperty TPrice;
    

    public NewOrder(String id,String name, String quant, String tprice){
        this.ID = new SimpleStringProperty(id);
        this.Name = new SimpleStringProperty(name);
        this.Quantity = new SimpleStringProperty(quant);
        this.TPrice = new SimpleStringProperty(tprice);
    }



    public String getID(){
         return ID.get();
    }
    public String getName(){
         return Name.get();
    }
    public String getQuant(){
         return Quantity.get();
    }
    public String getTPrice(){
         return TPrice.get();
    }   
    
    public void setID(String id){
         ID.set(id);
    }      
    public void setName(String name){
         Name.set(name);
    }
    public void setQuant(String quant){
         Quantity.set(quant);
    } 
    public void setPrice(String tprice){
         TPrice.set(tprice);
    }

}
