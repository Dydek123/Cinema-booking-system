package com.okno;

import javax.swing.*;

import static com.okno.State.*;


public class Siedzenie{
    private int coordX;
    private int coordY;
    private int size=149;
    private JLabel bSiedzenie;
    private String miejsce; //"litera+liczba", litera - rzad, liczba miejsce w rzędzie
    private State state;

    public Siedzenie(int coordX, int coordY, String miejsce, int state) {
        /*
        coordX: 0-9
        coordY: 0-2
        miejsce: przy tworzeniu siedzen wymaga stworzenia stringa "litera+liczba"
        state: wolne/zajete/wybrane
        wymaga użycia siedzenia[x][y].getbSiedzenie().addMouseListener(this) po uzyciu konstruktora by siedzenie było clickable
        wymaga użycia add(siedzenie[x][y].getbSiedzenie()) po uzyciu konstruktora by siedzenie wyswietlilo się w oknie
         */
        ImageIcon iWolne = new ImageIcon("Coś tam\\Nowe Grafiki\\wolne.png");
        this.coordX = coordX;
        this.coordY = coordY;
        bSiedzenie = new JLabel(iWolne);  //wersja robocza
        int paddingY = 400; //odsunięcie siatki krzeseł od górnej krawędzi
        int paddingX = 180; // odsunięcie siatki krzeseł od lewej krawędzi
        int gapY= 70; // odstęp bo tło zawiera cyferki między rzedami siedzen
        bSiedzenie.setBounds(paddingX + coordX *this.size, paddingY + coordY *(this.size + gapY), this.size, this.size);
        bSiedzenie.setBorder(null);
        this.miejsce = miejsce;
        this.state = WOLNE;
    }

    public void setState(State state) {
        try {
            this.state = state;
            //Zmiana ikony wraz ze zmianą stanu kliknięcia
            if (state == WOLNE) {
                ImageIcon iWolne = new ImageIcon("Coś tam\\Nowe Grafiki\\wolne.png");
                bSiedzenie.setIcon(iWolne);
            } else if (state == ZAJETE) {
                ImageIcon iZajete = new ImageIcon("Coś tam\\Nowe Grafiki\\zajete.png");
                bSiedzenie.setIcon(iZajete);
            } else if (state == WYBRANE) {
                ImageIcon iWybrane = new ImageIcon("Coś tam\\Nowe Grafiki\\wybrane.png");
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
