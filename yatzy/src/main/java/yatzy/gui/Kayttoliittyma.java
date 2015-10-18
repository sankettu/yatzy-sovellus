/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yatzy.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import yatzy.peli.Peli;
import yatzy.domain.Pelaaja;
import javax.swing.JLabel;

/**
 * Pelin graafinen käyttöliittymä näyttää pelaajille pelin kulun
 * @author Santeri
 */
public class Kayttoliittyma implements Runnable, Paivitettava {

    private JFrame frame;
    private Peli peli;

    public Kayttoliittyma(Peli peli) {
        this.peli = peli;
    }

    @Override
    public void run() {
        frame = new JFrame("Yatzy");
        frame.setPreferredSize(new Dimension(700, 600));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.add(new PelaajienValinta(this.peli));
    }

    public JFrame getFrame() {
        return frame;
    }

    public Peli getPeli() {
        return this.peli;
    }

    @Override
    public void paivita() {
        this.frame.getContentPane().removeAll();
        this.frame.getContentPane().add(new Tulostaulu(this.peli));
        this.frame.getContentPane().add((new Noppataulu(this.peli)), BorderLayout.SOUTH);
        this.frame.revalidate();
        this.frame.repaint();
    }

    public void pelinVoittaja(Pelaaja pelaaja) {
        this.frame.getContentPane().removeAll();
        this.frame.getContentPane().add(new Tulostaulu(this.peli), BorderLayout.CENTER);
        this.frame.getContentPane().add(new JLabel("Voittaja on " + pelaaja.getNimi() + " tuloksella " + pelaaja.getTaulu().getTulos("summa") + "!"), BorderLayout.NORTH);
        this.frame.revalidate();
        this.frame.repaint();
    }
}
