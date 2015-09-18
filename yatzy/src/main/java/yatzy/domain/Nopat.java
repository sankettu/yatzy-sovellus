package yatzy.domain;


public class Nopat {

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

    public int arvojenSumma() {
        return noppa1.getArvo() + noppa2.getArvo() + noppa3.getArvo() + noppa4.getArvo() + noppa5.getArvo();
    }

    public void heitaNopat() {
        noppa1.heita();
        noppa2.heita();
        noppa3.heita();
        noppa4.heita();
        noppa5.heita();
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
    }
}
