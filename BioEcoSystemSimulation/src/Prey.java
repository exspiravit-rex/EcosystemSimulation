import java.awt.Point;

public class Prey extends Animal {
    
    public Prey() {
    
    }
    
    public Prey(int age, int hunger, int thirst, int strength, boolean move, boolean fight, Point location) {
        super(age, hunger, thirst, strength, move, fight, location);
    }
    
}
