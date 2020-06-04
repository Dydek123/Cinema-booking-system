package com.movies;

public class Romans extends Filmy{

    public Romans(int idFlimy, String tytul, int idRezyserzy, double ocena, String czasTrwania, /*year*/ int rokProdukcji, String opis, String zwiastun){
        setIdFlimy(idFlimy);
        setTytul(tytul);
        setIdRezyserzy(idRezyserzy);
        setOcena(ocena);
        setCzasTrwania(czasTrwania);
        setRokProdukcji(rokProdukcji);
        setOpis(opis);
        setZwiastun(zwiastun);
        setIdGatunki(5);
    }
}
