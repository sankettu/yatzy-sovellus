package yatzy.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Collections;
import java.util.HashMap;

public class TulostauluTest {

    Tulostaulu tulostaulu;
    Nopat nopat;

    public TulostauluTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        tulostaulu = new Tulostaulu();
        nopat = new Nopat();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void ykkosetToimii() {
        nopat.getNopat().get(0).setArvo(1);
        nopat.getNopat().get(1).setArvo(1);
        nopat.getNopat().get(2).setArvo(1);
        nopat.getNopat().get(3).setArvo(6);
        nopat.getNopat().get(4).setArvo(6);

        tulostaulu.ykkoset(nopat);

        assertEquals(3, tulostaulu.getTulos("ykkoset"));
    }

    @Test
    public void kakkosetToimii() {
        nopat.getNopat().get(0).setArvo(1);
        nopat.getNopat().get(1).setArvo(2);
        nopat.getNopat().get(2).setArvo(3);
        nopat.getNopat().get(3).setArvo(5);
        nopat.getNopat().get(4).setArvo(6);

        tulostaulu.kakkoset(nopat);

        assertEquals(2, tulostaulu.getTulos("kakkoset"));
    }

    @Test
    public void kolmosetToimii() {
        nopat.getNopat().get(0).setArvo(3);
        nopat.getNopat().get(1).setArvo(3);
        nopat.getNopat().get(2).setArvo(3);
        nopat.getNopat().get(3).setArvo(3);
        nopat.getNopat().get(4).setArvo(6);

        tulostaulu.kolmoset(nopat);

        assertEquals(12, tulostaulu.getTulos("kolmoset"));
    }

    @Test
    public void nelosetToimii() {
        nopat.getNopat().get(0).setArvo(1);
        nopat.getNopat().get(1).setArvo(3);
        nopat.getNopat().get(2).setArvo(4);
        nopat.getNopat().get(3).setArvo(4);
        nopat.getNopat().get(4).setArvo(4);

        tulostaulu.neloset(nopat);

        assertEquals(12, tulostaulu.getTulos("neloset"));
    }

    @Test
    public void viitosetToimii() {
        nopat.getNopat().get(0).setArvo(5);
        nopat.getNopat().get(1).setArvo(5);
        nopat.getNopat().get(2).setArvo(5);
        nopat.getNopat().get(3).setArvo(5);
        nopat.getNopat().get(4).setArvo(5);

        tulostaulu.viitoset(nopat);

        assertEquals(25, tulostaulu.getTulos("viitoset"));
    }

    @Test
    public void kuutosetToimii() {
        nopat.getNopat().get(0).setArvo(3);
        nopat.getNopat().get(1).setArvo(5);
        nopat.getNopat().get(2).setArvo(6);
        nopat.getNopat().get(3).setArvo(6);
        nopat.getNopat().get(4).setArvo(6);

        tulostaulu.kuutoset(nopat);

        assertEquals(18, tulostaulu.getTulos("kuutoset"));
    }

    @Test
    public void kuutosetIlmanKuutosia() {
        nopat.getNopat().get(0).setArvo(1);
        nopat.getNopat().get(1).setArvo(2);
        nopat.getNopat().get(2).setArvo(4);
        nopat.getNopat().get(3).setArvo(5);
        nopat.getNopat().get(4).setArvo(5);

        tulostaulu.kuutoset(nopat);

        assertEquals(0, tulostaulu.getTulos("kuutoset"));
    }

    @Test
    public void pariToimii() {
        nopat.getNopat().get(0).setArvo(1);
        nopat.getNopat().get(1).setArvo(3);
        nopat.getNopat().get(2).setArvo(4);
        nopat.getNopat().get(3).setArvo(4);
        nopat.getNopat().get(4).setArvo(6);

        tulostaulu.pari(nopat);

        assertEquals(8, tulostaulu.getTulos("pari"));
    }

    @Test
    public void pariIlmanPariaToimii() {
        nopat.getNopat().get(0).setArvo(1);
        nopat.getNopat().get(1).setArvo(2);
        nopat.getNopat().get(2).setArvo(3);
        nopat.getNopat().get(3).setArvo(4);
        nopat.getNopat().get(4).setArvo(5);

        tulostaulu.pari(nopat);

        assertEquals(0, tulostaulu.getTulos("pari"));
    }

    @Test
    public void kolmoislukuToimii() {
        nopat.getNopat().get(0).setArvo(2);
        nopat.getNopat().get(1).setArvo(2);
        nopat.getNopat().get(2).setArvo(2);
        nopat.getNopat().get(3).setArvo(6);
        nopat.getNopat().get(4).setArvo(6);

        tulostaulu.kolmoisluku(nopat);

        assertEquals(6, tulostaulu.getTulos("kolmoisluku"));
    }

    @Test
    public void kolmoislukuIlmanKolmeaToimii() {
        nopat.getNopat().get(0).setArvo(2);
        nopat.getNopat().get(1).setArvo(3);
        nopat.getNopat().get(2).setArvo(4);
        nopat.getNopat().get(3).setArvo(6);
        nopat.getNopat().get(4).setArvo(4);

        tulostaulu.kolmoisluku(nopat);

        assertEquals(0, tulostaulu.getTulos("kolmoisluku"));
    }

    @Test
    public void neloislukuToimii() {
        nopat.getNopat().get(0).setArvo(5);
        nopat.getNopat().get(1).setArvo(5);
        nopat.getNopat().get(2).setArvo(5);
        nopat.getNopat().get(3).setArvo(5);
        nopat.getNopat().get(4).setArvo(6);

        tulostaulu.neloisluku(nopat);

        assertEquals(20, tulostaulu.getTulos("neloisluku"));
    }

    @Test
    public void yatzyToimii() {
        nopat.getNopat().get(0).setArvo(1);
        nopat.getNopat().get(1).setArvo(1);
        nopat.getNopat().get(2).setArvo(1);
        nopat.getNopat().get(3).setArvo(1);
        nopat.getNopat().get(4).setArvo(1);

        tulostaulu.yatzy(nopat);

        assertEquals(50, tulostaulu.getTulos("yatzy"));
    }

    @Test
    public void yatzyIlmanViitta() {
        nopat.getNopat().get(0).setArvo(1);
        nopat.getNopat().get(1).setArvo(1);
        nopat.getNopat().get(2).setArvo(1);
        nopat.getNopat().get(3).setArvo(1);
        nopat.getNopat().get(4).setArvo(4);

        tulostaulu.yatzy(nopat);

        assertEquals(0, tulostaulu.getTulos("yatzy"));
    }

    @Test
    public void pieniSuoraOikein() {
        nopat.getNopat().get(0).setArvo(1);
        nopat.getNopat().get(1).setArvo(2);
        nopat.getNopat().get(2).setArvo(3);
        nopat.getNopat().get(3).setArvo(4);
        nopat.getNopat().get(4).setArvo(5);

        tulostaulu.pieniSuora(nopat);

        assertEquals(15, tulostaulu.getTulos("pienisuora"));
    }

    @Test
    public void pieniSuoraVaarin() {
        nopat.getNopat().get(0).setArvo(1);
        nopat.getNopat().get(1).setArvo(2);
        nopat.getNopat().get(2).setArvo(3);
        nopat.getNopat().get(3).setArvo(4);
        nopat.getNopat().get(4).setArvo(6);

        tulostaulu.pieniSuora(nopat);

        assertEquals(0, tulostaulu.getTulos("pienisuora"));
    }

    @Test
    public void isoSuoraOikein() {
        nopat.getNopat().get(0).setArvo(2);
        nopat.getNopat().get(1).setArvo(3);
        nopat.getNopat().get(2).setArvo(4);
        nopat.getNopat().get(3).setArvo(5);
        nopat.getNopat().get(4).setArvo(6);

        tulostaulu.isoSuora(nopat);

        assertEquals(20, tulostaulu.getTulos("isosuora"));
    }

    @Test
    public void isoSuoraVaarin() {
        nopat.getNopat().get(0).setArvo(2);
        nopat.getNopat().get(1).setArvo(3);
        nopat.getNopat().get(2).setArvo(3);
        nopat.getNopat().get(3).setArvo(6);
        nopat.getNopat().get(4).setArvo(6);

        tulostaulu.isoSuora(nopat);

        assertEquals(0, tulostaulu.getTulos("isosuora"));
    }

    @Test
    public void sattumaToimii() {
        nopat.getNopat().get(0).setArvo(1);
        nopat.getNopat().get(1).setArvo(2);
        nopat.getNopat().get(2).setArvo(5);
        nopat.getNopat().get(3).setArvo(5);
        nopat.getNopat().get(4).setArvo(6);

        tulostaulu.sattuma(nopat);

        assertEquals(19, tulostaulu.getTulos("sattuma"));
    }

    @Test
    public void kaksiPariaToimii() {
        nopat.getNopat().get(0).setArvo(1);
        nopat.getNopat().get(1).setArvo(1);
        nopat.getNopat().get(2).setArvo(5);
        nopat.getNopat().get(3).setArvo(6);
        nopat.getNopat().get(4).setArvo(6);

        tulostaulu.kaksiParia(nopat);

        assertEquals(14, tulostaulu.getTulos("kaksiparia"));
    }

    @Test
    public void kaksiPariaVaarin() {
        nopat.getNopat().get(0).setArvo(1);
        nopat.getNopat().get(1).setArvo(1);
        nopat.getNopat().get(2).setArvo(3);
        nopat.getNopat().get(3).setArvo(4);
        nopat.getNopat().get(4).setArvo(5);

        tulostaulu.kaksiParia(nopat);

        assertEquals(0, tulostaulu.getTulos("kaksiparia"));
    }

    @Test
    public void kaksiPariaNeljaSamaa() {
        nopat.getNopat().get(0).setArvo(1);
        nopat.getNopat().get(1).setArvo(1);
        nopat.getNopat().get(2).setArvo(1);
        nopat.getNopat().get(3).setArvo(1);
        nopat.getNopat().get(4).setArvo(5);

        tulostaulu.kaksiParia(nopat);

        assertEquals(0, tulostaulu.getTulos("kaksiparia"));
    }

    @Test
    public void summaToimii() {
        nopat.getNopat().get(0).setArvo(1);
        nopat.getNopat().get(1).setArvo(1);
        nopat.getNopat().get(2).setArvo(1);
        nopat.getNopat().get(3).setArvo(1);
        nopat.getNopat().get(4).setArvo(1);

        tulostaulu.yatzy(nopat);
        tulostaulu.ykkoset(nopat);
        tulostaulu.pari(nopat);
        tulostaulu.sattuma(nopat);
        tulostaulu.kolmoisluku(nopat);
        tulostaulu.summa();
        tulostaulu.summa();

        assertEquals(65, tulostaulu.getTulos("summa"));
    }

    @Test
    public void summaIlmanTuloksia() {
        tulostaulu.summa();

        assertEquals(0, tulostaulu.getTulos("summa"));
    }

    @Test
    public void tayskasiToimii() {
        nopat.getNopat().get(0).setArvo(2);
        nopat.getNopat().get(1).setArvo(2);
        nopat.getNopat().get(2).setArvo(2);
        nopat.getNopat().get(3).setArvo(4);
        nopat.getNopat().get(4).setArvo(4);

        tulostaulu.tayskasi(nopat);

        assertEquals(14, tulostaulu.getTulos("tayskasi"));
    }

    @Test
    public void tayskasiVaarin() {
        nopat.getNopat().get(0).setArvo(2);
        nopat.getNopat().get(1).setArvo(3);
        nopat.getNopat().get(2).setArvo(2);
        nopat.getNopat().get(3).setArvo(5);
        nopat.getNopat().get(4).setArvo(4);

        tulostaulu.tayskasi(nopat);

        assertEquals(0, tulostaulu.getTulos("tayskasi"));
    }

    @Test
    public void tayskasiViidellaSamalla() {
        nopat.getNopat().get(0).setArvo(2);
        nopat.getNopat().get(1).setArvo(2);
        nopat.getNopat().get(2).setArvo(2);
        nopat.getNopat().get(3).setArvo(2);
        nopat.getNopat().get(4).setArvo(2);

        tulostaulu.tayskasi(nopat);

        assertEquals(0, tulostaulu.getTulos("tayskasi"));
    }

    @Test
    public void valisummaToimii() {
        nopat.getNopat().get(0).setArvo(1);
        nopat.getNopat().get(1).setArvo(2);
        nopat.getNopat().get(2).setArvo(3);
        nopat.getNopat().get(3).setArvo(4);
        nopat.getNopat().get(4).setArvo(5);

        tulostaulu.ykkoset(nopat);
        tulostaulu.kakkoset(nopat);
        tulostaulu.kolmoset(nopat);
        tulostaulu.neloset(nopat);
        tulostaulu.viitoset(nopat);
        tulostaulu.kuutoset(nopat);

        assertEquals(15, tulostaulu.valisumma());
    }

    @Test
    public void bonusYliRajan() {
        HashMap<String, Integer> taulu = tulostaulu.getTulostaulu();
        taulu.put("ykkoset", 4);
        taulu.put("kakkoset", 0);
        taulu.put("kolmoset", 9);
        taulu.put("neloset", 0);
        taulu.put("viitoset", 20);
        taulu.put("kuutoset", 30);

        tulostaulu.bonus();

        assertEquals(50, tulostaulu.getTulos("bonus"));
    }

    @Test
    public void bonusAlleRajan() {
        nopat.getNopat().get(0).setArvo(1);
        nopat.getNopat().get(1).setArvo(2);
        nopat.getNopat().get(2).setArvo(3);
        nopat.getNopat().get(3).setArvo(4);
        nopat.getNopat().get(4).setArvo(5);

        tulostaulu.ykkoset(nopat);
        tulostaulu.kakkoset(nopat);
        tulostaulu.kolmoset(nopat);
        tulostaulu.neloset(nopat);
        tulostaulu.viitoset(nopat);
        tulostaulu.kuutoset(nopat);

        tulostaulu.bonus();

        assertEquals(0, tulostaulu.getTulos("bonus"));
    }
}
