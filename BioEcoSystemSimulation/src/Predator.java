import java.awt.Point;

public class Predator extends Animal {
    private Point preyLocation;
    
    public Predator() {
        super();
    }
    
    public Predator(int age, int hunger, int thirst, int strength, Point location) {
        super(age, hunger, thirst, strength, location);
    }
    
    public String toString() {
        return "Predator";
    }
}
