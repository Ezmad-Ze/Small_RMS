/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Ezwad_Ze
 */
public class DbConnection {
    public Connection connect;
    
    public Connection getConnection(){
        String dbName ="restaurant_ms";
        String dbUser="root";
        String dbPassword ="root";
        String url="jdbc:mysql://localhost:3309/"+dbName;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");
            
            connect = (Connection) DriverManager.getConnection(url, dbUser, dbPassword);
        }catch(Exception ex){
            ex.printStackTrace();
        }
           
        return connect;
    }

}
