import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;

public class MapGUI extends javax.swing.JFrame {

    private Timer timer;
    private int count = 0;    
    protected int gridSize = 5; // stores the size of the grid
    protected Ecosystem[][] map = new Ecosystem[gridSize][gridSize]; // stores map

    /**
     * Creates new form MapGUI
     */
    public MapGUI() {
        initComponents();
        generateMap();
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

        buttonStart = new javax.swing.JButton();
        buttonStop = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
                .addContainerGap(647, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonStart)
                    .addComponent(buttonStop))
                .addContainerGap(575, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStartActionPerformed
        startTimer();
    }//GEN-LAST:event_buttonStartActionPerformed

    private void buttonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStopActionPerformed
        stopTimer();
        //System.out.println(((Predator)map[1][1]).checkSurroundings(map[1][1].getRow(), map[1][1].getCol()));
        //System.out.println(((Prey)map[0][0]).checkSurroundings(map[0][0].getRow(), map[0][0].getCol()));
    }//GEN-LAST:event_buttonStopActionPerformed
    
    public void generateMap() {
        // fill in grid
        
        for(int r = 0; r < gridSize; r++) {
            for(int c = 0; c < gridSize; c++) {
                int type = (int)(Math.random()*4);
                if(type == 0) {
                    map[r][c] = new Water(this, r, c);
                }
                else if(type == 1) {
                    map[r][c] = new Tiger(this, r, c);
                }
                else if(type == 2){
                    map[r][c] = new Pig(this, r, c);
                }
                else {
                    map[r][c] = new Plant(this, r, c);
                }
            }
        }
        
        //map[0][0] = new Pig(this, 0, 0);
        map[1][1] = new Tiger(this, 1, 1);
        //map[0][1] = new Plant(this, 0, 1);
        
        // print map
        printMap();
        System.out.println(map[1][1] instanceof Ecosystem);
        
    }
    
    public void printMap() {
        for(int r = 0; r < gridSize; r++) {
            for(int c = 0; c < gridSize; c++) {
                System.out.print(map[r][c] + " ");
            }
            System.out.println("");
        }
    }
    
    public int getGridSize() {
        return gridSize;
    }
    
    public Ecosystem[][] getMap() {
        return map;
    }
    
    
    
    
    
    
    
    
    
   
    
    
    
    
    
    
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
    // End of variables declaration//GEN-END:variables
}