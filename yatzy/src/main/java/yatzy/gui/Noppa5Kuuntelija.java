/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yatzy.gui;

import javax.swing.JFrame;
import yatzy.peli.Peli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Santeri
 */
public class Noppa5Kuuntelija implements ActionListener {

    private Peli peli;

    public Noppa5Kuuntelija(Peli peli) {
        this.peli = peli;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.peli.getNopat().vaihdaLukitus5();
    }

}
