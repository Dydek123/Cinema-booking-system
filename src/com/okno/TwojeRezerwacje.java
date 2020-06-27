package com.okno;

import com.bazydanych.BazaDanych;
import com.bazydanych.Uzytkownicy;

import javax.swing.*;
import java.awt.*;


public class TwojeRezerwacje extends JComponent {

    public TwojeRezerwacje(Uzytkownicy uzyt)
    {
        setLayout(null);

        BazaDanych baza = new BazaDanych();
        String[][] data = baza.selectRezerwacjeUzytkownika(uzyt.getIdUzytkownika());

        Font font = new Font("Impact", Font.PLAIN, 40);
        if(data[0][0] != null) {

            JTable tabelaRezerwacje = new JTable(data, new Object[]{"Film", "Data", "Godzina", "Miejsce"});
            tabelaRezerwacje.setFont(font);
            tabelaRezerwacje.setEnabled(false);
            tabelaRezerwacje.setRowHeight(50);

            JScrollPane scroll = new JScrollPane(tabelaRezerwacje);
            scroll.setBounds(50, 40, 1350, 500);
            add(scroll);
        }else{
            JLabel tRezerwacjaTeraz = new JLabel("Brak zarezerwowanych biletow. Zarezerwuj juz teraz!", SwingConstants.CENTER);
            tRezerwacjaTeraz.setBounds(50,40,1350,500);
            tRezerwacjaTeraz.setFont(font);
            add(tRezerwacjaTeraz);
        }

    }

}
