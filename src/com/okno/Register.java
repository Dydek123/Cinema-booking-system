package com.okno;

import com.bazydanych.BazaDanych;
import com.bazydanych.Uzytkownicy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends JFrame implements ActionListener {
    private JButton bSingUp;
    private JLabel lLogin, lPassword, lEmail, lName, lSurname, lAge, lPhone, background, lWrongData;
    private JTextField tLogin, tEmail, tName, tSurname, tAge, tPhone;
    private JPasswordField fPassword;
    private Login login;
    private String regex = "^(.+)@(.+).(.+)$";
    private Pattern pattern;
    public Register(){
        setSize(1920,1080); // inicjalizownie okna
        setTitle("Register"); // nazwa okna
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ustawienie domyslnego zamkniecia okna
        setLayout(null);

        lLogin = new JLabel("Login: "); // inicjalizownie oraz ustawianie tekstu "login"
        lLogin.setBounds(50,10,150,20);
        lLogin.setBackground(Color.white);
        lLogin.setForeground(Color.black);
        add(lLogin);

        tLogin = new JTextField(); // inicjalizownie oraz ustawianie pola do wpisania loginu
        tLogin.setBounds(50, 30, 150, 20);
        tLogin.addActionListener(this);
        add(tLogin);

        lPassword = new JLabel("Hasło: "); // inicjalizownie oraz ustawianie tekstu "hasło"
        lPassword.setFont(new Font("Impact", Font.ITALIC, 50));
        lPassword.setBounds(50,50,150,20);
        lPassword.setBackground(Color.white);
        lPassword.setForeground(Color.black);
        add(lPassword);

        fPassword = new JPasswordField(); // inicjalizownie oraz ustawianie pola do wpisania hasla
        fPassword.setBounds(50,70,150,20);
        fPassword.addActionListener(this);
        add(fPassword);

        lEmail = new JLabel("E-mail: "); // inicjalizownie oraz ustawianie tekstu "email"
        lEmail.setBounds(50, 90, 150, 20);
        add(lEmail);

        pattern = Pattern.compile(regex);
        tEmail = new JTextField(); // inicjalizownie oraz ustawianie pola do wpisywania hasla
        tEmail.setBounds(50,110,150,20);
        tEmail.addActionListener(this);
        add(tEmail);

        lName = new JLabel("Imie: "); // inicjalizownie oraz ustawianie tekstu "imie"
        lName.setBounds(50,130,150,20);
        add(lName);

        tName = new JTextField(); // inicjalizownie oraz ustawianie pola do wpisywania imienia
        tName.setBounds(50,150,150,20);
        tName.addActionListener(this);
        add(tName);

        lSurname = new JLabel("Nazwisko: "); // inicjalizownie oraz ustawianie tekstu "nazwisko"
        lSurname.setBounds(50,170,150,20);
        add(lSurname);

        tSurname = new JTextField(); // inicjalizownie oraz ustawianie pola do wpisania nazwiska
        tSurname.setBounds(50,190,150,20);
        tSurname.addActionListener(this);
        add(tSurname);

        lAge = new JLabel("Wiek"); // inicjalizownie oraz ustawianie tekstu "wiek"
        lAge.setBounds(50,210,150,20);
        add(lAge);

        tAge = new JTextField(); // inicjalizownie oraz ustawianie pola do wpisania wieku
        tAge.setBounds(50,230,150,20);
        tAge.addActionListener(this);
        add(tAge);

        lPhone = new JLabel("Numer telefon: "); // inicjalizownie oraz ustawianie tekstu "telefon"
        lPhone.setBounds(50,250,150,20);
        add(lPhone);

        tPhone = new JTextField(); // inicjalizownie oraz ustawianie pola wpisania nr telefonu
        tPhone.setBounds(50,270,150,20);
        tPhone.addActionListener(this);
        add(tPhone);

        bSingUp = new JButton("Zarejestruj się");
        bSingUp.setBounds(150,300,100,20);
        bSingUp.addActionListener(this);
        add(bSingUp);

        lWrongData = new JLabel("Złe dane");
        lWrongData.setBounds(50,300,100,20);
        lWrongData.setVisible(false);
        add(lWrongData);

        background = new JLabel(new ImageIcon("Images\\Startowa v1.png")); // inicjalizownie oraz ustawianie tła
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
            if (p == bSingUp || p == tPhone) { // proba przypisania wpisanych tekstow w polu do zmiennych
                //moze klasa w przyszlosci?
                String l = tLogin.getText();
                String ps = fPassword.getText();
                String em = tEmail.getText();
                Matcher matcher = pattern.matcher(em);
                if(matcher.matches() == false){
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
                baza.insertUzytkownicy(l,ps,em, name, surname, age, phone);
                login.setVisible(true);
                dispose();
            }
        } catch (RuntimeException err) {
            System.out.println(err);
            lWrongData.setForeground(Color.red);
            lWrongData.setVisible(true);
        }
    }
}
