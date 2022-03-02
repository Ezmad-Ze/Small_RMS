/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class Admin_Login {
        //declaring Scene
        Scene scene1;
        Scene scene2;
      //declaring root pane
        AnchorPane root ;
        Pane left_pane ;
       //button
        Button btn_to_admin ;
        Button btn_to_user ;
        Button btn_to_register ;
        Button btn_login ; 
        Button btn_cancel ;
        //Label
        Label lbl_login ;
        Label lbl_name;
        Label lbl_password ;
        //Fields
        TextField tx_name ;
        PasswordField ps_password ;
    public Scene Admin_Login(){
        //declaring root pane
        root = new AnchorPane();
        left_pane = new Pane();
        //button
        btn_to_user = new Button("User");
        btn_to_register = new Button("Register");
        btn_login = new Button("Login"); 
        btn_cancel = new Button("Cancel");
        //Label
        lbl_login = new Label("Admin Login"); 
        lbl_name = new Label("Name"); 
        //Field
        lbl_password = new Label("Password"); 
        tx_name = new TextField();  
        ps_password = new PasswordField();  
        //styling left_pane
        left_pane.getStyleClass().add("left-pane");
        left_pane.setPrefSize(111, 400);
        //adding and aligning
        btn_to_user.setLayoutX(132);
        btn_to_user.setLayoutY(26);
        // 
        btn_to_register.setLayoutX(394);
        btn_to_register.setLayoutY(26);
        //
        btn_login.setLayoutX(190);
        btn_login.setLayoutY(320);
        //          
        btn_cancel.setLayoutX(380);
        btn_cancel.setLayoutY(320);
        
        //Label        
        lbl_login.setLayoutX(220);
        lbl_login.setLayoutY(88);
        lbl_login.setId("new-label-2");
        //       
        lbl_name.setLayoutX(155);
        lbl_name.setLayoutY(172);
        //       
        lbl_password.setLayoutX(140);
        lbl_password.setLayoutY(240);
        //            
        tx_name.setLayoutX(253);
        tx_name.setLayoutY(160);
        tx_name.setPromptText("Name");
        //             
        ps_password.setLayoutX(253);
        ps_password.setLayoutY(228);
        ps_password.setPromptText("Password");
        //adding elements to root
        root.getChildren().addAll(left_pane,btn_to_user,btn_to_register,btn_login,btn_cancel,lbl_login,lbl_name,lbl_password,tx_name,ps_password);
        //aligning elements
        AnchorPane.setLeftAnchor(left_pane, 0.0);
        AnchorPane.setTopAnchor(left_pane, 0.0);
        AnchorPane.setBottomAnchor(left_pane, 0.0);
        //
        AnchorPane.setTopAnchor( btn_to_user, 36.0);
        //
        AnchorPane.setRightAnchor( btn_to_register, 26.0);
        AnchorPane.setTopAnchor( btn_to_register, 36.0);
        //
        AnchorPane.setLeftAnchor(tx_name, 263.0);
        AnchorPane.setTopAnchor(tx_name, 169.0);
        AnchorPane.setRightAnchor(tx_name, 89.0);
        //
        AnchorPane.setLeftAnchor(ps_password, 263.0);
        AnchorPane.setTopAnchor(ps_password, 237.0);
        AnchorPane.setRightAnchor(ps_password, 89.0);
        //
        AnchorPane.setRightAnchor( btn_cancel, 49.0);
        //setting actions
        //register button
        btn_to_register.setOnAction((ActionEvent e) -> {
            Stage stage= Main.getStage();
            Scene scene = new Admin_Register().Admin_Register();
            new Main().switchScene(stage,scene);
        });
        //user button
        btn_to_user.setOnAction((ActionEvent e) -> {
             Stage stage= Main.getStage();
             Scene scene = new Login().Login();
             new Main().switchScene(stage,scene);
        });
        //Login
         btn_login.setOnAction(e -> {
             verifyLogin();
         });
        //cancel
         btn_cancel.setOnAction(e -> System.exit(0));
        //setting Scene
        scene2 = new Scene(root, 520, 400);
        scene2.getStylesheets().add(Main.class.getResource("../Style/css.css").toExternalForm());
        
        return scene2;
    }
    //verifying Login
    public void verifyLogin(){
        //establish connection
        DbConnection dbconn = new DbConnection();
        Connection conn = dbconn.getConnection();
        //get text
        String Name = tx_name.getText() ;
        String Pass = ps_password.getText();
        //query
        String verifyLogin = "SELECT count(1) FROM tbl_admin WHERE adminName='"+Name+"'AND adminPassword='"+Pass+"'";
        //execute query
        try{
            Statement statement = conn.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            while(queryResult.next()){
            //check if it is available or not
                if(queryResult.getInt(1)==1){
                    Stage stage = Main.getStage();
                    Scene scene = new Admin_Home().Admin_Home();
                    new Main().switchScene(stage, scene);
                }else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Please Insert Correct Information");
                    alert.showAndWait();
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
