/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yatzy.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import yatzy.peli.Peli;
import yatzy.domain.Pelaaja;
import javax.swing.SwingUtilities;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author Santeri
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Tulostaulu tulostaulu;
    private Peli peli;
    private PelaajienValinta valinta;

    public Kayttoliittyma(Peli peli) {
        this.peli = peli;
    }

    @Override
    public void run() {
        frame = new JFrame("Yatzy");
        frame.setPreferredSize(new Dimension(800, 800));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        this.valinta = new PelaajienValinta(this.peli);
        container.add(this.valinta, BorderLayout.NORTH);
    }

    public JFrame getFrame() {
        return frame;
    }

    public PelaajienValinta getValinta() {
        return this.valinta;
    }

    public Peli getPeli() {
        return this.peli;
    }

    public void lopetaPelaajienValinta() {
        this.frame.getContentPane().remove(valinta);
        this.frame.getContentPane().add(new Tulostaulu(this.peli));
        paivita();
        this.frame.revalidate();
        this.frame.repaint();
    }

    public void paivita() {
        this.frame.getContentPane().removeAll();
        this.frame.getContentPane().add(new Tulostaulu(this.peli));
        this.frame.getContentPane().add((new Noppataulu(this.peli)), BorderLayout.SOUTH);
        this.frame.revalidate();
        this.frame.repaint();
    }

    public void pelinVoittaja(Pelaaja pelaaja) {
        this.frame.getContentPane().removeAll();
        this.frame.getContentPane().add(new Tulostaulu(this.peli));
        this.frame.getContentPane().add(new JLabel("Pelin voittaja on " + pelaaja.getNimi() + "!"), BorderLayout.SOUTH);
        this.frame.revalidate();
        this.frame.repaint();
    }
}
