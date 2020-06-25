package com.bazydanych;

import com.movies.FactoryFilmy;
import com.movies.Filmy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.bazydanych.Bilety;
import com.okno.Siedzenie;
import com.okno.State;

import javax.xml.transform.Result;

public class BazaDanych {
  public static final String DRIVER = "org.sqlite.JDBC";
  public static final String DB_URL = "jdbc:sqlite:JavaKino.db";

  private Connection conn;
  private Statement stat;

  public BazaDanych() {
    try {
      Class.forName(BazaDanych.DRIVER);
    } catch (ClassNotFoundException e) {
      System.err.println("Brak sterownika JDBC");
      e.printStackTrace();
    }

    try {
      conn = DriverManager.getConnection(DB_URL);
      stat = conn.createStatement();
    } catch (SQLException e) {
      System.err.println("Problem z otwarciem polaczenia");
      e.printStackTrace();
    }

    createTables();
  }
  public boolean createTables(){
    String createBilety = "CREATE TABLE IF NOT EXISTS Bilety (ID_bilety INTEGER, Cena_biletu VARCHAR(100), Rodzaj VARCHAR(100) );"; // to do
    String createFilmy = "CREATE TABLE IF NOT EXISTS Filmy (ID_filmy INTEGER AUTOINCREMENT PRIMARY KEY, Tytul VARCHAR (100)  UNIQUE ON CONFLICT ABORT, ID_rezyserzy INTEGER, ID_gatunki INTEGER, Ocena VARCHAR(100)," +
            "Czas_trwania VARCHAR(100), Rok_produkcji VARCHAR(100), Opis VARCHAR(1000), Zwiastun VARCHAR(100) );"; // to do
    String createGatunki = "CREATE TABLE IF NOT EXISTS Gatunki (ID_gatunki INTEGER AUTOINCREMENT PRIMARY KEY, Nazwa_gatunku VARCHAR(100) );"; // to do
    String createRezerwacje = "CREATE TABLE IF NOT EXISTS Rezerwacje (ID_uzytkownicy INTEGER, ID_seanse INTEGER, ID_rezerwacje INTEGER, Miejsce VARCHAR );"; // to do
    String createRezyserzy = "CREATE TABLE IF NOT EXISTS Rezyserzy (ID_rezyserzy INTEGER AUTOINCREMENT PRIMARY KEY, Imie_rezysera VARCHAR(100), Nazwisko_rezysera VARCHAR(100) );"; // to do
    String createSale = "CREATE TABLE IF NOT EXISTS Sale (ID_sale INTEGER AUTOINCREMENT PRIMARY KEY, Numer INTEGER, Liczba_miejsc INTEGER );"; // to do
    String createSeanse = "CREATE TABLE IF NOT EXISTS Seanse (ID_seanse INTEGER AUTOINCREMENT PRIMARY KEY, ID_sale INTEGER, ID_filmy INTEGER, Data_seansu VARCHAR(100), Godzina_seansu VARCHAR(100) );"; // to do
    String createUzytkownicy = "CREATE TABLE IF NOT EXISTS Uzytkownicy (ID_uzytkownicy INTEGER AUTOINCREMENT PRIMARY KEY, Login VARCHAR(100), Haslo VARCHAR(100), Email VARCHAR(100), " +
            "Imie_uzytkownika VARCHAR(100), Nazwisko_uzytkownika VARCHAR(100), Wiek INTEGER, Telefon INTEGER, Admin INTEGER (1) DEFAULT (0) );"; // to do
    String createZakupy = "CREATE TABLE IF NOT EXISTS Zakupy(ID_zakupy INTEGER, ID_bilety INTEGER, ID_rezerwacje INTEGER, Data_zakupu VARCHAR(100) );"; // to do
    try {
      stat.execute(createBilety);
      stat.execute(createFilmy);
      stat.execute(createGatunki);
      stat.execute(createRezerwacje);
      stat.execute(createRezyserzy);
      stat.execute(createSale);
      stat.execute(createSeanse);
      stat.execute(createUzytkownicy);
      stat.execute(createZakupy);
    } catch (SQLException e) {
      System.err.println("Blad przy tworzeniu tabeli");
      e.printStackTrace();
      return false;
    }
    return true;
  }
  public boolean insertBilety(float cenaBiletu, String rodzaj) {
    try {
      PreparedStatement prepStmt = conn.prepareStatement("insert into Bilety values (NULL, ?, ?);"); // to do // sprawdzic wszystkie inserty
      prepStmt.setFloat(1, cenaBiletu);
      prepStmt.setString(2, rodzaj);
      prepStmt.execute();
    } catch (SQLException e) {
      System.err.println("Blad przy wstawianiu biletu");
      e.printStackTrace();
      return false;
    }
    return true;
  }
  public boolean insertFilmy(String tytul, int idRezyserzy, int idGatunki, double ocena, String czasTrwania, /*year*/ int rokProdukcji, String opis, String zwiastun) {
    try {
      PreparedStatement prepStmt = conn.prepareStatement("insert into Filmy values (NULL, ?, ?, ?, ?, ?, ?, ?, ? );"); // to do // sprawdzic wszystkie inserty
      prepStmt.setString(1, tytul);
      prepStmt.setInt(2, idRezyserzy);
      prepStmt.setInt(3,idGatunki);
      prepStmt.setDouble(4, ocena);
      prepStmt.setString(5, czasTrwania);
      prepStmt.setInt(6, rokProdukcji/*year*/);
      prepStmt.setString(7, opis);
      prepStmt.setString(8, zwiastun);
      prepStmt.execute();
    } catch (SQLException e) {
      System.err.println("Blad przy wstawianiu filmu");
      e.printStackTrace();
      return false;
    }
    return true;
  }
  public boolean insertGatunki(String nazwaGatunku) {
    try {
      PreparedStatement prepStmt = conn.prepareStatement("insert into Gatunki values (NULL, ?);"); // to do // sprawdzic wszystkie inserty
      prepStmt.setString(1, nazwaGatunku);
      prepStmt.execute();
    } catch (SQLException e) {
      System.err.println("Blad przy wstawianiu gatunku");
      e.printStackTrace();
      return false;
    }
    return true;
  }
  public boolean insertRezerwacje(int idUzytkownicy,int idSeanse,int idRezerwacje, String miejsce) {
    try {
      PreparedStatement prepStmt = conn.prepareStatement("insert into Rezerwacje values (?, ?, ?, ?);"); // to do // sprawdzic wszystkie inserty
      prepStmt.setInt(1, idUzytkownicy);
      prepStmt.setInt(2, idSeanse);
      prepStmt.setInt(3, idRezerwacje);
      prepStmt.setString(4,miejsce);
      prepStmt.execute();
    } catch (SQLException e) {
      System.err.println("Blad przy wstawianiu rezerwacji");
      e.printStackTrace();
      return false;
    }
    return true;
  }
  public boolean insertRezyserzy(String imieRezysera, String nazwiskoRezysera) {
    try {
      PreparedStatement prepStmt = conn.prepareStatement("insert into Rezyserzy values (NULL, ?, ?);"); // to do // sprawdzic wszystkie inserty
      prepStmt.setString(1, imieRezysera);
      prepStmt.setString(2, nazwiskoRezysera);
      prepStmt.execute();
    } catch (SQLException e) {
      System.err.println("Blad przy wstawianiu rezysera");
      e.printStackTrace();
      return false;
    }
    return true;
  }
  public boolean insertSale(int numer, int liczbaMiejsc) {
    try {
      PreparedStatement prepStmt = conn.prepareStatement("insert into Sale values (NULL, ?, ?);"); // to do // sprawdzic wszystkie inserty
      prepStmt.setInt(1, numer);
      prepStmt.setInt(2, liczbaMiejsc);
      prepStmt.execute();
    } catch (SQLException e) {
      System.err.println("Blad przy wstawianiu sali");
      e.printStackTrace();
      return false;
    }
    return true;
  }
  public boolean insertSeanse(int idSale, int idFilmy, /*date*/String dataSeansu, float godzinaSeansu) {
    try {
      PreparedStatement prepStmt = conn.prepareStatement("insert into Seanse values (NULL, ?, ?, ?, ?);"); // to do // sprawdzic wszystkie inserty
      prepStmt.setInt(1, idSale);
      prepStmt.setInt(2, idFilmy);
      prepStmt.setString(3, dataSeansu);
      prepStmt.setFloat(4, godzinaSeansu);
      prepStmt.execute();
    } catch (SQLException e) {
      System.err.println("Blad przy wstawianiu seansu");
      e.printStackTrace();
      return false;
    }
    return true;
  }
  public boolean insertUzytkownicy(String login, String haslo, String email, String imieUzytkownika, String nazwiskoUzytkownika, int wiek, int telefon) {
    try {
      PreparedStatement prepStmt = conn.prepareStatement("insert into Uzytkownicy values (NULL, ?, ?, ?, ?, ?, ?, ?);"); // to do // sprawdzic wszystkie inserty
      prepStmt.setString(1, login);
      prepStmt.setString(2, haslo);
      prepStmt.setString(3, email);
      prepStmt.setInt(4, wiek);
      prepStmt.setInt(5, telefon);
      prepStmt.setString(4, imieUzytkownika);
      prepStmt.setString(5, nazwiskoUzytkownika);
      prepStmt.setInt(6, wiek);
      prepStmt.setInt(7, telefon);
      prepStmt.execute();
    } catch (SQLException e) {
      System.err.println("Blad przy wstawianiu uzytkownika");
      e.printStackTrace();
      return false;
    }
    return true;
  }
  public boolean insertZakupy(int idBilety,int idRezerwacje, /*date*/String dataZakupu) {
    try {
      PreparedStatement prepStmt = conn.prepareStatement("insert into Zakupy values (NULL, ?, ?, ?);"); // to do // sprawdzic wszystkie inserty
      prepStmt.setInt(1, idBilety);
      prepStmt.setInt(2, idRezerwacje);
      prepStmt.setString(3, dataZakupu);
      prepStmt.execute();
    } catch (SQLException e) {
      System.err.println("Blad przy wstawianiu zakupow");
      e.printStackTrace();
      return false;
    }
    return true;
  }

  public List<Bilety> selectBilety() {
    List<Bilety> biletyList = new LinkedList<Bilety>();
    try {
      ResultSet result = stat.executeQuery("SELECT * FROM Bilety"); // to do
      int idBilety;
      float cenaBiletu;
      String rodzaj;
      while(result.next()) {
        idBilety = result.getInt("ID_bilety");
        cenaBiletu = result.getFloat("Cena_biletu");
        rodzaj = result.getString("Rodzaj");      // to do
        biletyList.add(new Bilety(idBilety, cenaBiletu, rodzaj));
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
    return biletyList;
  }

  public List<Filmy> selectFilmy() {
    List<Filmy> filmyList = new LinkedList<Filmy>();
    try {
      ResultSet result = stat.executeQuery("SELECT * FROM Filmy"); // to do
      int idFlimy, idRezyserzy, idGatunki;
      String tytul, opis, zwiastun;
      float ocena;
      String czasTrwania;
      /*year*/ int rokProdukcji;
      FactoryFilmy filmyFactory = new FactoryFilmy();

      while(result.next()) {
        idFlimy = result.getInt("ID_filmy");
        tytul = result.getString("Tytul");      // to do
        idRezyserzy = result.getInt("ID_rezyserzy");
        idGatunki = result.getInt("ID_gatunki");
        ocena = result.getFloat("Ocena");
        czasTrwania = result.getString("Czas_trwania"); // string?
        rokProdukcji = result.getInt("Rok_produkcji");
        opis = result.getString("Opis");
        zwiastun = result.getString("Zwiastun");

        filmyList.add(filmyFactory.makeFilm(idFlimy, tytul, idRezyserzy, ocena, czasTrwania, rokProdukcji, opis, zwiastun,idGatunki));
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
    return filmyList;
  }
  public List<Gatunki> selectGatunki() {
    List<Gatunki> gatunkiList = new LinkedList<Gatunki>();
    try {
      ResultSet result = stat.executeQuery("SELECT * FROM Gatunki"); // to do
      int idGatunki;
      String nazwaGatunku;
      while(result.next()) {
        idGatunki = result.getInt("ID_gatunki");
        nazwaGatunku = result.getString("Nazwa_gatunku");      // to do
        gatunkiList.add(new Gatunki(idGatunki, nazwaGatunku));
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
    return gatunkiList;
  }
  public List<Rezerwacje> selectRezerwacje() {
    List<Rezerwacje> rezerwacjeList = new LinkedList<Rezerwacje>();
    try {
      ResultSet result = stat.executeQuery("SELECT * FROM Rezerwacje");
      int idRezerwacje, idUzytkownicy, idSeanse,miejsce_nr;
      char rzad;
      String miejsce_bd;
      while(result.next()) {
        idRezerwacje = result.getInt("ID_rezerwacje");
        idUzytkownicy = result.getInt("ID_uzytkownicy");
        idSeanse = result.getInt("ID_seanse");
        //rzad = result.getString("Rzad");
        miejsce_bd = result.getString("Miejsce");
        rzad=miejsce_bd.charAt(0);
        miejsce_nr=Integer.parseInt(String.valueOf(miejsce_bd.charAt(1)));

        rezerwacjeList.add(new Rezerwacje.RezerwacjeBuilder()
                .idrezerwacja(idRezerwacje)
                .iduzytkownik(idUzytkownicy)
                .idseans(idSeanse)
                .rzad(rzad)
                .miejsce(miejsce_nr)
                .build());
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
    return rezerwacjeList;
  }
  public List<Rezyserzy> selectRezyserzy() {
    List<Rezyserzy> rezyserzyList = new LinkedList<Rezyserzy>();
    try {
      ResultSet result = stat.executeQuery("SELECT * FROM Rezyserzy");
      int idRezyserzy;
      String imieRezysera, nazwiskoRezysera;
      while(result.next()) {
        idRezyserzy = result.getInt("ID_rezyserzy");
        imieRezysera = result.getString("Imie_rezysera");
        nazwiskoRezysera = result.getString("Nazwisko_rezysera");
        rezyserzyList.add(new Rezyserzy(idRezyserzy, imieRezysera, nazwiskoRezysera));
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
    return rezyserzyList;
  }
  public List<Sale> selectSale() {
    List<Sale> saleList = new LinkedList<Sale>();
    try {
      ResultSet result = stat.executeQuery("SELECT * FROM Sale");
      int idSale, numer, liczbaMiejsc;
      while(result.next()) {
        idSale = result.getInt("ID_sale");
        numer = result.getInt("Numer");
        liczbaMiejsc = result.getInt("Liczba_miejsc");
        saleList.add(new Sale(idSale, numer, liczbaMiejsc));
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
    return saleList;
  }
  public List<Seanse> selectSeanse() {
    List<Seanse> seanseList = new LinkedList<Seanse>();
    try {
      ResultSet result = stat.executeQuery("SELECT * FROM Seanse");
      int idSeanse, idSale, idFilmy;
      /*date*/String dataSeansu, godzinaSeansu;
      while(result.next()) {
        idSeanse = result.getInt("ID_seanse");
        idSale = result.getInt("ID_sale");
        idFilmy = result.getInt("ID_filmy");
        dataSeansu = result.getString("Data_seansu");
        godzinaSeansu = result.getString("Godzina_seansu");
        seanseList.add(new Seanse(idSeanse, idSale, idFilmy, dataSeansu, godzinaSeansu));
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
    return seanseList;
  }

  public List<Uzytkownicy> selectUzytkownicy() {
    List<Uzytkownicy> uzytkownicyList = new LinkedList<Uzytkownicy>();
    try {
      ResultSet result = stat.executeQuery("SELECT * FROM Uzytkownicy");
      int idUzytkownika, wiek;
      String login, haslo, email, imieUzytkownika, nazwiskoUzytkownika;
      int telefon,admin; // varchar?
      boolean zgodaMarketingowa; //bit?
      while(result.next()) {
        idUzytkownika = result.getInt("ID_uzytkownicy");
        login = result.getString("Login");
        haslo = result.getString("Haslo");
        email = result.getString("Email");
        imieUzytkownika = result.getString("Imie_uzytkownika");
        nazwiskoUzytkownika = result.getString("Nazwisko_uzytkownika");
        wiek = result.getInt("Wiek");
        telefon = result.getInt("Telefon"); //varchar?
        admin = result.getInt("Admin");
        uzytkownicyList.add(new Uzytkownicy.UzytkownicyBuilder()
            .idUzytkownik(idUzytkownika)
                .ustaw_login(login)
                .ustaw_haslo(haslo)
                .ustaw_email(email).imie(imieUzytkownika)
                .nazwisko(nazwiskoUzytkownika)
                .user_wiek(wiek)
                .user_telefon(telefon)
                .user_admin(admin)
                .build());
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
    return uzytkownicyList;
  }
  public List<Zakupy> selectZakupy() {
    List<Zakupy> zakupyList = new LinkedList<Zakupy>();
    try {
      ResultSet result = stat.executeQuery("SELECT * FROM Zakupy");
      int idZakupy, idBilety, idRezerwacje;
      /*date*/String dataZakupu;
      while(result.next()) {
        idZakupy = result.getInt("ID_zakupy");
        idBilety = result.getInt("ID_bilety");
        idRezerwacje = result.getInt("ID_rezerwacje");
        dataZakupu = result.getString("Data_zakupu");
        zakupyList.add(new Zakupy(idZakupy, idBilety, idRezerwacje, dataZakupu));
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
    return zakupyList;
  }

  public int ile_wolnych(int idFilmu){        //funkcja zwracająca ilosc wolnych miejsc na dany seans
    int wolne = 0;
    try {
      PreparedStatement zajete = conn.prepareStatement("SELECT COUNT(Miejsce) FROM Rezerwacje where ID_seanse=?");
      zajete.setInt(1,idFilmu);
      ResultSet temp=zajete.executeQuery();
      if(temp.next()){
        wolne=30-temp.getInt(1);
      }
    }catch(SQLException e){
      e.printStackTrace();
      return 0;
    }
    return wolne;
  }

  public void ktore_zajete(int id_film, Siedzenie[][] l)  //Funkcja zmieniająca kolory zajętych miejsc, sprawdzane przed
  {                                                       //wyborem miejsc w sali na dany film
    int rzad, miejsce;
    String pomocnicza;
    try {
      PreparedStatement zajete = conn.prepareStatement("SELECT * FROM Rezerwacje where ID_seanse=?");
      zajete.setInt(1, id_film);
      ResultSet temp = zajete.executeQuery();
      while (temp.next()) {
        pomocnicza = temp.getString("Miejsce");
        char pomocnicza2 = pomocnicza.charAt(0);
        miejsce = Integer.parseInt(String.valueOf(pomocnicza.charAt(1)));
        switch (pomocnicza2) {
          case 'A':
            rzad = 0;
            l[rzad][miejsce].state = State.ZAJETE;
          case 'B':
            rzad = 1;
            l[rzad][miejsce].state = State.ZAJETE;
          case 'C':
            rzad = 2;
            l[rzad][miejsce].state = State.ZAJETE;
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }



  public void closeConnection(){
    try {
      conn.close();
         } catch (SQLException e) {
      System.err.println("Problem z zamknieciem polaczenia");
      e.printStackTrace();
                          }
          }
}
