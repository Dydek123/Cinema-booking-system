package com.okno;

import com.bazydanych.Uzytkownicy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.List;

public class Rezerwacja extends JFrame implements ActionListener, MouseListener {
    private JLabel background;

    public Rezerwacja(Uzytkownicy uzyt) {
        setSize(1920, 1080); // inicjalizownie okna
        setTitle("Okno rezerwacji"); // nazwa okna
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ustawienie domyslnego zamkniecia okna
        setLayout(null);

        background = new JLabel(new ImageIcon("Coś tam\\Nowe Grafiki\\Profil_uzytkownika.png")); // inicjalizownie oraz ustawianie tła
        background.setBounds(0,0,1920,1080);
        add(background);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

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
