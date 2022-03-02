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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Order {
        private static ObservableList<NewOrder> datas;
        private static TableView tbl_menu;
        private static ObservableList<NewItem> data;

        public static ObservableList<NewOrder> getdatas() {
            return datas;
        }
        public static ObservableList<NewItem> getdata() {
            return data;
        }
        public static TableView gettbl_menu() {
            return tbl_menu;
        }        
        //declaring Scene
        Scene scene2;
        //declaring root pane
        AnchorPane root ;
       //button
        Button btn_add;
        Button btn_reset;
        Button btn_remove;
        Button btn_report;
        Button btn_load;
        Button btn_to_user;
        //Label
        Label lbl_title;
        Label lbl_sub_title;
        Label lbl_category;
        Label lbl_item;
        Label lbl_quantity;
        //Fields
        TextField tx_quantity;
        ComboBox cb_category;
        ComboBox cb_items;
        //Table
        //TableView tbl_menu;
        TableView tbl_order;

        final ObservableList Coptions = FXCollections.observableArrayList();
        final ObservableList Ioptions = FXCollections.observableArrayList();
        //dialog
        TextInputDialog td = new TextInputDialog();

    public Scene Order(){
        //declaring root pane
        root = new AnchorPane();
        //button
        btn_add = new Button("Add");
        btn_reset = new Button("Reset");
        btn_remove = new Button("Remove");
        btn_report = new Button("Report");
        btn_load = new Button("Load Table");
        btn_to_user = new Button("Back");
        //Label
        lbl_title = new Label("Order");  
        lbl_sub_title = new Label("Menu"); 
        lbl_quantity = new Label("Quantity");
        lbl_item = new Label("Item");
        lbl_category = new Label("Category");
        //Fields
        tx_quantity = new TextField();
        cb_category = new ComboBox();
        cb_items = new ComboBox();
        //Table
        tbl_menu = new TableView();
        data = FXCollections.observableArrayList();
        TableColumn categoryCol = new TableColumn("Category Name");
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("catName"));
        TableColumn itemNameCol= new TableColumn("Item Name");
        itemNameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        TableColumn priceCol = new TableColumn("Price");
        priceCol.setCellValueFactory(new PropertyValueFactory<>("Price"));
        TableColumn quanCol = new TableColumn("Quantity");
        quanCol.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        tbl_menu.getColumns().addAll(categoryCol,itemNameCol, priceCol,quanCol);
        
        tbl_order = new TableView();
        datas = FXCollections.observableArrayList();
        TableColumn idCol= new TableColumn("ID");
        idCol.setMinWidth(20);
        idCol.setMaxWidth(500);
        idCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
        TableColumn additemNameCol= new TableColumn("Item Name");
        additemNameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        TableColumn addquantityCol = new TableColumn("Quantity");
        addquantityCol.setCellValueFactory(new PropertyValueFactory<>("Quant"));
        TableColumn addTotalCol = new TableColumn("Total Price");
        addTotalCol.setCellValueFactory(new PropertyValueFactory<>("TPrice"));
        tbl_order.getColumns().addAll(idCol,additemNameCol,addquantityCol,addTotalCol);
        //adding and aligning
        //Label        
        lbl_title.setLayoutX(58);
        lbl_title.setLayoutY(14);
        lbl_title.setId("new-label-2");
        //
        lbl_sub_title.setLayoutX(58);
        lbl_sub_title.setLayoutY(95);
        //
        lbl_quantity.setLayoutX(61);
        lbl_quantity.setLayoutY(425);
        //
        lbl_category.setLayoutX(60);
        lbl_category.setLayoutY(347);
        //
        lbl_item.setLayoutX(58);
        lbl_item.setLayoutY(386);
        //
        btn_add.setLayoutX(55);
        btn_add.setLayoutY(479);
        // 
        btn_reset.setLayoutX(269);
        btn_reset.setLayoutY(479);
        //
        btn_remove.setLayoutX(521);
        btn_remove.setLayoutY(357);
        //
        btn_report.setLayoutX(797);
        btn_report.setLayoutY(357);
        //
        btn_load.setLayoutX(52);
        btn_load.setLayoutY(532);
        //
        btn_to_user.setLayoutX(799);
        btn_to_user.setLayoutY(494);
        //
        tx_quantity.setLayoutX(174);
        tx_quantity.setLayoutY(424);
        tx_quantity.setPrefWidth(162);
        tx_quantity.setPromptText("Quantity");
        //
        cb_category.setLayoutX(174);
        cb_category.setLayoutY(346);
        cb_category.setPrefSize(162,25);
        cb_category.setPromptText("Choose Category");
        //
        cb_items.setLayoutX(174);
        cb_items.setLayoutY(385);
        cb_items.setPrefSize(162,25);
        cb_items.setPromptText("Choose Items");
        //
        tbl_order.setLayoutX(471);
        tbl_order.setLayoutY(136);
        tbl_order.setPrefSize(420, 200);
        tbl_order.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        //
        tbl_menu.setLayoutX(29);
        tbl_menu.setLayoutY(131);
        tbl_menu.setPrefSize(370, 200);
        tbl_menu.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        //adding elements to root
        root.getChildren().addAll(btn_add,btn_remove,btn_reset,btn_to_user,btn_report,btn_load,lbl_item,lbl_category,lbl_title,lbl_sub_title,lbl_quantity,tx_quantity,cb_items,cb_category,tbl_order,tbl_menu);

        //aligning elements
        AnchorPane.setRightAnchor( btn_report, 36.0);
        //
        AnchorPane.setRightAnchor( btn_to_user, 36.0);
        //
        AnchorPane.setRightAnchor( tbl_order, 14.0);
        AnchorPane.setLeftAnchor( tbl_order, 471.0);
        //setting actions
        //report
        btn_report.setOnAction(e->{
            //rep(Report.getta());
            Stage stage= Main.getStage();
            Scene scene = new Report().Report();
            new Main().switchScene(stage,scene);
        });
        //load
        btn_load.setOnAction(e -> {
            loadTable(data,tbl_menu); 
            loadComboCat();});
        //remove
        btn_remove.setOnAction(e ->{removeTable();});
        //add
        btn_add.setOnAction(e -> {addTableOr();});
        //to add only numbers
        tx_quantity.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                tx_quantity.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        //back button
        btn_to_user.setOnAction(e -> {
            clearDB(datas);
            Stage stage = Main.getStage();
            Scene scene = new Home().Home();
            new Main().switchScene(stage, scene);
        });
        //reset
        btn_reset.setOnAction(e->{
            tx_quantity.clear();
        });
        //to add selection based on category
        cb_category.getSelectionModel().selectedItemProperty().addListener(new ChangeListener(){
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if(cb_category.getValue()== (null)){
                    return;
                }
                else{
                    loadComboItm();
                    //loadTableOr();
                }
            }
        });
        
        //setting Scene
        scene2 = new Scene(root);
        scene2.getStylesheets().add(Main.class.getResource("../Style/css.css").toExternalForm());
        
        return scene2;
    }
    //loading table
    public void loadTable(ObservableList<NewItem> data,  TableView tbl_menu){
        data.clear();
        DbConnection dbconn = new DbConnection();
        Connection conn = dbconn.getConnection();
        String query = "select catName,itemName,itemPrice,itemQuan from tbl_item inner join tbl_category where tbl_item.catID=tbl_category.catID";
        try{
           PreparedStatement statement = conn.prepareStatement(query);
           ResultSet output = statement.executeQuery();
           
           while(output.next()){
               data.add(new NewItem(null,
                       output.getString("itemName"),
                       output.getString("itemPrice"),
                       output.getString("itemQuan"),
                       output.getString("catName")          
               ));
               tbl_menu.setItems(data);
           }
           statement.close();
           output.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    //calculaute product of quantity and price
    public String Total(){
        String Citems= (String) cb_items.getValue();
        String Ccat = tx_quantity.getText();
        DbConnection dbconn = new DbConnection();
        Connection conn = dbconn.getConnection();
        
        String query = "select itemPrice from tbl_item where itemName = '"+Citems+"'";
        String tots = null;
        try{
           PreparedStatement statement = conn.prepareStatement(query);
           ResultSet output = statement.executeQuery();

           while(output.next()){
               String x = output.getString("itemPrice");    
               int cp = Integer.parseInt(x);
               int cq = Integer.parseInt(Ccat);
               int tot = cp * cq;        
               tots = Integer.toString(tot);
           }

        }catch(Exception ex){
            ex.printStackTrace();
        }
       return tots; 
    }
    //calculate stock
    public String CalcStock(){
        String Citems= (String) cb_items.getValue();
        String Ccat = tx_quantity.getText();
        DbConnection dbconn = new DbConnection();
        Connection conn = dbconn.getConnection();
        
        String query = "select itemQuan from tbl_item where itemName = '"+Citems+"'";
        String calc = null;
        try{
           PreparedStatement statement = conn.prepareStatement(query);
           ResultSet output = statement.executeQuery();

           while(output.next()){
               String x = output.getString("itemQuan");    
               int cp = Integer.parseInt(x);
               int cq = Integer.parseInt(Ccat);
               int tot = cp - cq;        
               calc = Integer.toString(tot);
           }

        }catch(Exception ex){
            ex.printStackTrace();
        }
       return calc; 
    }
    //insert subtracted data to the insert
     public void addtoItem(){
        String m=null;
        String Cname= (String) cb_category.getValue();
        String Citems= (String) cb_items.getValue();
        String Ccat = tx_quantity.getText();
     
            data.clear();
            //establish connection
            DbConnection dbconn = new DbConnection();
            Connection conn = dbconn.getConnection();
            // write query  
            int x= Integer.parseInt(CalcStock());
            int y = Integer.parseInt(Ccat);
            String query ="update tbl_item set itemQuan='"+ x +"',tbl_item.catID = (select tbl_category.catID from tbl_category where tbl_category.catName ='"+Cname+"')  WHERE itemName ='"+Citems+"'";
            Statement statement;
            try {
                statement = conn.createStatement();
                statement.executeUpdate(query);      
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            //datas.add(new NewOrder((String)cb_items.getValue(),tx_quantity.getText(),Total()));

            //ta.appendText((String)cb_items.getValue()+"\t\t"+tx_quantity.getText()+"\t\t"+Total() +"\n");
            
            tbl_menu.setItems(data);  
 
    }
    //isAvailable
    public boolean isAvailable(){
        //getting text from text field
        String Cname= (String) cb_category.getValue();
        String Cquan= tx_quantity.getText();
        //getting conncetion
        DbConnection dbconn = new DbConnection();
        Connection conn = dbconn.getConnection();
        
        boolean isEnough = false;
        //query statement
        //String query = "SELECT * FROM tbl_item WHERE itemQuan>='"+Cquan+"'";
        String query ="select * from tbl_item inner join tbl_category where tbl_item.catID=tbl_category.catID and itemQuan>='"+Cquan+"' and catName='"+Cname+"'";
        //executing statement
        try{
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query); 
            isEnough = resultSet.next(); 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
         return isEnough;
    }
    //loading Order Table
    public void loadTableOr(){
         DbConnection dbconn = new DbConnection();
        Connection conn = dbconn.getConnection();
        String query = "Select orderID,itemName, quantity, total from tbl_order inner join tbl_item where tbl_item.itemID = tbl_order.itemID;";
        try{
           PreparedStatement statement = conn.prepareStatement(query);
           ResultSet output = statement.executeQuery();
           
           while(output.next()){
                datas.add(new NewOrder(output.getString("orderID"),
                       output.getString("itemName"),
                       output.getString("quantity"),
                       output.getString("total")
               ));
               tbl_order.setItems(datas);
           }
           statement.close();
           output.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    //adding Order Table
    public void addTableOr(){
        String m=null;
        String Cname= (String) cb_category.getValue();
        String Citems= (String) cb_items.getValue();
        String Ccat = tx_quantity.getText();
        
        if (Citems.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please Insert Item Name");
            alert.showAndWait();
        }
        else if(Ccat.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please Insert Quantity");
            alert.showAndWait();
        }
        else if (isAvailable()==false){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please Insert quantity Less than the amount");
            alert.showAndWait();
            datas.clear();
        }
        else{
            datas.clear();
            //establish connection
            DbConnection dbconn = new DbConnection();
            Connection conn = dbconn.getConnection();
            // write query  
            int x= Integer.parseInt(Total());
            int y = Integer.parseInt(Ccat);
            String query ="insert into tbl_order(itemID,quantity,total) values ((select itemID from tbl_item where itemName = '"+Citems+"'),'"+y+"','"+x+"');";
            String queries ="Select orderID,itemName, quantity, total from tbl_order inner join tbl_item where tbl_item.itemID = tbl_order.itemID;";
            Statement statement;
            try {
                statement = conn.createStatement();
                statement.executeUpdate(query);      
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            //datas.add(new NewOrder((String)cb_items.getValue(),tx_quantity.getText(),Total()));

            //ta.appendText((String)cb_items.getValue()+"\t\t"+tx_quantity.getText()+"\t\t"+Total() +"\n");
            
            tbl_order.setItems(datas);
            
        }
        loadTableOr();
        addtoItem();
        loadTable(data,tbl_menu);
    }
    //clear Database
    public void clearDB(ObservableList<NewOrder> datas){
            try {
                DbConnection dbconn = new DbConnection();
                Connection conn = dbconn.getConnection();
                String verifyDel = "delete  from tbl_order;";
                Statement statement = conn.createStatement();
                statement.executeUpdate(verifyDel); 
                datas.clear();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
    }
    //removing table
    public void removeTable(){
        datas.clear();
        //establish connection
        DbConnection dbconn = new DbConnection();
        Connection conn = dbconn.getConnection();
        //get text
        td.setHeaderText("Enter ID to be Deleted");
        //getID
        Optional<String> result = td.showAndWait();
        String id = td.getEditor().getText();
        //checking if empty
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
                String verifyDel = "DELETE FROM tbl_order WHERE orderID='"+id+"'";
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
        loadTableOr();
    }
    //loading comboBox
    public void loadComboCat(){
        Coptions.clear();
        DbConnection dbconn = new DbConnection();
        Connection conn = dbconn.getConnection();
        String query = "SELECT catName from tbl_category";
        try{
           PreparedStatement statement = conn.prepareStatement(query);
           ResultSet output = statement.executeQuery();

           while(output.next()){
              Coptions.add(output.getString("catName"));
               cb_category.setItems(Coptions);
           }

           statement.close();
           output.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    //loading comboBox
    public void loadComboItm(){
        Ioptions.clear();
        DbConnection dbconn = new DbConnection();
        Connection conn = dbconn.getConnection();
        
        String query = "select itemName from tbl_item inner join tbl_category where tbl_item.catID=tbl_category.catID and tbl_category.catName = '"+(String)cb_category.getValue()+"'";
        try{
           PreparedStatement statement = conn.prepareStatement(query);
           ResultSet output = statement.executeQuery();
 
           while(output.next()){
               Ioptions.add(output.getString("itemName"));
               cb_items.setItems(Ioptions);
           }
           
           statement.close();
           output.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

   
}
