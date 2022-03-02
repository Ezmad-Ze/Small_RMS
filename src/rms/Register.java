/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class Register {
       //declaring Scene
        Scene scene2;
      //declaring root pane
        AnchorPane root ;
        Pane left_pane ;
       //button
        Button btn_to_admin ;
        Button btn_to_user ;
        Button btn_register ;
        //Label
        Label lbl_register;
        Label lbl_name;
        Label lbl_gender;
        Label lbl_phone;
        Label lbl_password ;
        //Fields
        TextField tx_name ;
        TextField tx_phone ;
        TextField tx_gender;
        PasswordField ps_password ;

    public Scene Register(){
        //declaring root pane
        root = new AnchorPane();
        left_pane = new Pane();
        //button
        btn_to_user = new Button("Back");
        btn_register = new Button("Register");
        //Label
        lbl_register = new Label("Register"); 
        lbl_name = new Label("Name"); 
        lbl_phone = new Label("Phone No"); 
        lbl_gender = new Label("Gender"); 
        lbl_password = new Label("Password"); 
        //Field
        tx_name = new TextField(); 
        tx_phone = new TextField();
        tx_gender = new TextField();
        ps_password = new PasswordField();  
        //styling left_pane
        left_pane.getStyleClass().add("left-pane");
        left_pane.setPrefSize(111, 400);
        //adding and aligning
        btn_to_user.setLayoutX(386);
        btn_to_user.setLayoutY(329);
        // 
        btn_register.setLayoutX(179);
        btn_register.setLayoutY(329);
        //Label        
        lbl_register.setLayoutX(216);
        lbl_register.setLayoutY(34);
        lbl_register.setId("new-label-2");
        //       
        lbl_name.setLayoutX(165);
        lbl_name.setLayoutY(100);
        // 
        lbl_phone.setLayoutX(149);
        lbl_phone.setLayoutY(151);
        //
        lbl_gender.setLayoutX(165);
        lbl_gender.setLayoutY(203);
        //
        lbl_password.setLayoutX(150);
        lbl_password.setLayoutY(262);
        // 
        tx_name.setLayoutX(263);
        tx_name.setLayoutY(99);
        tx_name.setPromptText("Name");
        //
        tx_phone.setLayoutX(263);
        tx_phone.setLayoutY(150);
        tx_phone.setPromptText("Phone number");
        //
        tx_gender.setLayoutX(263);
        tx_gender.setLayoutY(202);
        tx_gender.setPromptText("Gender");
        //
        ps_password.setLayoutX(263);
        ps_password.setLayoutY(261);
        ps_password.setPromptText("Password");
        //adding elements to root
        root.getChildren().addAll(left_pane,btn_to_user,btn_register,lbl_register,lbl_name,lbl_phone,lbl_gender,lbl_password,tx_name, tx_phone,tx_gender,ps_password);

        //aligning elements
        AnchorPane.setLeftAnchor(left_pane, 0.0);
        AnchorPane.setTopAnchor(left_pane, 0.0);
        AnchorPane.setBottomAnchor(left_pane, 0.0);
        //
        AnchorPane.setRightAnchor( btn_to_user, 58.0);
        //
  
        //
        AnchorPane.setLeftAnchor(tx_name, 263.0);
        AnchorPane.setRightAnchor(tx_name, 89.0);
        //
        AnchorPane.setLeftAnchor(tx_phone, 263.0);
        AnchorPane.setRightAnchor(tx_phone, 89.0);
        //
        AnchorPane.setLeftAnchor(tx_gender, 263.0);
        AnchorPane.setRightAnchor(tx_gender, 89.0);
        //
        AnchorPane.setLeftAnchor(ps_password, 263.0);
        AnchorPane.setRightAnchor(ps_password, 89.0);
        //action
        //register
        btn_register.setOnAction(e ->{
            registerUser();
        });
        //back
        btn_to_user.setOnAction((ActionEvent e) -> {
             Stage stage= Main.getStage();
             Scene scene = new Login().Login();
             new Main().switchScene(stage,scene);
        });
        //setting Scene
        scene2 = new Scene(root, 514, 425);
        scene2.getStylesheets().add(Main.class.getResource("../Style/css.css").toExternalForm());
        
        return scene2;
    }
    //register User
    public void registerUser(){
        //establish connection
        DbConnection dbconn = new DbConnection();
        Connection conn = dbconn.getConnection();
        //getText
        String Uname= tx_name.getText();
        String Uphone= tx_phone.getText();
        String Ugender= tx_gender.getText();
        String Upass= ps_password.getText();
        // write query 
        String insertquery1 = "INSERT into tbl_customer(customerName,customerPhone,customerGender,customerPassword) values ('";
        String insertquery2 = Uname + "','" + Uphone + "','" + Ugender + "','" + Upass + "')" ;
        String insertFullquery = insertquery1+insertquery2;
        
        if (Uname.isEmpty()){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please Insert Name");
            alert.showAndWait();
            //alert.setHeaderText("Look, an Error Dialog");
            //JOptionPane.showMessageDialog(null, "Please Insert Name");
        }
        else if(isPresent()){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please Change the Name");
            alert.showAndWait();
            //JOptionPane.showMessageDialog(null, "Please Change the Name");
        }
        else if(Upass.isEmpty()){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please Insert Password");
            alert.showAndWait();
            //JOptionPane.showMessageDialog(null, "Please Insert Password");
        }
        else{
            //executing statement
                try{
                    Statement statement = conn.createStatement();
                    statement.executeUpdate(insertFullquery);
                    //alert
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setHeaderText(null);
                    alert.setContentText("Registered");
                    alert.showAndWait();
                    
                    Stage stage= Main.getStage();
                    Scene scene = new Login().Login();
                    new Main().switchScene(stage,scene);
            } catch(Exception ex){
                ex.printStackTrace();
            }
        }
        
    }
    //to avoid redundant user names    
    public boolean isPresent(){
        //getting text from text field
        String Uname= tx_name.getText();
        //getting conncetion
        DbConnection dbconn = new DbConnection();
        Connection conn = dbconn.getConnection();
        
        boolean isAvailable = false;
        //query statement
        String query = "SELECT * FROM tbl_customer WHERE customerName= '" + Uname + "'"; 
        //executing statement
        try{
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query); 
            isAvailable = resultSet.next(); 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
         return isAvailable;
    }
}



