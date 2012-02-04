
import org.junit.*;
import static org.junit.Assert.*;
import matopeli.*;

public class MatopeliTest {

    Mato ossi = new Mato();
    Kentta kentta = new Kentta();
    Logiikka peli = new Logiikka();

    public MatopeliTest() {
    }

    @Before
    public void setUp() {
        ossi.alustaMato(5, 5);
    }

    // LUOKAN MATO TESTIT
    // -------------------------------------------------------------------------
    
    @Test
    public void suunta() {
        assertEquals(ossi.getSuunta(), "oikealle");
    }
    
    @Test
    public void kaantyminen() {
        ossi.setSuunta("ylös");
        assertEquals(ossi.getSuunta(), "ylös");
        ossi.setSuunta("vasemmalle");
        assertEquals(ossi.getSuunta(), "vasemmalle");
    }
    
    @Test
    public void suunnanMuutosVastakkaiseenSuuntaan() {        
        ossi.setSuunta("vasemmalle");
        assertEquals(ossi.getSuunta(), "oikealle");
        ossi.setSuunta("ylös");
        ossi.setSuunta("alas");
        assertEquals(ossi.getSuunta(), "ylös");
    }
    
    @Test
    public void madonAlustus() {
        
    }
}
