
/**
 * Write a description of class Play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Play
{
    // instance variables - replace the example below with your own
    private Board board;
    private int blueWins;
    private int redWins;

    /**
     * Constructor for objects of class Play
     */
    public Play()
    {
        board = new Board();
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
        
    }
}
