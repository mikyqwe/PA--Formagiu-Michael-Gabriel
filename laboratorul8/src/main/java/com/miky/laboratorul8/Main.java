
package com.miky.laboratorul8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mikyqwe
 */
public class Main {


 public static void main (String[] args)
 {
    ArtistController artist= new ArtistController();
    //artist.create("mihai", "romania");
    artist.findByName("mihai");
    AlbumController album = new AlbumController();
    album.create("luceafarul",1,2020);
    album.findByArtist(1);
 }
}
