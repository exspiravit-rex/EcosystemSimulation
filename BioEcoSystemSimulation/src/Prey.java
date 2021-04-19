import java.awt.Point;

public class Prey extends Animal {
    
    
    public Prey(MapGUI mapGUI) {
        super(mapGUI);
    }
    
    public Prey(MapGUI mapGUI, int age, int hunger, int thirst, int strength, Point location) {
        super(mapGUI, age, hunger, thirst, strength, location);
    }
    
    public String toString() {
        return "Prey";
    }
    
}
