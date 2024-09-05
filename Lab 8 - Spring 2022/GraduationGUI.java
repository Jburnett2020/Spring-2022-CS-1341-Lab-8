/*
Julia Burnett
48354206
Lab 8 Spring 2022
*/

//import statements
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//GraduationGUI extends JFrame class
/*
The GraduationGUI will need to contain an inner class to implement an
ActionListener interface
*/
public class GraduationGUI extends JFrame{

    //Simple instance variables
    //Declare JTextArea and JScroll Pane
    //above the Constructor
    private JTextArea myOutput;
    private JScrollPane myScrollPane;
    private JButton myPlay;
    private JButton myReset;
    private GraduationGame myGame;

    //Constructor
    /*
    This listener will be used to handle events from clicking on the GUI
    components from the frame created by the GraduationGUI constructor
    This listener will be used to handle events from clicking on the GUI
    Upon clicking the “Play” button:
    – The text “New Graduation Game!!!” Should be printed to the
        TextArea
    – An input dialog should appear to receive the locations file name to
        read from
    – The “Play” button should be disabled and the “Reset” button should
        be enabled
    – After receiving and passing that filename to your GraduationGame
        constructor just like we did in Lab 7, your game should start
    – We’ll also want to add all the text output for the entire game to our
        TextArea after a player wins the game
    Clicking the “Reset” button should:
        – Clear the Text Area
        – Restart the game
    */
    public GraduationGUI(){
        super("Graduation Game");
        setLayout(new FlowLayout());

        myPlay = new JButton("Play");
        myPlay.addActionListener(new ButtonListener());
        myPlay.setEnabled(true);
        add(myPlay);

        myReset = new JButton("Reset");
        myReset.addActionListener(new ButtonListener());
        myReset.setEnabled(false);
        add(myReset);

        //Create and add widgets in the Constructor
        myOutput = new JTextArea(20,30);
        myScrollPane = new JScrollPane(myOutput);
        add(myScrollPane);

        //Disable editing
        myOutput.setEditable(false);
    }//end construction

    public class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == myPlay){
                myPlay.setEnabled(false);
                myReset.setEnabled(true);
                myOutput.setText("New Graduation Game!!!");

                String myfilename = JOptionPane.showInputDialog(null, "Enter filename for ",
                    "Enter filename", JOptionPane.INFORMATION_MESSAGE);

                myGame = new GraduationGame(myfilename);
                myOutput.append(myGame.playGame());
            }//end loop

            if (e.getSource() == myReset) {
                myPlay.setEnabled(true);
                myReset.setEnabled(false);
                myOutput.setText("");
                
            }//end loop
        }//end actionPerformance
    }//end ButtonListener
}//end GraduationGUI extends JFrame class