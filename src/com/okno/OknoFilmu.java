package com.okno;

import com.bazydanych.BazaDanych;
import com.bazydanych.Rezyserzy;
import com.movies.Filmy;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class OknoFilmu  extends JFrame implements ActionListener, MouseListener {
    BazaDanych baza = new BazaDanych();
    private JLabel background;
    private JLabel bZarezerwuj, bPowrot;
    private String chosenMovieTitle;
    private int selected;
    private int selectedSeansId;
    /*
     chcialem to tak zrobic zeby tabela wyglądała tak:
    dostepneSeanse:
    [[data1,data2,data3]
    [indSeansu1,indSeansu2,indSeansu3]]
    To by pozwolilo na łatwe przekazywanie ID seansu do nastepnęgo okna
    po prostu wartosc selected z zaznaczonej opcji w comboboxie byłaby indexem [1][selected]
    i to byłby index seansu na ktory chcemy rezerwowac
    */
    String[][] dostepneSeanse;

    public OknoFilmu(String chosenMovieTitle) throws IOException {
        this.chosenMovieTitle = chosenMovieTitle;
        setSize(1920, 1080); // inicjalizownie okna
        setTitle("Opis filmu: "+ this.chosenMovieTitle); // nazwa okna
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ustawienie domyslnego zamkniecia okna
        setLayout(null);

        Filmy chosenMovie = baza.selectFilm(this.chosenMovieTitle);


        ImageIcon zarezerwuj = new ImageIcon("Coś tam\\Nowe Grafiki\\rezerwuj.png");
        bZarezerwuj = new JLabel(zarezerwuj);
        bZarezerwuj.setBounds(1570, 740, 260, 110);
        bZarezerwuj.setBorder(null);
        bZarezerwuj.addMouseListener(this);
        add(bZarezerwuj);

        ImageIcon powrot = new ImageIcon("Coś tam\\Nowe Grafiki\\powrot.png");
        bPowrot = new JLabel(powrot);
        bPowrot.setBounds(1570, 870, 260, 110);
        bPowrot.setBorder(null);
        bPowrot.addMouseListener(this);
        add(bPowrot);

        JLabel tTytul = new JLabel(chosenMovie.getTytul(), SwingConstants.CENTER); // jak zrobic napis aby byl idalnie na srodku nie zaleznie od dlugosci nazwy uzytkownika?
        tTytul.setVerticalAlignment(JLabel.TOP);
        tTytul.setBounds(745, 90, 1080, 90); //dostosowac granice
        tTytul.setFont(new Font("Elephant", Font.PLAIN, 70));
        tTytul.setForeground(Color.RED);
        add(tTytul);

        JLabel tOpis = new JLabel("<html>"+ chosenMovie.getOpis() +"</html>"); // jak zrobic napis aby byl idalnie na srodku nie zaleznie od dlugosci nazwy uzytkownika?
        tOpis.setVerticalAlignment(JLabel.TOP);
        tOpis.setBounds(745, 189, 1080, 550); //dostosowac granice
        tOpis.setFont(new Font("Arial", Font.PLAIN, 35));
        tOpis.setForeground(Color.white);
        add(tOpis);

        JLabel iPlakat = new JLabel();
        iPlakat.setBounds(100, 90, 605, 900);
        iPlakat.setBorder(null);
        //Ustawienie plakatu dopasowanego do labela
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("Coś tam\\Nowe Grafiki\\"+chosenMovie.getTytul()+".png"));
        } catch (IOException e) {
            e.printStackTrace();
            img = ImageIO.read(new File("Coś tam\\Nowe Grafiki\\default.png"));
        }
        Image dimg = img.getScaledInstance(iPlakat.getWidth(), iPlakat.getHeight(),
                Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        iPlakat.setIcon(imageIcon);
        add(iPlakat);

        //Rezyser
        Rezyserzy rezyser=baza.selectRezyser(chosenMovie.getIdRezyserzy());

        JLabel tRezyser = new JLabel("Rezyser: "+rezyser.getImieRezysera()+" "+rezyser.getNazwiskoRezysera()); // jak zrobic napis aby byl idalnie na srodku nie zaleznie od dlugosci nazwy uzytkownika?
        tRezyser.setVerticalAlignment(JLabel.TOP);
        tRezyser.setBounds(745, 740, 500, 50);
        tRezyser.setFont(new Font("Arial", Font.BOLD, 30));
        tRezyser.setForeground(Color.WHITE);
        add(tRezyser);

        //Czas trwania

        JLabel tCzas = new JLabel("Czas trwania: "+chosenMovie.getCzasTrwania()); // jak zrobic napis aby byl idalnie na srodku nie zaleznie od dlugosci nazwy uzytkownika?
        tCzas.setVerticalAlignment(JLabel.TOP);
        tCzas.setBounds(745, 800, 500, 50);
        tCzas.setFont(new Font("Arial", Font.BOLD, 30));
        tCzas.setForeground(Color.WHITE);
        add(tCzas);

        //Ocena
        //String ocena=String.valueOf(chosenMovie.getOcena());
        String ocena=String.format("%.1f",chosenMovie.getOcena());
        JLabel tOcena = new JLabel("Ocena: "+ ocena); // jak zrobic napis aby byl idalnie na srodku nie zaleznie od dlugosci nazwy uzytkownika?
        tOcena.setVerticalAlignment(JLabel.TOP);
        tOcena.setBounds(745, 860, 500, 50);
        tOcena.setFont(new Font("Arial", Font.BOLD, 30));
        tOcena.setForeground(Color.WHITE);
        add(tOcena);

        //Rok Produkcji

        JLabel tRok = new JLabel("Wyprodukowano: "+ chosenMovie.getRokProdukcji()); // jak zrobic napis aby byl idalnie na srodku nie zaleznie od dlugosci nazwy uzytkownika?
        tRok.setVerticalAlignment(JLabel.TOP);
        tRok.setBounds(745, 920, 500, 50);
        tRok.setFont(new Font("Arial", Font.BOLD, 30));
        tRok.setForeground(Color.WHITE);
        add(tRok);

        //Lista seansów
        //napis
        JLabel tWybierz = new JLabel("Wybierz seans: "); // jak zrobic napis aby byl idalnie na srodku nie zaleznie od dlugosci nazwy uzytkownika?
        tWybierz.setVerticalAlignment(JLabel.TOP);
        tWybierz.setBounds(745, 680, 500, 50);
        tWybierz.setFont(new Font("Arial", Font.BOLD, 30));
        tWybierz.setForeground(Color.WHITE);
        add(tWybierz);

        //Ten select powinien zwracać seanse Filmu o danym ID ktore jeszcze sie nie odbyły - Data_seansu>date()
        //ale chyba nie zwraca, nie wiem czemu, coś nie wychodzi mi napisanie tego selecta
        dostepneSeanse=baza.selectDostepneSeanse(chosenMovie.getIdFilmy());
        JComboBox seanseList = new JComboBox(dostepneSeanse[0]);

        Font theFont = new Font("Arial", Font.BOLD, 25);
        seanseList.setSelectedIndex(0);
        //Ustawienie domyslnie pierwszego dostepnego seansu jesli uzytkownik nie wybierze zadnego z combo box'a
        selectedSeansId=Integer.parseInt(dostepneSeanse[1][0]);
        seanseList.setFont(theFont);
        seanseList.addActionListener(this);
        seanseList.setBounds(1250,680,270,50);
        add(seanseList);

        background = new JLabel(new ImageIcon("Coś tam\\Nowe Grafiki\\Film.png")); // inicjalizownie oraz ustawianie tła
        background.setBounds(0,0,1920,1080);
        add(background);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        String filmName = (String)cb.getSelectedItem();
        selected = (int)cb.getSelectedIndex();
        //no i tu sie dzieje magia: selected to index opcji wybranej z comboBoxa
        //i zeby uzyskac index seansu na ktory chcemy rezerwowac uzywamy tej magicznej listy String[][] ktora zrobilem
        //w dostepneSeanse[1] są indexy dostępnych seansów
        //dostepneSeanse[1][selected] to wybrany index jednego z dostępnego seansow
        selectedSeansId=Integer.parseInt(dostepneSeanse[1][selected]);
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
