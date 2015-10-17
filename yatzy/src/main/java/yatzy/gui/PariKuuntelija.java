/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yatzy.gui;

import javax.swing.JFrame;
import yatzy.peli.Peli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import yatzy.domain.Tulostaulu;
import yatzy.domain.Pelaaja;

/**
 *
 * @author Santeri
 */
public class PariKuuntelija implements ActionListener {

    private Peli peli;
    private Pelaaja pelaaja;

    public PariKuuntelija(Peli peli) {
        this.peli = peli;
        this.pelaaja = this.peli.getPelaajaVuorossa();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.pelaaja.getTaulu().getTulos("pari") == -1 && this.peli.getHeittojaJaljella() != 3) {
            this.pelaaja.getTaulu().pari(this.peli.getNopat());
            this.peli.tulosLaitettu();
            this.peli.getNopat().poistaLukitukset();
        }
    }

}
