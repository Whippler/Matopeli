
import org.junit.*;
import static org.junit.Assert.*;
import matopeli.*;
/**
 *
 * @author Kalle
 */
public class kenttaTest {
    
    Kentta kentta = new Kentta();
    
    public kenttaTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void arvonOttaminen() {
        kentta.getArvo(3, 3);
        assertEquals(0, kentta.getArvo(3, 3));
        assertEquals(0, kentta.getArvo(6, 3));  
    }
    
    @Test
    public void arvonAsettaminen(){
        kentta.setArvo(4, 6, 2);
        assertEquals(2, kentta.getArvo(4, 6));
    }
    @Test
    public void omenanAsettaminen(){
        kentta.setArvo(6, 3, 0);
        kentta.setOmena();
        assertEquals(true, etsiOmena());
    }
    
    
    public boolean etsiOmena(){
        boolean arvo = false;
        
        for (int i = 0; i<kentta.getKorkeus(); i++){
            for (int j = 0; j<kentta.getLeveys(); j++){
                if (kentta.getArvo(i, j) == 2) arvo = true;
            }
        }
        return arvo;
    }
    
    
}
