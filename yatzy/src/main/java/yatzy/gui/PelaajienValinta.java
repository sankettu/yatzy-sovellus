/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yatzy.gui;

import yatzy.peli.Peli;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;

/**
 *
 * @author Santeri
 */
public class PelaajienValinta extends JPanel {

    private Peli peli;


    public PelaajienValinta(Peli peli) {
        super(new GridLayout(1, 4));
        this.peli = peli;
        luoKomponentit();
    }

    private void luoKomponentit() {
        JButton nappi1 = new JButton("1 Pelaaja");
        JButton nappi2 = new JButton("2 Pelaajaa");
        JButton nappi3 = new JButton("3 Pelaajaa");
        JButton nappi4 = new JButton("4 Pelaajaa");

        nappi1.addActionListener(new PelaajaKuuntelija1(this.peli));
        nappi2.addActionListener(new PelaajaKuuntelija2(this.peli));
        nappi3.addActionListener(new PelaajaKuuntelija3(this.peli));
        nappi4.addActionListener(new PelaajaKuuntelija4(this.peli));

        add(nappi1);
        add(nappi2);
        add(nappi3);
        add(nappi4);
    }
}
