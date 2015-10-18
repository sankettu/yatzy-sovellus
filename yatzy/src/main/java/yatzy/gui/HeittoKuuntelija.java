/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yatzy.gui;

import yatzy.peli.Peli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Santeri
 */
public class HeittoKuuntelija implements ActionListener {

    private Peli peli;

    public HeittoKuuntelija(Peli peli) {
        this.peli = peli;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.peli.getHeittojaJaljella() == 3) {
            this.peli.getNopat().heitaKaikkiNopat();
            this.peli.kerranHeitetty();
            this.peli.getNopat().poistaLukitukset();
        } else if (this.peli.getHeittojaJaljella() > 0) {
            this.peli.getNopat().heitaNopat();
            this.peli.kerranHeitetty();
            this.peli.getNopat().poistaLukitukset();
        }
    }

}
