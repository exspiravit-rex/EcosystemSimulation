import java.awt.Color;
import java.awt.Graphics;


public class Pig extends Prey{
    private Color myColor;
    
    public Pig(MapGUI mapGUI, int r, int c) {
        super(mapGUI, r , c);
        Color myColor = Color.PINK;
    }
    
    public Pig(MapGUI mapGUI, int r, int c, int age, int hunger, int thirst) {
        super(mapGUI, r, c, age, hunger, thirst);
    }
    
    // draw the object on graphics object
    public void draw(Graphics g) {
        g.setColor(myColor);
        g.fillOval(getRow(), getCol(), 20, 20);
    }
    
    public String toString() {
        return "Pig at " + getRow() + ", " + getCol();
    }
    
}
