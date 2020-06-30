package com.okno;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoundBorderTest {
    private RoundBorder border;

    @Before
    public void  setUp(){
        border = new RoundBorder(4);
    }

    @Test
    public void isBorderOpaque() {
        boolean isTrue = true;
        try{
            border.isBorderOpaque();
        }catch(Exception exception) {
            isTrue = false;
        }
        assertTrue(isTrue);

    }
}