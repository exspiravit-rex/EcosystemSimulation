import java.awt.Point;

public class Predator extends Animal {
    private Point preyLocation;
    
    public Predator(MapGUI mapGUI, int r, int c) {
        super(mapGUI, r, c);
    }
    
    public Predator(MapGUI mapGUI, int r, int c, int age, int hunger, int thirst, int strength) {
        super(mapGUI, r, c, age, hunger, thirst, strength);
    }
    
    public String toString() {
        return "Predator at " + getLocation().getX() + ", " + getLocation().getY();
    }
    
    // checks if the index at r, c is a prey
    public boolean isOccupied(int r, int c) {
        if(r < 0 || c < 0 || r >= mapGUI.getGridSize() || c >= mapGUI.getGridSize() || r > getLocation().getX() + 3 || c > getLocation().getY() + 3) {
            System.out.println("not in range");
            return false;
        }
        if (mapGUI.getMap()[r][c] instanceof Prey) {
             System.out.println(mapGUI.getMap()[r][c]);
            return true;
        }
        else {
            System.out.println(mapGUI.getMap()[r][c]);
            return false;
        }
    }
}
