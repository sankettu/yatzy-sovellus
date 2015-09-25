
package yatzy.domain;

import java.util.Random;

public class Noppa implements Comparable<Noppa> {
    
    private Random random;
    private int arvo;
    
    public Noppa() {
        this.random = new Random();
    }
    
    public void heita() {
        this.arvo = this.random.nextInt(6) + 1;
    }
    
    public int getArvo() {
        return this.arvo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Noppa other = (Noppa) obj;
        if (this.arvo != other.arvo) {
            return false;
        }
        return true;
    }
    
    public void setArvo(int arvo) {
        this.arvo = arvo;
    }

    @Override
    public int compareTo(Noppa o) {
        return this.getArvo() - o.getArvo();
    }
}
