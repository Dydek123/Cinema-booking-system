package com.movies;

import static com.movies.Gatunek.*;

public class FactoryFilmy {
    public Filmy makeFilm(int idFilmy, String tytul, int idRezyserzy, double ocena, String czasTrwania, /*year*/ int rokProdukcji, String opis,/* String zwiastun,*/ Gatunek newFilmGatunek){

        Filmy nowyFilm=null;

        if(newFilmGatunek==DRAMAT){
            return new Dramat( idFilmy,  tytul,  idRezyserzy,  ocena,  czasTrwania, rokProdukcji,  opis/*,  zwiastun*/);
        }else if(newFilmGatunek==KOMEDIA){
                return new Komedia( idFilmy,  tytul,  idRezyserzy,  ocena,  czasTrwania, rokProdukcji,  opis/*,  zwiastun*/);
        }else if(newFilmGatunek==HORROR){
                return new Horror( idFilmy,  tytul,  idRezyserzy,  ocena,  czasTrwania, rokProdukcji,  opis/*,  zwiastun*/);
        }else if(newFilmGatunek==BIOGRAFICZNY) {
                return new Biograficzny(idFilmy, tytul, idRezyserzy, ocena, czasTrwania, rokProdukcji, opis/*,  zwiastun*/);
        }else if(newFilmGatunek==ROMANS) {
                return new Romans(idFilmy, tytul, idRezyserzy, ocena, czasTrwania, rokProdukcji, opis/*,  zwiastun*/);
        }else if(newFilmGatunek==FANTASY) {
                return new Fantasy(idFilmy, tytul, idRezyserzy, ocena, czasTrwania, rokProdukcji, opis/*,  zwiastun*/);
        }else if(newFilmGatunek==KOMEDIODRAMAT) {
                return new Komediodramat(idFilmy, tytul, idRezyserzy, ocena, czasTrwania, rokProdukcji, opis/*,  zwiastun*/);
        }else return null;

    }

    public Filmy makeFilm(int idFilmy, String tytul, int idRezyserzy, double ocena, String czasTrwania, /*year*/ int rokProdukcji, String opis,/* String zwiastun,*/ int newFilmGatunek){

        Filmy nowyFilm=null;

        if(newFilmGatunek==1){
            return new Dramat( idFilmy,  tytul,  idRezyserzy,  ocena,  czasTrwania, rokProdukcji,  opis/*,  zwiastun*/);
        }else if(newFilmGatunek==2){
            return new Komedia( idFilmy,  tytul,  idRezyserzy,  ocena,  czasTrwania, rokProdukcji,  opis/*,  zwiastun*/);
        }else if(newFilmGatunek==3){
            return new Horror( idFilmy,  tytul,  idRezyserzy,  ocena,  czasTrwania, rokProdukcji,  opis/*,  zwiastun*/);
        }else if(newFilmGatunek==4) {
            return new Biograficzny(idFilmy, tytul, idRezyserzy, ocena, czasTrwania, rokProdukcji, opis/*,  zwiastun*/);
        }else if(newFilmGatunek==5) {
            return new Romans(idFilmy, tytul, idRezyserzy, ocena, czasTrwania, rokProdukcji, opis/*,  zwiastun*/);
        }else if(newFilmGatunek==6) {
            return new Fantasy(idFilmy, tytul, idRezyserzy, ocena, czasTrwania, rokProdukcji, opis/*,  zwiastun*/);
        }else if(newFilmGatunek==7) {
            return new Komediodramat(idFilmy, tytul, idRezyserzy, ocena, czasTrwania, rokProdukcji, opis/*,  zwiastun*/);
        }else return null;

    }
}
