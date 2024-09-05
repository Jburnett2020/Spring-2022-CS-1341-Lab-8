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
import java.io.PrintWriter;
import java.util.ArrayList;

//GraduationGame class
public class GraduationGame {
    /*
    Reference instance variables
    - players contains an arraylist of Player objects
    - theCampus contains a reference to a Campus object
    - Add a third reference instance variable named theShaker
      referencing one Shaker object
    */
    private static ArrayList<Player> players = new ArrayList<Player>();
    private static Campus theCampus;
    private static Shaker theShaker;
    
    //Constructor
    public GraduationGame(String filename){
        theCampus = new Campus(filename);
        createPlayer();
        theShaker = new Shaker();
    }//end constructor

    /*
    main method will be adjusted to pass the file provided from
    the command line arguments to the Campus class using the
    args parameter in the main method.
    */
    public static void main(String[] args){
     GraduationGUI f = new GraduationGUI();
     //Without this, window won't exit the program when closed
     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     f.setSize(450,450);

     //Nothing displays without this
     f.setVisible(true);

    }// end main class

    /*
    In the createPlayers method:
    – Rather than using a Scanner object to accept input,
    we’ll need to use input dialogs to receive the
    names and player types associated with each
    player.
    – Also, use a confirm dialog to handle the “Would you
    like to add an additional player?”.
    – Any unexpected input should be met with a
    message dialog indicating that the input was not
    recognized, An incorrect choice (not A or B) for player 
    type should result in the following error message.
    This should take you back to the input dialog for 
    the player’s name to recreate the player.
    */
    public void createPlayer(){
        int num = 1;
        String name;
        while(true) {
            name = JOptionPane.showInputDialog(null, String.format("Enter player %d's name:  ", num), "Enter Player Name", JOptionPane.QUESTION_MESSAGE);
            Location start = theCampus.getStartLocation();
            String playType;
            playType = JOptionPane.showInputDialog(null,"Is this a Advanced player or Beginner? (A/B)","Enter Player Type", JOptionPane.QUESTION_MESSAGE);
            if(playType.equals("A")){
                players.add(new AdvancedPlayer(name, start));
            }
            else if(playType.equals("B")){
                players.add(new BeginnerPlayer(name, start));
            }//end loop
        
            int choice = JOptionPane.showConfirmDialog(null, "Would you like to add an additional player?","Add Players?", JOptionPane.YES_NO_CANCEL_OPTION);
        
            if((choice) == JOptionPane.YES_OPTION){
                num++;

                continue;
            }
            else if(choice == JOptionPane.NO_OPTION){
                break;
            }
            else{
                JOptionPane.showInputDialog("your input wasn't recognized please create a new player to try again");
            }
    
            // end for loop
        }// end for loop
    }//end createPlayer

    /*
    In the playGame method:
    – Change the return type from void to String
    – The method should return an output string created
    by concatenating all console output to a single
    formatted String
    – String.format() may be helpful here
    – Also, be sure to use a message dialog to output the
    results of each player’s turn
    */
    public String playGame(){
        boolean gameOver = false;
        String allOutput = "";
        while(gameOver == false){
            for(int i = 0 ; i < players.size(); i++){
                Player aPlayer = players.get(i);
                boolean advance = aPlayer.takeTurn(theShaker);
                if(advance == false){
                    allOutput = allOutput + String.format(" %s is at Location #%d: %s\n    %s is stuck\n",aPlayer.getName(), aPlayer.getLocationNumber(), aPlayer.getMyLocation().getName(), aPlayer.getName());
                    
                } else {
                    //get player's current location number
                    int locNum = aPlayer.getLocationNumber();
                    //increment locNum to advance
                    locNum++;
                    if (locNum == 7){
                        gameOver = true;
                        allOutput = allOutput + String.format("Game over! %s is the winner!\n",aPlayer.getName());
                        JOptionPane.showMessageDialog(null, String.format("Game over! %s is the winner!\n",aPlayer.getName()));

                        createWinnerCertificate(aPlayer);
                        break; //break out of playing for loop
                    } else {
                        Location newLoc = theCampus.getLocation(locNum);
                        aPlayer.setMyLocation(newLoc);
                        allOutput = allOutput + String.format("   %s is at Location #%d: %s and is advanced \n",aPlayer.getName(),locNum, newLoc.getName());
                        JOptionPane.showMessageDialog(null, String.format("   %s is at Location #%d: %s and is advanced \n",aPlayer.getName(),locNum, newLoc.getName()));
                    }
                }// end else advance == false
            }// end for loop
        }//end while loop
        return allOutput;

    }//end playGame

    /*
    A method called createWinnerCertificate(Player player) will be
    created that outputs the winner Certificate to the file
    winnerCertificate.txt.
    */
    public void createWinnerCertificate(Player player){
        String filename = "winnerCertificate.txt";
        try{
        PrintWriter writer = new PrintWriter(filename);  
        writer.println("*************************************");
        writer.println("           CONGRATS!!!               ");
        writer.println(String.format("%s has won the game!!!", player.name));
        writer.println("*************************************");
        writer.close();
        }
        catch(Exception e){
            System.out.println("cant make file");
        }//end loop
    }//end createWinnerCertificate

    /*
    toString()
    - Returns a String containing the String representation of
    both Player objects in the players array with their
    location
    */
    public String toString() {
        return "Graduation Game: \n" + players.get(0).toString() + players.get(1).toString();
    }// end toString
}//end GraduationGame class