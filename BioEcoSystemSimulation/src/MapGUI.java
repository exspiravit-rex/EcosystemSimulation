import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MapGUI extends javax.swing.JFrame {

    private Timer timer;
    private int count = 0;    
    protected int gridSize = 25; // stores the size of the grid
    protected Ecosystem[][] map = new Ecosystem[gridSize][gridSize]; // stores map

    protected int[][] grid = new int[gridSize][gridSize]; //create the matrix    (row major)     
    private final int squareSize = 20; //the size length of individual squares in pixels
    private final int gridCount = gridSize * squareSize;  //size of entire draw grid in pixels
    private final int offSet = 50;  //how far from top/left edge do we draw the grid
    
    private int penColor = 0; //keeps track of current drawing color
    private Color[] colors; //our array of colors
    private Image ib;  //we do all drawing onto this image, it acts as an image buffer
    private Graphics ibg;  //will be set to our image buffer's graphic object    

    private Color borderColor = new Color(20, 20, 20);    
    
    //MAY NEED TO BE PUBLIC
    private ArrayList<Ecosystem> ecosystemMap = new ArrayList<Ecosystem>(); //keeps track of the objects in the map
    
    /**
     * Creates new form MapGUI
     */
    public MapGUI() {
        initComponents();
        generateMap();
        setUpImageBuffer();
        setLocationRelativeTo(null);
        setUpColors();
        clearGrid();
        draw();
    }

    //TIMER OBJECT
    
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
        //clearGrid();
        //add movement and other action methods
        drawObjects();
    }
    
    //GRAPHICS
    
    //set the image (buffer) to a new image of the correct size
    public void setUpImageBuffer(){
        ib = this.createImage(gridCount + 1,gridCount + 1);
        ibg = ib.getGraphics();
    }
    
    //Add colors
    public void setUpColors(){
        colors = new Color[6];
        colors[0] = Color.darkGray;
        colors[1] = Color.white; //background
        colors[2] = Color.orange; //tiger
        colors[3] = Color.pink; //pig
        colors[4] = Color.green; //plant
        colors[5] = Color.blue; //water
    }
    
    //fills the grid with 1's (represents white!)
    public void clearGrid(){
        for(int r = 0; r < gridSize; r++) {
            for(int c = 0; c < gridSize; c++) {
                grid[r][c] = 1;
            }
        }
        draw();
    }
    
    //set a square in the grid to the color value as long as the values are valid
    public void colorSquare(int row, int col, int colorValue){
        grid[row][col] = colorValue;
        draw();
    }
    
    //Draws all of the objects in the arraylist ecosystemMap, which contains all of the ecosystem objects   
    public void drawObjects() {
        //set color to corresponding color for each object
        for (int k = 0; k < ecosystemMap.size(); k++) {
            if (ecosystemMap.get(k) instanceof Predator) {
                penColor = 2;
            }
            else if (ecosystemMap.get(k) instanceof Prey) {
                penColor = 3;
            }
            else if (ecosystemMap.get(k) instanceof Plant) {
                penColor = 4;
            }
            else if (ecosystemMap.get(k) instanceof Water) {
                penColor = 5;
            }
            colorSquare(ecosystemMap.get(k).getRow(), ecosystemMap.get(k).getCol(), penColor);  
        }
    }
    
    //draws the image based on the values stored in the grid.
    //we will draw on the image buffer's graphics object and then when we are
    //all done we will copy the image buffer onto the Frame's graphic object.
    public void draw(){
        
        //clear the area, draw white background
        ibg.clearRect(0, 0, gridCount,gridCount);
        ibg.setColor(Color.white);
        ibg.fillRect(0, 0, gridCount, gridCount);
        
        //draws individual squares (pass this method the frames graphics object
        drawSquares(ibg);
        
        //draws a black border around edge of grid
        ibg.setColor(Color.black);
        ibg.drawRect(0,0,gridCount,gridCount);
        
        //all done drawing your stuff onto the image buffer?
        //get the frame's graphics object and draw our image buffer onto the frame
        Graphics g = this.getGraphics();
        g.drawImage(ib,offSet,offSet,this);
    }
    
    //draws the individual colored squares that make the grid using the values
    //stored in the grid matrix.
    public void drawSquares(Graphics g){
       //draw each square (remember that squareSize is size of each square...
       g.setColor(Color.black);
       for(int r=0; r<gridSize; r++){
           for(int c=0; c<gridSize; c++) {
               g.setColor(colors[ grid[r][c] ] );
               g.fillRect(c*squareSize, r*squareSize, squareSize, squareSize);      
               g.setColor(borderColor);
               g.drawRect(c*squareSize, r*squareSize, squareSize, squareSize);
           }
       }
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
                .addContainerGap(788, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonStop)
                    .addComponent(buttonStart))
                .addGap(69, 69, 69))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(buttonStart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonStop)
                .addContainerGap(537, Short.MAX_VALUE))
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
                //chance of spawning an object on a grid square
                int spawn = (int)(Math.random()*4);
                if (spawn == 0) {
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
                    ecosystemMap.add(map[r][c]); //add the object to the arraylist of objects on the map
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