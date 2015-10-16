/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yatzy.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JFrame;
import yatzy.peli.Peli;

/**
 *
 * @author Santeri
 */
public class PelaajaKuuntelija4 implements ActionListener {

    private Peli peli;
    private Kayttoliittyma kayttoliittyma;

    public PelaajaKuuntelija4(Peli peli) {
        this.peli = peli;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.peli.setPelaajienLkm(4);
        this.peli.luoPelaajat();
    }
}
