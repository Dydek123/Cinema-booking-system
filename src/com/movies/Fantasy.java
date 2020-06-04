package com.movies;

public class Fantasy extends Filmy{

    public Fantasy(int idFlimy, String tytul, int idRezyserzy, double ocena, String czasTrwania, /*year*/ int rokProdukcji, String opis, String zwiastun){
        setIdFlimy(idFlimy);
        setTytul(tytul);
        setIdRezyserzy(idRezyserzy);
        setOcena(ocena);
        setCzasTrwania(czasTrwania);
        setRokProdukcji(rokProdukcji);
        setOpis(opis);
        setZwiastun(zwiastun);
        setIdGatunki(6);
    }
}
