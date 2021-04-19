import java.awt.Point;

public class Predator extends Animal {
    private Point preyLocation;
    
    public Predator(MapGUI mapGUI) {
        super(mapGUI);
    }
    
    public Predator(MapGUI mapGUI, int age, int hunger, int thirst, int strength, Point location) {
        super(mapGUI, age, hunger, thirst, strength, location);
    }
    
    public String toString() {
        return "Predator";
    }
    
    // checks if the index at r, c is a prey
    public boolean isOccupied(int r, int c) {
        if(r < 0 || c < 0 || r >= mapGUI.getGridSize() || c >= mapGUI.getGridSize()) {
            System.out.println(r + " " + c);
            System.out.println("out of grid");
            return false;
        }
        if (mapGUI.getMap()[r][c] instanceof Prey) {
            System.out.println(r + " " + c);
            System.out.println("is a prey");
            return true;
        }
        else {
            System.out.println(mapGUI.getMap()[r][c] + " " + r + " " + c);
            System.out.println("not a prey");
            return false;
        }
    }
}
