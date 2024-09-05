/*
Julia Burnett
48354206
Lab 8 Spring 2022
*/

//import statements
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;

import java.io.File; 

//Player class
public class Player{

    /*
    Reference instance variable
    - myLocation contains a reference to a Location
    object passed into the constructor 
    */
    protected Location mylocation;

    /*
    Simple instance variable
    - name contains a String with the Player name 
    */
    protected String name;

    /*
    Constructor
    - Two parameters contain the player name and location
    - Set name and myLocation to the passed in values 
    */
    public Player(String name, Location mylocation){
        this.name = name;
        this.mylocation = mylocation;
    }//end constructor

    /*
    setName(int)
    setter for name attribute 
    */
    public void setName(String n) {
        this.name = n;
    }//end setName

    /*
    getName()
    Getter for name attribute 
    */
    public String getName() {
        return name;
    }//end getName

    /*
    setMyLocation(Location)
    setter for myLocation attribute 
    */
    public void setMyLocation(Location mylocation){
        this.mylocation = mylocation;
    }//end setMyLocation

    /*
    getMyLocation()
    Getter for myLocation attribute 
    */
    public Location getMyLocation() {
        return mylocation;
    }//end getMyLocation

    public int getLocationNumber() {
        return mylocation.getlocationNumber();
    }//end getLocationNumber

    /*
    Changes to the takeTurn method:
    – Rather than using a Scanner object to “shake” the dice, use a message
    dialog with the same text
    */
    public boolean takeTurn(Shaker theShaker){
        
        JOptionPane.showMessageDialog(null, String.format("%s's turn at %s. \n Press Enter to shake the dice...", name, mylocation.getName()));
        theShaker.shake();
        System.out.println("   " + theShaker);
        return isSuccessful(theShaker);
    }//end boolean

    /*
    isSuccessful - takes the total rolled value and the shaker. In the
    player class it will return true. This will be overridden by the
    subclasses. 
    */
    public boolean isSuccessful(Shaker theShaker){
        if(theShaker.isEven() == true){
            System.out.println("    Sum is even!");
            return true;
        }else{
            return false;
        }//end loop
    }//end boolean

    /*
    toString()
    - Returns a String containing the player name and
    current
    - Example: Pat is at Location #0: Admissions
    */
    public String toString() {
        return name + " is at " + mylocation;
    }//end String

}//end Player class