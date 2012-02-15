
package matopeli;

public class Score {
    
    private int score;
    private String nimi;
    
    public Score(String nimi, String kentta, int score){
        this.nimi=nimi;
        this.score=score;        
    }

    public String getNimi() {
        return nimi;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return score + " " + nimi;
    }
    
    
    
    
    
}
