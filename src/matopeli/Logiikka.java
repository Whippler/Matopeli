package matopeli;

import java.util.LinkedList;

public class Logiikka {

    Kentta classic = new Kentta();
    Mato ossi = new Mato();

    public Logiikka() {
    }

    public void asetaSuunta(String suunta) {
        ossi.suunta(suunta);
    }

    public void etene() {

        ossi.etene();

        LinkedList<Integer> X = ossi.getX();
        LinkedList<Integer> Y = ossi.getY();

        int ruutu = classic.getArvo(X.getFirst(), Y.getFirst());

        for (int i = 0; i < ossi.getPituus(); i++) {  //piirtää madon kentälle
            classic.setArvo(X.get(i), Y.get(i), 3);
        }

        classic.setArvo(X.size(), Y.size(), 0);  //poistaa hännän kentältä
        ossi.poista();                          //poistaa hännän madosta

    }
}
