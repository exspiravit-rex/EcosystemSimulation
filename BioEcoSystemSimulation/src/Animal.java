import java.awt.Point;
import java.util.ArrayList;

public class Animal extends Ecosystem{
    
    private int hunger; // affected by move
    private int thirst; // affected by move
    // not used private boolean fight;
    private boolean moved;
    private boolean reproduced;
    private int[] directions = {0, 1, 2, 3, 4, 5, 6, 7};
    
    
    public Animal(MapGUI mapGUI, int r, int c) {
        super(mapGUI, r, c);
        hunger = 100;
        thirst = 100;
        // fight = false;
        moved = false;
        reproduced = true;
        
    }
    
    public Animal(MapGUI mapGUI, int r, int c, int hunger, int thirst) {
        super(mapGUI, r, c);
        this.hunger = hunger;
        this.thirst = thirst;
        // this.fight = false;
        moved = false;
        reproduced = true;
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
    
    public boolean getMoved() {
        return moved;
    }
    
    public void setMoved(boolean b) {
        moved = b;
    }
    
    public boolean getReproduced() {
        return reproduced;
    }
    
    public void setReproduced(boolean b) {
        reproduced = b;
    }
    
    
    public Point getDirection() {
        int dir = directions[(int)(Math.random()*directions.length)];
        int r;
        int c;
        
        if(dir == 0) {
            r = getRow() - 1;
            c = getCol() - 1;
            if((r < 0 || c < 0 || r >= mapGUI.getGridSize() || c >= mapGUI.getGridSize()) == false) {
                if(isOccupied(r, c) == false){
                    return new Point(r, c);
                }
            }
        }
        else if(dir == 1) {
            r = getRow() - 1;
            c = getCol();
            if((r < 0 || r >= mapGUI.getGridSize()) == false) {
                if(isOccupied(r, c) == false){
                    return new Point(r, c);
                }
            }
        }
        else if(dir == 2) {
            r = getRow() - 1;
            c = getCol() + 1;
            if((r < 0 || c < 0 || r >= mapGUI.getGridSize() || c >= mapGUI.getGridSize()) == false) {
                if(isOccupied(r, c) == false){
                    return new Point(r, c);
                }
            }
        }
        else if(dir == 3) {
            r = getRow();
            c = getCol() + 1;
            if((r < 0 || c < 0 || r >= mapGUI.getGridSize() || c >= mapGUI.getGridSize()) == false) {
                if(isOccupied(r, c) == false){
                    return new Point(r, c);
                }
            }
        }
        else if(dir == 4) {
            r = getRow() + 1;
            c = getCol() + 1;
            if((r < 0 || c < 0 || r >= mapGUI.getGridSize() || c >= mapGUI.getGridSize()) == false) {
                if(isOccupied(r, c) == false){
                    return new Point(r, c);
                }
            }
        }
        else if(dir == 5) {
            r = getRow() + 1;
            c = getCol();
            if((r < 0 || c < 0 || r >= mapGUI.getGridSize() || c >= mapGUI.getGridSize()) == false) {
                if(isOccupied(r, c) == false){
                    return new Point(r, c);
                }
            }
        }
        else if(dir == 6) {
            r = getRow() + 1;
            c = getCol() - 1;
            if((r < 0 || c < 0 || r >= mapGUI.getGridSize() || c >= mapGUI.getGridSize()) == false) {
                if(isOccupied(r, c) == false){
                    return new Point(r, c);
                }
            }
        }
        else if(dir == 7) {
            r = getRow();
            c = getCol() - 1;
            if((r < 0 || c < 0 || r >= mapGUI.getGridSize() || c >= mapGUI.getGridSize()) == false) {
                if(isOccupied(r, c) == false){
                    return new Point(r, c);
                }
            }
        }
        return new Point(getRow(), getCol());
    }

    
    // MOVEMENT CODE - WHAT IT DOES DURING EACH TICK
    public void move() {
        // decrease hunger and thirst
        setThirst(getThirst() - 1);
        setHunger(getHunger() - 1);
        
        // moving
        moved = true;
        Point dir = getDirection();
        mapGUI.getMap()[getRow()][getCol()] = null;
        mapGUI.getMap()[((int)dir.getX())][((int)dir.getY())] = this;
        setLocation(((int)dir.getX()),((int)dir.getY()));
        System.out.println("moving to " + ((int)dir.getX()) + ", " + ((int)dir.getY()));
        
        
        // check for drinking water
        if(getThirst() <= 75) {
            System.out.println("Thirst is " + getThirst());
            drinkWater();
            System.out.println("Thirst is " + getThirst());
        }
        
        if(getHunger() <= 0) {
            ArrayList<Ecosystem> temp  = mapGUI.getEcosystemArray();
            for(Ecosystem eco : temp) {
                if(eco.getRow() == getRow() && eco.getCol() == getCol()) {
                    temp.remove(temp.indexOf(eco));
                    break;
                }
            }
            mapGUI.setEcosystemArray(temp);
            System.out.println(this + " died.");
            mapGUI.getMap()[getRow()][getCol()] = null;
        }
        
        if(getThirst() <= 0) {
            ArrayList<Ecosystem> temp  = mapGUI.getEcosystemArray();
            for(Ecosystem eco : temp) {
                if(eco.getRow() == getRow() && eco.getCol() == getCol()) {
                    temp.remove(temp.indexOf(eco));
                    break;
                }
            }
            mapGUI.setEcosystemArray(temp);
            System.out.println(this + " died.");
            mapGUI.getMap()[getRow()][getCol()] = null;
        }
    }
    
    //mapGUI.getMap()[getRow()][getCol()].getClass() + " at " + getRow() + ", " + getCol() +
    
    
    
    
    
    
    
    public String toString() {
        return "Animal at " + getLocation();
    }
    
    public void drinkWater() {
        for(int row = getRow() - 1; row < getRow() + 2; row++) {
            for(int col = getCol() - 1; col < getRow() + 2; col++) {
                if(isOccupied(row, col)) {
                    if(mapGUI.getMap()[row][col] instanceof Water) { //&& ((Water)mapGUI.getMap()[row][col]).getWater() <= 0
                        if(((Water)mapGUI.getMap()[row][col]).getWater() >= 25) {
                            System.out.println(((Water)mapGUI.getMap()[row][col]).getWater());
                            ((Water)mapGUI.getMap()[row][col]).changeWater(100 - getThirst());
                            System.out.println(((Water)mapGUI.getMap()[row][col]).getWater());
                            setThirst(100);
                            System.out.println("Drank from " + mapGUI.getMap()[row][col]);
                            break;
                        }
                        else {
                            System.out.println("Not enough water here at " + row + ", " + col);
                        }
                    }
                    else{
                        System.out.println("No water here at " + row + ", " + col);
                    }
                }
            }
            if(getThirst() == 100) {
                break;
            }
        }
    }
}
