package yatzy.domain;

import java.util.ArrayList;
import java.util.Collections;
/**
 * Luokka Nopat-oliota varten
 * Nopat käsittelee pelin viittä noppaa yhtenä kokonaisuutena
 * @author Santeri
 */
public class Nopat {

    private ArrayList<Noppa> nopat;
    private Noppa noppa1;
    private Noppa noppa2;
    private Noppa noppa3;
    private Noppa noppa4;
    private Noppa noppa5;

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
        return this.noppa1.getArvo();
    }
    
    public int getNoppa5() {
        return this.noppa5.getArvo();
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

    public void heitaNopat() {
        for(Noppa noppa : this.nopat) {
            noppa.heita();
        }
        Collections.sort(nopat);
    }
    

    public void heitaNopat(boolean noppa1, boolean noppa2, boolean noppa3, boolean noppa4, boolean noppa5) {
        if (noppa1) {
            this.noppa1.heita();
        }

        if (noppa2) {
            this.noppa2.heita();
        }

        if (noppa3) {
            this.noppa3.heita();
        }

        if (noppa4) {
            this.noppa4.heita();
        }

        if (noppa5) {
            this.noppa5.heita();
        }
        
        Collections.sort(nopat);
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
