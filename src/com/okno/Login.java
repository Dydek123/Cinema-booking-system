package com.okno;

import com.bazydanych.BazaDanych;
import com.bazydanych.Uzytkownicy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class Login extends JFrame implements ActionListener, MouseListener {
    private JTextField tLogin;
    private JPasswordField fPassword;
    private JLabel lLogin, lPassword, lWrongPass, background,bSingUp, bLogUp;
    private Register register;
    private OknoUzytkownika userWindow;
    private ImageIcon iZalogujZielone = new ImageIcon("Coś tam\\Nowe Grafiki\\zaloguj_zielone.png");
    private ImageIcon iZalogujHover = new ImageIcon("Coś tam\\Nowe Grafiki\\zaloguj_hover.png");
    private ImageIcon iZalogujClicked = new ImageIcon("Coś tam\\Nowe Grafiki\\zaloguj_clicked.png");
    private ImageIcon iZarejestrujZielone = new ImageIcon("Coś tam\\Nowe Grafiki\\zarejestruj_zielone.png");
    private ImageIcon iZarejestrujHover = new ImageIcon("Coś tam\\Nowe Grafiki\\zarejestruj_hover.png");
    private ImageIcon iZarejestrujClicked = new ImageIcon("Coś tam\\Nowe Grafiki\\zarejestruj_clicked.png");
    private ImageIcon iStronaLogowania = new ImageIcon("Images\\Strona Logowania2.png");
    int x = (935-80)/3, y= 300, width = (935-80)/2, height = 50; // x=80, 935, y = 260
    public Login(){
        register = new Register(this);
        //register.setVisible(true);
        register.setVisible(false);



        setSize(1920,1080);
        setTitle("test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        lLogin = new JLabel("Login: ", JLabel.LEFT);
        lLogin.setBounds(x,y,width,height);
        lLogin.setFont(new Font("Impact", Font.PLAIN, 30));
        add(lLogin);

        tLogin = new JTextField();
        tLogin.setBounds(x,y + height,width,height);
        tLogin.addActionListener(this);
        tLogin.setFont(new Font("Impact", Font.PLAIN, 30));
        add(tLogin);

        lPassword = new JLabel("Hasło: ", JLabel.RIGHT);
        lPassword.setBounds(x,y + (2*height),width,height);
        lPassword.setFont(new Font("Impact", Font.PLAIN, 30));
        add(lPassword);

        fPassword = new JPasswordField();
        fPassword.setBounds(x,y + (3*height),width,height);
        fPassword.setFont(new Font("Impact", Font.PLAIN, 30));
        fPassword.addActionListener(this);
        add(fPassword);

        lWrongPass = new JLabel();
        lWrongPass.setBounds(x,y + (4*height),width,height);
        lWrongPass.setFont(new Font("Impact", Font.PLAIN, 30));
        add(lWrongPass);

        bLogUp = new JLabel(iZalogujZielone);
        bLogUp.setBounds(85,y + (5*height),428,140);
        bLogUp.setBorder(null);
        bLogUp.addMouseListener(this);


        add(bLogUp);

        bSingUp = new JLabel(iZarejestrujZielone);
        bSingUp.setBounds(85+(938-80)/2,y + (5*height),428,140);
        bSingUp.setBorder(null);
        bSingUp.addMouseListener(this);
        add(bSingUp);

        background = new JLabel(iStronaLogowania);
        background.setBounds(0,0,1920,1080);
        add(background);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object p = e.getSource();
       /* if(p == bLogUp || p == fPassword){
            String l = tLogin.getText();
            String pass = fPassword.getText();
            BazaDanych baza = new BazaDanych();
            List<Uzytkownicy> uzyt = baza.selectUzytkownicy();
            for(Uzytkownicy c: uzyt) {
                System.out.println("login podany "+ l + " login z bazy " + c.getLogin() + ".");
               if(l.equals(c.getLogin()) && pass.equals(c.getHaslo())){
                   lWrongPass.setVisible(false);
                   EkranGlowny ekranGlowny = new EkranGlowny(c);
                   ekranGlowny.setVisible(true);

                   dispose();
                   break;
               }
            }
            lWrongPass.setText("Zle dane logowania");
            lWrongPass.setForeground(Color.red);
            lWrongPass.setVisible(true);
        }*/
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object p = e.getSource();
        if(p == bSingUp){
            register.setVisible(true);
            setVisible(false);
        }else if(p == bLogUp){
                String l = tLogin.getText();
                String pass = fPassword.getText();
                BazaDanych baza = new BazaDanych();
                List<Uzytkownicy> uzyt = baza.selectUzytkownicy();
                for(Uzytkownicy c: uzyt) {
                    System.out.println("login podany "+ l + " login z bazy " + c.getLogin() + ".");
                    if(l.equals(c.getLogin()) && pass.equals(c.getHaslo())){
                        lWrongPass.setVisible(false);
                        setVisible(false);
                        userWindow = new OknoUzytkownika(c);
                        userWindow.setVisible(true);
                        dispose();
                        break;
                    }
                }
                lWrongPass.setText("Zle dane logowania");
                lWrongPass.setForeground(Color.red);
                lWrongPass.setVisible(true);


        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Object p = e.getSource();
        if(p == bSingUp) {
            bSingUp.setIcon(iZarejestrujClicked);
        }else{
            bLogUp.setIcon(iZalogujClicked);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Object p = e.getSource();
        if(p == bSingUp) {
            bSingUp.setIcon(iZarejestrujZielone);
        }else{
            bLogUp.setIcon(iZalogujHover);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Object p = e.getSource();
        if(p == bSingUp) {
            bSingUp.setIcon(iZarejestrujHover);
        }else{
            bLogUp.setIcon(iZalogujHover);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object p = e.getSource();
        if(p == bSingUp) {
            bSingUp.setIcon(iZarejestrujZielone);
        }else{
             bLogUp.setIcon(iZalogujZielone);
        }
    }
}
