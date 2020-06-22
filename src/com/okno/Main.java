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

        System.out.println("test commit");
        System.out.println("test2");

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
