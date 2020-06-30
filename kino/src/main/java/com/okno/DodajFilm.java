package main.java.com.okno;

import main.java.com.bazydanych.BazaDanych;
import main.java.com.bazydanych.Rezyserzy;
import main.java.com.bazydanych.Uzytkownicy;
import main.java.com.movies.FactoryFilmy;
import main.java.com.movies.Filmy;
import main.java.com.movies.Gatunek;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DodajFilm extends JPanel implements MouseListener, OknoJPanel {

    private JLabel bZatwierdz, bPowrot, lRezyserImie, lRezyserNazwisko, lTytul, lGatunek, lOcena, lCzasTrwania, lRokProdukcji, lOpis, background, lWrongData, test;
    private JTextField tTytul, tCzasTrwania, tRezyserImie, tRezyserNazwisko, tOcena, tRokProdukcji,tGatunek, tOpis;
    private Uzytkownicy uzytkownik;
    //private ImageIcon iZarejestrujHover = new ImageIcon("Coś tam\\Nowe Grafiki\\zarejestruj_hover.png");
    //private ImageIcon iZarejestrujClicked = new ImageIcon("Coś tam\\Nowe Grafiki\\zarejestruj_clicked.png");
    //private JPasswordField fPassword;
    //private Login login;
    private String regex = "^([0-9])h[0-9][0-9]m$";
    private Pattern pattern;
    private BufferedImage bi;

    BazaDanych baza = new BazaDanych();

    int x = 700, y= 250, width = 400, height = 50; // x=80, 935, y = 260
    public DodajFilm(Uzytkownicy uzytkownik){
        setBounds(0,0,1920,1080); // inicjalizownie okna
        setLayout(null);
        this.uzytkownik=uzytkownik;


        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("kino\\Coś tam\\Fonts\\Caudex-Regular.ttf"));

            lTytul = new JLabel("Tytul:",JLabel.LEFT); // inicjalizownie oraz ustawianie tekstu "wiek"
            lTytul.setFont(font.deriveFont(Font.BOLD, 50f));
            lTytul.setBounds(x,y+0*(height+20),width*2+50,height);
            lTytul.setForeground(Color.black);
            add(lTytul);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }

        tTytul = new JTextField(); // inicjalizownie oraz ustawianie pola do wpisania wieku
        tTytul.setBounds(x,y+1*(height+20),width*2+50,height);
        add(tTytul);

        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("kino\\Coś tam\\Fonts\\Caudex-Regular.ttf"));

            lGatunek = new JLabel("Gatunek: ",JLabel.LEFT); // inicjalizownie oraz ustawianie tekstu "imie"
            lGatunek.setFont(font.deriveFont(Font.BOLD, 50f));
            lGatunek.setBounds(x,y+2*(height+20),width,height);
            lGatunek.setForeground(Color.black);
            add(lGatunek);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }

        tGatunek = new JTextField(); // inicjalizownie oraz ustawianie pola do wpisywania imienia
        tGatunek.setBounds(x,y+3*(height+20),width,height);
        add(tGatunek);

        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("kino\\Coś tam\\Fonts\\Caudex-Regular.ttf"));

            lCzasTrwania = new JLabel("Czas trwania: ",JLabel.LEFT); // inicjalizownie oraz ustawianie tekstu "email"
            lCzasTrwania.setFont(font.deriveFont(Font.BOLD, 50f));
            lCzasTrwania.setBounds(x+width+50, y+2*(height+20), width, height);
            lCzasTrwania.setForeground(Color.black);
            add(lCzasTrwania);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }

        pattern = Pattern.compile(regex);
        tCzasTrwania = new JTextField(); // inicjalizownie oraz ustawianie pola do wpisywania e-maila
        tCzasTrwania.setBounds(x+width+50,y+3*(height+20),width,height);
        add(tCzasTrwania);

        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("kino\\Coś tam\\Fonts\\Caudex-Regular.ttf"));

            lRokProdukcji = new JLabel("Rok produkcji: "); // inicjalizownie oraz ustawianie tekstu "telefon"
            lRokProdukcji.setFont(font.deriveFont(Font.BOLD, 50f));
            lRokProdukcji.setBounds(x,y+4*(height+20),width,height);
            lRokProdukcji.setForeground(Color.black);
            add(lRokProdukcji);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }

        tRokProdukcji = new JTextField(); // inicjalizownie oraz ustawianie pola wpisania nr telefonu
        tRokProdukcji.setBounds(x,y+5*(height+20),width,height);
        add(tRokProdukcji);

        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("kino\\Coś tam\\Fonts\\Caudex-Regular.ttf"));

            lOcena = new JLabel("Ocena: "); // inicjalizownie oraz ustawianie tekstu "nazwisko"
            lOcena.setFont(font.deriveFont(Font.BOLD, 50f));
            lOcena.setBounds(x+width+50,y+4*(height+20),width,height);
            lOcena.setForeground(Color.black);
            add(lOcena);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }

        tOcena = new JTextField(); // inicjalizownie oraz ustawianie pola do wpisania nazwiska
        tOcena.setBounds(x+width+50,y+5*(height+20),width,height);
        add(tOcena);

        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("kino\\Coś tam\\Fonts\\Caudex-Regular.ttf"));

            lRezyserImie = new JLabel("Imie reżysera:",JLabel.LEFT); // inicjalizownie oraz ustawianie tekstu "login"
            lRezyserImie.setFont(font.deriveFont(Font.BOLD, 40f));
            lRezyserImie.setBounds(x,y+6*(height+20),width,height+5);
            lRezyserImie.setBackground(Color.white);
            lRezyserImie.setForeground(Color.black);
            add(lRezyserImie);

            lRezyserNazwisko = new JLabel("Nazwisko reżysera:"); // inicjalizownie oraz ustawianie tekstu "hasło"
            lRezyserNazwisko.setFont(font.deriveFont(Font.BOLD, 40f));
            lRezyserNazwisko.setBounds(x+width+50,y+6*(height+20),width,height);
            lRezyserNazwisko.setBackground(Color.white);
            lRezyserNazwisko.setForeground(Color.black);
            add(lRezyserNazwisko);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }

        tRezyserImie = new JTextField(); // inicjalizownie oraz ustawianie pola do wpisania loginu
        tRezyserImie.setBounds(x, y+7*(height+20), width, height);
        add(tRezyserImie);

        tRezyserNazwisko = new JTextField(); // inicjalizownie oraz ustawianie pola do wpisania loginu
        tRezyserNazwisko.setBounds(x+width+50, y+7*(height+20), width, height);
        add(tRezyserNazwisko);

        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("kino\\Coś tam\\Fonts\\Caudex-Regular.ttf"));

            lOpis = new JLabel("Opis: "); // inicjalizownie oraz ustawianie tekstu "telefon"
            lOpis.setFont(font.deriveFont(Font.BOLD, 50f));
            lOpis.setBounds(x,y+8*(height+20),width*2+50,height);
            lOpis.setForeground(Color.black);
            add(lOpis);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }

        tOpis = new JTextField(); // inicjalizownie oraz ustawianie pola wpisania nr telefonu
        tOpis.setBounds(x,y+9*(height+20),width*2+50,height);
        add(tOpis);

        bPowrot=new JLabel();
        //ImageIcon iZarejestrujZielone = new ImageIcon("Coś tam\\Nowe Grafiki\\zarejestruj_zielone.png");
        bPowrot.setIcon(new ImageIcon("kino\\Coś tam\\Nowe Grafiki\\powrot2.png"));
        bPowrot.setBounds(x,y+10*(height+20),400,100);
        bPowrot.setBorder(null);
        bPowrot.addMouseListener(this);
        add(bPowrot);

        bZatwierdz=new JLabel();
        //ImageIcon iZarejestrujZielone = new ImageIcon("Coś tam\\Nowe Grafiki\\zarejestruj_zielone.png");
        bZatwierdz.setIcon(new ImageIcon("kino\\Coś tam\\Nowe Grafiki\\zatwierdz.png"));
        bZatwierdz.setBounds(x+width+50,y+10*(height+20),400,100);
        bZatwierdz.setBorder(null);
        bZatwierdz.addMouseListener(this);
        add(bZatwierdz);

        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("kino\\Coś tam\\Fonts\\Caudex-Regular.ttf"));

            test = new JLabel("Kliknięcie sie powiodło");
            test.setFont(font.deriveFont(Font.BOLD, 50f));
            test.setBounds(x+(width/2),y-height,500,height);
            test.setForeground(Color.RED);
            add(test);
            test.setVisible(false);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }

        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("kino\\Coś tam\\Fonts\\Caudex-Regular.ttf"));

            lWrongData = new JLabel("Złe dane",JLabel.CENTER);
            lWrongData.setFont(font.deriveFont(Font.BOLD, 50f));
            lWrongData.setBounds(x,y-(height*2-25),width*2+50,height);
            lWrongData.setVisible(false);
            add(lWrongData);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }

        background = new JLabel(new ImageIcon("kino\\Coś tam\\Nowe Grafiki\\dodaj_film_bg.png")); // inicjalizownie oraz ustawianie tła
        background.setBounds(0,0,1920,1080);
        add(background);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            Object p = e.getSource();
            if ( p == bZatwierdz) { // proba przypisania wpisanych tekstow w polu do zmiennych
                //moze klasa w przyszlosci?
                String tyt = tTytul.getText();
                String gat = tGatunek.getText();
                String czas = tCzasTrwania.getText();
                String name = tRezyserImie.getText();
                String surname = tRezyserNazwisko.getText();
                String _ocena = tOcena.getText();
                String _rok = tRokProdukcji.getText();
                String opis=tOpis.getText();
                double ocena=0;
                int rok=0;
                int idRezyserzy = 0;
                if (tyt == null || gat == null || czas == null || name == null || surname == null || _ocena == null || _rok == null || opis == null) {
                    throw new RuntimeException("Brak danych");
                }
                ocena = Double.parseDouble(_ocena);
                rok = Integer.parseInt(_rok);
                Matcher matcher = pattern.matcher(czas);
                if(!matcher.matches()){
                    throw new RuntimeException("Zly czas trwania (np. 1h00m)");
                }
                //send to check

                List<Filmy> filmy = baza.selectFilmy();
                for(Filmy c: filmy){
                    if(tyt.equals(c.getTytul())){
                        throw new RuntimeException("Taki film istnieje");
                    }
                }

                List<Rezyserzy> rezyserzy = baza.selectRezyserzy();

                boolean found=false;
                for(Rezyserzy c: rezyserzy){
                    if(name.equals(c.getImieRezysera())){
                        if(surname.equals((c.getNazwiskoRezysera()))){
                            idRezyserzy=c.getIdRezyserzy();
                            found=true;
                        }
                    }
                }
                if(!found){
                        baza.insertRezyserzy(name,surname);
                        Rezyserzy rezyser=baza.selectRezyser(name,surname);
                        idRezyserzy=rezyser.getIdRezyserzy();
                }

                Gatunek gatunek=Gatunek.retGatunek(gat);
                FactoryFilmy filmyFactory = new FactoryFilmy();

                Filmy tempFilm = filmyFactory.makeFilm(1, tyt, idRezyserzy, ocena, czas, rok, opis,/* zwiastun,*/ gatunek);
                uzytkownik.dodajFilm(tempFilm);

                exit();
                Main.setJPanel(Window.OknoUzytkownika,uzytkownik);
            }
            if ( p == bPowrot) {
                exit();
                Main.setJPanel(Window.OknoUzytkownika,uzytkownik);
            }
        } catch (NumberFormatException err){
            System.out.println(err);
            lWrongData.setText("Brak danych");
            lWrongData.setForeground(Color.red);
            lWrongData.setVisible(true);
        } catch (RuntimeException err) {
            System.out.println(err);
            lWrongData.setText(err.getMessage());
            lWrongData.setForeground(Color.red);
            lWrongData.setVisible(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Object p = e.getSource();
        if(p == bZatwierdz) {
       //     bZatwierdz.setIcon(iZarejestrujClicked);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Object p = e.getSource();
        if(p == bZatwierdz) {
         //   bZatwierdz.setIcon(iZarejestrujHover);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Object p = e.getSource();
        if(p == bZatwierdz) {
         //   bZatwierdz.setIcon(iZarejestrujHover);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object p = e.getSource();
        if(p == bZatwierdz) {
         //   bZatwierdz.setIcon(iZarejestrujZielone);
        }
    }

    @Override
    public void exit() {
        baza.closeConnection();
        removeAll();
    }
}
