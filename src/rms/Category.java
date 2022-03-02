/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class Category {
      //declaring Scene
        Scene scene2;
      //declaring root pane
        AnchorPane root ;
       //button
        Button btn_add;
        Button btn_reset;
        Button btn_load;
        Button btn_search;
        Button btn_delete;
        Button btn_update;
        Button btn_to_admin;
        //Label
        Label lbl_title;
        Label lbl_name;
        Label lbl_desc;
        //Fields
        TextField tx_name;
        TextArea ta_desc;
        //Table
        TableView<NewCategory> tbl_category;
        ObservableList<NewCategory> data;


    public Scene Category(){
        //declaring root pane
        root = new AnchorPane();
        //button
        btn_add = new Button("Add");
        btn_reset = new Button("Clear");
        btn_load = new Button("Load Table");
        btn_search = new Button("Search");
        btn_delete = new Button("Delete");
        btn_update = new Button("Update");
        btn_to_admin = new Button("Back");
        //Label
        lbl_title = new Label("Add Category");  
        lbl_name = new Label("Name"); 
        lbl_desc = new Label("Description");
        //Fields
        tx_name = new TextField();
        ta_desc = new TextArea();
        //Table
        tbl_category = new TableView();
        data = FXCollections.observableArrayList();
        TableColumn idCol= new TableColumn("ID");
        idCol.setMinWidth(20);
        idCol.setMaxWidth(500);
        idCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
        TableColumn nameCol= new TableColumn("Category Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        TableColumn descCol = new TableColumn("Description");
        descCol.setCellValueFactory(new PropertyValueFactory<>("Desc"));
        tbl_category.getColumns().addAll(idCol,nameCol, descCol);
        //adding and aligning
        //
        tbl_category.setLayoutX(51);
        tbl_category.setLayoutY(275);
        tbl_category.setPrefSize(480, 200);
        tbl_category.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        //
        tx_name.setLayoutX(149);
        tx_name.setLayoutY(85);
        tx_name.setPrefWidth(230);
        tx_name.setPromptText("Category Name");
        //
        ta_desc.setLayoutX(149);
        ta_desc.setLayoutY(140);
        ta_desc.setPrefSize(230,62);
        ta_desc.setPromptText("Description");
        //
        btn_add.setLayoutX(94);
        btn_add.setLayoutY(224);
        // 
        btn_reset.setLayoutX(277);
        btn_reset.setLayoutY(224);
        // 
        btn_search.setLayoutX(432);
        btn_search.setLayoutY(224);
        //
        btn_load.setLayoutX(403);
        btn_load.setLayoutY(507);
        //
        btn_delete.setLayoutX(433);
        btn_delete.setLayoutY(72);
        //
        btn_update.setLayoutX(433);
        btn_update.setLayoutY(151);
        //
        btn_to_admin.setLayoutX(51);
        btn_to_admin.setLayoutY(507);
        //Label        
        lbl_title.setLayoutX(58);
        lbl_title.setLayoutY(14);
        lbl_title.setId("new-label-2");
        //
        lbl_name.setLayoutX(51);
        lbl_name.setLayoutY(86);
        //
        lbl_desc.setLayoutX(20);
        lbl_desc.setLayoutY(154);
        //adding elements to root
        root.getChildren().addAll(btn_add,btn_delete,btn_update,btn_load,btn_search,btn_to_admin,btn_reset,lbl_name,lbl_desc,lbl_title,tx_name,ta_desc,tbl_category);

        //aligning elements
        AnchorPane.setRightAnchor( btn_delete, 40.0);
        //
        AnchorPane.setRightAnchor( btn_update, 40.0);
        //
        AnchorPane.setRightAnchor( btn_load, 40.0);
        //
        AnchorPane.setRightAnchor( btn_search, 45.0);
        //
        AnchorPane.setRightAnchor( tx_name, 168.0);
        AnchorPane.setLeftAnchor( tx_name, 149.0);
        //
        AnchorPane.setRightAnchor( ta_desc, 167.0);
        AnchorPane.setLeftAnchor( ta_desc, 150.0);
        //
        AnchorPane.setRightAnchor( tbl_category, 16.0);
        AnchorPane.setLeftAnchor( tbl_category, 51.0);
        //setting action
        //search 
        btn_search.setOnAction(e ->{verifySearch();});
        //load table
        btn_load.setOnAction(e ->{loadTable();});
        //add
        btn_add.setOnAction(e ->{addCat();});
        //delete
        btn_delete.setOnAction(e ->{verifyDelete();});
        //update
        btn_update.setOnAction(e->{verifyUpdate();});
        //back
        btn_to_admin.setOnAction(e -> {
            Stage stage = Main.getStage();
            Scene scene = new Admin_Home().Admin_Home();
            new Main().switchScene(stage, scene);
        });
        //clear
        btn_reset.setOnAction(e->{
            tx_name.clear();
            ta_desc.clear();
        });
        //setting Scene
        scene2 = new Scene(root,550,550);
        scene2.getStylesheets().add(Main.class.getResource("../Style/css.css").toExternalForm());
        
        return scene2;
    }
    //adding category
    public void addCat(){
        //establish connection
        DbConnection dbconn = new DbConnection();
        Connection conn = dbconn.getConnection();
        //getText
        String Cname= tx_name.getText();
        String Cdesc= ta_desc.getText();
        // write query 
        String insertquery1 = "INSERT into tbl_category(catName,catDescription) values ('";
        String insertquery2 = Cname + "','" + Cdesc + "')" ;
        String insertFullquery = insertquery1+insertquery2;
        //checking if empty
        if (Cname.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please Insert Category Name");
            alert.showAndWait();
        }
        else if(isPresent()){
             Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Category Already Added");
            alert.showAndWait();
        }
        else{
            //executing statement
                try{
                    Statement statement = conn.createStatement();
                    statement.executeUpdate(insertFullquery);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setHeaderText(null);
                    alert.setContentText("Category Added");
                    alert.showAndWait();
                    tx_name.clear();
                    ta_desc.clear();
            } catch(Exception ex){
                ex.printStackTrace();
            }
            loadTable();
        }   
    }
    //to avoid redundant category names    
    public boolean isPresent(){
        //getting text from text field
        String Cname= tx_name.getText();
        //getting conncetion
        DbConnection dbconn = new DbConnection();
        Connection conn = dbconn.getConnection();
        
        boolean isAvailable = false;
        //query statement
        String query = "SELECT * FROM tbl_category WHERE catName= '" + Cname + "'"; 
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
    //deleting 
    public void verifyDelete(){
        //establish connection
        DbConnection dbconn = new DbConnection();
        Connection conn = dbconn.getConnection();
        //get text
        String id = null;
        id=JOptionPane.showInputDialog("Enter ID to be Deleted");
        //checking if empty 
        if(id == null){
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("INFORMATION");
            alert1.setHeaderText(null);
            alert1.setContentText("Please Add ID NO");
        } 
        else {
            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("CONFIRMATION");
            alert1.setHeaderText(null);
            alert1.setContentText("Are you sure to delete?");
            Optional<ButtonType> action =alert1.showAndWait();
        
            if(action.get()== ButtonType.OK){
                String verifyLogin = "DELETE FROM tbl_category WHERE catID='"+id+"'";
                //execute query
                try{
                    Statement statement = conn.createStatement();
                    statement.executeUpdate(verifyLogin); 
            
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setHeaderText(null);
                    alert.setContentText("Deleted");
            
                }catch(Exception ex){
                    ex.printStackTrace();
                }
                          
            }   
        }
        loadTable();  
    }
    //searching content
    public void verifySearch(){
        //establish connection
        DbConnection dbconn = new DbConnection();
        Connection conn = dbconn.getConnection();
        //get text
        TextInputDialog td = new TextInputDialog();
        td.setHeaderText("Enter ID to be searched");
        //getID
        Optional<String> result = td.showAndWait();
        String id = td.getEditor().getText();
        String verifySearch = "SELECT catName,catDescription FROM tbl_category WHERE catID='"+id+"'";
        //execute query
        try{ 
            Statement statement = conn.createStatement();
            ResultSet queryOutput = statement.executeQuery(verifySearch);
            String arr[] = new String[2];
            while(queryOutput.next()){
                arr[0] = queryOutput.getString("catName");
                arr[1] = queryOutput.getString("catDescription");
            }
            tx_name.setText(arr[0]);
            ta_desc.setText(arr[1]);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    //loading table
    public void loadTable(){
        data.clear();
        DbConnection dbconn = new DbConnection();
        Connection conn = dbconn.getConnection();
        String query = "SELECT * from tbl_category";
        try{
           PreparedStatement statement = conn.prepareStatement(query);
           ResultSet output = statement.executeQuery();
           
           while(output.next()){
               data.add(new NewCategory(output.getString("catId"),
                       output.getString("catName"),
                       output.getString("catDescription")
               ));
               tbl_category.setItems(data);
           }
           statement.close();
           output.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    //updating table
    public void verifyUpdate(){
        //establish connection
        DbConnection dbconn = new DbConnection();
        Connection conn = dbconn.getConnection();
        //getText
        String Cname= tx_name.getText();
        String Cdesc= ta_desc.getText();
        TextInputDialog td = new TextInputDialog();
        td.setHeaderText("Enter ID to be Updated");
        //getID
        Optional<String> result = td.showAndWait();
        String id = td.getEditor().getText();
        // write query 
        String insertquery1 = "Update tbl_category Set catName ='"+Cname+"', catDescription='"+Cdesc+"' WHERE catID='"+id+"' ";
        
        String verifySearch = "SELECT catName,catDescription FROM tbl_category WHERE catID='"+id+"'";
        
        //execute query
        try{   
            Statement statement1;
            try {
                statement1 = conn.createStatement();
                ResultSet queryOutput = statement1.executeQuery(verifySearch);
                String arr[] = new String[2];
                while(queryOutput.next()){
                    arr[0] = queryOutput.getString("catName");
                    arr[1] = queryOutput.getString("catDescription");       
                }
                tx_name.setText(arr[0]);
                ta_desc.setText(arr[1]); 
            } catch (SQLException ex) {
                Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
            }
            //checking if empty
            if (Cname.isEmpty()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("Please Insert Category Name");
                alert.showAndWait();
            }else{
                try{
                    Statement statement = conn.createStatement();
                    statement.executeUpdate(insertquery1);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setHeaderText(null);
                    alert.setContentText("Category Updated");
                    alert.showAndWait();
                    tx_name.clear();
                    ta_desc.clear();
            } catch(Exception ex){
                ex.printStackTrace();
            }
                loadTable();
            } 
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}