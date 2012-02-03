package matopeli;

import java.util.ArrayList;

public class Pisteet {
    
    private int pisteet = 0;
    private int pisteetMax =0;
    
    public void addPisteet(){
        pisteet = pisteet + 100;
    }
    
    public int getPisteet(){
        return this.pisteet;
    }
    
    public int getPisteetMax(){
        return pisteetMax;
    }
    
    public void nollaa(){
        if (this.pisteet>pisteetMax){
            pisteetMax = pisteet;
        }
        this.pisteet = 0;
    }
    
}
