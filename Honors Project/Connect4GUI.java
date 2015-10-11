 //Name: Diana Chen
 //ID: 1209034433
 
 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;
public class Connect4GUI extends JPanel
{
    // instance variables - replace the example below with your own
    private JPanel basePanel;
    private JLabel lastTurnLabel;
    private JLabel playerBlueWinsLabel;
    private JLabel playerRedWinsLabel;
    private JButton selectColumnButton;
    private Play game;
    private JPanel labelPanel;
    private int selectedRow;
    private int turnNum;

    /**
     * Constructor for objects of class Connect4GUI
     */
    public Connect4GUI()
    {
        selectedRow = -1;
        turnNum = 0;
        basePanel = new JPanel();
        basePanel.setLayoutManager(new GridLayout(4, 1));
        lastTurnLabel = new JLabel("");
        game = new Play();
        playerBlueWinsLabel = new JLabel("Player Blue Wins: " + game.getBlueWins());
        playerRedWinsLabel = new JLabel ("Player Red Wins: " + game.getRedWins());
        selectColumnButton = new JButton("Select Column");
        labelPanel = new JPanel();
        labelPanel.setLayoutManager(new FlowLayout());
        labelPanel.add(playerBlueWinsLabel);
        labelPanel.add(playerRedWinsLabel);
        
        selectColumnButton.addActionListener(new ButtonListener);
        
    }
    private class ButtonListener extends ActionListener {
        private void actionPerformed(ActionEvent e){
            if (selectedRow >= 0){
                if (turnNum % 2 == 0){
                    game.playTurn(1, selectedRow);
                } else {
                    game.playTurn(2, selectedRow);
                }
            } else {
                lastTurnLabel.setText("Please Select a Column");
            }
        }
    }
}
