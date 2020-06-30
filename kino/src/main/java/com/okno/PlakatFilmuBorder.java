package main.java.com.okno;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;

//DEKORATOR

public class PlakatFilmuBorder extends PlakatFilmu{
    public Border border_yellow = BorderFactory.createLineBorder(Color.YELLOW,5);
    public PlakatFilmu plakat;


    PlakatFilmuBorder(PlakatFilmu plakat) throws IOException {
        super(plakat.chosenMovieTitle);
        this.plakat = plakat;
    }

    public void set_border(Border border){
        this.plakat.getiPlakat().setBorder(border);
    }

}
