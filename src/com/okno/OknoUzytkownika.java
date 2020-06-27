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
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OknoUzytkownika extends JPanel implements ActionListener, MouseListener
{

    private JLabel bEdytujDane, bWyloguj, bTwojeRezerwacje, bExit, bDostepneFilmy, bZapiszDane, bPowrotMini, bDodajSeans, bDodajFilm, bPowrot;
    private JLabel tNazwaUzytkownika, tEmailUzytkownika, tTelefonUzytkownika, tPowitanie, tNajblizszeSeanse, tBledneDane;
    private JTextField fNoweImie, fNoweNazwisko, fNowyEmailUzytkownika, fNowyTelefonUzytkownika;
    private JPasswordField fNoweHaslo;
    private JLabel background;
    private Uzytkownicy uzytkownik;
    private Pattern pattern;
    private TwojeRezerwacje twojeRezerwacje;
    BazaDanych baza = new BazaDanych();

    //List<Filmy> filmy = baza.selectFilmy();

    private BufferedImage bi;

    public OknoUzytkownika(Uzytkownicy uzyt){
        setBounds(0,0,1920,1080); // inicjalizownie okna
        setLayout(null);

        uzytkownik=uzyt;

        ImageIcon zamknij = new ImageIcon("Coś tam\\Nowe Grafiki\\Zamknij_button.png");
        bExit = new JLabel(zamknij);  //wersja robocza
        bExit.setBounds(1600, 48, 280, 70);
        bExit.setBorder(null);
        bExit.addMouseListener(this);
        add(bExit);

        twojeRezerwacje = new TwojeRezerwacje(uzytkownik);
        twojeRezerwacje.setBounds(500,160,1420,540);
        twojeRezerwacje.setVisible(false);
        add(twojeRezerwacje);

        ImageIcon edytuj_dane = new ImageIcon("Coś tam\\Nowe Grafiki\\edytuj_dane.png");
        bEdytujDane = new JLabel(edytuj_dane); //wersja robocza
        bEdytujDane.setBounds(60, 575, 377, 75);
        bEdytujDane.setBorder(null);
        bEdytujDane.addMouseListener(this);
        add(bEdytujDane);

        ImageIcon wyloguj = new ImageIcon("Coś tam\\Nowe Grafiki\\wyloguj.png");
        bWyloguj = new JLabel(wyloguj);  //wersja robocza
        bWyloguj.setBounds(1300, 48, 280, 70);
        bWyloguj.setBorder(null);
        bWyloguj.addMouseListener(this);
        add(bWyloguj);

        ImageIcon dodajSeans = new ImageIcon("Coś tam\\Nowe Grafiki\\dodaj_seans.png");
        bDodajSeans = new JLabel(dodajSeans);  //wersja robocza
        bDodajSeans.setBounds(1000, 48, 280, 70);
        bDodajSeans.setBorder(null);
        bDodajSeans.addMouseListener(this);
        add(bDodajSeans);


        ImageIcon dodajFilm = new ImageIcon("Coś tam\\Nowe Grafiki\\dodaj_film.png");
        bDodajFilm = new JLabel(dodajFilm);  //wersja robocza
        bDodajFilm.setBounds(700, 48, 280, 70);
        bDodajFilm.setBorder(null);
        bDodajFilm.addMouseListener(this);
        add(bDodajFilm);


        if(uzytkownik.getAdmin()==1) {
            bDodajSeans.setVisible(true);
            bDodajFilm.setVisible(true);
        }
        else{
            bDodajSeans.setVisible(false);
            bDodajFilm.setVisible(false);
        }

        ImageIcon twoje_rezerwacje = new ImageIcon("Coś tam\\Nowe Grafiki\\twoje_rezerwacje.png");
        bTwojeRezerwacje = new JLabel(twoje_rezerwacje);
        bTwojeRezerwacje.setBounds(520, 720, 1380, 150);
        bTwojeRezerwacje.setBorder(null);
        bTwojeRezerwacje.addMouseListener(this);
        add(bTwojeRezerwacje);

        bPowrot = new JLabel(new ImageIcon("Coś tam\\Nowe Grafiki\\powrot.png"));
        bPowrot.setBounds(1080, 744, 260, 110);
        bPowrot.addMouseListener(this);
        add(bPowrot);

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

        fNoweImie = new JTextField();
        fNoweImie.setBounds(165,570, 300, 40);
        fNoweImie.setFont(new Font("Impact", Font.PLAIN, 40));
        fNoweImie.setVisible(false);
        add(fNoweImie);

        fNoweNazwisko = new JTextField();
        fNoweNazwisko.setBounds(165,665,300,40);
        fNoweNazwisko.setFont(new Font("Impact", Font.PLAIN, 40));
        fNoweNazwisko.setVisible(false);
        add(fNoweNazwisko);


        fNowyEmailUzytkownika = new JTextField();
        fNowyEmailUzytkownika.setBounds(165,760,300,40);
        fNowyEmailUzytkownika.setFont(new Font("Impact", Font.PLAIN, 40));
        fNowyEmailUzytkownika.setVisible(false);
        add(fNowyEmailUzytkownika);

        fNowyTelefonUzytkownika = new JTextField();
        fNowyTelefonUzytkownika.setBounds(165,855,300,40);
        fNowyTelefonUzytkownika.setFont(new Font("Impact", Font.PLAIN, 40));
        fNowyTelefonUzytkownika.setVisible(false);
        add(fNowyTelefonUzytkownika);

        fNoweHaslo = new JPasswordField();
        fNoweHaslo.setBounds(165,950,300,40);
        fNoweHaslo.setFont(new Font("Impact", Font.PLAIN, 40));
        fNoweHaslo.setVisible(false);
        add(fNoweHaslo);

        bZapiszDane = new JLabel(new ImageIcon("Coś tam\\Nowe Grafiki\\zapisz_dane.png"));
        bZapiszDane.setBounds(255,1005,235,50);
        bZapiszDane.setBorder(null);
        bZapiszDane.setVisible(false);
        bZapiszDane.addMouseListener(this);
        add(bZapiszDane);

        bPowrotMini = new JLabel(new ImageIcon("Coś tam\\Nowe Grafiki\\powrot_mini.png"));
        bPowrotMini.setBounds(10,1005,235,50);
        bPowrotMini.setBorder(null);
        bPowrotMini.setVisible(false);
        bPowrotMini.addMouseListener(this);
        add(bPowrotMini);

        tBledneDane = new JLabel("Bledne dane");
        tBledneDane.setBounds(150,905,500,40);
        tBledneDane.setFont(new Font("Impact", Font.PLAIN, 25));
        tBledneDane.setForeground(Color.red);
        tBledneDane.setVisible(false);
        add(tBledneDane);

        background = new JLabel(new ImageIcon("Coś tam\\Nowe Grafiki\\Profil_uzytkownika_2.png")); // inicjalizownie oraz ustawianie tła
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

            Object p = e.getSource();
            System.out.println(e.getSource());

            if ( p == bDostepneFilmy ) {
                try {
                //private Login login;
                /*Rezerwacja rezerwacja = new Rezerwacja();
                rezerwacja.setVisible(true);
                dispose();
                */
                Main.setJPanel(Window.DostepneFilmy, uzytkownik);
                } catch (RuntimeException err) {
                    System.out.println(err);
                }
            }else if( p == bWyloguj){
                Main.setJPanel(Window.Login);
            }else if( p == bTwojeRezerwacje){

                tNajblizszeSeanse.setVisible(false);
                tPowitanie.setVisible(false);
                bTwojeRezerwacje.setVisible(false);

                twojeRezerwacje.setVisible(true);
                bPowrot.setVisible(true);

            }else if(p == bPowrot) {
                tNajblizszeSeanse.setVisible(true);
                tPowitanie.setVisible(true);
                bTwojeRezerwacje.setVisible(true);

                twojeRezerwacje.setVisible(false);
                bPowrot.setVisible(false);
            }else if( p == bEdytujDane){
                background.setIcon(new ImageIcon("Coś tam\\Nowe Grafiki\\tlo_edytuj_dane.png"));

                bEdytujDane.setVisible(false);
                tNazwaUzytkownika.setVisible(false);
                tEmailUzytkownika.setVisible(false);
                tTelefonUzytkownika.setVisible(false);

                fNoweImie.setVisible(true);
                fNoweImie.setText("");

                fNoweNazwisko.setVisible(true);
                fNoweNazwisko.setText("");

                fNowyEmailUzytkownika.setVisible(true);
                fNowyEmailUzytkownika.setText("");

                fNowyTelefonUzytkownika.setVisible(true);
                fNowyTelefonUzytkownika.setText("");

                fNoweHaslo.setVisible(true);
                fNoweHaslo.setText("");

                bZapiszDane.setVisible(true);
                bPowrotMini.setVisible(true);

            }else if( p == bZapiszDane){
                try {
                    tBledneDane.setVisible(false);
                    String regex="[a-zA-Z0-9]+";
                    pattern = Pattern.compile(regex);
                    String im = fNoweImie.getText();
                    Matcher matcher = pattern.matcher(im);
                    if (!matcher.matches() && im.length()>0){
                        System.out.println("imie ze spacjami");
                        throw new RuntimeException("Imie nie może zawierać spacji!");}
                    else
                        if (im.length()!=0)
                            uzytkownik.setImieUzytkownika(fNoweImie.getText());

                    //if (fNoweNazwisko.getText().length() != 0)
                     //   uzytkownik.setNazwiskoUzytkownika(fNoweNazwisko.getText());


                    /*
                    if (fNoweImie.getText().length() != 0)
                        uzytkownik.setImieUzytkownika(fNoweImie.getText());
                    if (fNoweNazwisko.getText().length() != 0)
                        uzytkownik.setNazwiskoUzytkownika(fNoweNazwisko.getText());*/

                    regex = "^(.+)@(.+).(.+)$";
                    pattern = Pattern.compile(regex);
                    String em = fNowyEmailUzytkownika.getText();
                    matcher = pattern.matcher(em);
                    if (!matcher.matches() && em.length() > 0)
                        throw new RuntimeException("Email nie jest emailem!");
                    else
                        if (em.length() != 0)
                            uzytkownik.setEmail(em);
                            tEmailUzytkownika.setText(em);


                    regex = "[0-9]+";
                    pattern = Pattern.compile(regex);
                    String tel=fNowyTelefonUzytkownika.getText();
                    matcher = pattern.matcher(tel);
                    if (!matcher.matches() && tel.length()> 0){
                        throw new RuntimeException("Numer musi być cyframi!");
                    }
                    else{
                        if (fNowyTelefonUzytkownika.getText().length() != 0)
                            uzytkownik.setTelefon(Integer.parseInt(fNowyTelefonUzytkownika.getText()));
                            tTelefonUzytkownika.setText(telefon);
                    }

                    regex="[a-zA-Z0-9]+";
                    pattern = Pattern.compile(regex);
                    String pas = fNoweHaslo.getText();
                    matcher = pattern.matcher(pas);
                    if (!matcher.matches() && pas.length()>0){
                        System.out.println("haslo ze spacjami");
                        throw new RuntimeException("Haslo nie może zawierać spacji!");}
                    else
                        if (pas.length()!=0)
                            uzytkownik.setHaslo(fNoweHaslo.getText());
                    //if (fNoweHaslo.getText().length() != 0)
                    //    uzytkownik.setHaslo(fNoweHaslo.getText());

                    if(!baza.updateUzytkownicy(uzytkownik))
                        throw new Exception("blad update uzytkownika");

                    bEdytujDane.setVisible(true);
                    tNazwaUzytkownika.setVisible(true);
                    tEmailUzytkownika.setVisible(true);
                    tTelefonUzytkownika.setVisible(true);

                    fNoweImie.setVisible(false);
                    fNoweNazwisko.setVisible(false);
                    fNowyEmailUzytkownika.setVisible(false);
                    fNowyTelefonUzytkownika.setVisible(false);
                    fNoweHaslo.setVisible(false);
                    bZapiszDane.setVisible(false);
                    bPowrotMini.setVisible(false);

                    background.setIcon(new ImageIcon("Coś tam\\Nowe Grafiki\\Profil_uzytkownika.png"));
                }catch(Exception err){
                    System.out.println(err);
                    tBledneDane.setText(err.getMessage());
                    tBledneDane.setVisible(true);
                }
            }else if(p==bDodajFilm){
                Main.setJPanel(Window.DodajFilm,uzytkownik);
            }else if(p==bDodajSeans){
                Main.setJPanel(Window.DodajSeans,uzytkownik);
            }else if(p==bPowrotMini){
                background.setIcon(new ImageIcon("Coś tam\\Nowe Grafiki\\Profil_uzytkownika.png"));

                bEdytujDane.setVisible(true);
                tNazwaUzytkownika.setVisible(true);
                tEmailUzytkownika.setVisible(true);
                tTelefonUzytkownika.setVisible(true);

                fNoweImie.setVisible(false);
                fNoweNazwisko.setVisible(false);
                fNowyEmailUzytkownika.setVisible(false);
                fNowyTelefonUzytkownika.setVisible(false);
                fNoweHaslo.setVisible(false);
                bZapiszDane.setVisible(false);
                bPowrotMini.setVisible(false);
                tBledneDane.setVisible(false);
            }else if(p == bExit){
                Main.setJPanel(Window.Login);
                removeAll();
                System.exit(0);
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
