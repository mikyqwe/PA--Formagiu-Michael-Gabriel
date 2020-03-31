/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miky.laborator7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author mikyqwe
 */
public class Board {
    private List<Token> piese;
    int maxBlanks;
    public Board (int size)
    {
        this.piese = new ArrayList<>();
        for(int i=1;i<=size;i++)
        {
            if (i%5==0)
                piese.add(new Token(1,true));//punem din 5 in 5 blank uri
            else
                piese.add(new Token(i,false));
        }
        maxBlanks=piese.size();
    }

    /**
     * @return the piese
     */
    public List<Token> getPiese() {
        return piese;
    }
    
    /**
     * @param piese the piese to set
     */
    public void setPiese(List<Token> piese) {
        this.piese = piese;
    }
    
    public synchronized Token drawToken () // va extrage o piesa random de pe tabla de joc, si este sigur ca nu o trag mai multi jucatori(synchronized)
    {
        Token extracted = piese.get(0);
        piese.remove(extracted);
        if (extracted.isBlank())
            extracted.setNumar(maxBlanks++);// ii dam lui blank un numar peste numarul maxim al maximului de piese
        return extracted;
    }
}
