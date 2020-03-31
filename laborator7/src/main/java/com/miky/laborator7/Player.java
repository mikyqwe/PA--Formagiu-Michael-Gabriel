/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miky.laborator7;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mikyqwe
 */
public class Player implements Runnable{
    String name;
    Board board;// piesele de pe masa
    Game game;
    List<Token> piese;// ce are in mana
    int lungimeProgresie;
    public Player (Board board, String name, Game game, int lungimeProgresie)
    {   this.name=name;
        this.board=board;
        piese= new ArrayList<>();
        this.game=game;
        this.lungimeProgresie=lungimeProgresie;
    }

    public int lungMaxProgresie() 
    {      int n = piese.size();
        if (n <= 2) return n; // daca sunt 2 numere, ele clar formeaza o progresie aritmetica
        int L[][] = new int[n][n]; // pe linia i j va fi cea mai mare progresie aritmetica
        int longestAP = 2; // orice progresie aritmetica are macar 2 numere

        for (int i = 0; i < n; i++) 
            L[i][n - 1] = 2; 
        for (int j = n - 2; j >= 1; j--) 
        { 
            int i = j -1 , k = j + 1; 
            while (i >= 0 && k <= n - 1) 
            { 
            if (piese.get(i).getNumar() + piese.get(k).getNumar() < 2 * piese.get(j).getNumar()) 
                k++; 
            else if (piese.get(i).getNumar() + piese.get(k).getNumar() > 2 * piese.get(j).getNumar()) 
            {  
                L[i][j] = 2; i--;  
                  
            } // stanga+dreapta=2*mijloc cand este mai mic sau mai mare cautam alt numar, cand este = este ok
      
            else
            { 
                L[i][j] = L[j][k] + 1; 
                longestAP = Math.max(longestAP, L[i][j]); 
                i--;
                k++; 
            } 
            } 
            while (i >= 0) 
            { 
                L[i][j] = 2; 
                i--; 
            } 
        } 
        return longestAP; 
    }
    
    @Override
    public void run() {
        
       while(!game.end())
       {
           piese.add(board.drawToken()); // tragem o carte
           System.out.println(name+" a tras piesa "+ piese.get(piese.size()-1).getNumar()+" de pe tabla.");
           if(lungMaxProgresie()==lungimeProgresie)
               game.setWinner(this);
           
       }
           
    }

}
