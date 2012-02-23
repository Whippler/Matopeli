package matopeli;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Tämä luokka toimii projektin sovelluslogiikkana
 *
 * @author lammenoj
 */
public class Logiikka {

    Kentta kentta = new Kentta();
    Mato mato = new Mato();
    Tilastot pisteet = new Tilastot();

    public Logiikka() {
        this.reset("classic");
    }

    /**
     * aloittaa uuden peli
     *
     * @param nimi Ladattava kentän nimi
     */
    public void reset(String nimi) {
        kentta.alustaKentta(nimi);
        mato.alustaMato(kentta.getKorkeus(), kentta.getLeveys());
        pisteet.nollaa();
    }

    // LUOKAN MATO HALLINTA
    //--------------------------------------------------------------------------
    /**
     * Tällä metodilla valitaan madolle etenemissuunta
     *
     * @param suunta Annetaan suunta merkkijonona, mihin mato on seuraavaksi
     * menossa
     */
    public void asetaSuunta(String suunta) {
        mato.setSuunta(suunta);
    }

    /**
     * Metodi siirtää matoa eteenpäin
     */
    public boolean etene() {

        mato.etene();

        boolean arvo = true;
        LinkedList<Integer> X = mato.getX();
        LinkedList<Integer> Y = mato.getY();
        int ruutu = kentta.getArvo(X.getFirst(), Y.getFirst());

        // poistaa hännän
        if (ruutu != 2) {
            kentta.setArvo(X.getLast(), Y.getLast(), 0);
            mato.poistaViimeinen();
        } else if (ruutu == 2) {
            kentta.setOmena();
            pisteet.addPisteet();
        }
        if (ruutu == 1 || ruutu == 3) {
            return false;
        }

        kentta.setArvo(X.getFirst(), Y.getFirst(), 3);
        return arvo;
    }

    public int getNopeus() {
        return mato.getNopeus();
    }

    public void setNopeus(int nopeus) {
        mato.setNopeus(nopeus);
    }

    //LUOKAN KENTTA HALLINTA
    //--------------------------------------------------------------------------
    /**
     * 
     * @return palauttaa kentän
     */
    public int[][] getKentta() {
        return kentta.getKentta();
    }

    /**
     * 
     * @return valitun kentän nimen
     */
    public String getKentanNimi() {
        return kentta.getNimi();
    }

    //Luokan TILASTOT HALLINTA
    //--------------------------------------------------------------------------
    
    /**
     * 
     * @return palauttaa käynnissä olevan pelin piste saldon
     */
    public int pisteet() {
        return pisteet.getPisteet();
    }

    /**
     * tallentaa pisteet
     * @param nimi Pelaajan syöttämä nimimerkki
     * @param nopeus pelatun pelin nopeus
     */
    public void setScore(String nimi, int nopeus) {
        pisteet.luoPisteet(nimi, kentta.getNimi(), nopeus);
    }
    
    /**
     * 
     * @param pelimuoto nopeuden muoto, staattinen tai kiihtyvä.
     * @return palauttaa valitun pelin suurimmat pisteet
     */
    public int pisteetMax(int pelimuoto) {
        if (pelimuoto == 0) {
            return pisteet.getPisteetMax(kentta.getNimi(), mato.getNopeus());
        } else {
            return pisteet.getPisteetMax(kentta.getNimi(), 1);
        }
    }
    /**
     * 
     * @return palauttaa valitun pelin 5 parasta tulosta.
     */
    public ArrayList<Score> getTopScore() {
        return pisteet.getTopScores(kentta.getNimi(), mato.getNopeus());
    }
}
