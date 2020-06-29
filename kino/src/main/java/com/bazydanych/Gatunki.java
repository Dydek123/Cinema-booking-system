package com.bazydanych;

public class Gatunki {
    private int idGatunki;
    private String nazwaGatunku;

    public Gatunki() { }
    public Gatunki(int idGatunki, String nazwaGatunku) {
        this.idGatunki = idGatunki;
        this.nazwaGatunku = nazwaGatunku;
    }

    public int getIdGatunki() {
        return idGatunki;
    }
    public void setIdGatunki(int idGatunki) {
        this.idGatunki = idGatunki;
    }
    public String getNazwaGatunku() {
        return nazwaGatunku;
    }
    public void setNazwaGatunku(String nazwaGatunku) {
        this.nazwaGatunku = nazwaGatunku;
    }
}
