// Assignment #: Arizona State University CSE205 Honors Project
//         Name: Diana Chen
//    StudentID: 1209034433
//      Lecture: MWF 9:00AM - 9:50AM
//      Section: #1
//  Description: Connect4GUI creates the GUI for the Connect 4 game.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Connect4GUI extends JPanel
{
    // instance variables - replace the example below with your own
    private JPanel bottomPanel;
    private JLabel lastTurnLabel;
    private JPanel lastTurnPanel;
    private JLabel playerBlueWinsLabel;
    private JLabel playerRedWinsLabel;
    private JButton selectColumnButton;
    private Play game;
    private JPanel labelPanel;
    private int selectedColumn;
    private int turnNum;
    private CanvasPanel canvas;
    private boolean rowIsSelected;
    /**
     * Constructor for objects of class Connect4GUI
     */
    public Connect4GUI()
    {
        selectedColumn = -1;
        turnNum = 0;
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(3, 1));
        rowIsSelected = false;
        game = new Play();

        //Creates canvas for visual of game
        canvas = new CanvasPanel();
        canvas.setBackground(Color.white);
        canvas.setSize(600,600);
        //Creates labels and button at bottom of GUI
        lastTurnLabel = new JLabel("");
        lastTurnPanel = new JPanel();
        lastTurnPanel.add(lastTurnLabel);
        playerBlueWinsLabel = new JLabel("Player Blue Wins: " + game.getBlueWins());
        playerRedWinsLabel = new JLabel ("Player Red Wins: " + game.getRedWins());
        selectColumnButton = new JButton("Select Column");
        //Panel for the player red/blue wins label
        labelPanel = new JPanel();
        labelPanel.setLayout(new FlowLayout());
        labelPanel.add(playerBlueWinsLabel);
        labelPanel.add(playerRedWinsLabel);
        //Adding components to the basePanel
        bottomPanel.add(lastTurnPanel);
        bottomPanel.add(labelPanel);
        bottomPanel.add(selectColumnButton);

        //adding button and mouse listeners to button and canvas
        selectColumnButton.addActionListener(new ButtonListener());
        canvas.addMouseListener(new RowListener());

        //add basePanel to the applet Panel
        setLayout(new BorderLayout());
        add(canvas, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            //checks if the selected column is valid
            if (selectedColumn >= 0){
                //checks to see which player is playing the turn
                if (turnNum % 2 == 0){
                    game.playTurn(1, selectedColumn);
                    //checks if the game was won or tied
                    if (game.gameComplete(1)){
                        JFrame frame = new JFrame("JOptionPane");
                        int n = JOptionPane.showConfirmDialog(frame, "Player 1 has won! Would you like to play again?",
                                "Play Again?", JOptionPane.YES_NO_OPTION);
                        if (n == JOptionPane.YES_OPTION){
                            game.resetGame();
                        } else {
                            System.exit(0);
                            remove(bottomPanel);
                        }
                    } else if (game.gameTied()){
                        JFrame frame = new JFrame("JOptionPane");
                        int n = JOptionPane.showConfirmDialog(frame, "Oh no! It is a tie! Would you like to play again?",
                                "Play Again?", JOptionPane.YES_NO_OPTION);
                        if (n == JOptionPane.YES_OPTION){
                            game.resetGame();
                        } else {
                            System.exit(0);
                            remove(bottomPanel);
                        }
                    }
                    turnNum ++;
                    //if the game was won, would need to reset labels
                    playerBlueWinsLabel.setText("Player Blue Wins: " + game.getBlueWins());
                    playerRedWinsLabel.setText("Player Red Wins: " + game.getRedWins());
                    lastTurnLabel.setText("Player Red has played his turn");
                } else {
                    game.playTurn(2, selectedColumn);
                    //checks if the game was won or tied
                    if (game.gameComplete(2)){
                        JFrame frame = new JFrame("JOptionPane");
                        int n = JOptionPane.showConfirmDialog(frame, "Player 2 has won! Would you like to play again?",
                                "Play Again?", JOptionPane.YES_NO_OPTION);
                        if (n == JOptionPane.YES_OPTION){
                            game.resetGame();
                        } else {
                            System.exit(0);
                            remove(bottomPanel);
                        }
                    } else if (game.gameTied()){
                        JFrame frame = new JFrame("JOptionPane");
                        int n = JOptionPane.showConfirmDialog(frame, "Oh no! It is a tie! Would you like to play again?",
                                "Play Again?", JOptionPane.YES_NO_OPTION);
                        if (n == JOptionPane.YES_OPTION){
                            game.resetGame();
                        } else {
                            System.exit(0);
                            remove(bottomPanel);
                        }
                    }
                    turnNum++;
                    //if the game was won, would need to reset labels
                    playerBlueWinsLabel.setText("Player Blue Wins: " + game.getBlueWins());
                    playerRedWinsLabel.setText("Player Red Wins: " + game.getRedWins());
                    lastTurnLabel.setText("Player Blue has played his turn");
                }
                rowIsSelected = false;
                canvas.repaint();
                selectedColumn = -1;
            } else {
                lastTurnLabel.setText("Please Select a Column");
            }
        }
    }
    private class RowListener implements MouseListener {
        //if the mouse is clicked on a given column, it selects that column
        public void mouseClicked(MouseEvent e){
            int x = e.getPoint().x;
            int y = e.getPoint().y;
            if (x < 100 && x >= 0){
                selectedColumn = 0;
                rowIsSelected = true;
            } else if (x < 200){
                selectedColumn = 1;
                rowIsSelected = true;
            } else if (x < 300){
                selectedColumn = 2;
                rowIsSelected = true;
            } else if (x < 400) {
                selectedColumn = 3;
                rowIsSelected = true;
            } else if (x < 500){
                selectedColumn = 4;
                rowIsSelected = true;
            } else if (x < 600){
                selectedColumn = 5;
                rowIsSelected = true;
            }

            canvas.repaint();
        }

        public void mouseEntered(MouseEvent e){}

        public void mouseExited(MouseEvent e){}

        public void mouseMoved(MouseEvent e){}

        public void mouseReleased(MouseEvent e){}

        public void mousePressed(MouseEvent e){}
    }
    //CanvasPanel is panel where game board is shown
    private class CanvasPanel extends JPanel{
        public void paintComponent(Graphics page){
            super.paintComponent(page);
            //draw out yellow rectangle of the board itself
            page.setColor(Color.yellow);
            page.fillRect(0, 0, 600, 600);
            page.setColor(Color.black);
            page.drawRect(0,0,600,600);
            //draw out the circles of the "slots" according to their color in the array
            //1 = red
            //2 = blue
            for (int i = 0; i < 6; i ++){
                for (int j = 0; j < 6; j ++){
                    switch(game.getBoardValue(i,j)){
                        case 1:
                        page.setColor(Color.red);
                        break;
                        case 2: page.setColor(Color.blue);
                        break;
                        default:
                        page.setColor(Color.white);
                        break;
                    }
                    page.fillOval(100*i + 10, 100 * j + 10, 80, 80);
                    page.setColor(Color.black);
                    page.drawOval(100*i + 10, 100 * j + 10, 80, 80);
                }
            }

            //if the user has selected a row, a rectangle will appear around the row
            //that they have selected
            if (rowIsSelected){
                page.setColor(Color.cyan);
                page.drawRect(100 * selectedColumn, 0, 100, 600); 
            }
        }
    }
}
