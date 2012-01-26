
package matopeli;

public class Kentta {
    // 0 = tyhjä
    // 1 = seinä
    // 2 = "omena"
    // 3 = mato
    
    private int[][] kentta = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                              {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, 
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
    public void Kentta(){
        
    }

    public int[][] getKentta() {
        return kentta;
    }
    
    public void setArvo(int x, int y, int value){
        kentta[x][y] = value;
    }
    
    public int getArvo(int x, int y) {
        return kentta[x][y];
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
