/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Home {
        //declaring Scene
        Scene scene2;
      //declaring root pane
        AnchorPane root ;
        Pane left_pane ;
       //button
        Button btn_order ;
        Button btn_logout ;
        //Label
        Label lbl_welcome;

    public Scene Home(){
        //declaring root pane
        root = new AnchorPane();
        left_pane = new Pane();
        //button
        btn_logout = new Button("Logout");
        btn_order = new Button("Add Order Request");
        //Label
        lbl_welcome = new Label("Welcome");  
        
        //styling left_pane
        left_pane.getStyleClass().add("left-pane");
        left_pane.setPrefSize(111, 400);
        //adding and aligning
        btn_logout.setLayoutX(402);
        btn_logout.setLayoutY(22);
        // 
        btn_order.setLayoutX(160);
        btn_order.setLayoutY(221);
        btn_order.setPrefSize(322, 29);
        
        //Label        
        lbl_welcome.setLayoutX(217);
        lbl_welcome.setLayoutY(90);
        lbl_welcome.setId("new-label-2");

        //adding elements to root
        root.getChildren().addAll(left_pane,btn_logout,btn_order,lbl_welcome);

        //aligning elements
        AnchorPane.setLeftAnchor(left_pane, 0.0);
        AnchorPane.setTopAnchor(left_pane, 0.0);
        AnchorPane.setBottomAnchor(left_pane, 0.0);
        //
        AnchorPane.setRightAnchor( btn_logout, 40.0);
        //
        AnchorPane.setLeftAnchor(btn_order, 160.0);
        AnchorPane.setRightAnchor(btn_order, 32.0);
        //setting actions
        //order button
        btn_order.setOnAction(e -> {
            Stage stage = Main.getStage();
            Scene scene = new Order().Order();
            new Main().switchScene(stage, scene);
        });
        //logout button
        btn_logout.setOnAction(e -> {
            Stage stage = Main.getStage();
            Scene scene = new Login().Login();
            new Main().switchScene(stage, scene);
        });
        //setting Scene
        scene2 = new Scene(root, 514, 425);
        scene2.getStylesheets().add(Main.class.getResource("../Style/css.css").toExternalForm());
        
        return scene2;
    }
    
}
