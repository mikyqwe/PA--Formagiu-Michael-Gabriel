
package com.miky.laborator7;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mikyqwe
 */
public class Main {
    public static void main (String[] args)
    {
        Board board= new Board(20);
        Game game = new Game(board);
        Player p1 = new Player(board, "Ion",game,3);
         Player p2 = new Player(board, "Mihai",game,3);
         Player p3 = new Player(board, "Jony",game,3);
         List<Player> players= new ArrayList<>();
         players.add(p1);
         players.add(p2);
         players.add(p3);
         game.setList(players);
         game.startGame();
    }
}
