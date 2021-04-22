import java.awt.Point;
import java.util.ArrayList;

public class Predator extends Animal {
    private int reprodCount;
    
    public Predator(MapGUI mapGUI, int r, int c) {
        super(mapGUI, r, c);
        reprodCount = 100;
    }
    
    public Predator(MapGUI mapGUI, int r, int c, int hunger, int thirst) {
        super(mapGUI, r, c, hunger, thirst);
        reprodCount = 100;
    }
    
    public String toString() {
        return "Predator at " + getLocation();
    }
    
    public int getReprodCount() {
        return reprodCount;
    }
    
    public void setReprodCount(int r) {
        reprodCount = r;
    }
    
    // checks all of surroundings and eats prey if found
    public void huntPrey() {
        for(int row = getRow() - 1; row < getRow() + 2; row++) {
            for(int col = getCol() - 1; col < getRow() + 2; col++) {
                if(isOccupied(row, col)) {
                    if(mapGUI.getMap()[row][col] instanceof Prey) {
                        setHunger(100);
                        ArrayList<Ecosystem> temp  = mapGUI.getEcosystemArray();
                        for(Ecosystem eco : temp) {
                            if(eco.getRow() == row && eco.getCol() == col) {
                                temp.remove(temp.indexOf(eco));
                                break;
                            }
                        }
                        mapGUI.setEcosystemArray(temp);
                        mapGUI.getMap()[row][col] = null;
                        System.out.println("removed prey at " + row + ", " + col + " which is now " + mapGUI.getMap()[row][col]);
                        break;
                    }
                    else{
                        System.out.println("No prey here at " + row + ", " + col);
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
                    if(mapGUI.getMap()[row][col] instanceof Predator) {
                        // check if both are able to reproduce
                        if(getReproduced() == false && ((Predator)mapGUI.getMap()[row][col]).getReproduced() == false) {
                            // look for a free spot in the grid
                            for(int r = getRow() - 1; r < getRow() + 2; r++) {
                                for(int c = getCol() - 1; c < getRow() + 2; c++) {
                                    // free spot found
                                    // check if out of grid
                                    if((r < 0 || c < 0 || r >= mapGUI.getGridSize() || c >= mapGUI.getGridSize()) == false) {
                                        if(mapGUI.getMap()[r][c] == null) {
                                            // yay made a kid
                                            setReproduced(true);
                                            setReprodCount(100);
                                            ((Predator)mapGUI.getMap()[row][col]).setReproduced(true);
                                            ((Predator)mapGUI.getMap()[row][col]).setReprodCount(100);
                                            Tiger baby = new Tiger(mapGUI, r, c);
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
            System.out.println("Tiger hunger is " + getHunger());
            huntPrey();
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
    
    
    
    
    
    
    
    
    
}
