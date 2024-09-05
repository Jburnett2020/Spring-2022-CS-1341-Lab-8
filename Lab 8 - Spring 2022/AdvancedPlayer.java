/*
Julia Burnett
48354206
Lab 8 Spring 2022
*/

//AdvancedPlayer extends Player class
public class AdvancedPlayer extends Player{

    /*
    Inherits the Player class
    Constructor
    */
    public AdvancedPlayer (String name, Location mylocation){
        super( name,mylocation);
    }//end Constructor

    /*
    isSuccessful receives the Shaker object. It determines if the roll
    as even and greater than 6.
    If so, it will print Sum is even and greater than 6! and return true.
    Otherwise it will return false.
    */
    public boolean isSuccessful(Shaker theShaker){
        if(theShaker.isEven() && theShaker.isGreaterThanSix()){
            System.out.println("    Sum is even and greater than 6!");
            return true;
        }else{
            return false;
        }// end for loop
    }//end boolean

    /*
    toString will return the player name, location and that it is an
    advanced player.
    */
    public String toString() {
        return super.toString();
    }//end toString
}//end AdvancedPlayer extends Player class