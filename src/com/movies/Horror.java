package com.movies;

public class Horror extends Filmy{

    public Horror(int idFlimy, String tytul, int idRezyserzy, double ocena, String czasTrwania, /*year*/ int rokProdukcji, String opis, String zwiastun){
        setIdFlimy(idFlimy);
        setTytul(tytul);
        setIdRezyserzy(idRezyserzy);
        setOcena(ocena);
        setCzasTrwania(czasTrwania);
        setRokProdukcji(rokProdukcji);
        setOpis(opis);
        setZwiastun(zwiastun);
        setIdGatunki(3);
    }
}
