import java.awt.Point;

public class Prey extends Animal {
    
    
    public Prey(MapGUI mapGUI, int r, int c) {
        super(mapGUI, r , c);
    }
    
    public Prey(MapGUI mapGUI, int r, int c, int age, int hunger, int thirst, int strength) {
        super(mapGUI, r, c, age, hunger, thirst, strength);
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
}
