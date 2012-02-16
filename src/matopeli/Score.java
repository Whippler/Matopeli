package matopeli;

public class Score {
    
    private int nopeus;
    private int pisteet;
    private String nimi;
    private String kentta;
    

    public Score(String nimi, String kentta, int nopeus, int score) {
        this.nimi = nimi;
        this.pisteet = score;
        this.kentta = kentta;
        this.nopeus = nopeus;
    }

    public void setScore(int score) {
        this.pisteet = score;
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
