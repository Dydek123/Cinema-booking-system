package com.movies;

public class Fantasy extends Filmy{

    public Fantasy(int idFilmy, String tytul, int idRezyserzy, double ocena, String czasTrwania, /*year*/ int rokProdukcji, String opis/*, String zwiastun*/){
        setIdFilmy(idFilmy);
        setTytul(tytul);
        setIdRezyserzy(idRezyserzy);
        setOcena(ocena);
        setCzasTrwania(czasTrwania);
        setRokProdukcji(rokProdukcji);
        setOpis(opis);
        //setZwiastun(zwiastun);
        setIdGatunki(6);
    }
}
