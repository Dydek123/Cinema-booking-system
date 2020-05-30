package com.okno;

import com.bazydanych.BazaDanych;
import com.bazydanych.Uzytkownicy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends JFrame implements ActionListener, MouseListener {

    private JLabel bSingUp, lLogin, lPassword, lEmail, lName, lSurname, lAge, lPhone, background, lWrongData, test;
    private JTextField tLogin, tEmail, tName, tSurname, tAge, tPhone;
    private ImageIcon iZarejestrujZielone = new ImageIcon("Coś tam\\Nowe Grafiki\\zarejestruj_zielone.png");
    private ImageIcon iZarejestrujHover = new ImageIcon("Coś tam\\Nowe Grafiki\\zarejestruj_hover.png");
    private ImageIcon iZarejestrujClicked = new ImageIcon("Coś tam\\Nowe Grafiki\\zarejestruj_clicked.png");
    private JPasswordField fPassword;
    private Login login;
    private String regex = "^(.+)@(.+).(.+)$";
    private Pattern pattern;
    private BufferedImage bi;
    int x = 500, y= 200, width = (935-80)/2, height = 50; // x=80, 935, y = 260
    public Register(){
        setSize(1920,1080); // inicjalizownie okna
        setTitle("Register"); // nazwa okna
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ustawienie domyslnego zamkniecia okna
        setLayout(null);

        lLogin = new JLabel("Login: ",JLabel.LEFT); // inicjalizownie oraz ustawianie tekstu "login"
        lLogin.setFont(new Font("Impact", Font.ITALIC, 50));
        lLogin.setBounds(x,y,width,height);
        lLogin.setBackground(Color.white);
        lLogin.setForeground(Color.black);
        add(lLogin);

        tLogin = new JTextField(); // inicjalizownie oraz ustawianie pola do wpisania loginu
        tLogin.setBounds(x, y+height+20, width, height);
        tLogin.addActionListener(this);
        add(tLogin);

        lPassword = new JLabel("Hasło: "); // inicjalizownie oraz ustawianie tekstu "hasło"
        lPassword.setFont(new Font("Impact", Font.ITALIC, 50));
        lPassword.setBounds(x+width+50,y,width,height);
        lPassword.setBackground(Color.white);
        lPassword.setForeground(Color.black);
        add(lPassword);

        fPassword = new JPasswordField(); // inicjalizownie oraz ustawianie pola do wpisania hasla
        fPassword.setBounds(x+width+50,y+height+20,width,height);
        fPassword.addActionListener(this);
        add(fPassword);

        lEmail = new JLabel("E-mail: ",JLabel.LEFT); // inicjalizownie oraz ustawianie tekstu "email"
        lEmail.setFont(new Font("Impact", Font.ITALIC, 50));
        lEmail.setBounds(x, y+2*(height+20), width*2+2*20, height);
        lEmail.setForeground(Color.black);
        add(lEmail);

        pattern = Pattern.compile(regex);
        tEmail = new JTextField(); // inicjalizownie oraz ustawianie pola do wpisywania hasla
        tEmail.setBounds(x,y+3*(height+20),width*2+50,height);
        tEmail.addActionListener(this);
        add(tEmail);

        lName = new JLabel("Imie: ",JLabel.LEFT); // inicjalizownie oraz ustawianie tekstu "imie"
        lName.setFont(new Font("Impact", Font.ITALIC, 50));
        lName.setBounds(x,y+4*(height+20),width,height);
        lName.setForeground(Color.black);
        add(lName);

        tName = new JTextField(); // inicjalizownie oraz ustawianie pola do wpisywania imienia
        tName.setBounds(x,y+5*(height+20),width,height);
        tName.addActionListener(this);
        add(tName);

        lSurname = new JLabel("Nazwisko: "); // inicjalizownie oraz ustawianie tekstu "nazwisko"
        lSurname.setFont(new Font("Impact", Font.ITALIC, 50));
        lSurname.setBounds(x+width+50,y+4*(height+20),width,height);
        lSurname.setForeground(Color.black);
        add(lSurname);

        tSurname = new JTextField(); // inicjalizownie oraz ustawianie pola do wpisania nazwiska
        tSurname.setBounds(x+width+50,y+5*(height+20),width,height);
        tSurname.addActionListener(this);
        add(tSurname);

        lAge = new JLabel("Wiek",JLabel.LEFT); // inicjalizownie oraz ustawianie tekstu "wiek"
        lAge.setFont(new Font("Impact", Font.ITALIC, 50));
        lAge.setBounds(x,y+6*(height+20),width,height);
        lAge.setForeground(Color.black);
        add(lAge);

        tAge = new JTextField(); // inicjalizownie oraz ustawianie pola do wpisania wieku
        tAge.setBounds(x,y+7*(height+20),width,height);
        tAge.addActionListener(this);
        add(tAge);

        lPhone = new JLabel("Numer telefon: "); // inicjalizownie oraz ustawianie tekstu "telefon"
        lPhone.setFont(new Font("Impact", Font.ITALIC, 50));
        lPhone.setBounds(x+width+50,y+6*(height+20),width,height);
        lPhone.setForeground(Color.black);
        add(lPhone);

        tPhone = new JTextField(); // inicjalizownie oraz ustawianie pola wpisania nr telefonu
        tPhone.setBounds(x+width+50,y+7*(height+20),width,height);
        tPhone.addActionListener(this);
        add(tPhone);

        bSingUp=new JLabel();
        bSingUp.setIcon(iZarejestrujZielone);
        bSingUp.setBounds(x+245,y+8*(height+20)+20,428,140);
        bSingUp.setBorder(null);
        bSingUp.addMouseListener(this);
        add(bSingUp);

        test = new JLabel("Kliknięcie sie powiodło");
        test.setFont(new Font("Impact", Font.ITALIC, 50));
        test.setBounds(x+(width/2),y-height,500,height);
        test.setForeground(Color.RED);
        add(test);
        test.setVisible(false);

        lWrongData = new JLabel("Złe dane",JLabel.CENTER);
        lWrongData.setFont(new Font("Impact", Font.ITALIC, 50));
        lWrongData.setBounds(x+(width/2)+25,y-height,width,height);
        lWrongData.setVisible(false);
        add(lWrongData);

        background = new JLabel(new ImageIcon("Coś tam\\Nowe Grafiki\\Startowa v1.png")); // inicjalizownie oraz ustawianie tła
        background.setBounds(0,0,1920,1080);
        add(background);

    }
    public Register(Login login){
        this();
        this.login = login;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Object p = e.getSource();

        } catch (RuntimeException err) {

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            Object p = e.getSource();
            if ( p == bSingUp || p == tPhone) { // proba przypisania wpisanych tekstow w polu do zmiennych
                //moze klasa w przyszlosci?
                String l = tLogin.getText();
                String ps = fPassword.getText();
                String em = tEmail.getText();
                Matcher matcher = pattern.matcher(em);
                if(!matcher.matches()){
                    throw new RuntimeException("zly email");
                }
                String name = tName.getText();
                String surname = tSurname.getText();
                String _age = tAge.getText();
                int age = Integer.parseInt(_age);
                String _phone = tPhone.getText();
                int phone = Integer.parseInt(_phone);
                if(l == null || ps == null || name == null || surname == null || age == 0 || phone == 0 ){
                    throw new RuntimeException("Brak danych");
                }
                //send to check
                BazaDanych baza = new BazaDanych();
                List<Uzytkownicy> uzyt = baza.selectUzytkownicy();
                for(Uzytkownicy c: uzyt){
                    if(l.equals(c.getLogin()) || em.equals(c.getEmail())){
                        throw new RuntimeException("Brak danych");
                    }
                }
                if(!baza.insertUzytkownicy(l, ps, em, name, surname, age, phone)){
                    throw new RuntimeException("zle dane");
                }
                login.setVisible(true);
                dispose();
            }
        } catch (RuntimeException err) {
            System.out.println(err);
            lWrongData.setForeground(Color.red);
            lWrongData.setVisible(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Object p = e.getSource();
        if(p == bSingUp) {
            bSingUp.setIcon(iZarejestrujClicked);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Object p = e.getSource();
        if(p == bSingUp) {
            bSingUp.setIcon(iZarejestrujHover);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Object p = e.getSource();
        if(p == bSingUp) {
            bSingUp.setIcon(iZarejestrujHover);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object p = e.getSource();
        if(p == bSingUp) {
            bSingUp.setIcon(iZarejestrujZielone);
        }
    }
}
