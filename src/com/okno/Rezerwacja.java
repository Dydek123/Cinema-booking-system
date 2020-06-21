package com.okno;
import com.bazydanych.*;
import com.bazydanych.BazaDanych;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.okno.Siedzenie;


public class Rezerwacja extends JFrame implements ActionListener, MouseListener {
    BazaDanych baza = new BazaDanych();
    public JFrame bSignUp;
    public JLabel background;

    Siedzenie [][] lista_siedzen = new Siedzenie[3][10];





    int ile = 0;
    //Klasa pomocnicza
    public Rezerwacja(int IDuser,int IDfilm, int ile) { //w tym konstruktorze wstawiamy wybrane siedzenia do bazy danych
        String miejsce = "temp";
        int wolne = baza.ile_wolnych(IDfilm);
        if (wolne > 0 && wolne >= ile) {
            for (int i = 1; i <= ile; i++) {
                baza.insertRezerwacje(IDuser, IDfilm, (31 - wolne), miejsce);
            }
        } else {
            System.err.println("Zbyt malo wolnych miejsc!");
        }
    }
    public Rezerwacja() {
        setSize(1920, 1080); // inicjalizownie okna
        setTitle("Okno rezerwacji"); // nazwa okna
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ustawienie domyslnego zamkniecia okna
        setLayout(null);
        background = new JLabel(new ImageIcon("Coś tam\\Nowe Grafiki\\Miejsce.png")); // inicjalizownie oraz ustawianie tła
        background.setBounds(0,0,1920,1080);
        add(background);



    }

//Tworzy liste do przechowywania obiektów Siedzenie, żeby nie ustawiać ręcznie tylu obiektow
    public void create_list_of_seats(Siedzenie [][] l)
    {
        for(int i=0;i<3;i++){
            for(int j=0;j<10;j++){
                String x=Integer.toString(j);

                switch(i){
                    case 0:
                        x="A"+x;
                        l[i][j]= new Siedzenie(10+i*10,10+j*10, x,State.WOLNE);
                    case 1:
                        x="B"+x;
                        l[i][j]= new Siedzenie(10+i*10,10+j*10, x,State.WOLNE);
                    case 2:
                        x="C"+x;
                        l[i][j]= new Siedzenie(10+i*10,10+j*10, x,State.WOLNE);

                }

            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object p = e.getSource();
        if (p == bSignUp) {
            this.ile+=1;

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