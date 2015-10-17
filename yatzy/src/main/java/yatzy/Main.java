package yatzy;

import javax.swing.SwingUtilities;
import yatzy.gui.Kayttoliittyma;
import yatzy.peli.Peli;

public class Main {

    public static void main(String[] args) {
        Peli peli = new Peli();
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(peli);
        SwingUtilities.invokeLater(kayttoliittyma);
        peli.peli(kayttoliittyma);
    }

}
