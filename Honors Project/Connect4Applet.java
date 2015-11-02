// Assignment #: Arizona State University CSE205 Honors Project
//         Name: Diana Chen
//    StudentID: 1209034433
//      Lecture: MWF 9:00AM - 9:50AM
//      Section: #1
//  Description: Connect4Applet creates the applet for the Connect4 Game.

import java.awt.*;
import javax.swing.*;


public class Connect4Applet extends JApplet
{
   public void init(){
       //Create a Connect4GUI object and add to the applet
       Connect4GUI connect4 = new Connect4GUI();
       getContentPane().add(connect4);
       setSize(900,900); 
    }
}
