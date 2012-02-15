package matopeli;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Luokka toteuttaa pisteiden hallinnan
 * @author lammenoj
 */
public class Tilastot {
    
    private int uudetPisteet = 0;
    private ArrayList<Score>  kaikki = new ArrayList();
    private File tiedosto = new File("matopeli_pisteet.txt");
   
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
        kaikki.add(uusi);
        nollaa();
    }
    public void nollaa(){
        uudetPisteet = 0;
        save();
    }
    
    public void save() {
        try {
        PrintWriter tulos = new PrintWriter(tiedosto);
         
        for (int i=0; i<kaikki.size();i++){
            
            String nimi = kaikki.get(i).getNimi();
            String kentta = kaikki.get(i).getKentta();
            int pisteet = kaikki.get(i).getScore();
            
            tulos.println(nimi + " " + kentta + " " + pisteet);
        }
        } catch (FileNotFoundException e){
            
        }
    }
    
    public void load(){
        
    }
}
