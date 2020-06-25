package com.okno;
import com.bazydanych.*;
import com.bazydanych.BazaDanych;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


public class Rezerwacja extends JFrame implements ActionListener, MouseListener {
    private BazaDanych baza = new BazaDanych();
    private int selectedSeansId;
    private Uzytkownicy uzytkownicy;
    private String chosenMovieTitle;
    private OknoFilmu oknoFilmu;
    private double cena = 0.0;
    private int IDuser;
    private int IDfilm;
    private int ile=0;
    private JLabel tIleBiletow;
    private JLabel bPowrot,bRezerwuj;


    private Siedzenie [][] listaSiedzen = new Siedzenie[3][10];
    //private JLabel [][] listaSiedzenB = new JLabel[3][10];
    private List<Siedzenie> zajete_siedzenia = new LinkedList<>();

    public JFrame bSignUp;
    public JLabel background;
    //Zainicjowanie listy siedzen stałą ilościa miejsc kazdej sali


    public Rezerwacja(Uzytkownicy uzytkownicy, int selectedSeansId, OknoFilmu oknoFilmu) throws IOException, FontFormatException {
        setSize(1920, 1080); // inicjalizownie okna
        setTitle("Okno rezerwacji"); // nazwa okna
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ustawienie domyslnego zamkniecia okna
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
        setLayout(null);
        this.selectedSeansId=selectedSeansId;
        this.uzytkownicy=uzytkownicy;
        this.oknoFilmu=oknoFilmu;

        createListOfSeats(listaSiedzen);
        baza.ktore_zajete(selectedSeansId, listaSiedzen);
        Font font = Font.createFont(Font.TRUETYPE_FONT, new File("Coś tam\\Fonts\\Caudex-Regular.ttf"));

        tIleBiletow = new JLabel("0");
        tIleBiletow.setBounds(1030, 165, 45, 40);
        tIleBiletow.setFont(new Font("Impact", Font.PLAIN, 40));
        add(tIleBiletow);

        JLabel tTxt = new JLabel("Dostępne filmy:"); // jak zrobic napis aby byl idalnie na srodku nie zaleznie od dlugosci nazwy uzytkownika?
        tTxt.setVerticalAlignment(JLabel.TOP);
        tTxt.setBounds(40, 25, 600, 90); //dostosowac granice
        tTxt.setFont(font.deriveFont(Font.BOLD, 70f));
        tTxt.setForeground(new Color(23, 101, 202));
        add(tTxt);

        bPowrot = new JLabel(new ImageIcon("Coś tam\\Nowe Grafiki\\powrot.png"));
        bPowrot.setBounds(1300, 25, 260, 110);
        bPowrot.addMouseListener(this);
        add(bPowrot);

        bRezerwuj = new JLabel(new ImageIcon("Coś tam\\Nowe Grafiki\\rezerwuj.png"));
        bRezerwuj.setBounds(1580, 25, 260, 110);
        bRezerwuj.addMouseListener(this);
        add(bRezerwuj);


        background = new JLabel(new ImageIcon("Coś tam\\Nowe Grafiki\\Miejsce.png")); // inicjalizownie oraz ustawianie tła
        background.setBounds(0,0,1920,1080);
        add(background);
    }

    //Funkcja rezerwująca miejsca
    public void rezerwowanieMiejsc(int IDuser,int IDSeansu, int ile){
        String miejsce;
        int wolne = baza.ile_wolnych(IDSeansu);
        if (wolne > 0 && wolne >= ile) {
            for (int i = 1; i <= ile; i++) {
                miejsce = zajete_siedzenia.get(i-1).getMiejsce();
                System.out.println(miejsce);
                baza.insertRezerwacje(IDuser, IDSeansu, (31 - wolne), miejsce);
            }
        } else {
            System.err.println("Zbyt malo wolnych miejsc!");
        }
    }

    //Tworzy liste do przechowywania obiektów Siedzenie, żeby nie ustawiać ręcznie tylu obiektow
    public void createListOfSeats(Siedzenie [][] l)
    {
        for(int i=0;i<3;i++){
            for(int j=0;j<10;j++){
                String x=Integer.toString(j);

                switch(i){
                    case 0:
                        x="A"+x;
                        l[i][j]= new Siedzenie(i,j, x,State.WOLNE);
                        break;
                    case 1:
                        x="B"+x;
                        l[i][j]= new Siedzenie(i,j, x,State.WOLNE);
                        break;
                    case 2:
                        x="C"+x;
                        l[i][j]= new Siedzenie(i,j, x,State.WOLNE);
                        break;

                }
                l[i][j].getbSiedzenie().addMouseListener(this);
                add(l[i][j].getbSiedzenie());
            }
        }
    }




    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object p = e.getSource();
        try {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 10; j++) {
                    if (p == listaSiedzen[i][j].getbSiedzenie()) {
                        if (listaSiedzen[i][j].getState() == State.WOLNE) {
                            listaSiedzen[i][j].setState(State.WYBRANE);
                            this.ile += 1;
                            this.cena += 15.00;
                            System.out.println("miejsce: " + listaSiedzen[i][j].getMiejsce());
                            zajete_siedzenia.add(listaSiedzen[i][j]);
                            tIleBiletow.setText("" + ile);
                            //System.out.println("Kliknieto siedzenie: " + i + " " + j);
                        } else if (listaSiedzen[i][j].getState() == State.WYBRANE) {
                            listaSiedzen[i][j].setState(State.WOLNE);
                            this.ile -= 1;
                            this.cena -= 15.00;
                            zajete_siedzenia.remove(listaSiedzen[i][j]);
                            tIleBiletow.setText("" + ile);
                            //System.out.println("Odkliknieto siedzenie: " + i + " " + j);
                        }
                    }

                }
            }
            if (p == bRezerwuj) {
                rezerwowanieMiejsc(uzytkownicy.getIdUzytkownika(), selectedSeansId, ile);
                OknoUzytkownika userWindow = new OknoUzytkownika(uzytkownicy);
                userWindow.setVisible(true);
                dispose();
            }
            if (p == bPowrot) {
                //OknoFilmu oknoFilmu = new OknoFilmu(chosenMovieTitle, uzytkownicy);
                oknoFilmu.setVisible(true);
                dispose();
            }
        } catch (RuntimeException err) {
            System.out.println(err);
        } /*catch (IOException ex) {
            ex.printStackTrace();
        }*/

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