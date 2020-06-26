package com.okno;

import com.bazydanych.BazaDanych;
import com.bazydanych.Uzytkownicy;
import com.movies.Filmy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class DostepneFilmy extends JPanel implements ActionListener, MouseListener {
    BazaDanych baza = new BazaDanych();
    public JFrame bSignUp;
    public JLabel background, bRezerwuj,bPowrot, bPlakat;
    public String[] dostepneFilmy=baza.selectDostepneFilmy();
    //Lista przechowująca obiekty klasy PlakatFilmu - pętla je wyswietli
    public List<PlakatFilmu> lista_plakatow = new LinkedList<>();

    public PlakatFilmu plakat;
    JComboBox filmList = new JComboBox(dostepneFilmy);
    private int selected;
    private Uzytkownicy uzytkownik;
    public DostepneFilmy(Uzytkownicy uzytkownik) throws IOException, FontFormatException {
        setBounds(0,0,1920, 1080); // inicjalizownie okna
        setLayout(null);

        this.uzytkownik=uzytkownik;
        Font font = Font.createFont(Font.TRUETYPE_FONT, new File("Coś tam\\Fonts\\Caudex-Regular.ttf"));

        bRezerwuj = new JLabel(new ImageIcon("Coś tam\\Nowe Grafiki\\rezerwuj.png"));
        bRezerwuj.setBounds(1580, 25, 260, 110);
        bRezerwuj.addMouseListener(this);
        add(bRezerwuj);

        bPowrot = new JLabel(new ImageIcon("Coś tam\\Nowe Grafiki\\powrot.png"));
        bPowrot.setBounds(1300, 25, 260, 110);
        bPowrot.addMouseListener(this);
        add(bPowrot);

        for(String s: dostepneFilmy){
            lista_plakatow.add(new PlakatFilmu(s));
        }
        int size= lista_plakatow.size();
        System.out.println("ROZMIAR ="+size);

        for(int i=0;i<lista_plakatow.size();i++)
        {
            int x = lista_plakatow.get(i).getCordX();
            int y = lista_plakatow.get(i).getCordY();
            lista_plakatow.get(i).setCordX(x+i*250);
            if(lista_plakatow.get(i).getCordX()> 1650){
                lista_plakatow.get(i).setCordX(50);
                lista_plakatow.get(i).setCordY(y+250);

            }
        }
        for(PlakatFilmu p: lista_plakatow)
        {
            add(p.getiPlakat());
        }



        JLabel tTxt = new JLabel("Dostępne filmy"); // jak zrobic napis aby byl idalnie na srodku nie zaleznie od dlugosci nazwy uzytkownika?
        tTxt.setVerticalAlignment(JLabel.TOP);
        tTxt.setBounds(40, 25, 600, 90); //dostosowac granice
        tTxt.setFont(font.deriveFont(Font.BOLD, 70f));
        tTxt.setForeground(new Color(23, 101, 202));
        add(tTxt);

        JLabel tWybierz = new JLabel("Wybierz film:"); // jak zrobic napis aby byl idalnie na srodku nie zaleznie od dlugosci nazwy uzytkownika?
        tWybierz.setVerticalAlignment(JLabel.TOP);
        tWybierz.setBounds(760, 400, 400, 90); //dostosowac granice
        tWybierz.setFont(font.deriveFont(Font.BOLD, 50f));
        tWybierz.setForeground(Color.BLACK);
        add(tWybierz);

        Font theFont = new Font("Arial", Font.BOLD, 25);
        filmList.setSelectedIndex(0);
        filmList.setFont(theFont);
        filmList.addActionListener(this);
        filmList.setBounds(760,490,400,90);
        add(filmList);

        background = new JLabel(new ImageIcon("Coś tam\\Nowe Grafiki\\Film.png")); // inicjalizownie oraz ustawianie tła
        background.setBounds(0,0,1920,1080);
        add(background);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        String filmName = (String)cb.getSelectedItem();
        selected = (int)cb.getSelectedIndex();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            Object p = e.getSource();
            if ( p == bRezerwuj ) {
                /*Rezerwacja rezerwacja = new Rezerwacja(dostepneFilmy[selected]);
                rezerwacja.setVisible(true);
                dispose();*/
//                OknoFilmu oknoFilmu = new OknoFilmu(dostepneFilmy[selected],uzytkownik,this);
//                oknoFilmu.setVisible(true);

                Main.setJPanel(Window.OknoFilmu, uzytkownik, dostepneFilmy[selected]);

            }
            if (p==bPowrot){
                Main.setJPanel(Window.OknoUzytkownika, uzytkownik);
            }
            for(int i=0;i<lista_plakatow.size();i++) {
                if (p == lista_plakatow.get(i).getiPlakat()) {
                    System.out.println("KLIKAM W FILM CO JEST");
                    Main.setJPanel(Window.OknoFilmu, uzytkownik, lista_plakatow.get(i).getchosenMovieTitle());
                }
            }
        } catch (RuntimeException err) {
            System.out.println(err);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}