package com.bazydanych;

public class Sale {
    private int idSale;
    private int numer;
    private int liczbaMiejsc;

    public Sale() { }
    public Sale(int idSale, int numer, int liczbaMiejsc) {
        this.idSale = idSale;
        this.numer = numer;
        this.liczbaMiejsc = liczbaMiejsc;
    }

    public int getIdSale() {
        return idSale;
    }
    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }
    public int getNumer() {
        return numer;
    }
    public void setNumer(int numer) {
        this.numer = numer;
    }
    public int getLiczbaMiejsc() {
        return liczbaMiejsc;
    }
    public void setLiczbaMiejsc(int liczbaMiejsc) {
        this.liczbaMiejsc = liczbaMiejsc;
    }
}
