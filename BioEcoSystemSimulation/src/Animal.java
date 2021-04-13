/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1269170
 */
public class Animal {
     
    private int age;
    private int hunger; // affected by move
    private int thirst; // affected by move
    private int strength; // affected by age
    private boolean move;
    private boolean fight;
    
    
    public Animal() {
        age = 1;
        hunger = 100;
        thirst = 100;
        strength = 0;
        move = false;
        fight = false;
        
    }
    
    public Animal(int age, int hunger, int thirst, int strength, boolean move, boolean fight) {
        this.age = age;
        this.hunger = hunger;
        this.thirst = thirst;
        this.strength = strength;
        this.move = move;
        this.fight = fight;
        
    }
    
    public int getAge() {
        // returns age of animal
        return age;
    }
    
    public void setAge(int num) {
        // age increases by num
        age += num;
    }
    
    public int getHunger() {
        // returns hunger of animal
        return hunger;
    }
    
    public void setHunger(int hunger) {
        this.hunger = hunger;
    }
    
    
    
    
    
}
