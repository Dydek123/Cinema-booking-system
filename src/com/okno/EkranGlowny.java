package com.okno;

import com.bazydanych.*;
import com.movies.Filmy;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class EkranGlowny extends JFrame implements ActionListener{
    JLabel background;
    JSlider test;
    ImageIcon iStronaGlowna = new ImageIcon("Images\\Strona Logowania.png");
    BazaDanych baza = new BazaDanych();
    List<Filmy> filmy = baza.selectFilmy();
    public EkranGlowny(Uzytkownicy uzyt){
        setSize(1920,1080);
        setTitle("EkranGlowny");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        //setUndecorated(true);
        //setVisible(true);
        //setLayout(null);

        test = new JSlider(0,10,1);  // suwak
        test.setBounds(700,360,300,50);
        test.setValue(0);
        for(Filmy f: filmy){
            if(f.getTytul().equals("Jojo Rabit")){
                test.setValue((int)f.getOcena());
            }
        }
        test.setMajorTickSpacing(2);
        test.setMinorTickSpacing(1);
        test.setPaintTicks(true);
        test.setPaintLabels(true);
        test.setEnabled(false);
        add(test);

        background = new JLabel(iStronaGlowna);
        background.setBounds(0,0,1920,1080);
        add(background);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
