package com.movies;

public abstract class Filmy {
    private int idFilmy;
    private String tytul;
    private int idRezyserzy;
    private int idGatunki;
    /*
    1-dramat
    2-komedia
    3-horror
    4-biograficzny
    5-romans
    6-fantasy
    7-komedio-dramat
     */
    private double ocena;
    private String czasTrwania;
    private /*year*/ int rokProdukcji;
    private String opis;
    //private String zwiastun;

    //konstruktor filmow przeniesiony do poszczegolnych gatunkow w mysl wzorca factory method

    //public Filmy() { }
  //  public Filmy(int idFlimy, String tytul, int idRezyserzy, float ocena, String czasTrwania, /*year*/ int rokProdukcji, String opis, String zwiastun) {
    /*    this.idFlimy = idFlimy;
        this.tytul = tytul;
        this.idRezyserzy = idRezyserzy;
        this.ocena = ocena;
        this.czasTrwania = czasTrwania;
        this.rokProdukcji = rokProdukcji;
        this.opis = opis;
        this.zwiastun = zwiastun;
    }  */

    public int getIdFilmy() {
        return idFilmy;
    }
    public void setIdFilmy(int idFilmy) {
        this.idFilmy = idFilmy;
    }
    public String getTytul() {
        return tytul;
    }
    public void setTytul(String tytul) {
        this.tytul = tytul;
    }
    public int getIdGatunki() {
        return idGatunki;
    }
    public void setIdGatunki(int IdGatunki) {
        this.idGatunki = IdGatunki;
    }
    public int getIdRezyserzy(){
        return idRezyserzy;
    }
    public void setIdRezyserzy(int idRezyserzy){
        this.idRezyserzy = idRezyserzy;
    }
    public double getOcena(){
        return ocena;
    }
    public void setOcena(double ocena){
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
    public void setOpis(String opis){
        this.opis = opis;
    }
    /*public String getZwiastun() {
        return zwiastun;
    }
    public void setZwiastun(String zwiastun) {
        this.zwiastun = zwiastun;
    }*/
}
