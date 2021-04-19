import java.awt.Point;

public class Animal extends Ecosystem{
    
    private int age;
    private int hunger; // affected by move
    private int thirst; // affected by move
    private int strength; // affected by age
    //private int speed;
    private boolean move;
    private boolean fight;
    
    
    public Animal(MapGUI mapGUI, int r, int c) {
        super(mapGUI, r, c);
        age = 1;
        hunger = 100;
        thirst = 100;
        strength = 0;
        move = false;
        fight = false;
        
    }
    
    public Animal(MapGUI mapGUI, int r, int c, int age, int hunger, int thirst, int strength) {
        super(mapGUI, r, c);
        this.age = age;
        this.hunger = hunger;
        this.thirst = thirst;
        this.strength = strength;
        this.move = false;
        this.fight = false;
        
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
    
    
    public String toString() {
        return "Animal at " + getLocation().getX() + ", " + getLocation().getY();
    }
}
