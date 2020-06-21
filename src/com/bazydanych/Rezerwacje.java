package com.bazydanych;
/*
import com.okno.Rezerwacja;

import java.sql.PreparedStatement;
import java.sql.SQLException;
*/

public class Rezerwacje {
    private int idRezerwacje;
    private int idUzytkownicy;
    private int idSeanse;
    private char rzad;
    private int miejsce;

    public Rezerwacje() { }
    public Rezerwacje(RezerwacjeBuilder builder) {
        this.idRezerwacje = builder.idRezerwacje;
        this.idUzytkownicy = builder.idUzytkownicy;
        this.idSeanse = builder.idSeanse;
        this.rzad = builder.rzad;
        this.miejsce = builder.miejsce;
    }

    public String statement_rezerwacja_biletow(){ //tworzymy statement do bazy danych
        String miejsce1=Integer.toString(this.miejsce);
        String miejsce2=this.rzad+miejsce1;

        String statement =String.format("INSERT INTO Rezerwacje VALUES (%d,%d,%d,%s);",this.idUzytkownicy,this.idSeanse,this.idRezerwacje,miejsce2);
        return statement;

    }
    public String toString(){
        return "Bilet: IdRezerwacji:"+this.idRezerwacje+" IdUzytkownika: "+this.idUzytkownicy+" IdSeansu: "+this.idSeanse+" Miejsce: "+
                this.rzad+this.miejsce;

    }
    public static class RezerwacjeBuilder
    {
        private int idRezerwacje;
        private int idUzytkownicy;
        private int idSeanse;
        private char rzad;
        private int miejsce;
        public RezerwacjeBuilder(){};

        public RezerwacjeBuilder idrezerwacja(int rezerwacja){
            this.idRezerwacje=rezerwacja;
            return this;
        }

        public RezerwacjeBuilder iduzytkownik(int user){
            this.idUzytkownicy=user;
            return this;
        }

        public RezerwacjeBuilder idseans(int seans){
            this.idSeanse=seans;
            return this;
        }

        public RezerwacjeBuilder rzad(char rzad){
            this.rzad=rzad;
            return this;
        }

        public RezerwacjeBuilder miejsce(int miejsce){
            this.miejsce=miejsce;
            return this;
        }

        public Rezerwacje build(){
            return new Rezerwacje(this);
        }

    }
    /*
    public int getIdRezerwacje() {
        return idRezerwacje;
    }
    public void setIdRezerwacje(int idRezerwacje) {
        this.idRezerwacje = idRezerwacje;
    }
    public int getIdUzytkownicy() {
        return idUzytkownicy;
    }
    public void setIdUzytkownicy(int idUzytkownicy) {
        this.idUzytkownicy = idUzytkownicy;
    }
    public int getIdSeanse() {
        return idSeanse;
    }
    public void setIdSeanse(int idSeanse) {
        this.idSeanse = idSeanse;
    }
    public String getRzad(){
        return this.rzad;
    }
    public void setRzad(String rzad){
        this.rzad = rzad;
    }
    public int getMiejsce(){
        return miejsce;
    }
    public void setMiejsce(int miejsce){
        this.miejsce = miejsce;
    }
    */

}