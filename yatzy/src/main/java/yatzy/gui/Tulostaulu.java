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
import javax.swing.JLabel;
import yatzy.domain.Pelaaja;

/**
 * Luokka luo taulukon pelaajien tuloksista ja tulosten sijoitusnapit
 * @author Santeri
 */
public class Tulostaulu extends JPanel {

    private Peli peli;

    public Tulostaulu(Peli peli) {
        super(new GridLayout(1, peli.getPelaajienLkm() + 2));
        this.peli = peli;
        luoKomponentit();
    }

    private JPanel luoTaulu() {
        JPanel panel = new JPanel(new GridLayout(19, 1));
        panel.add(new JLabel("Pelaajat"));
        panel.add(new JLabel("Ykköset"));
        panel.add(new JLabel("Kakkoset"));
        panel.add(new JLabel("Kolmoset"));
        panel.add(new JLabel("Neloset"));
        panel.add(new JLabel("Viitoset"));
        panel.add(new JLabel("Kuutoset"));
        panel.add(new JLabel("Välisumma"));
        panel.add(new JLabel("Bonus"));
        panel.add(new JLabel("Pari"));
        panel.add(new JLabel("Kaksi paria"));
        panel.add(new JLabel("Kolme samaa"));
        panel.add(new JLabel("Neljä samaa"));
        panel.add(new JLabel("Pieni suora"));
        panel.add(new JLabel("Iso suora"));
        panel.add(new JLabel("Täyskäsi"));
        panel.add(new JLabel("Sattuma"));
        panel.add(new JLabel("Yatzy"));
        panel.add(new JLabel("Summa"));

        return panel;
    }

    private void luoKomponentit() {
        add(luoTaulu());
        for (Pelaaja pelaaja : this.peli.getPelaajat()) {
            add(lisaaPelaajanTulokset(pelaaja));
        }
        add(lisaaTuloksenSijoitusNapit());
    }

    private JPanel lisaaPelaajanTulokset(Pelaaja pelaaja) {
        JPanel panel = new JPanel(new GridLayout(19, 1));
        panel.add(new JLabel(pelaaja.getNimi()));
        panel.add(new JLabel(getTulos(pelaaja, "ykkoset")));
        panel.add(new JLabel(getTulos(pelaaja, "kakkoset")));
        panel.add(new JLabel(getTulos(pelaaja, "kolmoset")));
        panel.add(new JLabel(getTulos(pelaaja, "neloset")));
        panel.add(new JLabel(getTulos(pelaaja, "viitoset")));
        panel.add(new JLabel(getTulos(pelaaja, "kuutoset")));
        panel.add(new JLabel(getTulos(pelaaja, "valisumma")));
        panel.add(new JLabel(getTulos(pelaaja, "bonus")));
        panel.add(new JLabel(getTulos(pelaaja, "pari")));
        panel.add(new JLabel(getTulos(pelaaja, "kaksiparia")));
        panel.add(new JLabel(getTulos(pelaaja, "kolmoisluku")));
        panel.add(new JLabel(getTulos(pelaaja, "neloisluku")));
        panel.add(new JLabel(getTulos(pelaaja, "pienisuora")));
        panel.add(new JLabel(getTulos(pelaaja, "isosuora")));
        panel.add(new JLabel(getTulos(pelaaja, "tayskasi")));
        panel.add(new JLabel(getTulos(pelaaja, "sattuma")));
        panel.add(new JLabel(getTulos(pelaaja, "yatzy")));
        panel.add(new JLabel(getTulos(pelaaja, "summa")));

        return panel;
    }

    private JPanel lisaaTuloksenSijoitusNapit() {
        JPanel panel = new JPanel(new GridLayout(19, 1));
        panel.add(new JLabel("Sijoita tulos:"));
        JButton nappi1 = new JButton("Ykköset");
        nappi1.addActionListener(new YkkosKuuntelija(this.peli));
        panel.add(nappi1);
        JButton nappi2 = new JButton("Kakkoset");
        nappi2.addActionListener(new KakkosKuuntelija(this.peli));
        panel.add(nappi2);
        JButton nappi3 = new JButton("Kolmoset");
        nappi3.addActionListener(new KolmosKuuntelija(this.peli));
        panel.add(nappi3);
        JButton nappi4 = new JButton("Neloset");
        nappi4.addActionListener(new NelosKuuntelija(this.peli));
        panel.add(nappi4);
        JButton nappi5 = new JButton("Viitoset");
        nappi5.addActionListener(new ViitosKuuntelija(this.peli));
        panel.add(nappi5);
        JButton nappi6 = new JButton("Kuutoset");
        nappi6.addActionListener(new KuutosKuuntelija(this.peli));
        panel.add(nappi6);
        panel.add(new JLabel("Välisumma"));
        panel.add(new JLabel("Bonus"));
        JButton nappi7 = new JButton("Pari");
        nappi7.addActionListener(new PariKuuntelija(this.peli));
        panel.add(nappi7);
        JButton nappi8 = new JButton("Kaksi paria");
        nappi8.addActionListener(new KaksiPariaKuuntelija(this.peli));
        panel.add(nappi8);
        JButton nappi9 = new JButton("Kolme samaa");
        nappi9.addActionListener(new KolmoislukuKuuntelija(this.peli));
        panel.add(nappi9);
        JButton nappi10 = new JButton("Neljä samaa");
        nappi10.addActionListener(new NeloislukuKuuntelija(this.peli));
        panel.add(nappi10);
        JButton nappi11 = new JButton("Pieni suora");
        nappi11.addActionListener(new PieniSuoraKuuntelija(this.peli));
        panel.add(nappi11);
        JButton nappi12 = new JButton("Iso suora");
        nappi12.addActionListener(new IsoSuoraKuuntelija(this.peli));
        panel.add(nappi12);
        JButton nappi13 = new JButton("Täyskäsi");
        nappi13.addActionListener(new TayskasiKuuntelija(this.peli));
        panel.add(nappi13);
        JButton nappi14 = new JButton("Sattuma");
        nappi14.addActionListener(new SattumaKuuntelija(this.peli));
        panel.add(nappi14);
        JButton nappi15 = new JButton("Yatzy");
        nappi15.addActionListener(new YatzyKuuntelija(this.peli));
        panel.add(nappi15);
        panel.add(new JLabel("Summa"));

        return panel;
    }

    private String getTulos(Pelaaja pelaaja, String tulos) {
        if (pelaaja.getTaulu().getTulos(tulos) == -1) {
            return "-";
        }

        return String.valueOf(pelaaja.getTaulu().getTulos(tulos));
    }
}
