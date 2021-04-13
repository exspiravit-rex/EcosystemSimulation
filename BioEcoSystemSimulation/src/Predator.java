import java.awt.Point;

public class Predator extends Animal {
    
    public Predator() {
        super();
    }
    
    public Predator(int age, int hunger, int thirst, int strength, boolean move, boolean fight, Point location) {
        super(age, hunger, thirst, strength, move, fight, location);
    }
    
}
