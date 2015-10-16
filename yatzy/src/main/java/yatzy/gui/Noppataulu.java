/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yatzy.gui;

import javax.swing.JPanel;
import yatzy.peli.Peli;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import yatzy.domain.Nopat;
import javax.swing.JCheckBox;
import yatzy.domain.Pelaaja;

/**
 *
 * @author Santeri
 */
public class Noppataulu extends JPanel {

    private Peli peli;

    public Noppataulu(Peli peli) {
        super(new GridLayout(3, 6));
        this.peli = peli;
        luoKomponentit();
    }

    private void luoKomponentit() {
        add(noppienTulokset());
        add(noppienHeittoNapit());
        add(new JLabel("Vuorossa: " + this.peli.getPelaajaVuorossa().getNimi()));
    }

    public JPanel noppienTulokset() {
        JPanel panel = new JPanel(new GridLayout(1, 6));
        JLabel kentta1 = new JLabel("Nopat:");
        panel.add(kentta1);
        JLabel kentta2 = new JLabel(String.valueOf(this.peli.getNopat().getNoppa1()));
        panel.add(kentta2);
        JLabel kentta3 = new JLabel(String.valueOf(this.peli.getNopat().getNoppa2()));
        panel.add(kentta3);
        JLabel kentta4 = new JLabel(String.valueOf(this.peli.getNopat().getNoppa3()));
        panel.add(kentta4);
        JLabel kentta5 = new JLabel(String.valueOf(this.peli.getNopat().getNoppa4()));
        panel.add(kentta5);
        JLabel kentta6 = new JLabel(String.valueOf(this.peli.getNopat().getNoppa5()));
        panel.add(kentta6);

        return panel;
    }

    public JPanel noppienHeittoNapit() {
        JPanel panel = new JPanel(new GridLayout(1, 7));
        JLabel kentta1 = new JLabel("Lukitse:");
        panel.add(kentta1);
        JCheckBox nappi1 = new JCheckBox("Noppa 1");
        nappi1.addActionListener(new Noppa1Kuuntelija(this.peli));
        panel.add(nappi1);
        JCheckBox nappi2 = new JCheckBox("Noppa 2");
        nappi2.addActionListener(new Noppa2Kuuntelija(this.peli));
        panel.add(nappi2);
        JCheckBox nappi3 = new JCheckBox("Noppa 3");
        nappi3.addActionListener(new Noppa3Kuuntelija(this.peli));
        panel.add(nappi3);
        JCheckBox nappi4 = new JCheckBox("Noppa 4");
        nappi4.addActionListener(new Noppa4Kuuntelija(this.peli));
        panel.add(nappi4);
        JCheckBox nappi5 = new JCheckBox("Noppa 5");
        nappi5.addActionListener(new Noppa5Kuuntelija(this.peli));
        panel.add(nappi5);
        JButton nappi6 = new JButton("Heitä nopat");
        nappi6.addActionListener(new HeittoKuuntelija(this.peli));
        panel.add(nappi6);

        return panel;
    }

}
