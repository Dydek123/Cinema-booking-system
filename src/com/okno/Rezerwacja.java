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
import java.util.LinkedList;
import java.util.List;


public class Rezerwacja extends JFrame implements ActionListener, MouseListener {
    BazaDanych baza=new BazaDanych();
    public JFrame bSignUp;
    //Pomocnicza funkcja, bo nie wiem gdzie to ma być
    int ile=0;
    Rezerwacja(int IDuser, int IDfilm, int ile)
    {
        String miejsce="temp";
        int wolne=baza.ile_wolnych(IDfilm);
        if(wolne>0&&wolne>=ile)
        {
            for(int i=1;i<=ile;i++)
            {
                baza.insertRezerwacje(IDuser,IDfilm,(31-wolne),miejsce);
            }
        }
        else{
            System.err.println("Zbyt malo wolnych miejsc!");
            }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e){
        Object p = e.getSource();
        if(p == bSignUp)
        {

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
