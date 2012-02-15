package matopeli;

public class Score {

    private int pisteet;
    private String nimi;
    private String kentta;

    public Score(String nimi, String kentta, int score) {
        this.nimi = nimi;
        this.pisteet = score;
        this.kentta = kentta;
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
    
    public String getKentta(){
        return kentta;
    }
//    @Override
//    public String toString() {
//        return uudetPisteet + " " + nimi;
//    }
}
