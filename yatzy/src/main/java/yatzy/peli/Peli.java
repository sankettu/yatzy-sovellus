package yatzy.peli;

import yatzy.domain.Nopat;
import yatzy.domain.Pelaaja;
import java.util.ArrayList;
import yatzy.gui.Kayttoliittyma;

/**
 * Luokka peli hallinnoi pelin kulun ohjelmalogiikkaa
 *
 * @author Santeri
 */
public class Peli {

    private Nopat nopat;
    private ArrayList<Pelaaja> pelaajat;
    private int pelaajienLkm;
    private Pelaaja pelaajaVuorossa;
    private boolean tulosLaitettu;
    private int heittojaJaljella;

    public Peli() {
        this.nopat = new Nopat();
        this.pelaajat = new ArrayList<Pelaaja>();
        this.pelaajienLkm = 0;
        this.tulosLaitettu = false;
        this.heittojaJaljella = 3;
    }

    /**
     * Metodi luo asetetun lukumäärän pelaajia
     */
    public void luoPelaajat() {
        for (int i = 1; i <= this.pelaajienLkm; i++) {
            this.pelaajat.add(new Pelaaja("Pelaaja " + i));
        }

        if (this.pelaajaVuorossa == null) {
            this.pelaajaVuorossa = this.pelaajat.get(0);
        }
    }

    public ArrayList<Pelaaja> getPelaajat() {
        return this.pelaajat;
    }

    public Pelaaja getPelaajaVuorossa() {
        return this.pelaajaVuorossa;
    }

    public Nopat getNopat() {
        return this.nopat;
    }

    public boolean getTulosLaitettu() {
        return this.tulosLaitettu;
    }

    public void tulosLaitettu() {
        this.tulosLaitettu = true;
    }

    public int getHeittojaJaljella() {
        return this.heittojaJaljella;
    }

    public void kerranHeitetty() {
        this.heittojaJaljella--;
    }

    /**
     * Metodi odottaa kunnes pelaajien lukumäärä on valittu
     */
    private void pelaajienValinta() {
        while (this.pelaajienLkm == 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Pelaajien lukumäärää ei ole vielä valittu");
            }
        }
    }

    /**
     * Metodi käy läpi yhden pelaajan pelivuoron ja päivittää käyttöliittymää
     * toimintojen välissä
     *
     * @param pelaaja kierros metodin parametrina antama vuorossa oleva pelaaja
     * @param kali käyttöliittymä
     */
    private void vuoro(Pelaaja pelaaja, Kayttoliittyma kali) {
        this.pelaajaVuorossa = pelaaja;
        this.heittojaJaljella = 3;
        this.tulosLaitettu = false;
        this.nopat.poistaLukitukset();
        kali.paivita();

        this.vuoronEnsimmainenHeitto();
        kali.paivita();

        this.vuoronToinenHeitto();
        kali.paivita();

        this.vuoronKolmasHeitto();
        kali.paivita();

        this.vuoronKaikkiHeitotHeitetty();
        pelaaja.getTaulu().bonus();
        pelaaja.getTaulu().summa();

    }
    /**
     *  Metodi odottaa kunnes vuoron ensimmäinen heitto on suoritettu
     */
    private void vuoronEnsimmainenHeitto() {
        while (heittojaJaljella == 3) {
            if (tulosLaitettu) {
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Aloitusheittoa ei ole heitetty");
            }
        }
    }
    /**
     * Metodi odottaa kunnes vuoron toinen heitto on heitetty tai tulos on sijoitettu
     */
    private void vuoronToinenHeitto() {
        while (heittojaJaljella == 2) {
            if (tulosLaitettu) {
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Ei ole heitetty tai laitettu tulosta");
            }
        }
    }
    /**
     * Metodi odottaa kunnes vuoron kolmas heitto on heitetty tai tulos sijoitettu
     */
    private void vuoronKolmasHeitto() {
        while (heittojaJaljella == 1) {
            if (tulosLaitettu) {
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Ei ole heitetty tai laitettu tulosta");
            }
        }
    }
    /**
     * Metodi odottaa kunnes tulos on sijoitettu
     */
    private void vuoronKaikkiHeitotHeitetty() {
        while (heittojaJaljella < 1) {
            if (tulosLaitettu) {
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Ei ole laitettu tulosta");
            }
        }
    }
    /**
     * Metodi käy läpi yhden pelikierroksen, eli kaikilla pelaajilla on yksi vuoro
     * @param kali parametrina annettu käyttöliittymä
     */
    private void kierros(Kayttoliittyma kali) {
        for (Pelaaja pelaaja : this.pelaajat) {
            vuoro(pelaaja, kali);
        }
    }
    /**
     * Metodi käy läpi koko pelin tapahtumat pelaajien valinnasta, heittokierroksiin ja lopuksi voittajan julistaminen
     * @param kali parametrina annettu käyttöliittymä
     */
    public void peli(Kayttoliittyma kali) {
        this.pelaajienValinta();
        kali.paivita();
        for (int i = 0; i < 15; i++) {
            kierros(kali);
        }
        this.voittaja(kali);
    }
    /**
     * Metodi vertaa pelaajien tuloksia ja selvittää voittajan
     * @param kali Parametrina annettu käyttöliittymä
     */
    public void voittaja(Kayttoliittyma kali) {
        Pelaaja voittaja = this.pelaajat.get(0);

        for (Pelaaja pelaaja : this.pelaajat) {
            if (pelaaja.getTaulu().getTulos("summa") > voittaja.getTaulu().getTulos("summa")) {
                voittaja = pelaaja;
            }
        }
        kali.pelinVoittaja(voittaja);
    }

    public void setPelaajienLkm(int lkm) {
        this.pelaajienLkm = lkm;
    }

    public int getPelaajienLkm() {
        return this.pelaajienLkm;
    }
}
