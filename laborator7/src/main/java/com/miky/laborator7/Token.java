/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miky.laborator7;

/**
 *
 * @author mikyqwe
 */
public class Token {
    private int numar;
    private boolean blank;

    /**
     * @return the numar
     */
    public Token(int numar, boolean blank)
    {
        this.numar=numar;
        this.blank=blank;
    }
    public int getNumar() {
        return numar;
    }

    /**
     * @param numar the numar to set
     */
    public void setNumar(int numar) {
        this.numar = numar;
    }

    /**
     * @return the blank
     */
    public boolean isBlank() {
        return blank;
    }

    /**
     * @param blank the blank to set
     */
    public void setBlank(boolean blank) {
        this.blank = blank;
    }
    
}
