package com.okno;
import com.bazydanych.*;
import com.bazydanych.BazaDanych;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;
import com.okno.Siedzenie;


public class Rezerwacja extends JFrame implements ActionListener, MouseListener {

    BazaDanych baza = new BazaDanych();
    public JLabel background;
    double cena = 0.0;
    Siedzenie [][] lista_siedzen = new Siedzenie[3][10];
    List<Siedzenie> zajete_siedzenia = new LinkedList<>();
    int IDuser;
    int IDfilm;
    int ile=0;
    public Siedzenie seat;


    public Rezerwacja() {
        setSize(1920, 1080); // inicjalizownie okna
        setTitle("Okno rezerwacji"); // nazwa okna
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ustawienie domyslnego zamkniecia okna
        setLayout(null);
        background = new JLabel(new ImageIcon("Coś tam\\Nowe Grafiki\\Miejsce.png")); // inicjalizownie oraz ustawianie tła
        background.setBounds(0,0,1920,1080);
        add(background);

    }

    //Funkcja rezerwująca miejsca
    public void rezerwowanie_miejsc(int IDuser,int IDfilm, int ile){
        String miejsce;
        int wolne = baza.ile_wolnych(IDfilm);
        if (wolne > 0 && wolne >= ile) {
            for (int i = 1; i <= ile; i++) {
                miejsce = zajete_siedzenia.get(i-1).getMiejsce();
                baza.insertRezerwacje(IDuser, IDfilm, (31 - wolne), miejsce);
            }
        } else {
            System.err.println("Zbyt malo wolnych miejsc!");
        }

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

    public void setIDuser(int IDuser) {
        this.IDuser = IDuser;
    }
<<<<<<< HEAD

    public void setIDfilm(int IDfilm) {
        this.IDfilm = IDfilm;
    }

    public void setIle(int ile) {
        this.ile = ile;
    }

    public int getIDuser() {
        return IDuser;
=======
    public Rezerwacja() {
        setSize(1920, 1080); // inicjalizownie okna
        setTitle("Okno rezerwacji"); // nazwa okna
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ustawienie domyslnego zamkniecia okna
        setLayout(null);
        background = new JLabel(new ImageIcon("Coś tam\\Nowe Grafiki\\Filmy.png")); // inicjalizownie oraz ustawianie tła
        background.setBounds(0,0,1920,1080);
        add(background);

>>>>>>> parent of e96c7da... Revert "Revert "Klasa i enum do obslugi siedzen, update grafik""
    }

    public int getIDfilm() {
        return IDfilm;
    }

    public int getIle() {
        return ile;
    }

    public double getCena() {
        return cena;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object p = e.getSource();
        if (p == seat) {
            if(seat.state==State.WOLNE){
                seat.state=State.WYBRANE;
                this.ile+=1;
                this.cena+=15.00;
                zajete_siedzenia.add(seat);
            }else if(seat.state==State.WYBRANE){
                seat.state=State.WOLNE;
                this.ile-=1;
                this.cena-=15.00;
                zajete_siedzenia.remove(seat);
            }

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