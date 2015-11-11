// Assignment #: Arizona State University CSE205 Honors Project
//         Name: Diana Chen
//    StudentID: 1209034433
//      Lecture: MWF 9:00AM - 9:50AM
//      Section: #1
//  Description: Play creates the board and keeps track of the wins for the players.
import java.awt.Dialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class Play
{
    // instance variables - replace the example below with your own
    private Connect4Board board;
    private int blueWins;
    private int redWins;

    /**
     * Constructor for objects of class Play
     */
    public Play()
    {
        board = new Connect4Board();
        blueWins = 0;
        redWins = 0;
    }
    //accessor method to return how many times the blue player has won
    public int getBlueWins(){
        return blueWins;
    }
    //accessor method to return how many times the red player has won
    public int getRedWins(){
        return redWins;
    }
    //plays a "turn" for the given player in the given column
    //places "chip" into given coordinate
    public void playTurn(int player, int column){
        if (board.isValid(column, board.lowestRow(column))){
            board.setValue(column, board.lowestRow(column), player);
        }
    }
    //returns if the game has been won by the given player
    //returns true if the game is complete
    //returns false if the game is not complete
    public boolean gameComplete(int player){
        if (board.hasWon()){
            System.out.print(";asldk");
            if (player == 1){
                redWins ++;
            } else if (player == 2){
                blueWins ++;
            }
            return true;
        }
        return false;
    }
    //returns if the game has been completed in a tie
    //returns true if the game ends in a tie
    //returns false if the game does not end in a tie
    public boolean gameTied(){
        if (board.isTied()){
            return true;
        }
        return false;
    }
    //returns board value at given coordinate
    public int getBoardValue(int x, int y){
        return board.getValue(x,y);
    }
    //resets the board to clear all of the "chips"
    //does not reset number of wins from each player
    public void resetGame(){
        board.clearBoard();
    }
}
