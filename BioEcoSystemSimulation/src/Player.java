


public class Player {
    
    int x=400;
    int y=300;
    int health=1000;
    int radius=20;
    
    public void moveLeft() {
        x=x-10;
    }
    
    public void moveRight() {
        x=x+10;
    }
    
    public void moveUp() {
        y=y-10;
    }
    
    public void moveDown() {
        y=y+10;
    }
    
    public void checkWrap() {
        if (x<0)
            x=800;
        else if (x>800)
            x=0;
        
        if (y<0)
            y=600;
        else if (y>600)
            y=0;
    }
}
