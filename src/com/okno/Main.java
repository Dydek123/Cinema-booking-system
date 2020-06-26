package com.okno;

import com.bazydanych.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        JFrame okno = new JFrame();
        Login login = new Login();
        Register register = new Register();
        OknoUzytkownika oknoUzytkownika;

        okno.setSize(1920,1080);
        okno.setTitle("test");
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.getContentPane().setBackground(Color.white);

        okno.setExtendedState(JFrame.MAXIMIZED_BOTH);
        okno.setUndecorated(true);

        okno.setLayout(null);
        okno.setVisible(true);

//        okno.setContentPane(register);
        okno.setVisible(true);

        BazaDanych test = new BazaDanych();
        List<Uzytkownicy> uzytkownicy = test.selectUzytkownicy();
        System.out.println("Lista uzytkownikow: ");
        for(Uzytkownicy c: uzytkownicy)
            System.out.println(c.getLogin() + " " + c.getHaslo());

        System.out.println("test commit");

       /* //test dodawania filmu
        Uzytkownicy admin= new Uzytkownicy();
        //szukam admina
        for (int i = 0; i < uzytkownicy.size(); i++) {
            Uzytkownicy uzytkownicy1 =  uzytkownicy.get(i);
            if (uzytkownicy1.getAdmin()==1){
                admin=uzytkownicy1;
                break;
            }
        }
        //mam admina

        //dodaje film
        admin.dodajFilm(test.selectFilmy(),test,"Shrek8s",1,9.99,"1h50m",1999,"fajny film bardzo","www.link.pl",2);
*/
        //czemu ID filmu w liscie =0? cos jest popsute

        //STWORZYC ENUM DO GATUNKOW PONIEWAZ TERAZ JEST SREDNIO WPISYWAC Z GLOWY NUMEREK

        //EventQueue.invokeLater(com.damianero.RateStar::createAndShowGui);
    }
}
