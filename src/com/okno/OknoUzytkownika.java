/*

Szybkie podsumowanie o co tu chodzi:
nie zczaiłem ze EkranGłowny to wlasnie ekran uzytkownika wiec zrobilem go na nowo
zakomentowane fragmenty kodu na dole to po prostu przyciski i input boxy ktore mozna potem odkomentować i zmienic odpowiednio pod ich przeznaczenie
Grafika ma w sobie juz te przyciski, nalezy wiec stworzyc jakieś tam obiekty o podobnych wymiarach co te przyciski na backgroundzie i odpowiednio je ulokowac
można tworzyc je przezroczyste albo normalne, graficzne i przykryć tą grafike w tle rzeczywistymi przyciskami
opcja nr 2 - usuniecie przyciskow z tej grafiki w tle i zrobienie swoich i ulokowanie gdziekolwiek

WAŻNE!!!! : dodajac przyciski musi gdzies byc miejsce na przycisk: "Dodaj film", "Dodaj seans"  if (uzytkownik.getAdmin()==true)

 */


package com.okno;

import com.bazydanych.*;
import com.movies.Filmy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.List;

public class OknoUzytkownika extends JFrame implements ActionListener, MouseListener {

    //private JLabel bSingUp, lLogin;
    private JLabel background;
    //private JTextField tLogin, tEmail, tName, tSurname, tAge, tPhone;
    //private ImageIcon iZarejestrujZielone = new ImageIcon("Coś tam\\Nowe Grafiki\\zarejestruj_zielone.png");

    //private JPasswordField fPassword;
    private Login login;
    //private String regex = "^(.+)@(.+).(.+)$";
    //private Pattern pattern;
    BazaDanych baza = new BazaDanych();
    List<Filmy> filmy = baza.selectFilmy();
    private BufferedImage bi;

    //int x = 500, y= 200, width = (935-80)/2, height = 50; // x=80, 935, y = 260
    public OknoUzytkownika(Uzytkownicy uzyt){
        setSize(1920,1080); // inicjalizownie okna
        setTitle("Okno uzytkownika"); // nazwa okna
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ustawienie domyslnego zamkniecia okna
        setLayout(null);

        /*lLogin = new JLabel("Login: ",JLabel.LEFT); // inicjalizownie oraz ustawianie tekstu "login"
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
        add(lWrongData);*/

        background = new JLabel(new ImageIcon("Coś tam\\Nowe Grafiki\\Profil_uzytkownika.png")); // inicjalizownie oraz ustawianie tła
        background.setBounds(0,0,1920,1080);
        add(background);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
