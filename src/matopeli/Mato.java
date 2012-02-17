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
    private int maxY;
    private int maxX;
    private int nopeus;

    public Mato() {
    }

    public void alustaMato(int x, int y) {
        Y.clear();
        X.clear();

        maxX = x;
        maxY = y;

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
    public void setSuunta(String suunta) {
        if (this.suunta.equals("oikealle") && suunta.equals("vasemmalle")
                || this.suunta.equals("vasemmalle") && suunta.equals("oikealle")
                || this.suunta.equals("ylös") && suunta.equals("alas")
                || this.suunta.equals("alas") && suunta.equals("ylös")) {
            return;
        }
        this.suunta = suunta;
    }

    /**
     * Metodi siirtää matoa eteenpäin
     */
    public void etene() {

        int xcord = X.getFirst();
        int ycord = Y.getFirst();

        if (this.suunta.equals("oikealle")) {

            X.addFirst(xcord);
            if (ycord == maxX) {
                Y.addFirst(0);
            } else {
                Y.addFirst(ycord + 1);
            }

        } else if (this.suunta.equals("alas")) {

            if (xcord == maxY) {
                X.addFirst(0);
            } else {
                X.addFirst(xcord + 1);
            }
            Y.addFirst(ycord);

        } else if (this.suunta.equals("vasemmalle")) {

            X.addFirst(xcord);
            if (ycord == 0) {
                Y.addFirst(maxX);
            } else {
                Y.addFirst(ycord - 1);
            }

        } else if (this.suunta.equals("ylös")) {

            if (xcord == 0) {
                X.addFirst(maxY);
            } else {
                X.addFirst(xcord - 1);
            }
            Y.addFirst(ycord);
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

    public String getSuunta() {
        return suunta;
    }

    public int getNopeus() {
        return nopeus;
    }

    public void setNopeus(int nopeus) {
        this.nopeus = nopeus;
    }
}
