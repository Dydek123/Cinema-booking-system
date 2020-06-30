package main.java.com.bazydanych;

public class Rezyserzy {
    private int idRezyserzy;
    private String imieRezysera;
    private String nazwiskoRezysera;

    public Rezyserzy() { }
    public Rezyserzy(int idRezyserzy, String imieRezysera, String nazwiskoRezysera) {
        this.idRezyserzy = idRezyserzy;
        this.imieRezysera = imieRezysera;
        this.nazwiskoRezysera = nazwiskoRezysera;
    }

    public int getIdRezyserzy() {
        return idRezyserzy;
    }
    public void setIdRezyserzy(int idRezyserzy) {
        this.idRezyserzy = idRezyserzy;
    }
    public String getImieRezysera() {
        return imieRezysera;
    }
    public void setImieRezysera(String imieRezysera) {
        this.imieRezysera = imieRezysera;
    }
    public String getNazwiskoRezysera() {
        return nazwiskoRezysera;
    }
    public void setNazwiskoRezysera(String nazwiskoRezysera) {
        this.nazwiskoRezysera = nazwiskoRezysera;
    }
}
