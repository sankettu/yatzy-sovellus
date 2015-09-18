package yatzy.domain;

import java.util.HashMap;

public class Tulostaulu {

    private HashMap<String, Integer> taulu;

    public Tulostaulu() {
        this.taulu = new HashMap<String, Integer>();
    }

    public void ykkoset(Nopat nopat) {
        int summa = 0;
        if (nopat.getNoppa1() == 1) {
            summa++;
        }

        if (nopat.getNoppa2() == 1) {
            summa++;
        }
        
        if (nopat.getNoppa3() == 1) {
            summa++;
        }
        
        if (nopat.getNoppa4() == 1) {
            summa++;
        }
        
        if (nopat.getNoppa5() == 1) {
            summa++;
        }
        
        this.taulu.put("ykkoset", summa);
    }
    
    public void kakkoset(Nopat nopat) {
        int summa = 0;
        if (nopat.getNoppa1() == 2) {
            summa += 2;
        }

        if (nopat.getNoppa2() == 2) {
            summa += 2;
        }
        
        if (nopat.getNoppa3() == 2) {
            summa += 2;
        }
        
        if (nopat.getNoppa4() == 2) {
            summa += 2;
        }
        
        if (nopat.getNoppa5() == 2) {
            summa += 2;
        }
        
        this.taulu.put("kakkoset", summa);
    }
    
    public void kolmoset(Nopat nopat) {
        int summa = 0;
        if (nopat.getNoppa1() == 3) {
            summa += 3;
        }

        if (nopat.getNoppa2() == 3) {
            summa += 3;
        }
        
        if (nopat.getNoppa3() == 3) {
            summa += 3;
        }
        
        if (nopat.getNoppa4() == 3) {
            summa += 3;
        }
        
        if (nopat.getNoppa5() == 3) {
            summa += 3;
        }
        
        this.taulu.put("kolmoset", summa);
    }
    
    public void neloset(Nopat nopat) {
        int summa = 0;
        if (nopat.getNoppa1() == 4) {
            summa += 4;
        }

        if (nopat.getNoppa2() == 4) {
            summa += 4;
        }
        
        if (nopat.getNoppa3() == 4) {
            summa += 4;
        }
        
        if (nopat.getNoppa4() == 4) {
            summa += 4;
        }
        
        if (nopat.getNoppa5() == 4) {
            summa += 4;
        }
        
        this.taulu.put("neloset", summa);
    }
    
    public void viitoset(Nopat nopat) {
        int summa = 0;
        if (nopat.getNoppa1() == 5) {
            summa += 5;
        }

        if (nopat.getNoppa2() == 5) {
            summa += 5;
        }
        
        if (nopat.getNoppa3() == 5) {
            summa += 5;
        }
        
        if (nopat.getNoppa4() == 5) {
            summa += 5;
        }
        
        if (nopat.getNoppa5() == 5) {
            summa += 5;
        }
        
        this.taulu.put("viitoset", summa);
    }
    
    public void kuutoset(Nopat nopat) {
        int summa = 0;
        if (nopat.getNoppa1() == 6) {
            summa += 6;
        }

        if (nopat.getNoppa2() == 6) {
            summa += 6;
        }
        
        if (nopat.getNoppa3() == 6) {
            summa += 6;
        }
        
        if (nopat.getNoppa4() == 6) {
            summa += 6;
        }
        
        if (nopat.getNoppa5() == 6) {
            summa += 6;
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
        
    }
}
