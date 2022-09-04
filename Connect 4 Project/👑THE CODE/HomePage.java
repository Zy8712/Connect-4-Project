import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class HomePage extends JFrame implements ActionListener
{
//Global Variables  
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
//HOMEPAGE COMPONENTS. HOMEPAGE COMPONENTS. HOMEPAGE COMPONENTS. HOMEPAGE COMPONENTS. HOMEPAGE COMPONENTS. 
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  JLabel title = new JLabel ("Connect 4"); //Create a label
  JButton instructions = new JButton ("How To Play"); //Create a button for instuctions
  JButton player1 = new JButton("2 Players"); //Create a button 1 player mode
  JButton player2 = new JButton ("vs AI"); //Create a button for 2 player mode
  JButton quitButton = new JButton ("Quit"); //Create a button for exiting program
//Difficulty Buttons  
  JButton noneButton = new JButton ("None");
  JButton easyButton = new JButton ("Easy");
  JButton mediumButton = new JButton ("Medium");
  JButton hardButton = new JButton ("Hard");
  public static int difficulti=0;
  JLabel dif = new JLabel("Current AI Difficulty Level: None   ");
  
//Panels  
  JPanel pan1 = new JPanel(); //Create a panel for title
  JPanel pan2 = new JPanel(); //Create a panel for How to Play Button and game modes
  JPanel pan5 = new JPanel(); //Create a panel for different point limit option buttons and AI difficulty
  JPanel pan6 = new JPanel(); //Create a panel for Quit Button
  
  
  public HomePage() 
  {
    //Settings for Frame/Window    
    setTitle ("Connect 4"); //Set title for the window
    setSize (480 , 480); //Set dimensions of the window
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
//Set Up Home Page
    GridLayout Format = new GridLayout(5, 8, 0 ,0);
    FlowLayout layout = new FlowLayout(); //Declare a flowlayout
    FlowLayout difficulty = new FlowLayout();
    setLayout(Format);
    pan1.setLayout(layout); //Set panel to flowlayout
    pan2.setLayout(layout); //Set panel to flowlayout
    pan5.setLayout(difficulty);
    title.setFont(new Font ("Times New Roman", Font.BOLD, 22)); //Set page title's font settings
    title.setPreferredSize(new Dimension(100,100)); //Set title size
    pan1.add(title); //Add title to panel
    
    setVisible(true);
    pan2.add(instructions);
    instructions.addActionListener(this);
    pan2.add(player1);
    player1.addActionListener(this);
    pan2.add(player2);
    player2.addActionListener(this);
    pan5.add(noneButton);
    noneButton.addActionListener(this);
    pan5.add(easyButton);
    easyButton.addActionListener(this);
    pan5.add(mediumButton);
    mediumButton.addActionListener(this);
    pan5.add(hardButton);
    hardButton.addActionListener(this);
    pan5.add(dif);
    pan6.add(quitButton);
    quitButton.addActionListener(this);
    
    add(pan1, BorderLayout.NORTH);
    add(pan2, BorderLayout.CENTER); 
    add(pan5, BorderLayout. WEST);
    add(pan6, BorderLayout. EAST);
    setVisible(true);
  }
  
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
//Action Listener. This method runs when an event occurs. Code in here only runs when a user interacts with a component that has an action listener attached to it.
  public void actionPerformed (ActionEvent event)
  {
    String command = event.getActionCommand(); //Find out the name of the component that was used    
    if (command.equals ("How To Play")) //Condition. If button of labelled was pressed.
    {     
      System.out.println ("How to Play Button Pressed"); //Display message in console
      new Instructions();
    }  
    
    else if (command.equals ("2 Players")) //Condition. If button of labelled was pressed.
    {     
      System.out.println ("2 Player Button Pressed"); //Display message in console
      difficulti =0;
      
      new Connect4Gui();
      
      //Connect to Connect4Gui
    }
    
    
    else if (command.equals ("vs AI")) //Condition. If button of labelled was pressed.
    {
      System.out.println ("vs AI Button Pressed"); //Display message in console
      difficulti = 1;
      new Connect4Gui();
      //Connect to Connect4Gui and Activiate AI      
    }
    
    else if (command.equals("None")) //Condition. If the button was pressed.
    {
      difficulti = 0;
      dif.setText("Current AI Difficulty Level: None   ");
    }
    
    else if (command.equals("Easy")) //Condition. If the button was pressed.
    {
      difficulti = 1;
      dif.setText("Current AI Difficulty Level: Easy   ");
    }
    
    else if (command.equals("Medium")) //Condition. If the button was pressed.
    {
      difficulti = 2;
      dif.setText("Current AI Difficulty Level: Medium   ");
    }
    
    else if (command.equals("Hard")) //Condition. If the button was pressed.
    {
      difficulti = 3;
      dif.setText("Current AI Difficulty Level: Hard   ");
    }
    
    else if (command.equals("Quit")) //Condition. If the button was pressed.
    {
      dispose();
    }
  }
  
}