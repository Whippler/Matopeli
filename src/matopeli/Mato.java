package matopeli;

import java.util.LinkedList;

/**
 * Luokka toteuttaa Madon ominaisuudet
 *
 * @author lammenoj
 */
public class Mato {

    private LinkedList<Integer> X = new LinkedList();
    private LinkedList<Integer> Y = new LinkedList();
    private String suunta;

    public Mato() {
        this.alustaMato();
    }

    public void alustaMato() {
        Y.clear();
        X.clear();

        Y.add(0, 4);
        X.add(0, 2);
        Y.add(1, 3);
        X.add(1, 2);
        Y.add(2, 2);
        X.add(2, 2);
        suunta = "oikealle";
    }

    /**
     * Metodi asettaa madolle suunnan
     *
     * @param suunta merkkijono joka kuvaa suuntaa
     */
    public void suunta(String suunta) {
        this.suunta = suunta;
    }

    /**
     * Metodi siirtää matoa eteenpäin
     */
    public void etene() {

        int xcord = X.getFirst();
        int ycord = Y.getFirst();

        if (this.suunta.equals("alas")) {

            if (xcord == 21) {
                X.addFirst(0);
            } else {
                X.addFirst(xcord + 1);
            }

            Y.addFirst(ycord);
        }
        if (this.suunta.equals("oikealle")) {

            X.addFirst(xcord);

            if (ycord == 21) {
                Y.addFirst(0);
            } else {
                Y.addFirst(ycord + 1);
            }
        }
        if (this.suunta.equals("ylös")) {

            if (xcord == 0) {
                X.addFirst(21);
            } else {
                X.addFirst(xcord - 1);
            }
            Y.addFirst(ycord);
        }
        if (this.suunta.equals("vasemmalle")) {
            X.addFirst(xcord);

            if (ycord == 0) {
                Y.addFirst(21);
            } else {
                Y.addFirst(ycord - 1);
            }
        }
    }

    /**
     * Metodi poistaa madon hännän
     */
    public void poistaViimeinen() {
        X.removeLast();
        Y.removeLast();
    }

    /**
     * Metodi palauttaa madon X koordinaatit
     *
     * @return Palauttaa madon X koordinaatit
     */
    public LinkedList getX() {
        return X;
    }

    /**
     * Metodi palauttaa madon Y koordinaatit
     *
     * @return Palauttaa madon Y koordinaatit
     */
    public LinkedList getY() {
        return Y;
    }

    /**
     *
     * @return Palauttaa madon pituuden
     */
    public int getPituus() {
        return X.size();
    }

    public String getSuunta() {
        return suunta;
    }
}
