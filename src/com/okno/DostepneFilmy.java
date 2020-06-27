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
    public JLabel background, bRezerwuj,bPowrot, hover;
    public String[] dostepneFilmy=baza.selectDostepneFilmy();
    //Lista przechowująca obiekty klasy PlakatFilmu - pętla je wyswietli
    public List<PlakatFilmu> lista_plakatow = new LinkedList<>();
    private PlakatFilmu selected_poster;
    private  boolean is_selected = false;
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

        int old_x=lista_plakatow.get(0).getCordX();
        int old_y=lista_plakatow.get(0).getCordY();
        int j=0;
        int temp_y=1;
        for(int i=0;i<lista_plakatow.size();i++)
        {

            lista_plakatow.get(i).getiPlakat().addMouseListener(this);
            if(j==5)
            {
                lista_plakatow.get(i).setCordX(170);
                old_x = lista_plakatow.get(i).getCordX();
                lista_plakatow.get(i).setCordY(old_y +temp_y*450);
                temp_y+=1;
                j=0;
            }
            else{
                lista_plakatow.get(i).setCordX(old_x+j*316);
                j+=1;

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
        tWybierz.setBounds(760, 50, 400, 90); //dostosowac granice
        tWybierz.setFont(font.deriveFont(Font.BOLD, 50f));
        tWybierz.setForeground(Color.WHITE);
        add(tWybierz);

//        Font theFont = new Font("Arial", Font.BOLD, 25);
//        filmList.setSelectedIndex(0);
//        filmList.setFont(theFont);
//        filmList.addActionListener(this);
//        filmList.setBounds(760,490,400,90);
//        add(filmList);

        background = new JLabel(new ImageIcon("Coś tam\\Nowe Grafiki\\Film.png")); // inicjalizownie oraz ustawianie tła
        background.setBounds(0,0,1920,1080);
        add(background);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
//        JComboBox cb = (JComboBox)e.getSource();
//        String filmName = (String)cb.getSelectedItem();
//        selected = (int)cb.getSelectedIndex();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            Object p = e.getSource();
            if (p==bPowrot){
                Main.setJPanel(Window.OknoUzytkownika, uzytkownik);
            }
            for(int i=0;i<lista_plakatow.size();i++) {
                if (p == lista_plakatow.get(i).getiPlakat()) {
                    if(lista_plakatow.get(i).selected == false) {
                        System.out.println("KLIKAM W FILM CO JEST");
                        this.selected_poster = lista_plakatow.get(i);
                        this.selected_poster.selected = true;
                        this.selected_poster.iPlakat.setBorder(this.selected_poster.border);
                        this.is_selected = true;
                        bRezerwuj.setIcon(new ImageIcon("Coś tam\\Nowe Grafiki\\rezerwuj_zielony.png"));
                    }else{
                        this.selected_poster.selected = false;
                        this.selected_poster.iPlakat.setBorder(null);
                        this.selected_poster = null;
                        this.is_selected = false;
                        bRezerwuj.setIcon(new ImageIcon("Coś tam\\Nowe Grafiki\\rezerwuj.png"));
                    }

                }
            }
            if ( p == bRezerwuj ) {
                if(this.is_selected == true) {
                    this.is_selected = false;
                    this.selected_poster.selected=false;
                    this.selected_poster.iPlakat.setBorder(null);
                    bRezerwuj.setIcon(new ImageIcon("Coś tam\\Nowe Grafiki\\rezerwuj.png"));
                    Main.setJPanel(Window.OknoFilmu, uzytkownik, this.selected_poster.getchosenMovieTitle());

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
        try{
            Object p= e.getSource();
            for(PlakatFilmu poster: lista_plakatow){
                if(p==poster.getiPlakat()){
                    poster.iPlakat.setBorder(poster.border);

                }
            }
        }catch (RuntimeException err){
            System.out.println(err);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        try{
            Object p= e.getSource();
            for(PlakatFilmu poster: lista_plakatow){
                if(p==poster.getiPlakat()){
                    if(poster.selected == false) poster.iPlakat.setBorder(null);

                }
            }
        }catch (RuntimeException err){
            System.out.println(err);
        }
    }
}