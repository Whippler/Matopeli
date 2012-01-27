package matopeli;

import java.util.LinkedList;

/**
 * Tämä luokka toimii projektin sovelluslogiikkana
 *
 * @author lammenoj
 */
public class Logiikka {

    Kentta classic = new Kentta();
    Mato mato = new Mato();

    public Logiikka() {
    }

    /**
     * Tällä metodilla valitaan madolle etenemissuunta
     *
     * @param suunta Annetaan suunta merkkijonona, mihin mato on seuraavaksi
     * menossa
     */
    public void asetaSuunta(String suunta) {
        mato.suunta(suunta);
    }

    /**
     * Metodi siirtää matoa eteenpäin
     */
    public void etene() {

        mato.etene();

        LinkedList<Integer> X = mato.getX();
        LinkedList<Integer> Y = mato.getY();

        int ruutu = classic.getArvo(X.getFirst(), Y.getFirst());

        // poistaa hännän
        if (ruutu != 2) {
            classic.setArvo(X.getLast(), Y.getLast(), 0);
            mato.poista();
        }

            //arpoo uuden omenan kentälle
        
        // piirtää madon kentälle
        for (int i = 0; i < mato.getPituus() - 1; i++) {
            classic.setArvo(X.get(i), Y.get(i), 3);
        }

    }

    public void print() {
        classic.print();
    }
}
