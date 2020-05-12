/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul5;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mikyqwe
 */
public class Catalog implements Serializable {

    private String name;
    private String path;
    private List<Document> documents = new ArrayList<>();

    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public void add(Document doc) throws DuplicateNameException {
        if (getDocuments().stream().filter(
                d -> d.getId().equals(doc.getId())).findFirst().orElse(null) != null) {
            throw new DuplicateNameException();
        }
        getDocuments().add(doc);
    }

    public Document findById(String id) {
        return getDocuments().stream().filter(
                d -> d.getId().equals(id)).findFirst().orElse(null);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return the documents
     */
    public List<Document> getDocuments() {
        return documents;
    }

    /**
     * @param documents the documents to set
     */
    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

}
