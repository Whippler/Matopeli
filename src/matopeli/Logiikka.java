package matopeli;

import java.util.LinkedList;

/**
 * Tämä luokka toimii projektin sovelluslogiikkana
 *
 * @author lammenoj
 */
public class Logiikka {

    Kentta kentta = new Kentta();
    Mato mato = new Mato();
    Pisteet pisteet = new Pisteet();

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
    public boolean etene() {

        mato.etene();
        boolean arvo = true;
        LinkedList<Integer> X = mato.getX();
        LinkedList<Integer> Y = mato.getY();

        int ruutu = kentta.getArvo(X.getFirst(), Y.getFirst());

        // poistaa hännän
        if (ruutu != 2) {
            kentta.setArvo(X.getLast(), Y.getLast(), 0);
            mato.poistaViimeinen();
        } else if (ruutu == 2) {
            kentta.setOmena();
        }
        if (ruutu == 1 || ruutu == 3){
            arvo = false;
        }

        // asettaa madon kentälle
        for (int i = 0; i < mato.getPituus() - 1; i++) {
            kentta.setArvo(X.get(i), Y.get(i), 3);
        }
        
        return arvo;
    }

    public int[][] getKentta() {
        return kentta.getKentta();
    }

    public LinkedList getMatoX() {
        return mato.getX();
    }

    public LinkedList getMatoY() {
        return mato.getY();
    }
}
