package com.okno;
import com.bazydanych.BazaDanych;
import com.movies.Filmy;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PlakatFilmu {
    String chosenMovieTitle;
    int cordX=200;
    int cordY=400;
    BazaDanych baza = new BazaDanych();
    JLabel iPlakat = new JLabel();

    PlakatFilmu(String chosenMovieTitle) throws IOException {


        this.iPlakat.setBounds(this.cordX, this.cordY, 170, 250);
        this.iPlakat.setBorder(null);
        //Ustawienie plakatu dopasowanego do labela
        BufferedImage img = null;
        this.chosenMovieTitle=chosenMovieTitle;
        Filmy chosenMovie = baza.selectFilm(this.chosenMovieTitle);
        try {
            img = ImageIO.read(new File("Coś tam\\Nowe Grafiki\\"+chosenMovie.getTytul()+".png"));
        } catch (IOException e) {
            e.printStackTrace();
            img = ImageIO.read(new File("Coś tam\\Nowe Grafiki\\default.png"));
        }
        Image dimg = img.getScaledInstance(iPlakat.getWidth(), iPlakat.getHeight(),
                Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        this.iPlakat.setIcon(imageIcon);


    }


    public void setName(String chosenMovieTitle) {
        this.chosenMovieTitle = chosenMovieTitle;
    }

    public void setCordX(int cordX) {
        this.cordX = cordX;
        this.iPlakat.setBounds(this.cordX, this.cordY, 170, 250);
    }

    public void setCordY(int cordY) {
        this.cordY = cordY;
        this.iPlakat.setBounds(this.cordX, this.cordY, 170, 250);
    }

    public JLabel getiPlakat() {
        return iPlakat;
    }
    public String getchosenMovieTitle() {
        return chosenMovieTitle;
    }

    public int getCordX() {
        return cordX;
    }

    public int getCordY() {
        return cordY;
    }
}
