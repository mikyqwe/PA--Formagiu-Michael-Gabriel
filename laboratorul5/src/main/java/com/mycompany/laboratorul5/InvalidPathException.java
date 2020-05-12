/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul5;

/**
 *
 * @author mikyqwe
 */
public class InvalidPathException extends Exception{

    public InvalidPathException(Exception ex) {
        super("Invalid path.", ex);
    }
}
