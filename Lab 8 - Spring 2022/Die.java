/*
Julia Burnett
48354206
Lab 8 Spring 2022
*/

//import statements
import java.util.Random;

//Die class
public class Die{

    //Declare and create private int value
    private int value;

    //Declare and create a Random
    Random random = new Random();

    /*
    Constructor
      Initialize value to 1
    */
    public Die() {
        value = 1;
    }// end Constructor

    //Getter for value attribute
    public int getValue(){
        return value;
    }//end getValue

    //Setter for value attribute
    public void setValue(int v){
        value = v;
    }//end setValue

    //Using java.util.Random, assign a random number in the range of 1..6 in the attribute value
    public int roll(){
        value = random.nextInt(6)+1;
        return value;
    }//end roll

    //Returns a String containing label Die followed by the contents of the value attribute, Example: Die 5
    public String toString() {
		String die = "Die " + String.valueOf(value);
        return die;
	}//end toString
}