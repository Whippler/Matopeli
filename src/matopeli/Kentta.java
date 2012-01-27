
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
                              {1, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 1},
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
    /**
     * Metodi arpoo kentälle uuden omenan
     */
    public void setOmena(){
        
        while (true){
            int x = (int)(Math.random()*11+1);
            int y = (int)(Math.random()*11+1);
            
            if (this.getArvo(x, y) != 3) {
                this.setArvo(x, y, 2);
                return;
            }
        }  
    }
    
    public int getLeveys(){
        return kentta.length;
    }
    public int getKorkeus(){
        return kentta[0].length;
    }
    
    public void print(){
        for (int i = 0; i<kentta.length; i++){
            for (int j = 0; j<kentta[i].length; j++){
                System.out.print(kentta[i][j] + " ");
            }
            System.out.println("");
        }
    }    
}
