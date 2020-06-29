package main.java.com.BazaFilmy;

public class FilmyOceny {
    private int idUzytkownika;
    private int ocenaFilmu;

    public FilmyOceny() { }
    public FilmyOceny(int idUzytkownika, int ocenaFilmu) {
        this.idUzytkownika = idUzytkownika;
        this.ocenaFilmu = ocenaFilmu;
    }

    public int getIdUzytkownika() {
        return idUzytkownika;
    }
    public void setIdUzytkownika(int idUzytkownika) {
        this.idUzytkownika = idUzytkownika;
    }
    public int getOcenaFilmu(){
        return ocenaFilmu;
    }
    public void getOcenaFilmu(int ocenaFilmu){
        this.ocenaFilmu = ocenaFilmu;
    }

}
