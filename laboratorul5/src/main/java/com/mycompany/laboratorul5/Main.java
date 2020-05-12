/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul5;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mikyqwe
 */
public class Main {

    public static void main(String args[]) {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() {
        try {
            Catalog catalog
                    = new Catalog("Java Resources", "d:/java/catalog.ser");
            Document doc = new Document("java1", "Java Course 1",
                    "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
            doc.addTag("type", "Slides");
            catalog.add(doc);
            
            CatalogUtil.save(catalog);
        } catch (DuplicateNameException | IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void testLoadView() {
        try {
            Catalog catalog = CatalogUtil.load("d:/java/catalog.ser");
            Document doc = catalog.findById("java1");
            CatalogUtil.view(doc);
        } catch (IOException | InvalidURLException | InvalidCatalogException | ClassNotFoundException | InvalidPathException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
