package com.movies;

public class Dramat extends Filmy{

    public Dramat(int idFilmy, String tytul, int idRezyserzy, double ocena, String czasTrwania, /*year*/ int rokProdukcji, String opis/*, String zwiastun*/){
        setIdFilmy(idFilmy);
        setTytul(tytul);
        setIdRezyserzy(idRezyserzy);
        setOcena(ocena);
        setCzasTrwania(czasTrwania);
        setRokProdukcji(rokProdukcji);
        setOpis(opis);
        //setZwiastun(zwiastun);
        setIdGatunki(1);
    }
}
