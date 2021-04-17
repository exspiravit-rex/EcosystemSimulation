import java.awt.Point;

public class Prey extends Animal {
    
    
    public Prey() {
        super();
    }
    
    public Prey(int age, int hunger, int thirst, int strength, Point location) {
        super(age, hunger, thirst, strength, location);
    }
    
    public String toString() {
        return "Prey";
    }
    
}
