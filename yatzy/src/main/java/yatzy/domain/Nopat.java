package yatzy.domain;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Luokka Nopat-oliota varten Nopat käsittelee pelin viittä noppaa yhtenä
 * kokonaisuutena
 *
 * @author Santeri
 */
public class Nopat {

    private ArrayList<Noppa> nopat;
    private Noppa noppa1;
    private Noppa noppa2;
    private Noppa noppa3;
    private Noppa noppa4;
    private Noppa noppa5;
    private boolean lukitus1;
    private boolean lukitus2;
    private boolean lukitus3;
    private boolean lukitus4;
    private boolean lukitus5;

    public Nopat() {
        this.noppa1 = new Noppa();
        this.noppa2 = new Noppa();
        this.noppa3 = new Noppa();
        this.noppa4 = new Noppa();
        this.noppa5 = new Noppa();
        this.nopat = new ArrayList<Noppa>();
        nopat.add(noppa1);
        nopat.add(noppa2);
        nopat.add(noppa3);
        nopat.add(noppa4);
        nopat.add(noppa5);
        this.lukitus1 = false;
        this.lukitus2 = false;
        this.lukitus3 = false;
        this.lukitus4 = false;
        this.lukitus5 = false;
    }

    public int getNoppa1() {
        return this.noppa1.getArvo();
    }

    public int getNoppa2() {
        return this.noppa2.getArvo();
    }

    public int getNoppa3() {
        return this.noppa3.getArvo();
    }

    public int getNoppa4() {
        return this.noppa4.getArvo();
    }

    public int getNoppa5() {
        return this.noppa5.getArvo();
    }

    public void vaihdaLukitus1() {
        if (this.lukitus1 == false) {
            this.lukitus1 = true;
        } else {
            this.lukitus1 = false;
        }
    }

    public void vaihdaLukitus2() {
        if (this.lukitus2 == false) {
            this.lukitus2 = true;
        } else {
            this.lukitus2 = false;
        }
    }

    public void vaihdaLukitus3() {
        if (this.lukitus3 == false) {
            this.lukitus3 = true;
        } else {
            this.lukitus3 = false;
        }
    }

    public void vaihdaLukitus4() {
        if (this.lukitus4 == false) {
            this.lukitus4 = true;
        } else {
            this.lukitus4 = false;
        }
    }

    public void vaihdaLukitus5() {
        if (this.lukitus5 == false) {
            this.lukitus5 = true;
        } else {
            this.lukitus5 = false;
        }
    }

    public void poistaLukitukset() {
        this.lukitus1 = false;
        this.lukitus2 = false;
        this.lukitus3 = false;
        this.lukitus4 = false;
        this.lukitus5 = false;
    }

    public ArrayList<Noppa> getNopat() {
        return this.nopat;
    }

    public int arvojenSumma() {
        int summa = 0;
        for (Noppa noppa : this.nopat) {
            summa += noppa.getArvo();
        }
        return summa;
    }

    public void heitaKaikkiNopat() {
        for (Noppa noppa : this.nopat) {
            noppa.heita();
        }
        Collections.sort(this.nopat);
    }

    public void heitaNopat() {
        if (!this.lukitus1) {
            this.noppa1.heita();
        }

        if (!this.lukitus2) {
            this.noppa2.heita();
        }

        if (!this.lukitus3) {
            this.noppa3.heita();
        }

        if (!this.lukitus4) {
            this.noppa4.heita();
        }

        if (!this.lukitus5) {
            this.noppa5.heita();
        }

        Collections.sort(this.nopat);
    }

    @Override
    public String toString() {
        String merkkijono = "";
        for (Noppa noppa : this.nopat) {
            merkkijono += noppa.getArvo() + " ";
        }
        return merkkijono;
    }
}
