package pgdp.chess.tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



import pgdp.PinguLib;


import pgdp.chess.PinguChess ;

public class TestPinguChess {
    PinguChess pC=new PinguChess();
    @Test
    public void testGetTeam(){
        assertEquals(pC.getTeam('S'),1) ;
        assertEquals(pC.getTeam('B'),-1);
        assertEquals(pC.getTeam('-'),-1);
        assertEquals(pC.getTeam( 'F'),0);
        assertEquals(pC.getTeam('!'),-1);
    }

    @Test
    public void testGetDirection(){
        assertEquals(pC.getDirection(0,-1),0);
        assertEquals(pC.getDirection(5,-2),-1);
        assertEquals(pC.getDirection(1,0),2);
        assertEquals(pC.getDirection(3,3),3);
    }

}
