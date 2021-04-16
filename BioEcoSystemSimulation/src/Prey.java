import java.awt.Point;

public class Prey extends Animal {
    
    
    public Prey(int gridSize, Animal[][] map) {
        super(gridSize, map);
    }
    
    public Prey(int gridSize, int age, int hunger, int thirst, int strength, Point location) {
        super(gridSize, age, hunger, thirst, strength, location);
    }
    
    
}
