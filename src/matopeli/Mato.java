package matopeli;

import java.util.LinkedList;

public class Mato extends Kentta {

    private LinkedList<Integer> X = new LinkedList();
    private LinkedList<Integer> Y = new LinkedList();
    
    private String suunta;
    private int score;

    public void Mato() {
        X.add(2, 2);
        Y.add(2, 2);
        X.add(1, 3);
        Y.add(1, 2);
        X.add(0, 4);
        Y.add(0, 2);
        suunta = "oikealle";
    }

    public void vaihdaSuunta(String suunta) {
        this.suunta = suunta;
    }

    public void etene() {

        int xcord = X.getFirst();
        int ycord = Y.getFirst();

        if (this.suunta.equals("ylös")) {
            X.addFirst(ycord + 1);
            Y.addFirst(xcord);
        }
        if (this.suunta.equals("oikealle")) {
            X.addFirst(ycord);
            Y.addFirst(xcord + 1);
        }
        if (this.suunta.equals("alas")) {
            X.addFirst(ycord - 1);
            Y.addFirst(xcord);
        }
        if (this.suunta.equals("vasemmalle")) {
            X.addFirst(ycord);
            Y.addFirst(xcord - 1);
        }
        super.setArvo(X.peekFirst(), Y.peekFirst(), 3);
        super.setArvo(X.peekLast(), Y.peekLast(), 0);
        X.removeLast();
        Y.removeLast();

    }
}
