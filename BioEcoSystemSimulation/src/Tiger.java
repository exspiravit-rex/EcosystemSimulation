import java.awt.Color;
import java.awt.Graphics;


public class Tiger extends Predator {
    private Color myColor;
    
    public Tiger(MapGUI mapGUI, int r, int c) {
        super(mapGUI, r, c);
        Color myColor = Color.ORANGE;
    }
    
    public Tiger(MapGUI mapGUI, int r, int c, int hunger, int thirst) {
        super(mapGUI, r, c, hunger, thirst);
    }
    
    //Drawing is done in the MapGUI class
    public void draw(Graphics g) {
        g.setColor(myColor);
        g.fillOval(getRow(), getCol(), 20, 20);
    }
    
    public String toString() {
        return "Tiger at " + getRow() + ", " + getCol();
    }
    
     
    /*
    //what it does during each step
    public void move() {
        
        // moving
        
        
        
        for(int row = getRow() - 1; row < getRow() + 2; row++) {
            for(int col = getCol() - 1; col < getCol() + 2; col++) {
                if(row == getRow() && col == getCol()) {
                    col++;
                    System.out.println("checking myself. col is now " + col);
                }
                //check for out of grid row & col
                if((row < 0 || col < 0 || row >= mapGUI.getGridSize() || col >= mapGUI.getGridSize()) == false) {
                    //check if there's already an ecosystem object there
                    if(isOccupied(row, col) == false){ // no ecosystem object in target destination
                        mapGUI.getMap()[getRow()][getCol()] = null;
                        mapGUI.getMap()[row][col] = this;
                        setLocation(row, col);
                        System.out.println("moving to " + row + ", " + col);
                        break;
                    }
                    else{
                        System.out.println("Can't move there");
                    }
                }
                else {
                    System.out.println("Out of grid at " + row + ", " + col);
                }
            }
        }
        
    }
    */
    
}
