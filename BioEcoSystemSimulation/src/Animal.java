import java.awt.Point;

public class Animal extends Ecosystem{
    
    private int age;
    private int hunger; // affected by move
    private int thirst; // affected by move
    private int speed;
    private boolean move;
    private boolean fight;
    
    
    public Animal(MapGUI mapGUI, int r, int c) {
        super(mapGUI, r, c);
        age = 1;
        hunger = 100;
        thirst = 100;
        move = false;
        fight = false;
        
    }
    
    public Animal(MapGUI mapGUI, int r, int c, int age, int hunger, int thirst) {
        super(mapGUI, r, c);
        this.age = age;
        this.hunger = hunger;
        this.thirst = thirst;
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
    
    public int getSpeed() {
        // gets the speed
        return speed;
    }
    
    public void setSpeed(int s) {
        speed = s;
    } 
    
    public String getStatus() {
        if(move = true) {
            return "on the move";
        }
        return "resting";
    }

    public String toString() {
        return "Animal at " + getLocation();
    }
    
    public void drinkWater() {
        for(int row = getRow() - 1; row < getRow() + 2; row++) {
            for(int col = getCol() - 1; col < getRow() + 2; col++) {
                if(isOccupied(row, col)) {
                    if(mapGUI.getMap()[row][col] instanceof Water) { //&& ((Water)mapGUI.getMap()[row][col]).getWater() <= 0
                        ((Water)mapGUI.getMap()[row][col]).changeWater(100 - getThirst());
                        setThirst(100);
                        System.out.println("Drank from " + mapGUI.getMap()[row][col]);
                        break;
                    }
                    else{
                        System.out.println("No water here");
                    }
                }
            }
            if(getThirst() == 100) {
                break;
            }
        }
    }
}
