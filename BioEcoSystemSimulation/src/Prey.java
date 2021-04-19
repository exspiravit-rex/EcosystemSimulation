import java.awt.Point;

public class Prey extends Animal {
    
    
    public Prey(MapGUI mapGUI, int r, int c) {
        super(mapGUI, r , c);
    }
    
    public Prey(MapGUI mapGUI, int r, int c, int age, int hunger, int thirst, int strength) {
        super(mapGUI, r, c, age, hunger, thirst, strength);
    }
    
    public String toString() {
        return "Prey at " + getLocation().getX() + ", " + getLocation().getY();
    }
    
}
