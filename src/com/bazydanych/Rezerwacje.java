package com.bazydanych;

public class Rezerwacje {
    private int idRezerwacje;
    private int idUzytkownicy;
    private int idSeanse;
    private int rzad;
    private int miejsce;

    public Rezerwacje() { }
    public Rezerwacje(int idRezerwacje, int idUzytkownicy,int idSeanse, int rzad, int miejsce) {
        this.idRezerwacje = idRezerwacje;
        this.idUzytkownicy = idUzytkownicy;
        this.idSeanse = idSeanse;
        this.rzad = rzad;
        this.miejsce = miejsce;
    }

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
    public int getRzad(){
        return rzad;
    }
    public void setRzad(int rzad){
        this.rzad = rzad;
    }
    public int getMiejsce(){
        return miejsce;
    }
    public void setMiejsce(int miejsce){
        this.miejsce = miejsce;
    }
}