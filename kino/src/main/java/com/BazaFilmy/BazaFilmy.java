package main.java.com.BazaFilmy;

import main.java.com.bazydanych.BazaDanych;
import main.java.com.movies.Filmy;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class BazaFilmy {

    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:FilmyBaza.db";

    private Connection conn;
    private Statement stat;

    public BazaFilmy() {
        try {
            Class.forName(BazaFilmy.DRIVER);
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

    public void createTables(){
        BazaDanych test = new BazaDanych();
        List<Filmy> filmy = test.selectFilmy();

        for(Filmy c: filmy){
            try {
                PreparedStatement prepStmt = conn.prepareStatement("CREATE TABLE IF NOT EXISTS `" + c.getTytul() +"` (ID_uzytkownika INTEGER UNIQUE ON CONFLICT ABORT, Ocena INTIGER );");
                prepStmt.execute();
            } catch (SQLException e) {
                System.err.println("Blad przy tworzeniu tabeli");
                e.printStackTrace();
            }
        }
    }

    public boolean insertOcenaFilmu(String nazwaFilmu, int idUzytkownika, int ocenaFilmu) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement("insert into `" + nazwaFilmu + "` values (?, ?);");
            prepStmt.setInt(1, idUzytkownika);
            prepStmt.setInt(2, ocenaFilmu);
            prepStmt.execute();
            
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu oceny uzytkownika");
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<FilmyOceny> selectFilmyOceny(String nazwaFilmu) {
        List<FilmyOceny> ocenyList = new LinkedList<FilmyOceny>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM `"+ nazwaFilmu + "`"); // to do
            int idUzytkownika;
            int ocena;
            while(result.next()) {
                idUzytkownika = result.getInt("ID_uzytkownika");
                ocena = result.getInt("Ocena");
                ocenyList.add(new FilmyOceny(idUzytkownika, ocena));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return ocenyList;
    }

    public double getAverageMovieRating(String nazwaFilmu){
        double averageMovieRating = 0.0;
        int countMovie = 0;

        List<FilmyOceny> ocenyList = this.selectFilmyOceny(nazwaFilmu);

        for(FilmyOceny c: ocenyList){
            averageMovieRating += c.getOcenaFilmu();
            countMovie++;
        }

        if(countMovie == 0){
            return 0.0;
        }

        return averageMovieRating/countMovie;
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Problem z zamknieciem polaczenia");
            e.printStackTrace();
        }
    }
}