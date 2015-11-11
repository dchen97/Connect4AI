// Assignment #: Arizona State University CSE205 Honors Project
//         Name: Diana Chen
//    StudentID: 1209034433
//      Lecture: MWF 9:00AM - 9:50AM
//      Section: #1
//  Description: Connect4Board creates the board of the game and
//              keeps track of what the players have played. The
//              board also checks if the player's move won or not.
import java.io.*;

public class Connect4Board
{
    // instance variables - replace the example below with your own
    private int [][] board;
    private final int BLUE = 1; //value in the array of the board when there is a blue "chip"
    private final int RED = 2; // value in the array of the board when there is a red "chip"
    private final int LENGTH = 6; //length of one side of the board
    private int counter;
    /**
     * Constructor for objects of class Board
     */
    public Connect4Board()
    {
        board = new int [LENGTH][LENGTH];
        counter = 0;
        //set all initial values of the board to 0 --> no "chips"
        for(int i = 0; i < LENGTH; i ++){
            for (int j = 0; j < LENGTH; j ++){
                board[i][j] = 0;
            }
        }
    }
    //returns value at given coordinate on board
    public int getValue(int x, int y){
        return board[x][y];
    }
    //checks if the move is valid move
    //if there is already a value at the given coordinate on the board --> is not a valid move
    public boolean isValid(int x, int y){
        if (x >= 0 || y >= 0){
            if (board[x][y] == 0){
                return true;
            } else {
                return false;
            }
        } else return false;
    }
    //checks if there is a winning streak of 4 chips of the same color
    //winning player is not considered
    public boolean hasWon(){
        counter = 0;
        for (int i = 0; i < LENGTH; i ++){
            for (int j = 0; j < LENGTH; j ++){
                if (board[i][j] != 0){
                    checkStreak(i,j);
                }
                if (counter == 4){
                    return true;
                }
            }
        }
        return false;
    }
    //checks if the board is completely filled which would indicate a tie
    public boolean isTied(){
        for (int i = 0; i < LENGTH; i ++){
            for (int j = 0; j < LENGTH; j ++){
                if (board[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }
    //checks if there is a winning streak anywhere on the board
    public void checkStreak(int x, int y){
        counter = 0;
        checkDown(x,y);
        if (counter < 4){
            counter = 0;
            checkRight(x,y);
        }
        if (counter < 4){
            counter = 0;
            checkDiagonalRight(x,y);
        }
        if (counter < 4){
            counter = 0;
            checkDiagonalLeft(x,y);
        }
    }
    //checks value below the given point to see if it has the same color as the given point
    //if it does, it will recursively check the coordinate below this new point
    //continues recursion until the next point is not of the same color or the counter reaches 4
    public void checkDown(int x, int y){
        int color = board[x][y];
        counter ++;
        if (counter < 4){
            //check value below (x,y)
            int newY = y + 1;
            if ((newY) != LENGTH){
                if (board[x][newY] == color){
                    checkDown(x, newY);
                }
            }
        }
    }
    //checks value to the right of the given point to see if it has the same color as the given point
    //if it does, it will recursively check the coordinate right of this new point
    //continues recursion until next point is not of the same color or the counter reaches 4
    public void checkRight(int x, int y){
        int color = board[x][y];
        counter ++;
        if (counter < 4){
            //check value right of (x,y)
            int newX = x + 1;
            if ((newX) != LENGTH){
                if (board[newX][y] == color){
                    checkRight(newX, y);
                }
            }
        } 
    }
    //checks value of the points below and to the right of the given
    //point to see if it has the same color as the given
    //if it does, it will recursively check the coordinate diagonal of it
    //continues recursion until next point is not of the same color or the counter reaches 4
    public void checkDiagonalRight(int x, int y){
        int color = board[x][y];
        counter ++;
        if (counter < 4){
            //check value bottom right of (x,y)
            int newX = x + 1;
            int newY = y + 1;
            if (newY != LENGTH && newX != LENGTH){
                if (board[newX][newY] == color){
                    checkDiagonalRight(newX,newY);
                }
            }

        }
    }
    //checks value of the points below and to the left of the given
    //point to see if it has the same color as the given point
    //if it does, it will recursively check the coordinate diagonal of it
    //continues recursion until next point is not of the same color or the counter reaches 4
    public void checkDiagonalLeft(int x, int y){
        int color = board[x][y];
        counter ++;
        //check value bottom left of (x,y)
        if (counter < 4){
            int newX = x - 1;
            int newY = y + 1;
            if (newY != LENGTH && newX >= 0){
                if (board[newX][newY] == color){
                    checkDiagonalLeft(newX,newY);
                }
            }
        }
    }
    //returns the length of one side of the board
    public int getLength(){
        return LENGTH;
    }
    //mutator method to set value at the given point to the given value (color)
    public void setValue(int x, int y, int color){
        board[x][y] = color;
    }
    //calculates the lowest row in a given column that does not already have a value/"chip"
    public int lowestRow(int column){
        for (int i = LENGTH-1; i >= 0; i --){
            if (board[column][i] == 0){
                return i;
            }
        }
        return -1;
    }
    //resets the board so all "chips" are removed
    public void clearBoard(){
        for(int i = 0; i < LENGTH; i ++){
            for (int j = 0; j < LENGTH; j ++){
                board[i][j] = 0;
            }
        }
    }
    //toString method
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
