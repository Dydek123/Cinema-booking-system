package com.damianero;

public class Uzytkownicy {
    private int idUzytkownika;
    private String login; // dziala string? tablica znakow zamiast string?
    private String haslo;
    private String email;
    private String imieUzytkownika;
    private String nazwiskoUzytkownika;
    private int wiek;
    private int telefon; // varchar?
//    private boolean zgodaMarketingowa; //bit?

    public Uzytkownicy() { }
    public Uzytkownicy(int idUzytkownika, String login, String haslo, String email, String imieUzytkownika, String nazwiskoUzytkownika, int wiek, int telefon) {
        this.idUzytkownika = idUzytkownika;
        this.login = login;
        this.haslo = haslo;
        this.email = email;
        this.imieUzytkownika = imieUzytkownika;
        this.nazwiskoUzytkownika = nazwiskoUzytkownika;
        this.wiek = wiek;
        this.telefon = telefon;
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
}
