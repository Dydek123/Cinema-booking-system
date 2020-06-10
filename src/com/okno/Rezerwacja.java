package com.okno;
import com.bazydanych.*;
import com.bazydanych.BazaDanych;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


public class Rezerwacja {
    BazaDanych baza=new BazaDanych();
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

}
