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
public class InvalidURLException extends Exception{
     public InvalidURLException(Exception ex) {
        super("Invalid url.", ex);
    }
}
