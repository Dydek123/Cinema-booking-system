package com.bazydanych;

import com.movies.FactoryFilmy;
import com.movies.Filmy;

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

    public Uzytkownicy() { }
    public Uzytkownicy(int idUzytkownika, String login, String haslo, String email, String imieUzytkownika, String nazwiskoUzytkownika, int wiek, int telefon,int admin) {
        this.idUzytkownika = idUzytkownika;
        this.login = login;
        this.haslo = haslo;
        this.email = email;
        this.imieUzytkownika = imieUzytkownika;
        this.nazwiskoUzytkownika = nazwiskoUzytkownika;
        this.wiek = wiek;
        this.telefon = telefon;
        this.admin = telefon;
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
    public void dodajFilm(List<Filmy> filmyList, BazaDanych baza, int idFlimy, String tytul, int idRezyserzy, double ocena, String czasTrwania, /*year*/ int rokProdukcji, String opis, String zwiastun, int newFilmGatunek){
        if (this.admin==1) {
            boolean found=false;
            for (int i = 0; i < filmyList.size(); i++) {
                Filmy filmy =  filmyList.get(i);
                if (filmy.getTytul().equals(tytul)){
                    found=true;
                    break;
                }
            }
            if(!found) {
                FactoryFilmy filmyFactory = new FactoryFilmy();
                filmyList.add(filmyFactory.makeFilm(idFlimy, tytul, idRezyserzy, ocena, czasTrwania, rokProdukcji, opis, zwiastun, newFilmGatunek));
                //WYKONAC POBRANIE NAJWIEKSZEGO IP FILMY Z BAZY I TO WLASNIE NIEGO PODAWA DO INSERTA I DO LISTY
                //Tworzenie rezysera jesli nie istnieje
                //A to wymaga stworzenia obiektu rezyser zamiast tylko imienia i nazwiska
                baza.insertFilmy(tytul, idRezyserzy, newFilmGatunek, ocena, czasTrwania, rokProdukcji, opis, zwiastun);
                System.out.println("Dodano film :)");
            }else{
                System.out.println("Taki film już istnieje");
            }
        }else{
            System.out.println("Nie jesteś adminem!");
        }
    }
    public void dodajSeans(){
        //tez w przyszlosci trzeba zrobic
    }
}
