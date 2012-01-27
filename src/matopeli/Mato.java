package matopeli;

import java.util.LinkedList;

public class Mato {

    private LinkedList<Integer> X = new LinkedList();
    private LinkedList<Integer> Y = new LinkedList();
    private String suunta;

    public Mato() {
        Y.add(0, 4);
        X.add(0, 2);
        Y.add(1, 3);
        X.add(1, 2);
        Y.add(2, 2);
        X.add(2, 2);
        suunta = "oikealle";
    }

    public void suunta(String suunta) {
        this.suunta = suunta;
    }

    public void etene() {

        int xcord = X.getFirst();
        int ycord = Y.getFirst();

        if (this.suunta.equals("alas")) {
            X.addFirst(xcord + 1);
            Y.addFirst(ycord);
        }
        if (this.suunta.equals("oikealle")) {
            X.addFirst(xcord);
            Y.addFirst(ycord + 1);
        }
        if (this.suunta.equals("ylös")) {
            X.addFirst(xcord - 1);
            Y.addFirst(ycord);
        }
        if (this.suunta.equals("vasemmalle")) {
            X.addFirst(xcord);
            Y.addFirst(ycord - 1);
        }
        

    }

    public void poista() {
        X.removeLast();
        Y.removeLast();
    }

    public LinkedList getX() {
        return X;
    }

    public LinkedList getY() {
        return Y;
    }

    public int getPituus() {
        return X.size();
    }
}
