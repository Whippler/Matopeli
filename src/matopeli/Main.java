
package matopeli;
public class Main {
    public static void main(String[] args) {
        
       Logiikka peli = new Logiikka();
        
       peli.print();
       peli.etene();
       peli.etene();
       peli.asetaSuunta("alas");
       peli.etene();
       peli.print();
       
    }
}
