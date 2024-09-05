/*
Julia Burnett
48354206
Lab 8 Spring 2022
*/

//import statements
import java.util.Scanner;
import java.util.ArrayList;

//Game class
public class Game{

    /*
    Reference instance variables
    - players contains an arraylist of Player objects
    - theCampus contains a reference to a Campus object
    */
    ArrayList<Player> players = new ArrayList<Player>();
    Campus theCampus;
    Scanner userinput = new Scanner(System.in);

    /*
    Constructor
    - Create a Campus object and assign to theCampus variable
    - Call the createPlayers method
    */
    public Game(){
        theCampus = new Campus("locations.txt");
        createPlayer();
    }//end Constructor

    /*createPlayers()
    - Use java.util.Scanner to prompt for the Players name into
    Strings
    - Send getStartLocation to theCampus, which will return the
    Location object that is the starting point of the game
    - Create two Player objects using the name entered by the
    user and the Location object returned by theCampus. Pass
    both to the Player constructor
    - Put each of the newly created Player objects in the
    players array */
    public void createPlayer(){
        System.out.print("Enter player 1's name: ");
        String playerOneName = userinput.next();
        
        System.out.print("Enter player 2's name: ");
        String playerTwoName = userinput.next();
        Location start = theCampus.getStartLocation();
        players.add(new Player(playerOneName, start));
        players.add(new Player(playerTwoName, start));
    }//end createPlayer

    /*
    toString()
    - Returns a String containing the String representation of
    both Player objects in the players array with their
    location
    */
    public String toString() {
        return "Graduation Game: \n" + players.get(0).toString() + players.get(1).toString();
    }//end toString
}//end Game class