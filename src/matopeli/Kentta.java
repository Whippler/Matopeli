
package matopeli;

import java.util.ArrayList;
import java.util.Random;
/**
 * Luokka toteuttaa kentän jossa mato liikkuu
 * @author lammenoj
 */
public class Kentta {
    // 0 = tyhjä
    // 1 = seinä
    // 2 = "omena"
    // 3 = mato
    
    private int[][] kentta;
    private String nimi;
    private KenttaGeneraattori kenttaGen = new KenttaGeneraattori();

    /**
     * 
     * @param x asetettavan arvon x koordinaatti
     * @param y asetettavan arvon y koordinaatti
     * @param value kentälle asetettava arvo
     */
    public Kentta(){
    }
    /**
     * hakee annetun kentän ja asettaa sinne omenan
     * @param nimi kentän nimi
     */
    public void alustaKentta(String nimi){
        kentta = null;
        this.kentta = kenttaGen.getKentta(nimi);
        this.nimi = nimi;
        this.setOmena();    
    }
    /**
     * asettaa kentälle arvon value, koordinaatteihin x,y
     * @param x
     * @param y
     * @param value 
     */
    public void setArvo(int x, int y, int value){
        kentta[x][y] = value;
    }
    /**
     * Metodi palauttaa kentältä yhden arvon
     * @param x halutun arvon x koordinaatti
     * @param y halutun arvon y koordinaatti
     * @return palauttaa kentältä arvon annetuista koordinaateista
     */
    public int getArvo(int x, int y) {
        return kentta[x][y];
    }
    /**
     * Metodi arpoo kentälle uuden omenan
     */
    public void setOmena(){
        
        ArrayList<Integer> X = new ArrayList<Integer>();
        ArrayList<Integer> Y = new ArrayList<Integer>();
        
        Random arpa = new Random();
        
        for (int i = 0; i<kentta.length; i++){
            for (int j = 0; j<kentta[i].length; j++){
                if (this.getArvo(i, j) == 0){
                    X.add(i);
                    Y.add(j);
                }
            }
        }
        int index = arpa.nextInt(X.size());
        this.setArvo(X.get(index), Y.get(index), 2);
        X.clear();
        Y.clear();
    }
    
    public int getLeveys(){
        return kentta.length;
    }
    public int getKorkeus(){
        return kentta[0].length;
    }
    
    public int[][] getKentta(){
        return kentta;
    }
    
    public String getNimi(){
        return nimi;
    }
}
