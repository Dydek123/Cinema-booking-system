package com.okno;

import com.bazydanych.*;
import com.movies.Filmy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DodajSeans extends JPanel implements MouseListener, OknoJPanel {

    private JLabel bZatwierdz, bPowrot, lTytul, lNumerSali, lDataSeansu, lGodzinaSeansu, background, lWrongData;
    private JTextField tTytul, tDataSeansu, tGodzinaSeansu, tNumerSali;
    private Uzytkownicy uzytkownik;
    private ImageIcon iPowrot = new ImageIcon("kino\\src\\main\\resources\\Images\\powrot2.png");
    private ImageIcon iPowrot_hover = new ImageIcon("kino\\src\\main\\resources\\Images\\powrot_button_hover.png");
    private ImageIcon iZatwierdz = new ImageIcon("kino\\src\\main\\resources\\Images\\zatwierdz.png");
    private ImageIcon iZatwierdz_hover = new ImageIcon("kino\\src\\main\\resources\\Images\\zatwierdz_hover.png");
    private String pData = "[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]";
    private String pGodzina = "[0-9][0-9]:[0-9][0-9]:[0-9][0-9]";
    private Pattern pattern;
    private BufferedImage bi;

    BazaDanych baza = new BazaDanych();

    int x = 700, y= 250, width = 400, height = 50; // x=80, 935, y = 260
    public DodajSeans(Uzytkownicy uzytkownik){
        setBounds(0,0,1920,1080); // inicjalizownie okna
        setLayout(null);
        this.uzytkownik=uzytkownik;

        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("kino\\Coś tam\\Fonts\\Caudex-Regular.ttf"));

            lTytul = new JLabel("Tytul filmu:",JLabel.LEFT); // inicjalizownie oraz ustawianie tekstu "wiek"
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

            lNumerSali = new JLabel("Numer Sali: ",JLabel.LEFT); // inicjalizownie oraz ustawianie tekstu "imie"
            lNumerSali.setFont(font.deriveFont(Font.BOLD, 50f));
            lNumerSali.setBounds(x,y+2*(height+20),width*2+50,height);
            lNumerSali.setForeground(Color.black);
            add(lNumerSali);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }

        tNumerSali = new JTextField(); // inicjalizownie oraz ustawianie pola do wpisywania imienia
        tNumerSali.setBounds(x,y+3*(height+20),width*2+50,height);
        add(tNumerSali);

        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("kino\\Coś tam\\Fonts\\Caudex-Regular.ttf"));

            lDataSeansu = new JLabel("Data seansu: ",JLabel.LEFT); // inicjalizownie oraz ustawianie tekstu "email"
            lDataSeansu.setFont(font.deriveFont(Font.BOLD, 50f));
            lDataSeansu.setBounds(x, y+4*(height+20), width*2+50, height);
            lDataSeansu.setForeground(Color.black);
            add(lDataSeansu);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }

        //pattern = Pattern.compile(regex);
        tDataSeansu = new JTextField(); // inicjalizownie oraz ustawianie pola do wpisywania e-maila
        tDataSeansu.setBounds(x,y+5*(height+20),width*2+50,height);
        add(tDataSeansu);

        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("kino\\Coś tam\\Fonts\\Caudex-Regular.ttf"));

            lGodzinaSeansu = new JLabel("Godzina Seansu: "); // inicjalizownie oraz ustawianie tekstu "telefon"
            lGodzinaSeansu.setFont(font.deriveFont(Font.BOLD, 50f));
            lGodzinaSeansu.setBounds(x,y+6*(height+20),width*2+50,height);
            lGodzinaSeansu.setForeground(Color.black);
            add(lGodzinaSeansu);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }

        tGodzinaSeansu = new JTextField(); // inicjalizownie oraz ustawianie pola wpisania nr telefonu
        tGodzinaSeansu.setBounds(x,y+7*(height+20),width*2+50,height);
        add(tGodzinaSeansu);

        bPowrot=new JLabel();
        //ImageIcon iZarejestrujZielone = new ImageIcon("Coś tam\\Nowe Grafiki\\zarejestruj_zielone.png");
        bPowrot.setIcon(new ImageIcon("kino\\src\\main\\resources\\Images\\powrot2.png"));
        bPowrot.setBounds(x,y+10*(height+20),400,100);
        bPowrot.setBorder(null);
        bPowrot.addMouseListener(this);
        add(bPowrot);

        bZatwierdz=new JLabel();
        //ImageIcon iZarejestrujZielone = new ImageIcon("Coś tam\\Nowe Grafiki\\zarejestruj_zielone.png");
        bZatwierdz.setIcon(new ImageIcon("kino\\src\\main\\resources\\Images\\zatwierdz.png"));
        bZatwierdz.setBounds(x+width+50,y+10*(height+20),400,100);
        bZatwierdz.setBorder(null);
        bZatwierdz.addMouseListener(this);
        add(bZatwierdz);


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

        background = new JLabel(new ImageIcon("kino\\src\\main\\resources\\Images\\dodaj_seans_bg.png")); // inicjalizownie oraz ustawianie tła
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
                String _nrSali = tNumerSali.getText();
                String data = tDataSeansu.getText();
                String godzina = tGodzinaSeansu.getText();
                int idSali=0;
                int nrSali=0;
                int idFilmu = 0;
                if (tyt == null || _nrSali == null || data == null || godzina == null) {
                    throw new RuntimeException("Brak danych");
                }
                nrSali = Integer.parseInt(_nrSali);

                pattern = Pattern.compile(pData);
                Matcher matcher = pattern.matcher(data);
                if(!matcher.matches()){
                    throw new RuntimeException("Zly format daty RRRR-MM-DD");
                }
                pattern = Pattern.compile(pGodzina);
                matcher = pattern.matcher(godzina);
                if(!matcher.matches()){
                    throw new RuntimeException("Zly format godziny GG:MM:SS");
                }
                //send to check

                List<Filmy> filmy = baza.selectFilmy();
                boolean found=false;
                for(Filmy c: filmy){
                    if(tyt.equals(c.getTytul())){
                        idFilmu=c.getIdFilmy();
                        found=true;
                    }
                }
                if(!found){
                    throw new RuntimeException("Podanego filmu nie ma w bazie");
                }

                List<Sale> sale = baza.selectSale();
                found=false;
                for(Sale c: sale){
                    if(nrSali==c.getNumer()){
                        idSali=c.getIdSale();
                        found=true;
                    }
                }
                if(!found){
                    throw new RuntimeException("Sala o podanym numerze nie istnieje");
                }

                baza.insertSeanse(idSali,idFilmu,data,godzina);

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
            bZatwierdz.setIcon(iZatwierdz);
        }else if(p == bPowrot) {
            bPowrot.setIcon(iPowrot);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Object p = e.getSource();
        if(p == bZatwierdz) {
            bZatwierdz.setIcon(iZatwierdz_hover);
        }else if(p == bPowrot) {
            bPowrot.setIcon(iPowrot_hover);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object p = e.getSource();
        if(p == bZatwierdz) {
            bZatwierdz.setIcon(iZatwierdz);
        }else if(p == bPowrot) {
            bPowrot.setIcon(iPowrot);
        }
    }

    @Override
    public void exit() {
        baza.closeConnection();
        removeAll();
    }
}
