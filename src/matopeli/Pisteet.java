package matopeli;

import java.util.ArrayList;

/**
 * Luokka toteuttaa pisteiden hallinnan
 * @author lammenoj
 */
public class Pisteet {
    
    private int pisteet = 0;
    private ArrayList<Score>  kaikki = new ArrayList();
   
    /**
     * Metodilla lisätään tulosta kun mato syö omenan
     */
    public void addPisteet(){
        pisteet = pisteet + 100;
    }
    /**
     * 
     * @return palauttaa käynnissä olevan pelin pisteet
     */
    public int getPisteet(){
        return this.pisteet;
    }
    
    public void pisteet(String nimi, String kentta, int nopeus){
        
        Score uusi = new Score(nimi, kentta, pisteet);
        nollaa();
    }
    public void nollaa(){
        pisteet = 0;
    }
}
