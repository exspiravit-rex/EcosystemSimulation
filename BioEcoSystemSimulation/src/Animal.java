import java.awt.Point;

public class Animal extends MapGUI{
    
    protected Animal[][] map; //stores map
    protected int gridSize; // stores the size of the grid
    private int age;
    private int hunger; // affected by move
    private int thirst; // affected by move
    private int strength; // affected by age
    //private int speed;
    private boolean move;
    private boolean fight;
    private Point location; // stores row & column of position in grid
    
    
    public Animal(int gridSize, Animal[][] map) {
        this.map = map;
        this.gridSize = gridSize;
        age = 1;
        hunger = 100;
        thirst = 100;
        strength = 0;
        move = false;
        fight = false;
        location = new Point(0, 0);
        
    }
    
    public Animal(int gridSize, int age, int hunger, int thirst, int strength, boolean move, boolean fight, Point location) {
        this.gridSize = gridSize;
        this.age = age;
        this.hunger = hunger;
        this.thirst = thirst;
        this.strength = strength;
        this.move = move;
        this.fight = fight;
        this.location = location;
        
    }
    
    public int getAge() {
        // returns age of animal
        return age;
    }
    
    public void setAge(int num) {
        // age increases by num
        age += num;
    }
    
    public int getHunger() {
        // returns hunger of animal
        return hunger;
    }
    
    public void setHunger(int hunger) {
        // sets hunger to param
        this.hunger = hunger;
    }
    
    public int getThirst() {
        // returns thirst of animal
        return thirst;
    }
    
    public void setThirst(int thirst) {
        // set thirst to param
        this.thirst = thirst;
    }
    
    public int getStrength() {
        // return strength
        return strength;
    }
    
    public void setStrength(int strength) {
        // set strength
        this.strength = strength;
    }
    
    public String getStatus() {
        if(move = true) {
            return "on the move";
        }
        return "resting";
    }
    
    public Point getLocation() {
        return location;
    }
}
