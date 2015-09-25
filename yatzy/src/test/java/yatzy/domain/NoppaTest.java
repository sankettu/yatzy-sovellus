package yatzy.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class NoppaTest {

    public NoppaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void nopanArvotOikein() {
        Noppa noppa = new Noppa();

        noppa.heita();

        assertTrue(0 < noppa.getArvo() && noppa.getArvo() < 7);
    }

    @Test
    public void compareToOikein() {
        Noppa noppa1 = new Noppa();
        Noppa noppa2 = new Noppa();
        noppa1.setArvo(5);
        noppa2.setArvo(2);

        assertTrue(noppa2.compareTo(noppa1) < 0);
    }

    @Test
    public void equalsOikein() {
        Noppa noppa1 = new Noppa();
        Noppa noppa2 = new Noppa();
        noppa1.setArvo(5);
        noppa2.setArvo(5);

        assertTrue(noppa1.equals(noppa2));
    }

    @Test
    public void equalsEriArvoilla() {
        Noppa noppa1 = new Noppa();
        Noppa noppa2 = new Noppa();
        noppa1.setArvo(1);
        noppa2.setArvo(5);

        assertTrue(!noppa1.equals(noppa2));
    }
}
