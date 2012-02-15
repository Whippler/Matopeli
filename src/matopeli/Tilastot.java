package matopeli;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
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
    private static Scanner lukija = new Scanner(System.in);

    /**
     * Metodilla lisätään tulosta kun mato syö omenan
     */
    public Tilastot() {
        try {
            tiedosto.createNewFile();
        } catch (IOException ex) {
//            Logger.getLogger(Tilastot.class.getName()).log(Level.SEVERE, null, ex);
        }
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

        try {
            PrintWriter tulos = new PrintWriter(new FileWriter("matopeli_pisteet.txt"), true);

            for (int i = 0; i < kaikki.size(); i++) {

                String nimi = kaikki.get(i).getNimi();
                String kentta = kaikki.get(i).getKentta();
                int pisteet = kaikki.get(i).getScore();

                tulos.println(nimi + "|" + kentta + "|" + pisteet);

            }
//            tulos.printf("%s" + "%n"+rivi);
//            tulos.flush();
            tulos.close();

        } catch (IOException ex) {
            Logger.getLogger(Tilastot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void load() {
        
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            String[] taulu = rivi.split("|");

            String nimi = taulu[0];
            String kentta = taulu[1];
            int pisteet = Integer.parseInt(taulu[2]);
            
            Score uusi = new Score(nimi, kentta, 0);
            
            kaikki.add(uusi);
        }
    }
}
