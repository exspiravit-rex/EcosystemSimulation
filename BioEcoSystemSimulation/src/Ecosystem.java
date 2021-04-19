
import java.awt.Point;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ariel
 */
public class Ecosystem {
    protected MapGUI mapGUI;
    private Point location; // stores row & column of position in grid
    
    public Ecosystem(MapGUI mapGUI, int r, int c) {
        this.mapGUI = mapGUI;
        location = new Point(r, c);
    }
    
    public MapGUI getMapGUI() {
        return mapGUI;
    }
    
    public Point getLocation() {
        return location;
    }
    

    public boolean isOccupied(int r, int c) {
        if(r < 0 || c < 0 || r >= mapGUI.getGridSize() || c >= mapGUI.getGridSize()) {
            System.out.println("out of grid");
            return false;
        }
        if (mapGUI.getMap()[r][c] instanceof Animal) {
            System.out.println(mapGUI.getMap()[r][c]);
            return true;
        }
        else {
            System.out.println(mapGUI.getMap()[r][c]);
            return false;
        }
    }
    
}
