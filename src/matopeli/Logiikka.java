package matopeli;

import java.util.LinkedList;
/**
 * Tämä luokka toimii projektin sovelluslogiikkana
 * @author lammenoj
 */
public class Logiikka {

    Kentta classic = new Kentta();
    Mato ossi = new Mato();

    public Logiikka() {
    }
    /**
     * Tällä metodilla valitaan madolle etenemissuunta
     * @param suunta Annetaan suunta merkkijonona, mihin mato on seuraavaksi menossa
     */
    public void asetaSuunta(String suunta) {
        ossi.suunta(suunta);
    }
    /**
     * Metodi siirtää matoa eteenpäin
     */
    public void etene() {

        ossi.etene();

        LinkedList<Integer> X = ossi.getX();
        LinkedList<Integer> Y = ossi.getY();

        int ruutu = classic.getArvo(X.getFirst(), Y.getFirst());

        // piirtää madon kentälle
        for (int i = 0; i < ossi.getPituus()-1; i++) { 
            classic.setArvo(X.get(i), Y.get(i), 3);
        }
        
        // poistaa hännän
        if (ruutu==0){
        classic.setArvo(X.size(), Y.size(), 0);  //poistaa hännän kentältä
        ossi.poista(); //poistaa hännän madosta
        } else if (ruutu == 2) {
            //arpoo uuden omenan kentälle
        }

    }
}
