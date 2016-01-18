/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yatzy.gui;

import yatzy.peli.Peli;
import java.awt.GridLayout;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JCheckBox;

/**
 * Noppataulu näyttää pelaajille noppien tulokset ja luo napit noppien
 * lukitsemiseen ja heittämiseen
 *
 * @author Santeri
 */
public class Noppataulu extends JPanel {

    private Peli peli;
    private ImageIcon[] kuvat;

    public Noppataulu(Peli peli) {
        super(new GridLayout(3, 7));
        this.peli = peli;
        this.kuvat = new ImageIcon[7];
        lisaaKuvat();
        luoKomponentit();
    }

    private void lisaaKuvat() {
        for (int i = 1; i < 7; i++) {
            try {
                ImageIcon image = new ImageIcon((ImageIO.read(getClass().getResourceAsStream(i + ".png"))));
                this.kuvat[i] = image;
            } catch (Exception e) {
                System.out.println("File not found!");
            }
        }
    }

    private JLabel nopanTulos(int arvo) {
        if (arvo == -1) {
            return new JLabel("");
        } else {
            return new JLabel(this.kuvat[arvo]);
        }
    }

    private void luoKomponentit() {
        add(noppienTulokset());
        add(noppienHeittoNapit());
        add(pelaajaVuorossa());
    }

    private JPanel noppienTulokset() {
        JPanel panel = new JPanel(new GridLayout(1, 7));
        JLabel kentta1 = new JLabel("Nopat");
        panel.add(kentta1);
        JLabel kentta2 = nopanTulos(this.peli.getNopat().getNoppa1());
        panel.add(kentta2);
        JLabel kentta3 = nopanTulos(this.peli.getNopat().getNoppa2());
        panel.add(kentta3);
        JLabel kentta4 = nopanTulos(this.peli.getNopat().getNoppa3());
        panel.add(kentta4);
        JLabel kentta5 = nopanTulos(this.peli.getNopat().getNoppa4());
        panel.add(kentta5);
        JLabel kentta6 = nopanTulos(this.peli.getNopat().getNoppa5());
        panel.add(kentta6);
        JLabel kentta7 = new JLabel("");
        panel.add(kentta7);

        return panel;
    }

    private JPanel noppienHeittoNapit() {
        JPanel panel = new JPanel(new GridLayout(1, 7));
        JLabel kentta1 = new JLabel("Lukitse");
        panel.add(kentta1);
        JCheckBox nappi1 = new JCheckBox();
        nappi1.addActionListener(new Noppa1Kuuntelija(this.peli));
        panel.add(nappi1);
        JCheckBox nappi2 = new JCheckBox();
        nappi2.addActionListener(new Noppa2Kuuntelija(this.peli));
        panel.add(nappi2);
        JCheckBox nappi3 = new JCheckBox();
        nappi3.addActionListener(new Noppa3Kuuntelija(this.peli));
        panel.add(nappi3);
        JCheckBox nappi4 = new JCheckBox();
        nappi4.addActionListener(new Noppa4Kuuntelija(this.peli));
        panel.add(nappi4);
        JCheckBox nappi5 = new JCheckBox();
        nappi5.addActionListener(new Noppa5Kuuntelija(this.peli));
        panel.add(nappi5);
        JButton nappi6 = new JButton("Heitä");
        nappi6.addActionListener(new HeittoKuuntelija(this.peli));
        panel.add(nappi6);

        return panel;
    }

    private JPanel pelaajaVuorossa() {
        JPanel panel = new JPanel(new GridLayout(1, 3));
        panel.add(new JLabel("Vuorossa:"));
        panel.add(new JLabel(this.peli.getPelaajaVuorossa().getNimi()));
        panel.add(new JLabel(""));

        return panel;
    }

}
