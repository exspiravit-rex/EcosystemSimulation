import java.awt.Point;

public class Predator extends Animal {
    private Point preyLocation;
    
    public Predator(MapGUI mapGUI, int r, int c) {
        super(mapGUI, r, c);
    }
    
    public Predator(MapGUI mapGUI, int r, int c, int age, int hunger, int thirst) {
        super(mapGUI, r, c, age, hunger, thirst);
    }
    
    public String toString() {
        return "Predator at " + getLocation();
    }
    
    // checks if the index at r, c is a prey
    public boolean findPrey(int r, int c) {
        if(r < 0 || c < 0 || r >= mapGUI.getGridSize() || c >= mapGUI.getGridSize()) {
            return false;
        }
        if(r > getRow() + 3 || r < getRow() - 3 || c > getCol() + 3 || c < getCol() - 3) {
            return false; // out of range
        }
        else {
            return( super.isOccupied(r, c) && mapGUI.getMap()[r][c] instanceof Prey); 
        }
    }
    
    public boolean isCloser(int closeR, int closeC, int tempR, int tempC) {
        if((Math.abs(getRow() - closeR) + (Math.abs(getCol() - closeC))) <= (Math.abs(getRow() - tempR)) + (Math.abs(getCol() - tempC))) {
            return true;
        }
        return false;
    }
    
    // checks all of surroundings and gets the index of the closest prey
    public Point checkSurroundings(int r, int c) {
        int closestR = r - 3; // holds the row of the closest prey object
        int closestC = c - 3; // holds column of closest prey object
        int tempR = r;
        int tempC = c;
        
        for(int row = r - 3; row < r + 3; row++) {
            for(int col = c - 3; col < c + 3; col++) {
                if(findPrey(row, col)) {
                    tempR = row;
                    tempC = col;
                    System.out.println("found prey at " + row + " " +  col);
                    
                    if(isCloser(closestR, closestC, tempR, tempC) == false) {
                        closestR = tempR;
                        closestC = tempC;
                        System.out.println(mapGUI.getMap()[closestR][closestC]);
                    }
                }
                
            }
        }
        return new Point(closestR, closestC);
    }
}
