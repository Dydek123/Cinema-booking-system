package com.okno;

import com.bazydanych.BazaDanych;
import com.bazydanych.Uzytkownicy;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TwojeRezerwacje extends JPanel implements MouseListener {
    private JLabel tRezerwacjaTeraz, tNazwaUzytkownika, tEmailUzytkownika, tTelefonUzytkownika;
    private JLabel bDostepneFilmy, bPowrot, bWyloguj;
    private JLabel background;
    private JTable tabelaRezerwacje;
    private Font font = new Font("Impact", Font.PLAIN, 40);
    private BazaDanych baza = new BazaDanych();
    private String[][] data;
    private JScrollPane scroll;
    private Uzytkownicy uzytkownik;
    public TwojeRezerwacje(Uzytkownicy uzyt)
    {
//        setBounds(500,160,1420,540);
        setBounds(0,0,1920,1080);
        setLayout(null);

        uzytkownik = uzyt;

        data = baza.selectRezerwacjeUzytkownika(uzyt.getIdUzytkownika());

        if(data[0][0] != null) {
            tabelaRezerwacje = new JTable(data, new Object[]{"Film", "Data", "Godzina", "Miejsce"});
            tabelaRezerwacje.setFont(font);
            tabelaRezerwacje.setEnabled(false);
            tabelaRezerwacje.setRowHeight(50);
            scroll = new JScrollPane(tabelaRezerwacje);
            scroll.setBounds(550, 200, 1350, 500);
            add(scroll);
        }else{
            tRezerwacjaTeraz = new JLabel("Brak zarezerwowanych biletow. Zarezerwuj juz teraz!", (int) JFrame.CENTER_ALIGNMENT);
            tRezerwacjaTeraz.setBounds(550,200,1350,500);
            tRezerwacjaTeraz.setFont(font);
            add(tRezerwacjaTeraz);
        }

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

        ImageIcon wyloguj = new ImageIcon("Coś tam\\Nowe Grafiki\\wyloguj.png");
        bWyloguj = new JLabel(wyloguj);  //wersja robocza
        bWyloguj.setBounds(1500, 48, 280, 70);
        bWyloguj.setBorder(null);
        bWyloguj.addMouseListener(this);
        add(bWyloguj);

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

        background = new JLabel(new ImageIcon("Coś tam\\Nowe Grafiki\\Profil_uzytkownika.png"));
        background.setBounds(0,0,1920,1080);
        add(background);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object p = e.getSource();

        if ( p == bDostepneFilmy ) {
            try {
                Main.setJPanel(Window.DostepneFilmy, uzytkownik);
            } catch (RuntimeException err) {
                System.out.println(err);
            }
        }
        else if (p==bPowrot){
            Main.setJPanel(Window.OknoUzytkownika, uzytkownik);
        }else if( p == bWyloguj){
            Main.setJPanel(Window.Login);
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
