/*

Szybkie podsumowanie o co tu chodzi:
nie zczaiłem ze EkranGłowny to wlasnie ekran uzytkownika wiec zrobilem go na nowo
zakomentowane fragmenty kodu na dole to po prostu przyciski i input boxy ktore mozna potem odkomentować i zmienic odpowiednio pod ich przeznaczenie
Grafika ma w sobie juz te przyciski, nalezy wiec stworzyc jakieś tam obiekty o podobnych wymiarach co te przyciski na backgroundzie i odpowiednio je ulokowac
można tworzyc je przezroczyste albo normalne, graficzne i przykryć tą grafike w tle rzeczywistymi przyciskami
opcja nr 2 - usuniecie przyciskow z tej grafiki w tle i zrobienie swoich i ulokowanie gdziekolwiek

WAŻNE!!!! : dodajac przyciski musi gdzies byc miejsce na przycisk: "Dodaj film", "Dodaj seans"  if (uzytkownik.getAdmin()==true)

 */
/*

To co zrobilem:
-jesli chodzi o "Dodaj film", "Dodaj seans"  if (uzytkownik.getAdmin()==true) to pogadaj z Dydkiem aby dodal do obrazu przykladowe przyciski to wtedy to zaimplementuje
-dodalem przyciski oraz napisy w skazane miejsca, trzeba sie na ktoras opcje zdecydowac, imo 2, ale to trzeba z Dydkiem pogadac
-zauwazylem ze w Register.java (ty chyba to poprawiales, ale moge sie myslic) oraz w Login.java przyciski sa zrobione w postac JLabel, ja zrobilem w postaci JButton,
nie wiem ktora opcja jest lepsza, ktora gorsza, podobnie dzialaja wiec jest git, na ktoras opcje trzeba sie zdecydowac, przerobienie tych przyciskow ktore stworzylem tutaj
jest latwa do przerowbienia, tylko trzeba miec obrazy tych przciskow, a z tym trzeba sie kierowac do Dydka, imo JLabel ma wiekszy sens jesli chcemy swoje grafiki przyciskow dodac
-brakuje jak na razie funkcji obslugujacych te przeciski, ale to jest latwe do zrobienia

*/

package com.okno;

import com.bazydanych.*;
import com.movies.Filmy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;

public class OknoUzytkownika extends JPanel implements ActionListener, MouseListener
{

    private JLabel bEdytujDane, bWyloguj, bTwojeRezerwacje, bDostepneFilmy;
    private JLabel tNazwaUzytkownika, tEmailUzytkownika, tTelefonUzytkownika, tPowitanie, tNajblizszeSeanse;
    private Uzytkownicy uzytkownik;
    BazaDanych baza = new BazaDanych();
    //List<Filmy> filmy = baza.selectFilmy();

    private BufferedImage bi;

    public OknoUzytkownika(Uzytkownicy uzyt){
        setBounds(0,0,1920,1080); // inicjalizownie okna
        setLayout(null);

        uzytkownik=uzyt;

        ImageIcon edytuj_dane = new ImageIcon("Coś tam\\Nowe Grafiki\\edytuj_dane.png");
        bEdytujDane = new JLabel(edytuj_dane); //wersja robocza
        bEdytujDane.setBounds(60, 575, 377, 75);
        bEdytujDane.setBorder(null);
        bEdytujDane.addMouseListener(this);
        add(bEdytujDane);

        ImageIcon wyloguj = new ImageIcon("Coś tam\\Nowe Grafiki\\wyloguj.png");
        bWyloguj = new JLabel(wyloguj);  //wersja robocza
        bWyloguj.setBounds(1500, 48, 280, 70);
        bWyloguj.setBorder(null);
        bWyloguj.addMouseListener(this);
        add(bWyloguj);

        ImageIcon twoje_rezerwacje = new ImageIcon("Coś tam\\Nowe Grafiki\\twoje_rezerwacje.png");
        bTwojeRezerwacje = new JLabel(twoje_rezerwacje);
        bTwojeRezerwacje.setBounds(520, 720, 1380, 150);
        bTwojeRezerwacje.setBorder(null);
        bTwojeRezerwacje.addMouseListener(this);
        add(bTwojeRezerwacje);

        ImageIcon wyswietl_dostepne = new ImageIcon("Coś tam\\Nowe Grafiki\\wyswietl_dostepne_filmy.png");
        bDostepneFilmy = new JLabel(wyswietl_dostepne);
        bDostepneFilmy.setBounds(520, 900, 1380, 150);
        bDostepneFilmy.setBorder(null);
        bDostepneFilmy.addMouseListener(this);
        add(bDostepneFilmy);

        tNazwaUzytkownika = new JLabel(uzyt.getLogin());
        tNazwaUzytkownika.setBounds(115, 700, 325, 25);
        tNazwaUzytkownika.setFont(new Font("Impact", Font.PLAIN, 25));
        add(tNazwaUzytkownika);

        tEmailUzytkownika = new JLabel(uzyt.getEmail());
        tEmailUzytkownika.setBounds(115, 810, 325, 25);
        tEmailUzytkownika.setFont(new Font("Impact", Font.PLAIN, 25));
        add(tEmailUzytkownika);

        tTelefonUzytkownika = new JLabel(String.valueOf((uzyt.getTelefon())));
        tTelefonUzytkownika.setBounds(115, 930, 325, 25);
        tTelefonUzytkownika.setFont(new Font("Impact", Font.PLAIN, 25));
        add(tTelefonUzytkownika);

        tPowitanie = new JLabel("Witaj ponownie, " + uzyt.getLogin(), SwingConstants.CENTER); // jak zrobic napis aby byl idalnie na srodku nie zaleznie od dlugosci nazwy uzytkownika?
        tPowitanie.setBounds(500, 330, 1420, 60); //dostosowac granice
        tPowitanie.setFont(new Font("Impact", Font.PLAIN, 60));
        add(tPowitanie);

        tNajblizszeSeanse = new JLabel("Sprawdz najblizsze seanse i wybierz film dla Siebie", SwingConstants.CENTER); //rownie dobrze moze to byc na backgroundzie, ale trzeba sie dogadac o font
        tNajblizszeSeanse.setBounds(500,450,1420,40);
        tNajblizszeSeanse.setFont(new Font("Impact", Font.PLAIN, 40));
        add(tNajblizszeSeanse);

        JLabel background = new JLabel(new ImageIcon("Coś tam\\Nowe Grafiki\\Profil_uzytkownika.png")); // inicjalizownie oraz ustawianie tła
        background.setBounds(0,0,1920,1080);
        add(background);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        try {
            Object p = e.getSource();
            if ( p == bDostepneFilmy ) {
                //private Login login;
                /*Rezerwacja rezerwacja = new Rezerwacja();
                rezerwacja.setVisible(true);
                dispose();
                */
                DostepneFilmy dostepneFilmy = new DostepneFilmy(uzytkownik,this);
                dostepneFilmy.setVisible(true);
            }
        } catch (RuntimeException | IOException | FontFormatException err) {
            System.out.println(err);
        }
    }

    @Override
    public void mousePressed(MouseEvent e)
    {

    }

    @Override
    public void mouseReleased(MouseEvent e)
    {

    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }
}
