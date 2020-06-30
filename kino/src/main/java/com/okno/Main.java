package main.java.com.okno;

import main.java.com.bazydanych.BazaDanych;
import main.java.com.bazydanych.Uzytkownicy;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class Main {

    private static Okno okno;

    public static void main(String[] args) {

         okno = new Okno();

        setJPanel(Window.Login);

//        BazaDanych test = new BazaDanych();
//
//        List<Uzytkownicy> uzytkownicy = test.selectUzytkownicy();
//        System.out.println("Lista uzytkownikow: ");
//        for(Uzytkownicy c: uzytkownicy)
//            System.out.println(c.getLogin() + " " + c.getHaslo());
//
//        System.out.println("test commit");


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

    public static void setJPanel(Window window)
    {
        switch (window)
        {
            case Login:
                okno.setContentPane(new Login());
                break;

            case Register:
                okno.setContentPane(new Register());
                break;


            default:
                System.out.println("Bledne okno w setJPanel");
        }
    }

    public static void setJPanel(Window window, Uzytkownicy uzyt)
    {
        switch (window) {
            case OknoUzytkownika:
                okno.setContentPane(new OknoUzytkownika(uzyt));
                break;

            case DostepneFilmy:
                try {
                    okno.setContentPane(new DostepneFilmy(uzyt));
                }catch (IOException | FontFormatException e){
                    System.out.println("Blad przy setJPanel DostepneFilmy");
                    e.printStackTrace();
                }
                break;

            case DodajFilm:
                okno.setContentPane(new DodajFilm(uzyt));
                break;

            case DodajSeans:
                okno.setContentPane(new DodajSeans(uzyt));
                break;

            default:
                System.out.println("Bledne okno w setJPanel uzyt");
        }
    }

    public static void setJPanel(Window window, Uzytkownicy uzyt, String chosenMovie)
    {
        try {
            okno.setContentPane(new OknoFilmu(chosenMovie, uzyt));
        }catch (IOException | FontFormatException e)
        {
            System.out.println("Blad przy setJPanel OknoFilmu");
            e.printStackTrace();
        }
    }

    public static void setJPanel(Window window, Uzytkownicy uzyt, int selectedSeansID, String chosenMovieTitle)
    {
        try{
            okno.setContentPane(new Rezerwacja(uzyt, selectedSeansID,chosenMovieTitle));
        }catch (IOException | FontFormatException e)
        {
            System.out.println("Blad przy setJPanel Rezerwacje");
            e.printStackTrace();
        }
    }

}
