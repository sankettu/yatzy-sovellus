/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yatzy.peli;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import yatzy.domain.Pelaaja;

/**
 *
 * @author Santeri
 */
public class PeliTest {

    Peli peli;

    public PeliTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        peli = new Peli();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void luoPelaajatLkmToimii() {
        peli.setPelaajienLkm(4);
        peli.luoPelaajat();
        int pelaajia = 0;
        for (Pelaaja pelaaja : peli.getPelaajat()) {
            pelaajia++;
        }

        assertEquals(4, pelaajia);
    }

    @Test
    public void luoPelaajatPelaajaVuorossaToimii() {
        peli.setPelaajienLkm(3);
        peli.luoPelaajat();

        assertEquals(peli.getPelaajaVuorossa(), peli.getPelaajat().get(0));
    }

    @Test
    public void tulosLaitettuAlussaFalse() {
        assertTrue(!peli.getTulosLaitettu());
    }

    @Test
    public void tulosLaitettuToimii() {
        peli.tulosLaitettu();

        assertTrue(peli.getTulosLaitettu());
    }

    @Test
    public void kerranHeitettyToimii() {
        peli.kerranHeitetty();

        assertEquals(2, peli.getHeittojaJaljella());
    }

    @Test
    public void getNopatToimii() {
        assertTrue(peli.getNopat() != null);
    }

    @Test
    public void getPelaajienLkmToimii() {
        peli.setPelaajienLkm(2);

        assertEquals(2, peli.getPelaajienLkm());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
