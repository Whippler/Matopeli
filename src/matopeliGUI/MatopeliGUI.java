package matopeliGUI;

/**
 *
 * @author lammenoj
 */
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import matopeli.*;

public class MatopeliGUI extends javax.swing.JFrame {

    Logiikka peli = new Logiikka();
    Timer kello;
    Kuuntelija kuuntelija = new Kuuntelija();

    private class Kuuntelija implements ActionListener {

        private String kentta;
        private int nopeus;
        private int pelimuoto;
        private int delay;

        public Kuuntelija() {
            kentta = "classic";
            nopeus = 100;
            pelimuoto = 0;
            delay = 0;
        }

        public void asetaKentta(String nimi) {
            this.kentta = nimi;
            peli.reset(nimi);
        }

        public void reset() {
            peli.reset(kentta);
        }

        public void asetaNopeus(int nopeus) {
            kello.setDelay(nopeus);
            pelimuoto = 0;
        }

        public void asetaKasvavaNopeus() {
            nopeus = 200;
            kello.setDelay(nopeus);
            pelimuoto = 1;
            delay = 0;
        }

        @Override
        public void actionPerformed(ActionEvent ae) {

            if (peli.etene() == true) {
                repaint();
                if (pelimuoto == 1) {
                    delay = delay + 1;
                    if (delay == 5 && nopeus > 20) {
                        nopeus = nopeus - 1;
                        kello.setDelay(nopeus);
                        delay = 0;
                    }
                    kello.setDelay(nopeus);
                }
            } else {
                kello.stop();
                showScore();
                peli.reset(kentta);

                if (pelimuoto == 1) {
                    this.asetaKasvavaNopeus();
                }
                repaint();
            }
        }
    }

    /**
     * Creates new form matopeliGUI2
     */
    public MatopeliGUI() {

        initComponents();
        kello = new Timer(100, kuuntelija);
        menu();
    }

    private void menu() {
        JMenuItem classic = new JMenuItem("classic");
        ActionListener classicListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                kuuntelija.asetaKentta("classic");
                repaint();
                jPopupMenu1.setVisible(false);
            }
        };
        classic.addActionListener(classicListener);

        JMenuItem nowalls = new JMenuItem("no walls");
        ActionListener nowallsListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                kuuntelija.asetaKentta("nowalls");
                repaint();
                jPopupMenu1.setVisible(false);
            }
        };
        nowalls.addActionListener(nowallsListener);


        JMenuItem cross = new JMenuItem("cross");
        ActionListener crossListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                kuuntelija.asetaKentta("cross");
                repaint();
                jPopupMenu1.setVisible(false);
            }
        };
        cross.addActionListener(crossListener);

        jPopupMenu1.add(classic);
        jPopupMenu1.add(nowalls);
        jPopupMenu1.add(cross);

        JMenuItem fast = new JMenuItem("fast");
        ActionListener fastListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                kello.setDelay(50);
                kuuntelija.asetaNopeus(50);
                kuuntelija.reset();
                jPopupMenu2.setVisible(false);
                repaint();
            }
        };
        fast.addActionListener(fastListener);

        JMenuItem normal = new JMenuItem("normal");
        ActionListener normalListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                kello.setDelay(100);
                kuuntelija.asetaNopeus(100);
                kuuntelija.reset();
                jPopupMenu2.setVisible(false);
                repaint();
            }
        };
        normal.addActionListener(normalListener);

        JMenuItem slow = new JMenuItem("slow");
        ActionListener slowListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                kello.setDelay(150);
                kuuntelija.asetaNopeus(150);
                kuuntelija.reset();
                jPopupMenu2.setVisible(false);
                repaint();
            }
        };
        slow.addActionListener(slowListener);

        JMenuItem increasing = new JMenuItem("increasing");
        ActionListener increasingListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                kuuntelija.asetaKasvavaNopeus();
                kuuntelija.reset();
                jPopupMenu2.setVisible(false);
                repaint();
            }
        };
        increasing.addActionListener(increasingListener);

        jPopupMenu2.add(fast);
        jPopupMenu2.add(normal);
        jPopupMenu2.add(slow);
        jPopupMenu2.addSeparator();
        jPopupMenu2.add(increasing);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        scoreLabel = new javax.swing.JLabel();
        TopScoreLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jPopupMenu1.addMouseListener(new java.awt.event.MouseAdapter() {

            //    public void mouseExited(java.awt.event.MouseEvent evt) {
                //        jPopupMenu1MouseExited(evt);
                //    }

        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Matopeli");
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(280, 328));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        scoreLabel.setBackground(new java.awt.Color(255, 255, 255));
        scoreLabel.setLabelFor(this);
        scoreLabel.setText("Score");
        scoreLabel.setMaximumSize(new java.awt.Dimension(37, 20));
        scoreLabel.setMinimumSize(new java.awt.Dimension(37, 20));
        scoreLabel.setPreferredSize(new java.awt.Dimension(37, 20));

        TopScoreLabel.setBackground(new java.awt.Color(255, 255, 255));
        TopScoreLabel.setText("TopScore");
        TopScoreLabel.setMaximumSize(new java.awt.Dimension(60, 20));
        TopScoreLabel.setMinimumSize(new java.awt.Dimension(60, 20));
        TopScoreLabel.setPreferredSize(new java.awt.Dimension(60, 20));

        jMenu1.setText("kenttä");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("nopeus");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(scoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TopScoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TopScoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 200, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        int nappain = evt.getKeyCode();

        if (nappain == 38 && kello.isRunning() == true) {  // ylänuoli
            peli.asetaSuunta("ylös");
        } else if (nappain == 40 && kello.isRunning() == true) {  // alanuoli
            peli.asetaSuunta("alas");
        } else if (nappain == 37 && kello.isRunning() == true) { // vasennuoli
            peli.asetaSuunta("vasemmalle");
        } else if (nappain == 39 && kello.isRunning() == true) { // oikeanuoli
            peli.asetaSuunta("oikealle");
        } else if (nappain == 32 && kello.isRunning() == true) { //Space
            kello.stop();
        } else if (nappain == 32 && kello.isRunning() == false) { //Space
            kello.start();
        }
    }//GEN-LAST:event_formKeyPressed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        jPopupMenu1.show(evt.getComponent(), 0, 21);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        jPopupMenu2.show(evt.getComponent(), 0, 21);
    }//GEN-LAST:event_jMenu2MouseClicked

//    private void jPopupMenu1MouseExited(java.awt.event.MouseEvent evt) {
//        // TODO add your handling code here:
//        jPopupMenu1.setVisible(false);
//        repaint();
//    }
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

    @Override
    public void paint(Graphics g) {

        super.paint(g);

        scoreLabel.setText("Score: " + peli.pisteet());
        TopScoreLabel.setText("Top Score: " + peli.pisteetMax());

        int[][] alue = peli.getKentta();

        for (int i = 0; i < alue.length; i++) {
            for (int j = 0; j < alue[i].length; j++) {
                if (alue[i][j] == 0) {
                    g.setColor(Color.WHITE);
                } else if (alue[i][j] == 1) {
                    g.setColor(Color.BLACK);
                } else if (alue[i][j] == 3) {
                    g.setColor(Color.red);
                } else {
                    g.setColor(Color.pink);
                }
                g.fillRect(j * 10 + 30, i * 10 + 80, 9, 9);
            }
        }
    }

    public void showScore() {
        JOptionPane.showMessageDialog(this, "lol");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TopScoreLabel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JLabel scoreLabel;
    // End of variables declaration//GEN-END:variables
}
