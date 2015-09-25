package yatzy.domain;

import java.util.HashMap;

public class Tulostaulu {

    private HashMap<String, Integer> taulu;

    public Tulostaulu() {
        this.taulu = new HashMap<String, Integer>();
    }

    public int getTulos(String tulos) {
        return this.taulu.get(tulos);
    }

    public void ykkoset(Nopat nopat) {
        int summa = 0;
        for (Noppa noppa : nopat.getNopat()) {
            if (noppa.getArvo() == 1) {
                summa++;
            }
        }

        this.taulu.put("ykkoset", summa);
    }

    public void kakkoset(Nopat nopat) {
        int summa = 0;
        for (Noppa noppa : nopat.getNopat()) {
            if (noppa.getArvo() == 2) {
                summa += 2;
            }
        }

        this.taulu.put("kakkoset", summa);
    }

    public void kolmoset(Nopat nopat) {
        int summa = 0;
        for (Noppa noppa : nopat.getNopat()) {
            if (noppa.getArvo() == 3) {
                summa += 3;
            }
        }

        this.taulu.put("kolmoset", summa);
    }

    public void neloset(Nopat nopat) {
        int summa = 0;
        for (Noppa noppa : nopat.getNopat()) {
            if (noppa.getArvo() == 4) {
                summa += 4;
            }
        }

        this.taulu.put("neloset", summa);
    }

    public void viitoset(Nopat nopat) {
        int summa = 0;
        for (Noppa noppa : nopat.getNopat()) {
            if (noppa.getArvo() == 5) {
                summa += 5;
            }
        }

        this.taulu.put("viitoset", summa);
    }

    public void kuutoset(Nopat nopat) {
        int summa = 0;
        for (Noppa noppa : nopat.getNopat()) {
            if (noppa.getArvo() == 6) {
                summa += 6;
            }
        }

        this.taulu.put("kuutoset", summa);
    }

    public int valisumma() {
        int valisumma = this.taulu.get("ykkoset") + this.taulu.get("kakkoset") + this.taulu.get("kolmoset") + this.taulu.get("neloset") + this.taulu.get("viitoset") + this.taulu.get("kuutoset");
        this.taulu.put("valisumma", valisumma);
        return valisumma;
    }

    public void bonus() {
        if (this.valisumma() >= 63) {
            this.taulu.put("bonus", 50);
        } else {
            this.taulu.put("bonus", 0);
        }
    }

    public void pari(Nopat nopat) {
        for (int i = 4; i > 0; i--) {
            if (nopat.getNopat().get(i).equals(nopat.getNopat().get(i - 1))) {
                this.taulu.put("pari", nopat.getNopat().get(i).getArvo() * 2);
                return;
            }
        }

        this.taulu.put("pari", 0);
    }

    public void kolmoisluku(Nopat nopat) {
        for (int i = 4; i > 0; i--) {
            if (nopat.getNopat().get(i).equals(nopat.getNopat().get(i - 1)) && nopat.getNopat().get(i).equals(nopat.getNopat().get(i - 2))) {
                this.taulu.put("kolmoisluku", nopat.getNopat().get(i).getArvo() * 3);
                return;
            }
        }

        this.taulu.put("kolmoisluku", 0);
    }

    public void neloisluku(Nopat nopat) {
        for (int i = 4; i > 0; i--) {
            if (nopat.getNopat().get(i).equals(nopat.getNopat().get(i - 1)) && nopat.getNopat().get(i).equals(nopat.getNopat().get(i - 2)) && nopat.getNopat().get(i).equals(nopat.getNopat().get(i - 3))) {
                this.taulu.put("neloisluku", nopat.getNopat().get(i).getArvo() * 4);
                return;
            }
        }

        this.taulu.put("neloisluku", 0);
    }
    
    public void yatzy(Nopat nopat) {
        int i = 4;
        if (nopat.getNoppa1() == nopat.getNoppa2() && nopat.getNoppa1() == nopat.getNoppa3() && nopat.getNoppa1() == nopat.getNoppa4() && nopat.getNoppa1() == nopat.getNoppa5()) {
            this.taulu.put("yatzy", 50);
        } else {
            this.taulu.put("yatzy", 0);
        }
    }
}
