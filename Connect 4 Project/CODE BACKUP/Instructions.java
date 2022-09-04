import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class Instructions extends JFrame implements ActionListener
{
 JPanel ipan1 = new JPanel();
 JPanel ipan2 = new JPanel();
 JButton back = new JButton ("Back");
 JLabel instruct = new JLabel ("<HTML><U>How to Play</U></HTML>"); //Create a label
 JLabel instruct2 = new JLabel ("<html>Connect 4 is a two-player connection game in which the players first choose a color <br> and then take turns dropping colored discs from the top into a seven-column,"
   +"<br>six-row vertically suspended grid. <br> The pieces fall straight down, occupying the next available space within the column.<br> The objective of the game is to connect four"
   +"<br>of one's own discs of the same color next to each other vertically, horizontally, or diagonally <br> before your opponent. <br> The first player to connect four will win!"); 


 public Instructions ()
 {
  setTitle("Connect 4 Instructions");
  setSize(740, 480); //Set window size
  setResizable(false);
  BorderLayout background = new BorderLayout();
  setLayout (background);
  ipan1.add(back);
  instruct.setFont(new Font ("Times New Roman", Font.BOLD, 36)); //Set page title's font settings
  instruct.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //Underline title
  instruct2.setFont(new Font ("Times New Roman", Font.BOLD, 18)); //Set text's font 
  ipan1.add(instruct);
  instruct.setPreferredSize(new Dimension(200,200)); //Set title size
  ipan2.add(instruct2);
  add(ipan1,BorderLayout.NORTH);
  add(ipan2,BorderLayout.CENTER);
  back.addActionListener(this);
  setVisible(true);
 }


 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
 //Action Listener. This method runs when an event occurs. Code in here only runs when a user interacts with a component that has an action listener attached to it.
 public void actionPerformed (ActionEvent event)
 {
  String command = event.getActionCommand(); //Find out the name of the component that was used    

  if (command.equals ("Back")) //Condition. If button of labeled was pressed.
  {
   System.out.println ("back Button Pressed"); //Display message in console
   dispose();
  }
 }
}