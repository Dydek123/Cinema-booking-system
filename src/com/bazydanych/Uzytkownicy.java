package com.bazydanych;

import com.movies.FactoryFilmy;
import com.movies.Filmy;

import java.sql.SQLException;
import java.util.List;

public class Uzytkownicy {
    private int idUzytkownika;
    private String login; // dziala string? tablica znakow zamiast string?
    private String haslo;
    private String email;
    private String imieUzytkownika;
    private String nazwiskoUzytkownika;
    private int wiek;
    private int telefon; // varchar?
    private int admin; // varchar?
//    private boolean zgodaMarketingowa; //bit?

    //public Uzytkownicy() { }
    public Uzytkownicy(UzytkownicyBuilder builder) {
        this.idUzytkownika = builder.idUzytkownika;
        this.login = builder.login;
        this.haslo = builder.haslo;
        this.email = builder.email;
        this.imieUzytkownika = builder.imieUzytkownika;
        this.nazwiskoUzytkownika = builder.nazwiskoUzytkownika;
        this.wiek = builder.wiek;
        this.telefon = builder.telefon;
        this.admin = builder.admin;

    }
    public static class UzytkownicyBuilder
    {
        private int idUzytkownika;
        private String login;
        private String haslo;
        private String email;
        private String imieUzytkownika;
        private String nazwiskoUzytkownika;
        private int wiek;
        private int telefon;
        private int admin;
        public UzytkownicyBuilder(){};

        public UzytkownicyBuilder idUzytkownik(int id){
            this.idUzytkownika=id;
            return this;
        }
        public UzytkownicyBuilder user_wiek(int wiek){
            this.wiek=wiek;
            return this;
        }
        public UzytkownicyBuilder user_telefon(int nr){
            this.telefon=nr;
            return this;
        }
        public UzytkownicyBuilder user_admin(int admin){
            this.admin=admin;
            return this;
        }
        public UzytkownicyBuilder ustaw_login(String log){
            this.login=log;
            return this;
        }
        public UzytkownicyBuilder ustaw_haslo(String haslo){
            this.haslo=haslo;
            return this;
        }
        public UzytkownicyBuilder ustaw_email(String email){
            this.email=email;
            return this;
        }
        public UzytkownicyBuilder imie(String imie){
            this.imieUzytkownika=imie;
            return this;
        }
        public UzytkownicyBuilder nazwisko(String nazwisko){
            this.nazwiskoUzytkownika=nazwisko;
            return this;
        }


        public Uzytkownicy build(){
            return new Uzytkownicy(this);
        }

    }

    public int getIdUzytkownika() {
        return idUzytkownika;
    }
    public void setIdUzytkownika(int idUzytkownika) {
        this.idUzytkownika = idUzytkownika;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getHaslo(){
        return haslo;
    }
    public void setHaslo(String haslo){
        this.haslo = haslo;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getImieUzytkownika(){
        return imieUzytkownika;
    }
    public void setImieUzytkownika(String imieUzytkownika){
        this.imieUzytkownika = imieUzytkownika;
    }
    public String getNazwiskoUzytkownika() {
        return nazwiskoUzytkownika;
    }
    public void setNazwiskoUzytkownika(String nazwiskoUzytkownika){
        this.nazwiskoUzytkownika = nazwiskoUzytkownika;
    }
    public int getWiek(){
        return wiek;
    }
    public void setWiek(){
        this.wiek = wiek;
    }
    public int getTelefon(){
        return telefon;
    }
    public void setTelefon(int telefon){
        this.telefon = telefon;
    }
    public int getAdmin(){
        return admin;
    }
    public void setAdmin(int admin){
        this.admin = admin;
    }

    public void dodajFilm(List<Filmy> filmyList, BazaDanych baza, String tytul, int idRezyserzy, double ocena, String czasTrwania, /*year*/ int rokProdukcji, String opis, String zwiastun, int newFilmGatunek){
        if (this.admin == 1) {
        //Sprawdza czy zalogowany jest adminem
            try{
                //jesli film ktory chcemy dodac nie istnieje to go dodajemy:
                //troubleshooting - nie wiem czemu nie jestem w stanie z listy filmow wziac ostatniego indeksu, jest to potrzebne po to zeby filmy w liscie mialy takie same ID co w bazie
                System.out.println(filmyList.get(filmyList.size() - 1).getIdFilmy());
                FactoryFilmy filmyFactory = new FactoryFilmy();
                filmyList.add(filmyFactory.makeFilm(filmyList.get(filmyList.size() - 1).getIdFilmy(), tytul, idRezyserzy, ocena, czasTrwania, rokProdukcji, opis, zwiastun, newFilmGatunek));

                //Tworzenie rezysera jesli nie istnieje
                //A to wymaga stworzenia obiektu rezyser zamiast tylko imienia i nazwiska

                //W bazie danych id aktualizuje sie samo (autoincrement,unique) wiec nie ma problemu i nie trzeba podawac ID filmu w ogole
                baza.insertFilmy(tytul, idRezyserzy, newFilmGatunek, ocena, czasTrwania, rokProdukcji, opis, zwiastun);
                //trouble shooting - sledzenie czy do listy dodal sie film o odpowiednim ID, z aktualnym kodem ID dodawanego filmu to 0, nie wiem czemu
                System.out.println("Dodano film o indexie: " + filmyList.get(filmyList.size()-1).getIdFilmy());
            }catch (RuntimeException e){
                System.out.println("Taki film już istnieje");
                e.printStackTrace();
            }
        }else{
            System.out.println("Nie jesteś adminem!");
        }
    }

    public void dodajSeans(){
        //tez w przyszlosci trzeba zrobic
    }
}
