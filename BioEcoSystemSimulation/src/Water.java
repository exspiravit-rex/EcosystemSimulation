/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ariel
 */
public class Water extends Ecosystem{
    private int amount;
    
    public Water(MapGUI mapGUI, int r, int c) {
        super(mapGUI, r, c);
        amount = 100;
    }
    
    public int getWater() {
        return amount;
    }
    
    public void setWater(int taken) {
        amount -= taken;
    }
    
    public String toString() {
        return "Water at " + getRow() + ", " + getCol();
    }
}
