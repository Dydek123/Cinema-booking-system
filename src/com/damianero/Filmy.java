package com.damianero;

public class Filmy {
    private int idFlimy;
    private String tytul;
    private int idRezyserzy;
    private int idGatunki;
    private float ocena;
    private String czasTrwania;
    private /*year*/ int rokProdukcji;
    private String opis;
    private String zwiastun;

    public Filmy() { }
    public Filmy(int idFlimy, String tytul, int idRezyserzy, int idGatunki, float ocena, String czasTrwania, /*year*/ int rokProdukcji, String opis, String zwiastun) {
        this.idFlimy = idFlimy;
        this.tytul = tytul;
        this.idRezyserzy = idRezyserzy;
        this.idGatunki = idGatunki;
        this.ocena = ocena;
        this.czasTrwania = czasTrwania;
        this.rokProdukcji = rokProdukcji;
        this.opis = opis;
        this.zwiastun = zwiastun;
    }

    public int getIdFlimy() {
        return idFlimy;
    }
    public void setIdFlimy(int idFilmy) {
        this.idFlimy = idFlimy;
    }
    public String getTytul() {
        return tytul;
    }
    public void setTytul(String tytul) {
        this.tytul = tytul;
    }
    public int getIdRezyserzy(){
        return idRezyserzy;
    }
    public void getidRezyserzy(int idRezyserzy){
        this.idRezyserzy = idRezyserzy;
    }
    public int getIdGatunki(){
        return idGatunki;
    }
    public void setIdGatunki(){
        this.idGatunki = idGatunki;
    }
    public float getOcena(){
        return ocena;
    }
    public void setOcena(float ocena){
        this.ocena = ocena;
    }
    public String getCzasTrwania() {
        return czasTrwania;
    }
    public void setCzasTrwania(String czasTrwania) {
        this.czasTrwania = czasTrwania;
    }
    public /*year*/int getRokProdukcji(){
        return rokProdukcji;
    }
    public void setRokProdukcji(/*year*/int rokProdukcji) {
        this.rokProdukcji = rokProdukcji;
    }
    public String getOpis() {
        return opis;
    }
    public void setOpis(){
        this.opis = opis;
    }
    public String getZwiastun() {
        return zwiastun;
    }
    public void setZwiastun(String zwiastun) {
        this.zwiastun = zwiastun;
    }
}
