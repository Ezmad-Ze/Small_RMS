/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Ezwad_Ze
 */
public class Report {
    //declaring Scene
    Scene scene2;
    //declaring root pane
    AnchorPane root ;
    //button
    Button btn_back;
    //Label
    Label lbl_title;
    //Field
    TextArea ta;
    
    public Scene Report(){
        //declaring root pane
        root = new AnchorPane();
        //button
        btn_back = new Button("Back");
        //Label
        lbl_title = new Label("Report");
        //Fields
        ta = new TextArea();
        
        //Label        
        lbl_title.setLayoutX(67);
        lbl_title.setLayoutY(14);
        lbl_title.setId("new-label-2");
        
         //
        btn_back.setLayoutX(483);
        btn_back.setLayoutY(317);
        
        //
        ta.setLayoutX(67);
        ta.setLayoutY(68);
        ta.prefWidth(490);
        ta.prefHeight(200);
        ta.setEditable(false);
        
        root.getChildren().addAll(btn_back,lbl_title,ta);
        
        AnchorPane.setRightAnchor( btn_back, 60.0);
        //
        AnchorPane.setRightAnchor( ta, 43.0);
        AnchorPane.setLeftAnchor( ta, 67.0);
        //setting action
        btn_back.setOnAction(e ->{
             Stage stage= Main.getStage();
             Scene scene = new Order().Order();
             new Main().switchScene(stage,scene);
        });
        rep(ta);
        //setting Scene
        scene2 = new Scene(root);
        scene2.getStylesheets().add(Main.class.getResource("../Style/css.css").toExternalForm());
        
        return scene2;
    }
    //creating report
    public void rep(TextArea tta){
        tta.clear();
            try {
                String m=null,n=null,o=null,q=null, r=null;
                //establish connection
                DbConnection dbconn = new DbConnection();
                Connection conn = dbconn.getConnection();
                String queries ="Select \"\",\"Total\", sum(total)  from tbl_order;";
                String Query ="Select itemPrice, itemName, quantity, total from tbl_order inner join tbl_item where tbl_item.itemID = tbl_order.itemID;";
                String verifyDel = "delete  from tbl_order;";
                PreparedStatement statements = conn.prepareStatement(Query);
                ResultSet outputs = statements.executeQuery();
                
                PreparedStatement Statement = conn.prepareStatement(queries);
                ResultSet output = Statement.executeQuery();
                tta.appendText("Item Name\t\t\t ItemQuantity\t\t\t ItemPrice\t\t\t ItemTotal\n");
                while(outputs.next()){ 
                    r = outputs.getString("itemPrice");
                    n =  outputs.getString("itemName");
                    o = outputs.getString("quantity");
                    q = outputs.getString("total");
                    tta.appendText(n +"\t\t\t\t\t "+ o +"\t\t\t\t\t "+r+"\t\t\t\t\t "+q +"\n");      
                }
                while(output.next()){
                    m = output.getString("sum(total)");
                }                
                tta.appendText("\n\nNet Total : "+ m);

                new Order().clearDB(Order.getdatas());
            } catch (SQLException ex) {
                Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
   
}
