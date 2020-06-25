package com.okno;

import com.bazydanych.BazaDanych;
import com.movies.Filmy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

public class DostepneFilmy extends JFrame implements ActionListener, MouseListener {
    BazaDanych baza = new BazaDanych();
    public JFrame bSignUp;
    public JLabel background, bOk;
    public String[] dostepneFilmy=baza.selectDostepneFilmy();
    JComboBox filmList = new JComboBox(dostepneFilmy);
    private int selected;
    public DostepneFilmy() {
        setSize(1920, 1080); // inicjalizownie okna
        setTitle("Dostepne filmy"); // nazwa okna
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ustawienie domyslnego zamkniecia okna
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
        setLayout(null);



        ImageIcon zatwierdz = new ImageIcon("Coś tam\\Nowe Grafiki\\zatwierdz.png");
        bOk = new JLabel(zatwierdz);
        bOk.setBounds(1160, 490, 400, 100);
        bOk.setBorder(null);
        bOk.addMouseListener(this);
        add(bOk);

        Font theFont = new Font("Arial", Font.BOLD, 25);
        filmList.setSelectedIndex(0);
        filmList.setFont(theFont);
        filmList.addActionListener(this);
        filmList.setBounds(760,490,400,90);
        add(filmList);

        background = new JLabel(new ImageIcon("Coś tam\\Nowe Grafiki\\Filmy.png")); // inicjalizownie oraz ustawianie tła
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
            if ( p == bOk ) {
                /*Rezerwacja rezerwacja = new Rezerwacja(dostepneFilmy[selected]);
                rezerwacja.setVisible(true);
                dispose();*/
                OknoFilmu oknoFilmu = new OknoFilmu(dostepneFilmy[selected]);
                oknoFilmu.setVisible(true);
                dispose();

            }
        } catch (RuntimeException | IOException err) {
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