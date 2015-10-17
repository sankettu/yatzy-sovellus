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
public class NeloislukuKuuntelija implements ActionListener {

    private Peli peli;
    private Pelaaja pelaaja;

    public NeloislukuKuuntelija(Peli peli) {
        this.peli = peli;
        this.pelaaja = this.peli.getPelaajaVuorossa();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.pelaaja.getTaulu().getTulos("neloisluku") == -1 && this.peli.getHeittojaJaljella() != 3) {
            this.pelaaja.getTaulu().neloisluku(this.peli.getNopat());
            this.peli.tulosLaitettu();
            this.peli.getNopat().poistaLukitukset();
        }
    }

}
