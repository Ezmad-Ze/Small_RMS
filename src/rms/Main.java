/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    //Getting the stage to use other classes
    private static Stage stage;

    public static Stage getStage() {
        return stage;
    } 
    //declaring scenes
    Scene scene1;
    //Scene scene2;
    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        scene1 =  new Login().Login();
        //new Order().loadTable(Order.getdata(), Order.gettbl_menu());
        stage.setTitle("Restaurant Managment System");
        stage.setScene( scene1);
        stage.show();
    }
    //Switching scene function
    public void switchScene(Stage s, Scene scenes){  
        s.setScene(scenes);  
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
