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
        try {
            tiedosto.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Tilastot.class.getName()).log(Level.SEVERE, null, ex);
        }
        load();
    }
    
    /**
     * laskee tulosta pelin edetessa kun mato syö omenan
     */
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
    
    /**
     * 
     * @param kentta 
     * @param nopeus
     * @return palauttaa parhaan tuloksen
     */
    public int getPisteetMax(String kentta, int nopeus) {
        int max = 0;
        String nimi;
        for (int i = 0; i < kaikki.size(); i++) {
            if (kaikki.get(i).getKentanNimi().equals(kentta)
                    && kaikki.get(i).getNopeus() == nopeus
                    && max < kaikki.get(i).getScore()) {
                max = kaikki.get(i).getScore();
            }
        }
        return max;
    }
    
    /**
     * 
     * @param kentta 
     * @param nopeus
     * @return palauttaa pelin 5 parasta tulosta
     */
    public ArrayList<Score> getTopScores(String kentta, int nopeus) {

        ArrayList<Score> pisteet = new ArrayList();
        
        // hakee pisteet
        for (int i = 0; i < kaikki.size(); i++) {
            if (kaikki.get(i).getKentanNimi().equals(kentta)
                    && kaikki.get(i).getNopeus() == nopeus) {
                pisteet.add(kaikki.get(i));
            }
        }
        
        // järjestää listan pisteiden perusteella laskevaan järjestykseen
        for (int i = 0; i<pisteet.size()-1; i++){
            for (int j = i+1; j<pisteet.size(); j++){
                if (pisteet.get(i).getScore()<pisteet.get(j).getScore()){
                    Score apu = pisteet.get(i);
                    pisteet.set(i, pisteet.get(j));
                    pisteet.set(j, apu);
                }
            }
        }
        return pisteet;
    }
    
    /**
     * luo pisteet olion ja tallentaa sen.
     * @param nimi pelaajan nimi
     * @param kentta kentän nimi
     * @param nopeus pelin nopeus
     */
    public void luoPisteet(String nimi, String kentta, int nopeus) {
        if (lisataan(kentta, nopeus) == true) {
            Score uusi = new Score(nimi, kentta, nopeus, uudetPisteet);
            kaikki.add(uusi);
            save();
        }
    }
    
    /**
     * Terkistaa pelin lopussa pääseekö pelaaja top5:een
     * @param kentta
     * @param nopeus
     * @return 
     */
    private boolean lisataan(String kentta, int nopeus) {
        int maara = pisteidenMaara(kentta, nopeus);
        if (maara >= 5 && haeAlin(kentta, nopeus) > uudetPisteet) {
            return false;
        } else if (maara >= 5) {
            kaikki.remove(haeAlimmanIndeksi(kentta, nopeus));
        }
        return true;
    }
    
    /**
     * nollaa piste laskurin
     */
    public void nollaa() {
        uudetPisteet = 0;
    }

    /**
     * tallentaa tilastot tiedostoon
     */
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
    
    /**
     * Lataa tilastot tiedostosta
     */
    private static void load() {

        try {
            lukija = new Scanner(tiedosto);

            while (lukija.hasNextLine()) {
                String rivi = lukija.nextLine();
                String[] taulu = rivi.split("\\|");
                if (taulu.length >= 4) {
                    String kentta = taulu[0];
                    int nopeus = Integer.parseInt(taulu[1]);
                    int pisteet = Integer.parseInt(taulu[2]);
                    String nimi = taulu[3];
                    if (taulu.length>4){
                        for (int i = 4; i<taulu.length; i++){
                            nimi = nimi + "|" + taulu[i];
                        }
                    }

                    Score uusi = new Score(nimi, kentta, nopeus, pisteet);
                    kaikki.add(uusi);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tilastot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * hakee tilastosta alimman tallennetun tuloksen, jotta voidaan tarkistaa pääseekö pelaaja top5:een
     * @param kentta 
     * @param nopeus
     * @return palauttaa huonoumman tallennetun tuloksen
     */
    private int haeAlin(String kentta, int nopeus) {

        int alin = Integer.MAX_VALUE;
        for (int i = 0; i < kaikki.size(); i++) {
            if (kaikki.get(i).getKentanNimi().equals(kentta)
                    && kaikki.get(i).getNopeus() == nopeus
                    && kaikki.get(i).getScore() < alin) {
                alin = kaikki.get(i).getScore();
            }
        }
        return alin;
    }
    
    /**
     * hakee alimman tallennetun tuloksen indeksin poistamista varten
     * @param kentta
     * @param nopeus
     * @return palauttaa huonoimman tallennetun tuloksen indeksin
     */
    private int haeAlimmanIndeksi(String kentta, int nopeus) {

        int alin = Integer.MAX_VALUE;
        int indeksi = 0;

        for (int i = 0; i < kaikki.size(); i++) {
            if (kaikki.get(i).getKentanNimi().equals(kentta)
                    && kaikki.get(i).getNopeus() == nopeus
                    && kaikki.get(i).getScore() < alin) {
                alin = kaikki.get(i).getScore();
                indeksi = i;
            }
        }
        return indeksi;
    }

    /**
     * laskee onko top5 täynnä
     * @param kentta
     * @param nopeus
     * @return palauttaa 
     */
    private int pisteidenMaara(String kentta, int nopeus) {
        int summa = 0;
        for (int i = 0; i < kaikki.size(); i++) {
            if (kaikki.get(i).getKentanNimi().equals(kentta)
                    && kaikki.get(i).getNopeus() == nopeus) {
                summa = summa + 1;
            }
        }
        return summa;
    }
}
