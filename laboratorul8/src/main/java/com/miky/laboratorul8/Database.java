/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miky.laboratorul8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    
    private static Connection connection=null;
    private static Database singleInstance=null;
    private Database ()
    {
       try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
           connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dtba", "sql");

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Connection getInstance() 
    {
        if(singleInstance == null)  // ca sa avem doar o singura conexiune
        {
            singleInstance = new Database();
            
        }

        return connection;
    }

}
