import java.awt.Color;
import java.awt.Graphics;


public class Water extends Ecosystem{
    private int amount;
    private Color myColor;
    
    public Water(MapGUI mapGUI, int r, int c) {
        super(mapGUI, r, c);
        amount = 100;
        myColor = Color.BLUE;
    }
    
    public int getWater() {
        return amount;
    }
    
    public void changeWater(int taken) {
        amount -= taken;
        if(amount <= 100) {
            amount++;
        }
    }
    
    public String toString() {
        return "Water at " + getRow() + ", " + getCol();
    }
    
    public void draw(Graphics g) {
        g.setColor(myColor);
        g.fillOval(getRow(), getCol(), 20, 20);
    }
}
