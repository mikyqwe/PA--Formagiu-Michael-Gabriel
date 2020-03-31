/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miky.laborator7;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mikyqwe
 */
public class Game {
    Player castigator=null;
    Board board;
    List<Player> jucatori;
    
    
    public Game(Board board)
    {
        this.board=board;
        
    }
    void setList(List<Player> jucatori)
    {
        this.jucatori=jucatori;
    }
            
    public boolean end()
    {
        if(board.getPiese().isEmpty())
            return true;
        return castigator!=null;
    }
    void setWinner(Player jucator)
    {
        castigator=jucator;
    }
    
    void startGame()
    {   
        List<Thread> threads = new ArrayList<>();
        for(Player p : jucatori)
        {
            threads.add(new Thread(p));
            threads.get(threads.size()-1).start();
        }
        for(Thread t : threads)
        {
            try {
                t.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(castigator!=null)
            System.out.println(castigator.name+" a castigat cu scorul "+castigator.lungimeProgresie);
        else
        {
            for(Player p : jucatori)// daca nu este 1 singur castigator, va fi remiza.
            {
                System.out.println(p.name+" a terminat jocul in remiza cu scorul "+p.lungMaxProgresie());
            }
        }
    }
    
}
