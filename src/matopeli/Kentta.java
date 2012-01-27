
package matopeli;

import java.math.*;
/**
 * Luokka toteuttaa kentän jossa mato liikkuu
 * @author lammenoj
 */
public class Kentta {
    // 0 = tyhjä
    // 1 = seinä
    // 2 = "omena"
    // 3 = mato
    
    private int[][] kentta = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                              {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, 
                              {1, 0, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 1},
                              {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                              {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                              {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                              {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                              {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                              {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                              {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                              {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                              {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                              {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};

    /**
     * 
     * @param x asetettavan arvon x koordinaatti
     * @param y asetettavan arvon y koordinaatti
     * @param value kentälle asetettava arvo
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
    
    public void setOmena(){
        int x = (int)(Math.random()*11+1);
    }
    
    public void print(){
        for (int i = 0; i<kentta.length;i++){
            for (int j = 0; j<kentta[i].length;j++){
                System.out.print(kentta[i][j]);
            }
            System.out.println("");
        }
    }
    
    
}
