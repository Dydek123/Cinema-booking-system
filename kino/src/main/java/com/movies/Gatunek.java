package main.java.com.movies;

public enum Gatunek {
    DRAMAT,KOMEDIA,HORROR,BIOGRAFICZNY,ROMANS,FANTASY,KOMEDIODRAMAT, BLAD;

    public static Gatunek retGatunek(String gatunek){

        switch (gatunek){
            case "Dramat":
                return DRAMAT;
            case "Komedia":
                return KOMEDIA;
            case "Horror":
                return HORROR;
            case "Biograficzny":
                return BIOGRAFICZNY;
            case "Romans":
                return ROMANS;
            case "Fantasy":
                return FANTASY;
            case "Komediodramat":
                return KOMEDIODRAMAT;
            default:
                return BLAD;
        }

    }
}
