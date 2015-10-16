package yatzy.domain;

import java.util.HashMap;

/**
 * Luokka tulostaulu pisteyttää pelaajan heittotulokset taulukkoon
 *
 * @author Santeri
 */
public class Tulostaulu {

    private HashMap<String, Integer> taulu;

    public Tulostaulu() {
        this.taulu = new HashMap<String, Integer>();
    }

    public int getTulos(String tulos) {
        if (this.taulu.get(tulos) == null) {
            return -1;
        }
        return this.taulu.get(tulos);
    }

    public HashMap<String, Integer> getTulostaulu() {
        return this.taulu;
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
        int valisumma = 0;
        if (this.taulu.get("ykkoset") != null) {
            valisumma += this.taulu.get("ykkoset");
        }

        if (this.taulu.get("kakkoset") != null) {
            valisumma += this.taulu.get("kakkoset");
        }

        if (this.taulu.get("kolmoset") != null) {
            valisumma += this.taulu.get("kolmoset");
        }

        if (this.taulu.get("neloset") != null) {
            valisumma += this.taulu.get("neloset");
        }

        if (this.taulu.get("viitoset") != null) {
            valisumma += this.taulu.get("viitoset");
        }

        if (this.taulu.get("kuutoset") != null) {
            valisumma += this.taulu.get("kuutoset");
        }
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
        for (int i = 4; i > 1; i--) {
            if (nopat.getNopat().get(i).equals(nopat.getNopat().get(i - 1)) && nopat.getNopat().get(i).equals(nopat.getNopat().get(i - 2))) {
                this.taulu.put("kolmoisluku", nopat.getNopat().get(i).getArvo() * 3);
                return;
            }
        }

        this.taulu.put("kolmoisluku", 0);
    }

    public void neloisluku(Nopat nopat) {
        for (int i = 4; i > 2; i--) {
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

    public void pieniSuora(Nopat nopat) {
        int silmaluku = 1;
        int summa = 0;
        for (Noppa noppa : nopat.getNopat()) {
            if (noppa.getArvo() != silmaluku) {
                summa = 0;
                break;
            } else {
                summa += silmaluku;
                silmaluku++;
            }
        }

        this.taulu.put("pienisuora", summa);
    }

    public void isoSuora(Nopat nopat) {
        int silmaluku = 2;
        int summa = 0;
        for (Noppa noppa : nopat.getNopat()) {
            if (noppa.getArvo() != silmaluku) {
                summa = 0;
                break;
            } else {
                summa += silmaluku;
                silmaluku++;
            }
        }

        this.taulu.put("isosuora", summa);
    }

    public void sattuma(Nopat nopat) {
        int summa = 0;
        for (Noppa noppa : nopat.getNopat()) {
            summa += noppa.getArvo();
        }

        this.taulu.put("sattuma", summa);
    }

    public void kaksiParia(Nopat nopat) {
        int ensimmainenPari = 0;
        int toinenPari = 0;
        int summa = 0;
        for (int i = 4; i > 0; i--) {
            if (ensimmainenPari == 0) {
                if (nopat.getNopat().get(i).equals(nopat.getNopat().get(i - 1))) {
                    ensimmainenPari = nopat.getNopat().get(i).getArvo();
                    i--;
                }
            } else {
                if (nopat.getNopat().get(i).equals(nopat.getNopat().get(i - 1)) && nopat.getNopat().get(i).getArvo() != ensimmainenPari) {
                    toinenPari = nopat.getNopat().get(i).getArvo();
                    break;
                }
            }
        }

        if (toinenPari != 0 && ensimmainenPari != 0) {
            summa = (2 * ensimmainenPari) + (2 * toinenPari);
        }

        this.taulu.put("kaksiparia", summa);
    }

    public void summa() {
        int summa = 0;
        for (String key : this.taulu.keySet()) {
            if (key.equals("summa") || key.equals("valisumma")) {
                continue;
            }
            if (this.taulu.get(key) != null) {
                summa += this.taulu.get(key);
            }
        }

        this.taulu.put("summa", summa);
    }

    public void tayskasi(Nopat nopat) {
        int summa = 0;
        int kolmeSamaa = 0;
        int pari = 0;
        for (int i = 4; i > 1; i--) {
            if (nopat.getNopat().get(i).equals(nopat.getNopat().get(i - 1)) && nopat.getNopat().get(i).equals(nopat.getNopat().get(i - 2))) {
                kolmeSamaa = nopat.getNopat().get(i).getArvo();
                break;
            }
        }

        for (int i = 4; i > 0; i--) {
            if (nopat.getNopat().get(i).equals(nopat.getNopat().get(i - 1)) && nopat.getNopat().get(i).getArvo() != kolmeSamaa) {
                pari = nopat.getNopat().get(i).getArvo();
                break;
            }
        }

        if (kolmeSamaa != 0 && pari != 0) {
            summa = (3 * kolmeSamaa) + (2 * pari);
        }

        this.taulu.put("tayskasi", summa);
    }
}
