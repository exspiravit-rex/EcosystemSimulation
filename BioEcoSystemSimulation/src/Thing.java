

import java.awt.Color;
import java.awt.Graphics;

public class Thing {
    
    int x, y, xSpeed, ySpeed;
    Color myColor;
    
    public Thing(int x, int y) {
        this.x=x;
        this.y=y;
        xSpeed=(int)(Math.random()*7)-3;
        ySpeed=(int)(Math.random()*7)-3;
        myColor=Color.ORANGE;
    }
    
    public void move() {
       x+=xSpeed;
       y+=ySpeed;
    }
    
    public void draw(Graphics g) {
        g.setColor(myColor);
        g.fillOval(x,y, 20, 20);
    }
}
