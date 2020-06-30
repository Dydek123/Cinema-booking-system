package main.java.com.okno;

import main.java.com.bazydanych.BazaDanych;
import main.java.com.bazydanych.Uzytkownicy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Login extends JPanel implements MouseListener, OknoJPanel{
    private JTextField tLogin;
    private JPasswordField fPassword;
    private JLabel lLogin, lPassword, lWrongPass, background,bSingUp, bLogUp, bExit;
    BazaDanych baza = new BazaDanych();
    private ImageIcon iZalogujZielone = new ImageIcon("kino\\Coś tam\\Nowe Grafiki\\zaloguj_zielone.png");
    private ImageIcon iZalogujHover = new ImageIcon("kino\\Coś tam\\Nowe Grafiki\\zaloguj_hover.png");
    private ImageIcon iZalogujClicked = new ImageIcon("kino\\Coś tam\\Nowe Grafiki\\zaloguj_clicked.png");
    private ImageIcon iZarejestrujZielone = new ImageIcon("kino\\Coś tam\\Nowe Grafiki\\zarejestruj_zielone.png");
    private ImageIcon iZarejestrujHover = new ImageIcon("kino\\Coś tam\\Nowe Grafiki\\zarejestruj_hover.png");
    private ImageIcon iZarejestrujClicked = new ImageIcon("kino\\Coś tam\\Nowe Grafiki\\zarejestruj_clicked.png");
    private ImageIcon iZamknij = new ImageIcon("kino\\Coś tam\\Nowe Grafiki\\Zamknij_x.png");
    private ImageIcon iZamknijHover = new ImageIcon("kino\\Coś tam\\Nowe Grafiki\\Zamknij_x_hover.png");
    private ImageIcon iZamknijClicked = new ImageIcon("kino\\Coś tam\\Nowe Grafiki\\Zamknij_x_clicked.png");

    int x = (935-80)/3, y= 300, width = (935-80)/2, height = 50; // x=80, 935, y = 260
    public Login(){
        setBounds(0,0,1920,1080);
        setLayout(null);

        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("kino\\Coś tam\\Fonts\\Caudex-Regular.ttf"));

            lLogin = new JLabel("Login: ", JLabel.LEFT);
            lLogin.setBounds(x, y, width, height);
            lLogin.setFont(font.deriveFont(Font.BOLD, 30));
            add(lLogin);

            lPassword = new JLabel("Hasło: ", JLabel.RIGHT);
            lPassword.setBounds(x, y + (2 * height), width, height);
            lPassword.setFont(font.deriveFont(Font.BOLD, 30));
            add(lPassword);

            lWrongPass = new JLabel();
            lWrongPass.setBounds(x,y + (4*height),width,height);
            lWrongPass.setFont(font.deriveFont(Font.BOLD, 30));
            add(lWrongPass);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }

        tLogin = new JTextField();
            tLogin.setBounds(x, y + height, width, height);
            tLogin.setFont(new Font("Impact", Font.PLAIN, 30));
            add(tLogin);


        fPassword = new JPasswordField();
        fPassword.setBounds(x,y + (3*height),width,height);
        fPassword.setFont(new Font("Impact", Font.PLAIN, 30));
        add(fPassword);


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

        bExit = new JLabel(iZamknij);
        bExit.setBounds(1750,20,150,150);
        bExit.setBorder(null);
        bExit.addMouseListener(this);
        add(bExit);

        ImageIcon iStronaLogowania = new ImageIcon("kino\\Coś tam\\Nowe Grafiki\\Strona Logowania2.png");
        background = new JLabel(iStronaLogowania);
        background.setBounds(0,0,1920,1080);
        add(background);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object p = e.getSource();
        if(p == bSingUp){
            exit();
            Main.setJPanel(Window.Register);
        }else if(p == bLogUp){
                String l = tLogin.getText();
                String pass = fPassword.getText();
                List<Uzytkownicy> uzyt = baza.selectUzytkownicy();
                for(Uzytkownicy c: uzyt) {
                    System.out.println("login podany "+ l + " login z bazy " + c.getLogin() + ".");
                    if(l.equals(c.getLogin()) && pass.equals(c.getHaslo())){
                        lWrongPass.setVisible(false);
                        exit();
                        Main.setJPanel(Window.OknoUzytkownika, c);
//                        removeAll();
                    }
                }
                lWrongPass.setText("Zle dane logowania");
                lWrongPass.setForeground(Color.red);
                lWrongPass.setVisible(true);
        }else if(p == bExit){
            exit();
            System.exit(0);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Object p = e.getSource();
        if(p == bSingUp) {
            bSingUp.setIcon(iZarejestrujClicked);
        }else if(p == bLogUp){
            bLogUp.setIcon(iZalogujClicked);
        }else if(p == bExit){
            bExit.setIcon(iZamknijClicked);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Object p = e.getSource();
        if(p == bSingUp) {
            bSingUp.setIcon(iZarejestrujZielone);
        }else if(p == bLogUp){
            bLogUp.setIcon(iZalogujZielone);
        }else if(p == bExit){
            bExit.setIcon(iZamknij);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Object p = e.getSource();
        if(p == bSingUp) {
            bSingUp.setIcon(iZarejestrujHover);
        }else if(p == bLogUp){
            bLogUp.setIcon(iZalogujHover);
        }else if(p == bExit){
            bExit.setIcon(iZamknijHover);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object p = e.getSource();
        if(p == bSingUp) {
            bSingUp.setIcon(iZarejestrujZielone);
        }else if(p == bLogUp){
            bLogUp.setIcon(iZalogujZielone);
        }else if(p == bExit){
            bExit.setIcon(iZamknij);
        }
    }

    @Override
    public void exit() {
        baza.closeConnection();
        removeAll();
    }
}
