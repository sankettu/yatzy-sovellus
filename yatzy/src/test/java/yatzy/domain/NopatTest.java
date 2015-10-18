package yatzy.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class NopatTest {

    Nopat nopat;

    public NopatTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        nopat = new Nopat();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void heitaKaikkiNopatJarjestysToimii() {
        nopat.heitaNopat();

        assertTrue(nopat.getNopat().get(0).getArvo() <= nopat.getNopat().get(1).getArvo() && nopat.getNopat().get(3).getArvo() <= nopat.getNopat().get(4).getArvo());
    }

    @Test
    public void arvojenSummaOikein() {
        nopat.getNopat().get(0).setArvo(1);
        nopat.getNopat().get(1).setArvo(3);
        nopat.getNopat().get(2).setArvo(5);
        nopat.getNopat().get(3).setArvo(6);
        nopat.getNopat().get(4).setArvo(6);

        assertEquals(21, nopat.arvojenSumma());
    }

    @Test
    public void lukitus1Toimii() {
        nopat.vaihdaLukitus1();
        assertTrue(nopat.getLukitus1());
    }

    @Test
    public void lukitus2Toimii() {
        nopat.vaihdaLukitus2();
        nopat.vaihdaLukitus2();
        nopat.vaihdaLukitus2();
        assertTrue(nopat.getLukitus2());
    }

    @Test
    public void lukitus3Toimii() {
        nopat.vaihdaLukitus3();
        nopat.vaihdaLukitus3();
        assertTrue(!nopat.getLukitus3());
    }

    @Test
    public void lukitus4Toimii() {
        nopat.vaihdaLukitus4();
        assertTrue(nopat.getLukitus4());
    }

    @Test
    public void lukitus5Toimii() {
        nopat.vaihdaLukitus5();
        nopat.vaihdaLukitus5();
        nopat.vaihdaLukitus5();
        assertTrue(nopat.getLukitus5());
    }

    @Test
    public void poistaLukituksetToimii() {
        nopat.vaihdaLukitus1();
        nopat.vaihdaLukitus3();
        nopat.vaihdaLukitus5();
        nopat.poistaLukitukset();

        assertTrue(!(nopat.getLukitus1() && nopat.getLukitus2() && nopat.getLukitus3() && nopat.getLukitus4() && nopat.getLukitus5()));
    }

}
