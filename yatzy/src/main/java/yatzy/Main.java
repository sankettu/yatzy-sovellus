package yatzy;

import javax.swing.SwingUtilities;
import yatzy.gui.Kayttoliittyma;
import yatzy.peli.Peli;

public class Main {

    public static void main(String[] args) {
        Peli peli = new Peli();
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(peli);
        SwingUtilities.invokeLater(kayttoliittyma);
        while (peli.getPelaajienLkm() == 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Pelaajien lukumäärää ei ole vielä valittu");
            }
        }
        kayttoliittyma.paivita();
        peli.peli(kayttoliittyma);
    }
}
