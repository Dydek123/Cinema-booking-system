package com.okno;

import com.bazydanych.*;

import java.awt.*;
import java.io.IOException;

public class Main {

    private static Okno okno;

    public static void main(String[] args) {

         okno = new Okno();

        setJPanel(Window.Login);

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
