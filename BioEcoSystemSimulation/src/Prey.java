import java.awt.Point;

public class Prey extends Animal {
    
    
    public Prey(MapGUI mapGUI, int r, int c) {
        super(mapGUI, r , c);
    }
    
    public Prey(MapGUI mapGUI, int r, int c, int age, int hunger, int thirst) {
        super(mapGUI, r, c, age, hunger, thirst);
    }
    
    public void eatPlant() {
        for(int row = getRow() - 1; row < getRow() + 2; row++) {
            for(int col = getCol() - 1; col < getRow() + 2; col++) {
                if(isOccupied(row, col)) {
                    if(mapGUI.getMap()[row][col] instanceof Plant) {//&& ((Plant)mapGUI.getMap()[row][col]).getHeight() <= 0
                        ((Plant)mapGUI.getMap()[row][col]).changeHeight();
                        setHunger(100);
                        System.out.println("Ate " + mapGUI.getMap()[row][col]);
                        break;
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
    
    
    
    
    
    
    
    public String toString() {
        return "Prey at " + getLocation();
    }
    
    public boolean findPredator(int r, int c) {
        if(r > getRow() + 2 || r < getRow() - 2 || c > getCol() + 2 || c < getCol() - 2) {
            return false; // out of range
        }
        else {
            return( super.isOccupied(r, c) && mapGUI.getMap()[r][c] instanceof Predator);
        }
    }
    
    public Point checkSurroundings(int r, int c) {

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
}
