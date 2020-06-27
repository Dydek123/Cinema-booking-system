package com.okno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Okno extends JFrame implements KeyListener {
    private PanelWyjscia panelWyjscia;
    public Okno(){
        setSize(1920,1080);
        setTitle("Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);

        setLayout(null);

        setVisible(true);

        addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("dupa");
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            if(panelWyjscia == null)
                panelWyjscia = new PanelWyjscia(this);
            panelWyjscia.setVisible(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    class PanelWyjscia extends JDialog implements ActionListener
    {
        private JLabel lZapytanie;
        private JButton bTak, bNie;
        public PanelWyjscia(JFrame owner)
        {
            super(owner, "Wyjscie", true);
            setSize(600,400);
            setLayout(null);
            setLocationRelativeTo(null);

            lZapytanie = new JLabel("Czy wyjść?", JLabel.CENTER);
            lZapytanie.setBounds(100,20,400,30);
            lZapytanie.setFont(new Font("Impact", Font.PLAIN, 30));
            add(lZapytanie);

            bTak = new JButton("Tak");
            bTak.setBounds(150,200,100,50);
            bTak.addActionListener(this);
            add(bTak);

            bNie = new JButton("Nie");
            bNie.setBounds(350,200,100,50);
            bNie.addActionListener(this);
            add(bNie);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Object p = e.getSource();

            if(p == bNie){
                dispose();
            }else if(p == bTak){
                getOwner().dispose();
            }
        }
    }

}
