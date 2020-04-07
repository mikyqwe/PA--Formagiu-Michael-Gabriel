/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miky.laboratorul8;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mikyqwe
 */
public class ArtistController {
    public void create(String name, String country)
    {
        try {
            Connection connection = Database.getInstance();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM artists");
            int id=0;
            while(rs.next())
            {
                id=rs.getInt(1);
            }
            id=id+1;
            rs=st.executeQuery("INSERT INTO artists VALUES("+String.valueOf(id)+",'"+name+"','"+country+"')");
            
        } catch (SQLException ex) {
            Logger.getLogger(ArtistController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void findByName(String name)
    {
               try {
            Connection connection = Database.getInstance();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM artists WHERE name='"+name+"'");
            
            while(rs.next())
            {
             System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
            }
           
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ArtistController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
