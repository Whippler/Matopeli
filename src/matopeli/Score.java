package matopeli;
/**
 * Luokka toteuttaa olion johon tallennetaan pisteet
 * @author Kalle
 */
public class Score {
    
    private int nopeus;
    private int pisteet;
    private String nimi;
    private String kentta;
    
    /**
     * 
     * @param nimi pelaajan nimi
     * @param kentta kentän nimi
     * @param nopeus pelin nopeus
     * @param score saadut pisteet
     */
    public Score(String nimi, String kentta, int nopeus, int score) {
        this.nimi = nimi;
        this.pisteet = score;
        this.kentta = kentta;
        this.nopeus = nopeus;
    }

    public String getNimi() {
        return nimi;
    }
    
    public int getScore(){
        return pisteet;
    }
    
    public String getKentanNimi(){
        return kentta;
    }

    public int getNopeus() {
        return nopeus;
    }

    @Override
    public String toString() {
        return pisteet + " " + nimi;
    }
    
    
}
