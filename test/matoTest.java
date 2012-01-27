

import org.junit.*;
import static org.junit.Assert.*;
import matopeli.*;

/**
 *
 * @author lammenoj
 */
public class matoTest {

    @Before
    public void setUp() {
    
    }
    
    Mato ossi = new Mato();
    
    @Test
    public void suunnanVaihto(){

        assertEquals(ossi.getSuunta(), "oikealle");
        ossi.suunta("alas");
        assertEquals(ossi.getSuunta(), "alas");
        
    }
    
    public void madonSijainti(){
        
    }
}
