package com.okno;


import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.*;

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
}
    