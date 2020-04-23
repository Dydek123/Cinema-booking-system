package com.okno;

import com.bazydanych.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Login okno = new Login();
        okno.setVisible(true);
        BazaDanych test = new BazaDanych();
        List<Uzytkownicy> uzytkownicy = test.selectUzytkownicy();
        System.out.println("Lista uzytkownikow: ");
        for(Uzytkownicy c: uzytkownicy)
            System.out.println(c.getLogin() + " " + c.getHaslo());
//        EventQueue.invokeLater(com.damianero.RateStar::createAndShowGui);
    }
}
