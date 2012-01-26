package matopeli;

import java.util.*;

public class Mato extends Kentta {

    private LinkedList<Integer> X = new LinkedList<Integer>();
    private LinkedList<Integer> Y = new LinkedList<Integer>();
    private String suunta;

    public void Mato() {
        X.add(0, 2);
        Y.add(0, 2);
        X.addFirst(3);
        Y.addFirst(2);
        X.addFirst(4);
        Y.addFirst(2);
        suunta = "oikealle";
    }

    public void vaihdaSuunta(String suunta) {
        this.suunta = suunta;
    }

    public void etene() {

        int x = X.peekFirst();
        int y = Y.peekFirst();

        if (this.suunta.equals("ylös")) {
            X.addFirst(y + 1);
            Y.addFirst(x);
        }
        if (this.suunta.equals("oikealle")) {
            X.addFirst(y);
            Y.addFirst(x + 1);
        }
        if (this.suunta.equals("alas")) {
            X.addFirst(y - 1);
            Y.addFirst(x);
        }
        if (this.suunta.equals("vasemmalle")) {
            X.addFirst(y);
            Y.addFirst(x - 1);
        }
        super.setArvo(X.peekFirst(), Y.peekFirst(), 3);

        super.setArvo(X.peekLast(), Y.peekLast(), 0);
        X.removeLast();
        Y.removeLast();

    }
}
