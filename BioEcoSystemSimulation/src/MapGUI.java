import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;

public class MapGUI extends javax.swing.JFrame {

    private Timer timer;
    private int count = 0;
    
    
    /**
     * Creates new form MapGUI
     */
    public MapGUI() {
        initComponents();
    }

    //Creates new Timer object if one does not already exist
    public void startTimer() {
     if (timer != null) {
            System.out.println("Timer already running");
            return;
        }
        //Create a new timer object
        timer = new java.util.Timer(true);
        System.out.println("Timer started");
        TimerTask task = new TimerTask() {
            public void run() {
                tick();
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000); 
    }
    
    public void stopTimer() {
        if (timer != null) {
            timer.cancel();
            timer = null;
            System.out.println("Timer stopped");
        }
        else {
            System.out.println("No timer running");
        }
    }
    
    //Step event
    public void tick() {
        count++;
        System.out.println(count);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        buttonStart = new javax.swing.JButton();
        buttonStop = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonStart.setText("Start Simulation");
        buttonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStartActionPerformed(evt);
            }
        });

        buttonStop.setText("Stop Simulation");
        buttonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(buttonStart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonStop)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 469, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(103, 103, 103))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(buttonStart)
                    .addComponent(buttonStop))
                .addContainerGap(575, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Prey p = new Prey(5, 1, 100, 100, 1, new Point(0, 0));
        Predator pr = new Predator(5, 2, 14, 51, 1, new Point(0, 0));
        System.out.println(pr.isOccupied(p));
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buttonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStartActionPerformed
        startTimer();
    }//GEN-LAST:event_buttonStartActionPerformed

    private void buttonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStopActionPerformed
        stopTimer();
    }//GEN-LAST:event_buttonStopActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MapGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MapGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MapGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MapGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MapGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonStart;
    private javax.swing.JButton buttonStop;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
