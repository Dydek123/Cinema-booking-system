package main.java.com.okno;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SiedzenieTest {
    private Siedzenie siedzenie;

    @Before
    public void setUp() {
        siedzenie = new Siedzenie(1, 3, "A3", State.WOLNE);
    }

    @Test
    public void isWolne() {

        assertEquals(State.WOLNE, siedzenie.getState());
    }

    @Test
    public void ifMiejsce() {
        assertEquals("A3", siedzenie.getMiejsce());
    }

    @Test
    public void isCoordX() {
        assertEquals(3, siedzenie.getCoordX() );
    }

    @Test
    public void isCoordY(){
        assertEquals(1, siedzenie.getCoordY());
    }

    @Test
    public void isGettingbSiedzenie(){
        boolean isTrue = true;
        try{
            siedzenie.getbSiedzenie();
        }catch(Exception exception) {
            isTrue = false;
        }
        assertTrue(isTrue);
    }
}