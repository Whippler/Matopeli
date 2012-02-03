package matopeli;

import java.util.ArrayList;

/**
 * Luokka toteuttaa pisteiden hallinnan
 * @author lammenoj
 */
public class Pisteet {
    
    private int pisteet = 0;
    private int pisteetMax =0;
    
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
    
    /**
     * 
     * @return palauttaa suurimmat pisteet
     */
    public int getPisteetMax(){
        return pisteetMax;
    }
    
    /**
     * nollaa pelin lopussa piste laskurin
     */
    
    public void nollaa(){
        if (this.pisteet>pisteetMax){
            pisteetMax = pisteet;
        }
        this.pisteet = 0;
    }
    
}
