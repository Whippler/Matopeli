package matopeli;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Luokka toteuttaa pisteiden hallinnan
 *
 * @author lammenoj
 */
public class Tilastot {

    private int uudetPisteet = 0;
    private ArrayList<Score> kaikki = new ArrayList();
    private File tiedosto = new File("matopeli_pisteet.txt");

    /**
     * Metodilla lisätään tulosta kun mato syö omenan
     */
    public Tilastot() {
//        tiedosto.createNewFile();
    }

    public void addPisteet() {
        uudetPisteet = uudetPisteet + 100;
    }

    /**
     *
     * @return palauttaa käynnissä olevan pelin pisteet
     */
    public int getPisteet() {
        return this.uudetPisteet;
    }

    public void luoPisteet(String nimi, String kentta, int nopeus) {
        Score uusi = new Score(nimi, kentta, uudetPisteet);
        kaikki.add(uusi);
    }

    public void nollaa() {
        uudetPisteet = 0;
        save();
    }

    public void save() {

        FileWriter tulos;
        try {
            tulos = new FileWriter(tiedosto);
            
            for (int i = 0; i < kaikki.size(); i++) {

                String nimi = kaikki.get(i).getNimi();
                String kentta = kaikki.get(i).getKentta();
                int pisteet = kaikki.get(i).getScore();

                tulos.write(nimi + "|" + kentta + "|" + pisteet);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Tilastot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void load() {
    }
}
