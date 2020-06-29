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
        ImageIcon iWolne = new ImageIcon("Coś tam\\Nowe Grafiki\\wolne.png");
    }


    @Test
    public void isWolne() {

        assertEquals(State.WOLNE, siedzenie.getState());
    }
}
    