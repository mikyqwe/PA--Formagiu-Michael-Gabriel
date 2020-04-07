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
public class AlbumController {
    public void create(String name, int artistId, int releaseYear)
    {
                try {
            Connection connection = Database.getInstance();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM albums");
            int id=0;
            while(rs.next())
            {
                id=rs.getInt(1);
            }
            id=id+1;
            rs=st.executeQuery("INSERT INTO albums VALUES("+String.valueOf(id)+",'"+name+"',"+String.valueOf(releaseYear)+","+String.valueOf(artistId)+")");
            
        } catch (SQLException ex) {
            Logger.getLogger(ArtistController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void findByArtist(int artistId)
    {
                      try {
            Connection connection = Database.getInstance();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM albums WHERE artist_id="+artistId);
            
            while(rs.next())
            {
             System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4));
            }
           
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ArtistController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
