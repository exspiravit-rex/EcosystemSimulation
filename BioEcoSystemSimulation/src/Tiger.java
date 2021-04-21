import java.awt.Color;
import java.awt.Graphics;


public class Tiger extends Predator {
    private Color myColor;
    
    public Tiger(MapGUI mapGUI, int r, int c) {
        super(mapGUI, r, c);
        Color myColor = Color.ORANGE;
    }
    
    public Tiger(MapGUI mapGUI, int r, int c, int age, int hunger, int thirst) {
        super(mapGUI, r, c, age, hunger, thirst);
    }
    
    public void draw(Graphics g) {
        g.setColor(myColor);
        g.fillOval(getRow(), getCol(), 20, 20);
    }
    
    public String toString() {
        return "Tiger at " + getRow() + ", " + getCol();
    }
    
}
