
package yatzy.domain;

import java.util.Random;

public class Noppa {
    
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
}
