
import matopeli.Kentta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kalle
 */
public class KenttaTest {
    
    Kentta kentta = new Kentta();
    
    public KenttaTest() {
        kentta.alustaKentta("classic");
    }

    @Before
    public void setUp() {
    }

    @Test
    public void arvonHaku(){
        assertEquals(1, kentta.getArvo(0, 0));
    }
    @Test
    public void arvonAsettaminen(){
        kentta.setArvo(5, 5, 3);
        assertEquals(3, kentta.getArvo(5, 5));
    }
    @Test
    public void leveydenHaku(){
        assertEquals(22, kentta.getLeveys());
    }
    @Test
    public void korkeudenHaku(){
        assertEquals(22, kentta.getKorkeus());
    }
    @Test
    public void kentanHaku(){
        int[][] apu = kentta.getKentta();
        assertEquals(1, apu[0][10]);
        assertEquals(3, apu[2][2]);
    }
}
