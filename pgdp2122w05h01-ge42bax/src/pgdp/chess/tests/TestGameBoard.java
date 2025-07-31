package pgdp.chess.tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import pgdp.chess.GameBoard;


public class TestGameBoard  {


    @Test
    public void testEvaluateWinner(){
        GameBoard g=GameBoard.newDefault() ;
        g.set(1,2,'C');
        assertEquals(g.evaluateWinner(),1);
        g.set(15,1,'A');
        assertEquals(g.evaluateWinner(),2);
        g.set(6,6,' ');
        assertEquals(g.evaluateWinner(),0);
        g.set(1,2,'L');
        assertEquals(g.evaluateWinner(),-1);

    }
    @Test
    public void testGetSet(){
        GameBoard g=new GameBoard(10,10);
        g.set(7,7,'K');
        assertEquals(g.get(7,7),'K');

        g.set(1,1,'A');
        assertEquals(g.get(1,1),'A');


    }
}