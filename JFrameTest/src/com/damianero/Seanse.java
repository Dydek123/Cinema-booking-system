package com.damianero;

public class Seanse {
    private int idSeanse;
    private int idSale;
    private int idFilmy;
    private /*date*/String dataSeansu;
    private String godzinaSeansu;

    public Seanse() { }
    public Seanse(int idSeanse, int idSale, int idFilmy, /*date*/String dataSeansu, String godzinaSeansu) {
        this.idSeanse = idSeanse;
        this.idSale = idSale;
        this.idFilmy = idFilmy;
        this.dataSeansu = dataSeansu;
        this.godzinaSeansu = godzinaSeansu;
    }

    public int getIdSeanse() {
        return idSeanse;
    }
    public void setIdSeanse(int idSeanse) {
        this.idSeanse = idSeanse;
    }
    public int getIdSale() {
        return idSale;
    }
    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }
    public int getIdFilmy() {
        return idFilmy;
    }
    public void setIdFilmy(int idFilmy) {
        this.idFilmy = idFilmy;
    }
    public /*date*/String getDataSeansu(){
        return dataSeansu;
    }
    public void setDataSeansu(/*date*/String dataSeansu){
        this.dataSeansu = dataSeansu;
    }
    public String getGodzinaSeansu(){
        return godzinaSeansu;
    }
    public void setGodzinaSeansu(String godzinaSeansu){
        this.godzinaSeansu = godzinaSeansu;
    }
}
