
package yatzy.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Collections;


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
    public void pariToimii() {
        nopat.getNopat().get(0).setArvo(1);
        nopat.getNopat().get(1).setArvo(2);
        nopat.getNopat().get(2).setArvo(4);
        nopat.getNopat().get(3).setArvo(6);
        nopat.getNopat().get(4).setArvo(6);
        
        tulostaulu.pari(nopat);
        
        assertEquals(12, tulostaulu.getTulos("pari"));
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

}
