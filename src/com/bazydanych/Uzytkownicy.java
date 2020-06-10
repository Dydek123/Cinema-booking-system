package com.bazydanych;

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

}
