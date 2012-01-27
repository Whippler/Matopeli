

import org.junit.*;
import static org.junit.Assert.*;
import matopeli.*;

/**
 *
 * @author lammenoj
 */
public class matoTest {
    
    public matoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
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
