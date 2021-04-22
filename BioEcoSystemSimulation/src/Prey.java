import java.awt.Point;
import java.util.ArrayList;

public class Prey extends Animal {
    private int reprodCount;
    
    public Prey(MapGUI mapGUI, int r, int c) {
        super(mapGUI, r , c);
        reprodCount = 10;
    }
    
    public Prey(MapGUI mapGUI, int r, int c, int hunger, int thirst) {
        super(mapGUI, r, c, hunger, thirst);
        reprodCount = 10;
    }
    
    public int getReprodCount() {
        return reprodCount;
    }
    
    public void setReprodCount(int r) {
        reprodCount = r;
    }
 
    // eat plant if near one method
    public void eatPlant() {
        for(int row = getRow() - 1; row < getRow() + 2; row++) {
            for(int col = getCol() - 1; col < getRow() + 2; col++) {
                if(isOccupied(row, col)) {
                    if(mapGUI.getMap()[row][col] instanceof Plant) {
                        if(((Plant)mapGUI.getMap()[row][col]).getHeight() > 0) { 
                            ((Plant)mapGUI.getMap()[row][col]).changeHeight();
                            setHunger(100);
                            System.out.println("Ate plant at" + row + ", " + col + " which is now " + ((Plant)mapGUI.getMap()[row][col]).getHeight());
                            break;
                        }
                        else {
                            System.out.println("Plant is not tall enough!");
                        }
                    }
                    else{
                        System.out.println("No plant here");
                    }
                }
            }
            if(getHunger() == 100) {
                break;
            }
        }
    }
    
    
    
    // REPRODUCTION CODE
    public void reproduction() {
        for(int row = getRow() - 1; row < getRow() + 2; row++) {
            for(int col = getCol() - 1; col < getRow() + 2; col++) {
                // check if it's occupied by ecosystem object or out of range
                if(isOccupied(row, col)) {
                    // check if it's predator
                    if(mapGUI.getMap()[row][col] instanceof Prey) {
                        // check if both are able to reproduce
                        if(getReproduced() == false && ((Prey)mapGUI.getMap()[row][col]).getReproduced() == false) {
                            // look for a free spot in the grid
                            for(int r = getRow() - 1; r < getRow() + 2; r++) {
                                for(int c = getCol() - 1; c < getRow() + 2; c++) {
                                    // free spot found
                                    // check if out of grid
                                    if((r < 0 || c < 0 || r >= mapGUI.getGridSize() || c >= mapGUI.getGridSize()) == false) {
                                        if(mapGUI.getMap()[r][c] == null) {
                                            // yay made a kid
                                            setReproduced(true);
                                            setReprodCount(10);
                                            ((Prey)mapGUI.getMap()[row][col]).setReproduced(true);
                                            ((Prey)mapGUI.getMap()[row][col]).setReprodCount(10);
                                            Pig baby = new Pig(mapGUI, r, c);
                                            mapGUI.getMap()[r][c] = baby;
                                            // add new thing in array list
                                            ArrayList<Ecosystem> temp  = mapGUI.getEcosystemArray();
                                            temp.add(baby);
                                            mapGUI.setEcosystemArray(temp);
                                            System.out.println("Produced a baby " + mapGUI.getMap()[r][c]);
                                            break;
                                        }
                                    }
                                }
                                if(getReproduced() == true) {
                                    break;
                                }
                            }
                        }
                    }
                }
                if(getReproduced() == true); {
                    break;
                }
            }
            if(getReproduced() == true) {
                break;
            }
        }
    }
    
    
    
    
    // MOVEMENT CODE 
    public void move() {
        super.move();
        
        if(getHunger() <= 75) {
            System.out.println("Pig hunger is " + getHunger());
            eatPlant();
        }
        
        if(getReproduced() == false) {
            reproduction();
        }
        else {
            setReprodCount(getReprodCount() - 1);
            if(getReprodCount() <= 0) {
                setReproduced(false);
            }
        }
    }
    
    
    
    
    
    public String toString() {
        return "Prey at " + getLocation();
    }
    
    // unused code. may be applied in the future
    /*
    public boolean findPredator(int r, int c) {
        if(r > getRow() + 2 || r < getRow() - 2 || c > getCol() + 2 || c < getCol() - 2) {
            return false; // out of range
        }
        else {
            return( super.isOccupied(r, c) && mapGUI.getMap()[r][c] instanceof Predator);
        }
    }
    
    public Point checkSurroundings(int r, int c) {
        // run away from predator
        for(int row = r - 1; row < r + 2; row++) {
            for(int col = c - 1; col < c + 2; col++) {
                if(findPredator(row, col)) {
                    System.out.println("found predator at " + row + " " +  col);
                    return new Point(row, col);
                }
            }
        }
        return new Point(r, c);
    }
    */
}
