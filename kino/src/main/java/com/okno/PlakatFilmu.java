package main.java.com.okno;

import main.java.com.bazydanych.BazaDanych;
import main.java.com.movies.Filmy;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PlakatFilmu {
    String chosenMovieTitle;
    int cordX=170;
    int cordY=200;
    BazaDanych baza = new BazaDanych();
    JLabel iPlakat;
    public boolean selected = false;

    PlakatFilmu(String chosenMovieTitle) throws IOException {

        iPlakat = new JLabel();
        this.iPlakat.setBounds(this.cordX, this.cordY, 272, 400);
        this.iPlakat.setBorder(null);
        //Ustawienie plakatu dopasowanego do labela
        BufferedImage img = null;
        this.chosenMovieTitle=chosenMovieTitle;
        Filmy chosenMovie = baza.selectFilm(this.chosenMovieTitle);
        try {
            img = ImageIO.read(new File("kino\\src\\main\\resources\\Images\\"+chosenMovie.getTytul()+".png"));
        } catch (IOException e) {
            e.printStackTrace();
            img = ImageIO.read(new File("kino\\src\\main\\resources\\Images\\default.png"));
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
        this.iPlakat.setBounds(this.cordX, this.cordY, 272, 400);
    }

    public void setCordY(int cordY) {
        this.cordY = cordY;
        this.iPlakat.setBounds(this.cordX, this.cordY, 272, 400);
    }

    public JLabel getiPlakat() {
        return this.iPlakat;
    }

    public String getchosenMovieTitle() {
        return this.chosenMovieTitle;
    }

    public int getCordX() {
        return cordX;
    }

    public int getCordY() {
        return cordY;
    }
}
