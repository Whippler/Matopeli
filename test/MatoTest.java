
import org.junit.*;
import static org.junit.Assert.*;
import java.util.LinkedList;
import matopeli.Mato;

public class MatoTest {

    Mato ossi = new Mato();

    public MatoTest() {
    }

    @Before
    public void setUp() {
        ossi.alustaMato(5, 5);
    }

    @Test
    public void suunta() {
        assertEquals(ossi.getSuunta(), "oikealle");
    }

    @Test
    public void kaantyminen() {
        ossi.setSuunta("ylös");
        assertEquals("ylös", ossi.getSuunta());
        ossi.setSuunta("vasemmalle");
        assertEquals("vasemmalle", ossi.getSuunta());
    }

    @Test
    public void suunnanMuutosVastakkaiseenSuuntaan() {

        ossi.setSuunta("vasemmalle");
        assertEquals( "oikealle", ossi.getSuunta());

        ossi.setSuunta("ylös");
        ossi.setSuunta("alas");
        assertEquals("ylös", ossi.getSuunta());

        ossi.setSuunta("vasemmalle");
        ossi.setSuunta("oikealle");
        assertEquals("vasemmalle", ossi.getSuunta());

        ossi.setSuunta("alas");
        ossi.setSuunta("ylös");
        assertEquals("alas", ossi.getSuunta());

    }

    @Test
    public void eteneeOikealle() {
        ossi.etene();
        LinkedList x = ossi.getX();
        LinkedList y = ossi.getY();
        assertEquals(2, x.getFirst());
        assertEquals(5, y.getFirst());
    }

    @Test
    public void eteneeAlas() {
        ossi.setSuunta("alas");
        ossi.etene();
        LinkedList x = ossi.getX();
        LinkedList y = ossi.getY();
        assertEquals(3, x.getFirst());
        assertEquals(4, y.getFirst());
    }

    @Test
    public void eteneeVasemmalle() {
        ossi.setSuunta("alas");
        ossi.etene();
        ossi.setSuunta("vasemmalle");
        ossi.etene();
        LinkedList x = ossi.getX();
        LinkedList y = ossi.getY();
        assertEquals(3, x.getFirst());
        assertEquals(3, y.getFirst());
    }

    @Test
    public void eteneeYlos() {
        ossi.setSuunta("ylös");
        ossi.etene();
        LinkedList x = ossi.getX();
        LinkedList y = ossi.getY();
        assertEquals(1, x.getFirst());
        assertEquals(4, y.getFirst());
    }

    @Test
    public void eteneeReunanYliYlhäältä() {
        ossi.setSuunta("ylös");
        ossi.etene();
        ossi.etene();
        ossi.etene();
        LinkedList x = ossi.getX();
        LinkedList y = ossi.getY();
        assertEquals(5, x.getFirst());
        assertEquals(4, y.getFirst());
    }
    @Test
    public void eteneeReunanYliAlhaalta() {
        ossi.setSuunta("alas");
        ossi.etene();
        ossi.etene();
        ossi.etene();
        ossi.etene();
        LinkedList x = ossi.getX();
        LinkedList y = ossi.getY();
        assertEquals(0, x.getFirst());
        assertEquals(4, y.getFirst());
    }
    @Test
    public void eteneeReunanYliOikealta() {
        ossi.etene();
        ossi.etene();

        LinkedList x = ossi.getX();
        LinkedList y = ossi.getY();
        assertEquals(2, x.getFirst());
        assertEquals(0, y.getFirst());
    }
    @Test
    public void eteneeReunanYliVasemmalta() {
        ossi.setSuunta("alas");                
        ossi.etene();
        ossi.setSuunta("vasemmalle");
        ossi.etene();
        ossi.etene();
        ossi.etene();
        ossi.etene();
        ossi.etene();
        LinkedList x = ossi.getX();
        LinkedList y = ossi.getY();
        assertEquals(3, x.getFirst());
        assertEquals(5, y.getFirst());
    }

    @Test
    public void pituus() {
        assertEquals(3, ossi.getPituus());
    }

    @Test
    public void viimeisenPoisto() {
        LinkedList x1 = ossi.getX();
        LinkedList y1 = ossi.getY();

        ossi.poistaViimeinen();

        LinkedList x2 = ossi.getX();
        LinkedList y2 = ossi.getY();

        x1.removeLast();
        y2.removeLast();

        assertEquals(x1.getLast(), x2.getLast());
        assertEquals(y1.getLast(), y2.getLast());

    }
}
