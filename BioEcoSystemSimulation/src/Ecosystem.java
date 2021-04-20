
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
    private int locR; // stores row of position in Map
    private int locC; // stores column of position in Map
    
    public Ecosystem(MapGUI mapGUI, int r, int c) {
        this.mapGUI = mapGUI;
        location = new Point(r, c);
        locR = r;
        locC = c;
    }
    
    public MapGUI getMapGUI() {
        return mapGUI;
    }
    
    public String getLocation() {
        return locR + ", " + locC;
    }
    
    public int getRow() {
        return locR;
    }
    
    public int getCol() {
        return locC;
    }

    public boolean isOccupied(int r, int c) {
        if(r < 0 || c < 0 || r >= mapGUI.getGridSize() || c >= mapGUI.getGridSize()) {
            System.out.println("out of grid");
            return false;
        }
        if (mapGUI.getMap()[r][c] instanceof Ecosystem) {
            System.out.println(mapGUI.getMap()[r][c]);
            return true;
        }
        else {
            System.out.println(mapGUI.getMap()[r][c]);
            return false;
        }
    }
    
}
