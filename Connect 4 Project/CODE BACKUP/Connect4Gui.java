import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.Timer;
import javax.swing.*;

class Connect4Gui extends JFrame implements MouseListener, ActionListener
{
  //variables
  static int column;
  public static int [][] board = new int [6][7]; // 0 = empty , 1 = player 1, 2 = player2
  public static int empty = 0;
  public static int p1 = 1;
  public static int p2 =2;
  public static boolean turn;
  public static Random rand = new Random();
  JLabel [][] check = new JLabel[6][7];
  public static JPanel Grid = new JPanel(); //Checkpoint
  public static JButton exitButton = new JButton ("Exit"); //Create a button for exiting game page
  public static JPanel options = new JPanel(); //Create a panel for exit button  
  JPanel northLayer = new JPanel(); //Checkpoint
  static draw[][] array=new draw[6][7];
  public static boolean click; 
  public static JLabel p1t = new JLabel("Player 1's Turn        ");
  public static JLabel p2t = new JLabel("Player 2's Turn        ");
  public static JLabel firstP = new JLabel ();

  
  
  public Connect4Gui()
  {
    BorderLayout Background = new BorderLayout(); //Set layout
    GridLayout layout1 = new GridLayout(6, 7, 0, 0); //Set layout
    FlowLayout layout2 = new FlowLayout(); //Set layout
    
    setTitle("Connect 4"); //Set title of window
    setSize (1000, 1000); //Set window size
    setDefaultCloseOperation(0); //Disables x sign on window, due to bugs when it is used
    
    
    setLayout(Background); //Set layout for frame
    Grid.setLayout(layout1); //Set layout for grid
    northLayer.setLayout(layout2); //Set layout for northlayer
    setResizable(false); //Restrict window size
    
//Draw up grid    
    for (int i = 0 ; i < board.length ; i++)
    {
      for (int j = 0 ; j < board[i].length ; j ++)
      {
        board[i][j] = empty;
        array[i][j]= new draw();
        Grid.add(array[i][j]);
        array[i][j].drawing();
        
        System.out.print(board[i][j]); //Print grid in console (for testing)
      }
      System.out.println(); //Create space in console
    }
    setVisible (true); //Set visible
    
    turn = GoingFirst(rand, turn); //Set turn equal to value returned from method
    System.out.println(turn); //Output variable (for testing)
    
    add(Grid, BorderLayout.CENTER); //Add grid onto window
    add(northLayer, BorderLayout.NORTH); //Add northlayer onto window
    options.add(firstP); //Add label onto panel
    options.add(p1t); //Add label onto panel
    options.add(p2t); //Add label onto panel
    options.add(exitButton); //Add exit button onto panel
    exitButton.addActionListener(this); //Implement actionlistener on exit button
    add(options, BorderLayout.SOUTH); //Add panel onto window
    Grid.addMouseListener(this); //Implement mouselistener onto grid
  }
  
//Determine who is going first
  public static boolean GoingFirst(Random rand, boolean turn)
  {  
    turn =false; //Set turn to false
    int n = rand.nextInt(2)+1; //Set integer variable n equal to randomly generated number between 1 and 2
    System.out.println (n); //Output variable (for testing)
    firstP.setText("Player "+n +" Goes First      ");
    firstP.setForeground(Color.green);
    p1t.setForeground(Color.white);
    p2t.setForeground(Color.white);
    
    if (n == 1)
    {
      System.out.println ("Player 1 is going first");
      turn = !turn;
      return turn;
    }
    
    else
    {
      System.out.println ("Player 2 is going first");
      int difficulti = HomePage.difficulti;
      
      if (difficulti == 1)
      {
        new AI_easy();
        column = AI_easy.easy;
        click = true;
        try        
        {
          Thread.sleep((long) .75);
        } 
        catch(InterruptedException ex) 
        {
          Thread.currentThread().interrupt();
        }       
      }
      click = false;
      return turn;
    }
  }
  
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
//Action Listener. This method runs when an event occurs. Code in here only runs when a user interacts with a component that has an action listener attached to it.
  public void actionPerformed (ActionEvent event)
  {
    String command = event.getActionCommand(); //Find out the name of the component that was used   
    if (command.equals("Exit")) //Condition. If the button was pressed.
    {
      for (int i = 0 ; i < board.length ; i++)
      {
        for ( int j = 0 ; j < board[i].length ; j ++)
        {
          Grid.remove(array[i][j]);
        }
      }
      remove(Grid);
      remove(options);
      dispose();
    }
  }
    
//Main Method
  public static void main(String [] args)
  {
    new HomePage();
    new GameState();
  }
  
//Mouse Listener 
  public void mouseClicked(MouseEvent e) {
    
    int x = e.getX();
    System.out.println(x);
    
    if (x>=0 && x <= 100){
      column=1;
      click = true;
    }else if(x>=143 && x<=243){
      column=2; 
      click = true;
    }else if(x>= 286 && x<=386){
      column=3;  
      click = true;
    }else if(x>=429 && x<=529){
      column=4; 
      click = true;
    }else if(x>=572 && x<=672){
      column=5;
      click = true;
    }else if(x>=714 &&x<=814){
      column=6; 
      click = true;
    }else if(x>=857 && x<=957){
      column=7;
      click = true;
    }
    
    
//Delay. Allows program to catch up.  
    try        
    {
      Thread.sleep((long) .75);
    } 
    catch(InterruptedException ex) 
    {
      Thread.currentThread().interrupt();
    }
    click = false;
  }
  
//Mouse Listener 
  public void mouseEntered(MouseEvent arg0) {
    // TODO Auto-generated method stub
  }
  
  public void mouseExited(MouseEvent arg0) {
    // TODO Auto-generated method stub
  }
  
  public void mousePressed(MouseEvent arg0) {
    // TODO Auto-generated method stub
  }
  
  public void mouseReleased(MouseEvent arg0) {
  }  
}