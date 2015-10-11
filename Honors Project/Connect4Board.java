import java.io.*;
/**
 * Write a description of class Board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Connect4Board
{
    // instance variables - replace the example below with your own
    private int [][] board;
    private final int BLUE = 1;
    private final int RED = 2;
    private final int LENGTH = 6;
    private int counter;
    /**
     * Constructor for objects of class Board
     */
    public Connect4Board()
    {
        board = new int [6][6];
        counter = 0;
        for(int i = 0; i < board.length; i ++){
            for (int j = 0; j < board[0].length; j ++){
                board[i][j] = 0;
            }
        }
    }
    public int getValue(int x, int y){
        return board[x][y];
    }
    public boolean isValid(int x, int y){
        if (board[x][y] == 0){
            return true;
        } else {
            return false;
        }
    }

    public boolean hasWon(){
        counter = 0;
        for (int i = 0; i < board.length; i ++){
            for (int j = 0; j < board[0].length; j ++){
                checkStreak(i,j);
                if (counter == 4){
                    return true;
                }
            }
        }
        return false;
    }

    public void checkStreak(int x, int y){
        int iInit, iFinal, jInit, jFinal; 
        switch (x){
            case 0:
            iInit = x;
            iFinal = x+1;
            break;
            case LENGTH-1:
            iInit = x-1;
            iFinal = x;
            break;
            default:
            iInit = x-1;
            iFinal = x+1;
            break;
        }
        switch (y) {
            case 0:
            jInit = y;
            jFinal = y+1;
            break;
            case LENGTH-1:
            jInit = y-1;
            jFinal = y;
            break;
            default:
            jInit = y-1;
            jFinal = y+1;
            break;
        }
        for (int i = iInit; i <= iFinal; i++){
            for (int j = jInit; j <= jFinal; j ++){
                if (board[x][y] == board[i][j] && (i != x && j != y)){
                    counter ++;
                    if (counter != 4){
                        checkStreak(i,j);
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public void setValue(int x, int y, int color){
        board[x][y] = color;
    }
    
    public int lowestRow(int column){
        for (int i = LENGTH-1; i >= 0; i --){
            if (board[i][column] == 0){
                return i;
            }
        }
        return -1;
    }
    public String toString(){
        String result = "";
        for (int i = 0; i < LENGTH; i ++){
            for (int j = 0; j < LENGTH; j ++){
                result = result + "Cell (" + i + "," + j + ") has the value " + getValue(i,j) + "\n";
            }
        }
        return result;
    }
}
