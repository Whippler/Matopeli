/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import matopeli.Logiikka;

/**
 *
 * @author Kalle
 */
public class LogiikkaTest {

    Logiikka peli = new Logiikka();

    public LogiikkaTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void kentanSaanti() {
        int[][] apu = peli.getKentta();
        assertEquals(1, apu[0][0]);
        assertEquals(3, apu[2][2]);

    }
    @Test
    public void suunnanAsettaminen(){
        peli.asetaSuunta("oikealle");
    }
    
    @Test
    public void eteneminen(){
        peli.etene();
    }        
}
