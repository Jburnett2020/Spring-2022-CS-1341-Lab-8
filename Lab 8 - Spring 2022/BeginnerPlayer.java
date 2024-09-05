/*
Julia Burnett
48354206
Lab 8 Spring 2022
*/

//AdvancedPlayer extends Player class
public class BeginnerPlayer extends Player{

    /*
    Inherits the Player Class
    Constructor
    */
    public BeginnerPlayer(String name, Location mylocation){
        super( name,mylocation);
    }//end Constructor

    /*
    isSuccessful() will take the shaker object. It will check that the shaker is even.
    If so it will return true and print Sum is even, else it will return false.
    */
    public boolean isSucccesful(Shaker theShaker){
        if(theShaker.isEven()){
            System.out.println("    Sum is even!");
            return true;
        }else{
            return false;
        }//end for loop
    }//end boolean

    /*
    toString will return the player name, location and that it is an advanced player. 
    */
    public String toString(){
        return super.toString();
    }//end toString
}//end AdvancedPlayer extends Player class