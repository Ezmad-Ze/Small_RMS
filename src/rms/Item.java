/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class Item {
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
        Label lbl_price;
        Label lbl_quan;
        Label lbl_category;
        //Fields
        TextField tx_name;
        TextField tx_price;
        TextField tx_quan;
        ComboBox cb_category;
        //Table
        TableView<NewItem> tbl_item;
        ObservableList<NewItem> data;
        final ObservableList options = FXCollections.observableArrayList();
        //dialog
        TextInputDialog td = new TextInputDialog();
    public Scene Item(){
        //declaring root pane
        root = new AnchorPane();
        //button
        btn_add = new Button("Add");
        btn_reset = new Button("Reset");
        btn_load = new Button("Load Table and ComboBox");
        btn_search = new Button("Search");
        btn_delete = new Button("Delete");
        btn_update = new Button("Update");
        btn_to_admin = new Button("Back");
        //Label
        lbl_title = new Label("Add Item");  
        lbl_name = new Label("Name"); 
        lbl_price = new Label("Price");
        lbl_quan = new Label("Quantity");
        lbl_category = new Label("Category");
        //Fields
        tx_name = new TextField();
        tx_price = new TextField();
        tx_quan = new TextField();
        //
        cb_category = new ComboBox();
        //Table
        tbl_item = new TableView();
        data = FXCollections.observableArrayList();
        TableColumn idCol= new TableColumn("ID");
        idCol.setMinWidth(20);
        idCol.setMaxWidth(500);
        idCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
        TableColumn itemNameCol= new TableColumn("Item Name");
        itemNameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        TableColumn priceCol = new TableColumn("Price");
        priceCol.setCellValueFactory(new PropertyValueFactory<>("Price"));
        priceCol.setMinWidth(100);
        priceCol.setMaxWidth(500);
        TableColumn quantCol = new TableColumn("Quantity");
        quantCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        quantCol.setMinWidth(100);
        quantCol.setMaxWidth(500);
        TableColumn categoryCol = new TableColumn("Category");
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("catName"));
        tbl_item.getColumns().addAll(idCol,itemNameCol, priceCol,quantCol,categoryCol);
        //adding and aligning
        //
        tbl_item.setLayoutX(30);
        tbl_item.setLayoutY(368);
        tbl_item.setPrefSize(480, 200);
        tbl_item.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        //
        tx_name.setLayoutX(149);
        tx_name.setLayoutY(85);
        tx_name.setPrefWidth(239);
        tx_name.setPromptText("Item Name");
        //
        tx_price.setLayoutX(149);
        tx_price.setLayoutY(139);
        tx_price.setPrefSize(239,25);
        tx_price.setPromptText("Price");
        //
        tx_quan.setLayoutX(149);
        tx_quan.setLayoutY(246);
        tx_quan.setPrefSize(239,25);
        tx_quan.setPromptText("Quantity");
        //
        cb_category.setLayoutX(149);
        cb_category.setLayoutY(194);
        cb_category.setPrefSize(239,25);
        cb_category.setPromptText("Choose Category");  
        //
        btn_add.setLayoutX(76);
        btn_add.setLayoutY(309);
        // 
        btn_reset.setLayoutX(294);
        btn_reset.setLayoutY(309);
        //
        btn_search.setLayoutX(427);
        btn_search.setLayoutY(309);
        //
        btn_load.setLayoutX(410);
        btn_load.setLayoutY(580);
        //
        btn_delete.setLayoutX(428);
        btn_delete.setLayoutY(83);
        //
        btn_update.setLayoutX(425);
        btn_update.setLayoutY(164);
        //
        btn_to_admin.setLayoutX(45);
        btn_to_admin.setLayoutY(580);
        //Label        
        lbl_title.setLayoutX(77);
        lbl_title.setLayoutY(21);
        lbl_title.setId("new-label-2");
        //
        lbl_name.setLayoutX(51);
        lbl_name.setLayoutY(86);
        //
        lbl_price.setLayoutX(36);
        lbl_price.setLayoutY(140);
        //
        lbl_quan.setLayoutX(36);
        lbl_quan.setLayoutY(247);
        //
        lbl_category.setLayoutX(36);
        lbl_category.setLayoutY(195);  
        //adding elements to root
        root.getChildren().addAll(btn_add,btn_delete,btn_load,btn_search,btn_update,btn_to_admin,btn_reset,lbl_name,lbl_price,lbl_quan,lbl_title,tx_name,tx_price,tx_quan,cb_category,tbl_item,lbl_category);

        //aligning elements
        AnchorPane.setRightAnchor( btn_delete, 40.0);
        //
        AnchorPane.setRightAnchor( btn_update, 40.0);
        //
        AnchorPane.setRightAnchor( btn_load, 50.0);
        //
        AnchorPane.setRightAnchor( btn_search, 50.0);
        //
        AnchorPane.setRightAnchor( tx_name, 168.0);
        AnchorPane.setLeftAnchor( tx_name, 149.0);
        //
        AnchorPane.setRightAnchor( tx_price, 167.0);
        AnchorPane.setLeftAnchor( tx_price, 150.0);
        //
        AnchorPane.setRightAnchor( tx_quan, 167.0);
        AnchorPane.setLeftAnchor( tx_quan, 150.0);
        //
        AnchorPane.setRightAnchor( cb_category, 159.0);
        AnchorPane.setLeftAnchor( cb_category, 149.0);
        //
        AnchorPane.setRightAnchor( tbl_item, 16.0);
        AnchorPane.setLeftAnchor( tbl_item, 51.0);
        //setting action
        //update
        btn_update.setOnAction(e -> {verifyUpdate();});
        //search
        btn_search.setOnAction(e->{verifySearch();});
        //delete
        btn_delete.setOnAction(e -> {verifyDelete();});
        //load table and combobox
        btn_load.setOnAction(e -> {loadCombo(); loadTable();});
        //add
        btn_add.setOnAction(e ->{addItem();});
        //back
        btn_to_admin.setOnAction(e -> {
            Stage stage = Main.getStage();
            Scene scene = new Admin_Home().Admin_Home();
            new Main().switchScene(stage, scene);
        });
        //reset
        btn_reset.setOnAction(e->{
            tx_name.clear();
            tx_price.clear(); 
        });
        //to add only numbers
        tx_price.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                tx_price.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        tx_quan.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                tx_quan.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        //setting Scene
        scene2 = new Scene(root);
        scene2.getStylesheets().add(Main.class.getResource("../Style/css.css").toExternalForm());
        
        return scene2;
    }
    //loading comboBox
    public void loadCombo(){
        options.clear();
        DbConnection dbconn = new DbConnection();
        Connection conn = dbconn.getConnection();
        String query = "SELECT catName from tbl_category";
        try{
           PreparedStatement statement = conn.prepareStatement(query);
           ResultSet output = statement.executeQuery();
            
           while(output.next()){
               options.add(output.getString("catName"));
               cb_category.setItems(options);
           }
           
           statement.close();
           output.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    //adding items
    public void addItem(){
        //establish connection
        DbConnection dbconn = new DbConnection();
        Connection conn = dbconn.getConnection();
        //getText
        String Cname= tx_name.getText();
        String Cprice= tx_price.getText();
        String Cquan= tx_quan.getText();
        String Ccat = (String) cb_category.getValue();
        // write query 
        String insertFullquery = "INSERT INTO tbl_item (itemName,itemPrice,itemQuan, catID) VALUES ('"+Cname+"','"+Cprice+"','"+Cquan+"',(select catID From tbl_category where catName = '"+Ccat+"'));";
        //checking if empty
        if (Cname.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please Insert Item Name");
            alert.showAndWait();
        }
        else if(Cprice.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please Insert Item Price");
            alert.showAndWait();
        }
        else if(Cquan.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please Insert Item Quantity in Stock");
            alert.showAndWait();
        }
        else if(isPresent()){
            Alert alerts = new Alert(Alert.AlertType.WARNING);
            alerts.setTitle("Warning");
            alerts.setHeaderText(null);
            alerts.setContentText("Item Already Added");
            alerts.showAndWait();
        }
        else{
            //executing statement
                try{
                    Statement statement = conn.createStatement();
                    statement.executeUpdate(insertFullquery);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setHeaderText(null);
                    alert.setContentText("Item Added");
                    alert.showAndWait();
                    tx_name.clear();
                    tx_quan.clear();
                    tx_price.clear();
            } catch(Exception ex){
                ex.printStackTrace();
            }
            loadCombo();
            loadTable();
        }   
    }
    //to avoid redundant item names    
    public boolean isPresent(){
        //getting text from text field
        String Cname= tx_name.getText();
        //getting conncetion
        DbConnection dbconn = new DbConnection();
        Connection conn = dbconn.getConnection();
        
        boolean isAvailable = false;
        //query statement
        String query = "SELECT * FROM tbl_item WHERE itemName= '" + Cname + "'"; 
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
    //deleting table
    public void verifyDelete(){
        //establish connection
        DbConnection dbconn = new DbConnection();
        Connection conn = dbconn.getConnection();
        //get text
        String id = null;
        id=JOptionPane.showInputDialog("Enter ID to be Deleted");

        if(id.isEmpty()){
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
                String verifyDel = "DELETE FROM tbl_item WHERE itemID='"+id+"'";
                //execute query
                try{
                    Statement statement = conn.createStatement();
                    statement.executeUpdate(verifyDel); 
            
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setHeaderText(null);
                    alert.setContentText("Deleted");
            
                }catch(Exception ex){
                    ex.printStackTrace();
                }           
            }            
        }
        loadCombo();
        loadTable();
    }
    //search table
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
        String verifySearch = "select itemName,itemPrice,itemQuan, catName from tbl_item inner join tbl_category where tbl_item.catID=tbl_category.catID and itemID='"+id+"'";
        //execute query
        try{  
            Statement statement = conn.createStatement();
            ResultSet queryOutput = statement.executeQuery(verifySearch);
            String arr[] = new String[4];
            while(queryOutput.next()){
                arr[0] = queryOutput.getString("itemName");
                arr[1] = queryOutput.getString("itemPrice");
                arr[2] = queryOutput.getString("itemQuan");
                arr[3] = queryOutput.getString("catName");         
            }
            tx_name.setText(arr[0]);
            tx_price.setText(arr[1]);
            tx_quan.setText(arr[2]);
            cb_category.setValue(arr[3]);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        loadCombo();
        loadTable();
    }
    //update table
    public void verifyUpdate(){
         //establish connection
        DbConnection dbconn = new DbConnection();
        Connection conn = dbconn.getConnection();
        //getText
        String Cname= tx_name.getText();
        String Cprice= tx_price.getText();
        String Cquan= tx_quan.getText();
        String Ccat = (String) cb_category.getValue();
        
        TextInputDialog td = new TextInputDialog();
        td.setHeaderText("Enter ID to be Updated");
        //getID
        Optional<String> result = td.showAndWait();
        String id = td.getEditor().getText();
        // write query 
        // write query 

        //String insertquery1 = "Update tbl_item Set itemName ='"+Cname+"', itemPrice='"+Cprice+"' WHERE itemID='"+id+"' ";
        String insertquery1 ="update tbl_item set itemName ='"+Cname+"', itemPrice='"+Cprice+"', itemQuan='"+Cquan+"',tbl_item.catID = (select tbl_category.catID from tbl_category where tbl_category.catName = '"+Ccat+"' )  WHERE itemID='"+id+"'";
        String verifySearch = "select itemName,itemPrice,itemQuan,catName from tbl_item inner join tbl_category where tbl_item.catID=tbl_category.catID and itemID='"+id+"'";
        
        //execute query
        try{
            
            Statement statement1;
            try {
                statement1 = conn.createStatement();
                ResultSet queryOutput = statement1.executeQuery(verifySearch);
                String arr[] = new String[4];
            while(queryOutput.next()){
                arr[0] = queryOutput.getString("itemName");
                arr[1] = queryOutput.getString("itemPrice");
                arr[2] = queryOutput.getString("itemQuan");
                arr[3] = queryOutput.getString("catName");
            }
            tx_name.setText(arr[0]);
            tx_price.setText(arr[1]);
            tx_quan.setText(arr[2]);
            cb_category.setValue(arr[3]);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            if (Cname.isEmpty()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("Please Insert Category Name");
                alert.showAndWait();
            }
            else if(Cprice.isEmpty()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("Please Insert Item Price");
                alert.showAndWait();
            }
            else if(Cquan.isEmpty()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("Please Insert Item Quantity in Stock");
                alert.showAndWait();
            }
            else{
                try{
                    Statement statement = conn.createStatement();
                    statement.executeUpdate(insertquery1);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setHeaderText(null);
                    alert.setContentText("Category Updated");
                    alert.showAndWait();
                    tx_name.clear();
                    tx_quan.clear();
                    tx_price.clear();
            } catch(Exception ex){
                ex.printStackTrace();
            }
                loadCombo();
                loadTable();
            } 
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    //loading table
    public void loadTable(){
        data.clear();
        DbConnection dbconn = new DbConnection();
        Connection conn = dbconn.getConnection();
        String query = "select itemID,itemName,itemPrice,itemQuan,catName from tbl_item inner join tbl_category where tbl_item.catID=tbl_category.catID";
        try{
           PreparedStatement statement = conn.prepareStatement(query);
           ResultSet output = statement.executeQuery();
           
           while(output.next()){
               data.add(new NewItem(output.getString("itemID"),
                       output.getString("itemName"),
                       output.getString("itemPrice"),
                       output.getString("itemQuan"),
                       output.getString("catName")
               ));
               tbl_item.setItems(data);
           }
           statement.close();
           output.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
