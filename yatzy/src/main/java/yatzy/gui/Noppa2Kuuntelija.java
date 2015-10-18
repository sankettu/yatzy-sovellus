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
public class Noppa2Kuuntelija implements ActionListener {

    private Peli peli;

    public Noppa2Kuuntelija(Peli peli) {
        this.peli = peli;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.peli.getNopat().vaihdaLukitus2();
    }

}
