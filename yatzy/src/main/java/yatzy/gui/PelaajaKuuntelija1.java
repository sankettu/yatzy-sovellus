/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yatzy.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import yatzy.peli.Peli;

/**
 *
 * @author Santeri
 */
public class PelaajaKuuntelija1 implements ActionListener {

    private Peli peli;

    public PelaajaKuuntelija1(Peli peli) {
        this.peli = peli;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.peli.setPelaajienLkm(1);
        this.peli.luoPelaajat();
    }
}
