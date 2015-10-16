package yatzy.peli;

import yatzy.domain.Nopat;
import yatzy.domain.Pelaaja;
import java.util.ArrayList;
import yatzy.gui.Kayttoliittyma;

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
    
    public void tulosLaitettu() {
        this.tulosLaitettu = true;
    }
    
    public int getHeittojaJaljella() {
        return this.heittojaJaljella;
    }
    
    public void kerranHeitetty() {
        this.heittojaJaljella--;
    }
    
    public void vuoro(Pelaaja pelaaja, Kayttoliittyma kali) {
        this.pelaajaVuorossa = pelaaja;
        this.heittojaJaljella = 3;
        if (tulosLaitettu) {
            tulosLaitettu = false;
        }
        kali.paivita();
        this.nopat.poistaLukitukset();
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
        kali.paivita();
        
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
        kali.paivita();
        
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
        kali.paivita();
        
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
        pelaaja.getTaulu().bonus();
        pelaaja.getTaulu().summa();
        
    }
    
    public void kierros(Kayttoliittyma kali) {
        for (Pelaaja pelaaja : this.pelaajat) {
            vuoro(pelaaja, kali);
        }
    }
    
    public void peli(Kayttoliittyma kali) {
        for (int i = 0; i < 15; i++) {
            kierros(kali);
        }
        voittaja(kali);
    }
    
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
