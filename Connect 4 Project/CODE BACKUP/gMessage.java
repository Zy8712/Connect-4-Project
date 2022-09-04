import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

class gMessage extends JFrame implements ActionListener
{
  public static JPanel winM = new JPanel();
  public static JLabel win1 = new JLabel("Player 1 Wins ");
  public static JLabel win2 = new JLabel("Player 2 Wins ");
  public static JLabel tie = new JLabel ("Tie   ");
  boolean p1w, p2w, tiew;
  JButton okButton = new JButton("OK");
  JPanel okPanel = new JPanel();
  
  public gMessage()
  {
    setTitle("Congratulations");
    setSize(520, 520);
    setDefaultCloseOperation(0);
    setResizable(false);
    p1w = WinCon.p1w;
    p2w = WinCon.p2w;
    tiew = WinCon.tiew;
    okButton.addActionListener(this);
    
    if(p1w==true)
    {
      win1.setForeground(Color.red);
      winM.add(win1);
      win1.setFont(new Font ("Times New Roman", Font.BOLD, 52)); //Set page title's font settings
      win1.setPreferredSize(new Dimension(400,400)); //Set title size
      winM.add(okButton);
      add(winM);
    }
    
    else if(p2w==true)
    {
      win2.setForeground(Color.blue);
      winM.add(win2);
      win2.setFont(new Font ("Times New Roman", Font.BOLD, 52)); //Set page title's font settings
      win2.setPreferredSize(new Dimension(400,400)); //Set title size
      winM.add(okButton);
      add(winM);
    }
    
    else if(tiew==true)
    {
      winM.add(tie);
      tie.setFont(new Font ("Times New Roman", Font.BOLD, 52)); //Set page title's font settings
      tie.setPreferredSize(new Dimension(400,400)); //Set title size
      winM.add(okButton);
      add(winM);
    }
    setVisible(true);
  }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
//Action Listener. This method runs when an event occurs. Code in here only runs when a user interacts with a component that has an action listener attached to it.
  public void actionPerformed (ActionEvent event)
  {
    String command = event.getActionCommand(); //Find out the name of the component that was used   
    if (command.equals("OK")) //Condition. If the button was pressed.
    {
      dispose();
    }
  }
}