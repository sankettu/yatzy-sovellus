
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

}
