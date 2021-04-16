import java.awt.Point;

public class Predator extends Animal {
    private Point preyLocation;
    
    public Predator(int gridSize, Animal[][] map) {
        super(gridSize, map);
    }
    
    public Predator(int gridSize, int age, int hunger, int thirst, int strength, Point location) {
        super(gridSize, age, hunger, thirst, strength, location);
    }
    /*
    public boolean isOccupied(Animal a) {
        //if(r < 0 || c < 0 || r >= gridSize || c >= gridSize) {
        //    return false;
        //}
        if (a.getClass().equals("Animal"))
            return true;
        else
            return false;
    }
    */
}
