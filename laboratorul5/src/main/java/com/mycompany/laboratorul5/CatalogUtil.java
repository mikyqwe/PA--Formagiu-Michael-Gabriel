/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul5;

import java.awt.Desktop;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URI;
import java.nio.file.Paths;

/**
 *
 * @author mikyqwe
 */
//The "classical" way
public class CatalogUtil {

    public static void save(Catalog catalog) throws IOException {
        try ( var oos = new ObjectOutputStream(new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }

    public static Catalog load(String path) throws InvalidCatalogException, IOException, ClassNotFoundException, InvalidPathException {
        try {
            Paths.get(path);
        } catch (Exception ex) {
           throw new InvalidPathException(ex);
        }

        Catalog cat;
        try ( var ois = new ObjectInputStream(new FileInputStream(path))) {
            cat = (Catalog) ois.readObject();
        }

        if (cat == null) {
            throw new InvalidCatalogException();
        }
        return cat;
    }

    public static void view(Document doc) throws IOException, InvalidURLException {
        Desktop desktop = Desktop.getDesktop();

        try {
            (new java.net.URL(doc.getLocation())).openStream().close();
        } catch (Exception ex) {
            throw new InvalidURLException(ex);
        }

        URI myURI = URI.create(doc.getLocation());
        desktop.browse(myURI);
    }
}
