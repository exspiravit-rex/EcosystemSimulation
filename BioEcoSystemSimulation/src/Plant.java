
import java.awt.Color;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ariel
 */
public class Plant extends Ecosystem{
    private int height;
    private Color myColor;
    
    public Plant(MapGUI mapGUI, int r, int c) {
        super(mapGUI, r, c);
        height = 10;
        myColor = Color.GREEN;
    }
    
    public int getHeight() {
        return height;
    }
    
    public void changeHeight() {
        height--;
    }
    
    public void regrowing() {
        height += 0.5;
        if(height >= 10) {
            height = 10;
        }
    }
    
    public String toString() {
        return "Plant at " + getRow() + ", " + getCol();
    }
    
    public void draw(Graphics g) {
        g.setColor(myColor);
        g.fillOval(getRow(), getCol(), 20, 20);
    }
}
