package matopeliGUI;
/**
 *
 * @author lammenoj
 */
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import matopeli.*;

public class MatopeliGUI extends javax.swing.JFrame {

    private class Kuuntelija implements ActionListener {

        public Kuuntelija() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            if ( peli.etene() == true){
                repaint();
            } else {
                kello.stop();
                peli.reset();
                repaint();
            }
            
        }
    }
    /**
     * Creates new form matopeliGUI2
     */
    Graphics db;
    Logiikka peli = new Logiikka();
    Timer kello;

    public MatopeliGUI() {
        initComponents();
        kello = new Timer(100, new Kuuntelija());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Matopeli");
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        int nappain = evt.getKeyCode();

        if (nappain == 38 && kello.isRunning()==true) {  // ylänuoli
            peli.asetaSuunta("ylös");
        } else if (nappain == 40 && kello.isRunning()==true) {  // alanuoli
            peli.asetaSuunta("alas");
        } else if (nappain == 37 && kello.isRunning()==true) { // vasennuoli
            peli.asetaSuunta("vasemmalle");
        }else if (nappain == 39 && kello.isRunning()==true) { // oikeanuoli
            peli.asetaSuunta("oikealle");
        }else if (nappain == 32 && kello.isRunning()==true) { //Space
            kello.stop();
        }else if (nappain == 32 && kello.isRunning()==false) { //Space
            kello.start();
        }
    }//GEN-LAST:event_formKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MatopeliGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MatopeliGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MatopeliGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MatopeliGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MatopeliGUI().setVisible(true);
            }
        });

    }
    
    public void paint(Graphics g) {
        
        int[][] alue = peli.getKentta();
        
        for(int i = 0; i < alue.length; i++){
            for(int j = 0; j < alue[i].length; j++){
                if (alue[i][j] == 0){
                    g.setColor(Color.WHITE);
                } else if(alue[i][j] == 1){
                    g.setColor(Color.BLACK);
                } else if(alue[i][j] == 3){
                    g.setColor(Color.red);
                } else {
                    g.setColor(Color.pink);
                }
                g.fillRect(j*10+30, i*10+50, 10, 10);
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
