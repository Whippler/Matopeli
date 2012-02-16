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
    private static ArrayList<Score> kaikki = new ArrayList();
    private static File tiedosto = new File("matopeli_pisteet.txt");
    private static Scanner lukija;

    public Tilastot() {
        load();
        try {
            tiedosto.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Tilastot.class.getName()).log(Level.SEVERE, null, ex);
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

    public int getPisteetMax(String kentta, int nopeus) {
        int max = 0;
        String nimi;
        for (int i = 0; i < kaikki.size(); i++) {
            if (kaikki.get(i).getKentanNimi().equals(kentta) &&
                kaikki.get(i).getNopeus() == nopeus && 
                max < kaikki.get(i).getScore()){
                max = kaikki.get(i).getScore();
            }
        }
        return max;
    }

    public void luoPisteet(String nimi, String kentta, int nopeus) {
        Score uusi = new Score(nimi, kentta, nopeus, uudetPisteet);
        kaikki.add(uusi);
        save();
    }

    public void nollaa() {
        uudetPisteet = 0;
    }

    private void save() {

        try {
            PrintWriter tulos = new PrintWriter(new FileWriter("matopeli_pisteet.txt"), true);

            for (int i = 0; i < kaikki.size(); i++) {

                String nimi = kaikki.get(i).getNimi();
                String kentta = kaikki.get(i).getKentanNimi();
                int pisteet = kaikki.get(i).getScore();
                int nopeus = kaikki.get(i).getNopeus();

                tulos.println(kentta + "|" + nopeus + "|" + pisteet + "|" + nimi);
            }
            tulos.close();

        } catch (IOException ex) {
            Logger.getLogger(Tilastot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void load() {


        try {
            lukija = new Scanner(tiedosto);

            while (lukija.hasNextLine()) {
                String rivi = lukija.nextLine();
                String[] taulu = rivi.split("\\|");
                if (taulu.length == 4) {
                    String nimi = taulu[3];
                    String kentta = taulu[0];
                    int nopeus = Integer.parseInt(taulu[1]);
                    int pisteet = Integer.parseInt(taulu[2]);

                    Score uusi = new Score(nimi, kentta, nopeus, pisteet);
                    kaikki.add(uusi);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tilastot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
