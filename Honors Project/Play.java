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
    public int getBlueWins(){
        return blueWins;
    }
    public int getRedWins(){
        return redWins;
    }
    public void playTurn(int player, int column){
        
        
        if (board.hasWon()){
            if (player == 1){
                redWins ++;
            } else if (player == 2){
                blueWins ++;
            }
            JFrame frame = new JFrame("JOptionPane");
            int n = JOptionPane.showConfirmDialog(frame, "Would you like to play again?",
                        "Play Again?", JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION){
                resetGame();
            } else {
                System.exit(0);
            }
        }
    }
    public int getBoardValue(int x, int y){
        return board.getValue(x,y);
    }
    public void resetGame(){
        
    }
}
