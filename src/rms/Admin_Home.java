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


public class Admin_Home {
     //declaring Scene
        Scene scene2;
      //declaring root pane
        AnchorPane root ;
        Pane left_pane ;
       //button
        Button btn_item ;
        Button btn_logout ;
        Button btn_category ;
        //Label
        Label lbl_welcome;

    public Scene Admin_Home(){
        //declaring root pane
        root = new AnchorPane();
        left_pane = new Pane();
        //button
        btn_logout = new Button("Logout");
        btn_category = new Button("Add Category");
        btn_item = new Button("Add Item");
        //Label
        lbl_welcome = new Label("Welcome");  

        //styling left_pane
        left_pane.getStyleClass().add("left-pane");
        left_pane.setPrefSize(111, 400);
        //adding and aligning
        btn_logout.setLayoutX(402);
        btn_logout.setLayoutY(22);
        // 
        btn_item.setLayoutX(159);
        btn_item.setLayoutY(265);
        btn_item.setPrefSize(322, 29);
        //
        btn_category.setLayoutX(159);
        btn_category.setLayoutY(198);
        btn_category.setPrefSize(322, 29);
        //Label        
        lbl_welcome.setLayoutX(217);
        lbl_welcome.setLayoutY(90);
        lbl_welcome.setId("new-label-2");

        //adding elements to root
        root.getChildren().addAll(left_pane,btn_logout,btn_item,btn_category,lbl_welcome);

        //aligning elements
        AnchorPane.setLeftAnchor(left_pane, 0.0);
        AnchorPane.setTopAnchor(left_pane, 0.0);
        AnchorPane.setBottomAnchor(left_pane, 0.0);
        //
        AnchorPane.setRightAnchor( btn_logout, 40.0);
        //
  
        //
        AnchorPane.setLeftAnchor(btn_item, 159.0);
        AnchorPane.setRightAnchor(btn_item, 33.0);
        //
        AnchorPane.setLeftAnchor(btn_category, 159.0);
        AnchorPane.setRightAnchor(btn_category, 33.0);
        //setting actions
        //Item
        btn_item.setOnAction(e->{
            Stage stage = Main.getStage();
            Scene scene = new Item().Item();
            new Main().switchScene(stage, scene);
        });
        //category button
        btn_category.setOnAction(e->{
            Stage stage = Main.getStage();
            Scene scene = new Category().Category();
            new Main().switchScene(stage, scene);
        });
        //logout button
        btn_logout.setOnAction(e -> {
            Stage stage = Main.getStage();
            Scene scene = new Admin_Login().Admin_Login();
            new Main().switchScene(stage, scene);
        });
        //setting Scene
        scene2 = new Scene(root, 514, 425);
        scene2.getStylesheets().add(Main.class.getResource("../Style/css.css").toExternalForm());
        
        return scene2;
    }
}
