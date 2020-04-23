package com.bazydanych;

public class Bilety {
    private int idBilety;
    private float cenaBiletu;
    private String rodzaj;

    public Bilety() { }
    public Bilety(int idBilety, float cenaBiletu, String rodzaj) {
        this.idBilety = idBilety;
        this.cenaBiletu = cenaBiletu;
        this.rodzaj = rodzaj;
    }

    public int getId() {
        return idBilety;
    }
    public void setId(int idBilety) {
        this.idBilety = idBilety;
    }
    public float getCenaBiletu() {
        return cenaBiletu;
    }
    public void setCenaBiletu(float cenaBiletu) {
        this.cenaBiletu = cenaBiletu;
    }
    public String getRodzaj() {
        return rodzaj;
    }
    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }
}
