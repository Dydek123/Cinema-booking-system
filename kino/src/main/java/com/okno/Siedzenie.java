package main.java.com.okno;

import javax.swing.*;

import static main.java.com.okno.State.*;


public class Siedzenie{
    private int coordX;
    private int coordY;
    private int size=149;
    private JLabel bSiedzenie;
    private String miejsce; //"litera+liczba", litera - rzad, liczba miejsce w rzędzie
    private State state;

    public Siedzenie(int i, int j, String miejsce, State state) {
        /*
        coordX: 0-9
        coordY: 0-2
        miejsce: przy tworzeniu siedzen wymaga stworzenia stringa "litera+liczba"
        state: wolne/zajete/wybrane
        wymaga użycia siedzenia[x][y].getbSiedzenie().addMouseListener(this) po uzyciu konstruktora by siedzenie było clickable
        wymaga użycia add(siedzenie[x][y].getbSiedzenie()) po uzyciu konstruktora by siedzenie wyswietlilo się w oknie
         */
        ImageIcon iWolne = new ImageIcon("kino\\src\\main\\resources\\Images\\wolne.png");
        this.coordX = j;
        this.coordY = i;
        bSiedzenie = new JLabel(iWolne);  //wersja robocza
        int paddingY = 400; //odsunięcie siatki krzeseł od górnej krawędzi
        int paddingX = 180; // odsunięcie siatki krzeseł od lewej krawędzi
        int gapY= 50; // odstęp bo tło zawiera cyferki między rzedami siedzen
        int gapX= 5; // odstęp miedzy siedzonkami
        //System.out.println("X: " + coordX + ", Y: " + coordY);
        bSiedzenie.setBounds((paddingX + coordX *(size+gapX)), (paddingY + coordY *(size + gapY)), size, size);
        bSiedzenie.setBorder(null);
        this.miejsce = miejsce;
        this.state = WOLNE;
    }

    public void setState(State state) {
        try {
            this.state = state;
            //Zmiana ikony wraz ze zmianą stanu kliknięcia
            if (state == WOLNE) {
                ImageIcon iWolne = new ImageIcon("kino\\src\\main\\resources\\Images\\wolne.png");
                bSiedzenie.setIcon(iWolne);
            } else if (state == ZAJETE) {
                ImageIcon iZajete = new ImageIcon("kino\\src\\main\\resources\\Images\\zajete.png");
                bSiedzenie.setIcon(iZajete);
            } else if (state == WYBRANE) {
                ImageIcon iWybrane = new ImageIcon("kino\\src\\main\\resources\\Images\\wybrane.png");
                bSiedzenie.setIcon(iWybrane);
            }
        } catch (RuntimeException err) {
            System.out.println("Zły state, zła ikona siedzenia");
        }
    }

    public int getCoordX() {
        return coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public String getMiejsce() {
        return miejsce;
    }

    public State getState() {
        return state;
    }

    public JLabel getbSiedzenie() {
        return bSiedzenie;
    }
}
