package matopeli;

import java.io.File;
import java.util.ArrayList;

/**
 * Luokka toteuttaa pisteiden hallinnan
 * @author lammenoj
 */
public class Tilastot {
    
    private int uudetPisteet = 0;
    private ArrayList<Score>  kaikki = new ArrayList();
    private File tiedosto = new File("matopeli_pisteet");
   
    /**
     * Metodilla lisätään tulosta kun mato syö omenan
     */
    public Tilastot(){
//        tiedosto.createNewFile();
    }
    
    public void addPisteet(){
        uudetPisteet = uudetPisteet + 100;
    }
    /**
     * 
     * @return palauttaa käynnissä olevan pelin pisteet
     */
    public int getPisteet(){
        return this.uudetPisteet;
    }
    
    public void luoPisteet(String nimi, String kentta, int nopeus){
        
        Score uusi = new Score(nimi, kentta, uudetPisteet);
        nollaa();
    }
    public void nollaa(){
        uudetPisteet = 0;
    }
    
    public void save(){
         
        for (int i=0; i<kaikki.size();i++){
            kaikki.get(i).getNimi();
            kaikki.get(i).getKentta();
            kaikki.get(i).getScore();
        }
    }
    
    public void load(){
        
    }
}
