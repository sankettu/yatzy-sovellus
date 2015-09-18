
package yatzy.domain;


public class Pelaaja {
    
    private String nimi;
    private Tulostaulu taulu;
    
    public Pelaaja(String nimi) {
        this.nimi = nimi;
    }
    
    public Tulostaulu getTaulu() {
        return this.taulu;
    }
    
    public String getNimi() {
        return this.nimi;
    }
}
