package yatzy.domain;

/**
 * Luokka Pelaaja-oliolle, jolla on nimi ja tulostaulu
 *
 * @author Santeri
 */
public class Pelaaja {

    private String nimi;
    private Tulostaulu taulu;

    public Pelaaja(String nimi) {
        this.taulu = new Tulostaulu();
        this.nimi = nimi;
    }

    public Tulostaulu getTaulu() {
        return this.taulu;
    }

    public String getNimi() {
        return this.nimi;
    }
}
