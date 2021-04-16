import java.awt.Point;

public class Predator extends Animal {
    private Point preyLocation;
    
    public Predator(int gridSize, Animal[][] map) {
        super(gridSize, map);
    }
    
    public Predator(int gridSize, int age, int hunger, int thirst, int strength, boolean move, boolean fight, Point location) {
        super(gridSize, age, hunger, thirst, strength, move, fight, location);
    }
    
    public boolean isOccupied(int r, int c) {
        if(r < 0 || c < 0 || r >= gridSize || c >= gridSize) {
            return false;
        }
        if (map[r][c] != null)
            return true;
        else
            return false;
    }
}
