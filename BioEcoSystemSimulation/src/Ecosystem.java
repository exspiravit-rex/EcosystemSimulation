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
    
    public Ecosystem(MapGUI mapGUI) {
        this.mapGUI = mapGUI;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public boolean isOccupied(int r, int c) {
        if(r < 0 || c < 0 || r >= mapGUI.getGridSize() || c >= mapGUI.getGridSize()) {
            System.out.println(r + " " + c);
            System.out.println("out of grid");
            return false;
        }
        if (mapGUI.getMap()[r][c] instanceof Animal) {
            System.out.println(r + " " + c);
            System.out.println("it's an animal");
            return true;
        }
        else {
            System.out.println(mapGUI.getMap()[r][c] + " " + r + " " + c);
            System.out.println("not an animal");
            return false;
        }
    }
    
}
