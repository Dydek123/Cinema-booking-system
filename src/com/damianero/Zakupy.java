package com.damianero;

public class Zakupy {
    private int idZakupy;
    private int idBilety;
    private int idRezerwacje;
    private /*date*/String dataZakupu;

    public Zakupy() { }
    public Zakupy(int idZakupy, int idBilety,int idRezerwacje, /*date*/String dataZakupu) {
        this.idZakupy = idZakupy;
        this.idBilety = idBilety;
        this.idRezerwacje = idRezerwacje;
        this.dataZakupu = dataZakupu;
    }

    public int getIdZakupy() {
        return idZakupy;
    }
    public void setIdZakupy(int idZakupy) {
        this.idZakupy = idZakupy;
    }
    public float getIdBilety() {
        return idBilety;
    }
    public void setIdBilety(int idBilety) {
        this.idBilety = idBilety;
    }
    public int getIdRezerwacje() {
        return idRezerwacje;
    }
    public void setIdRezerwacje(int idRezerwacje) {
        this.idRezerwacje = idRezerwacje;
    }
    public /*date*/String getDataZakupu(){
        return dataZakupu;
    }
    public void setDataZakupu(/*date*/String dataZakupu){
        this.dataZakupu = dataZakupu;
    }
}