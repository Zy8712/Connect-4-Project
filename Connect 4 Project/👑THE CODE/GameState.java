import java.awt.Color;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;

class GameState extends JFrame implements ActionListener
{
  int[][] board;
  public static int column = Connect4Gui.column;
  public static boolean click = Connect4Gui.click;
  Scanner input = new Scanner(System.in);
  int difficulti = HomePage.difficulti;
  public static JLabel p1t = Connect4Gui.p1t;
  public static JLabel p2t = Connect4Gui.p2t;
  public static JLabel firstP = Connect4Gui.firstP;
  public static Random rand = new Random();
  
  
  public GameState()
  {
    boolean turn = Connect4Gui.turn;
    board = Connect4Gui.board;
    int empty = Connect4Gui.empty;
    int p1 = Connect4Gui.p1;
    int p2 = Connect4Gui.p2;
    int counter = WinCon.counter;
    int counter2 = WinCon.counter2;
    boolean Finish = false;
    draw[][] array = Connect4Gui.array;
    //Determine who is going first
    
    turn = GoingFirst(rand, turn); //Set turn equal to value returned from method
    System.out.println(turn); //Output variable (for testing)
    
    while (!Finish)
    {
      int j = 0;
      while(true)
      {
        System.out.println("Please enter a column");
        difficulti=HomePage.difficulti;
        if (difficulti == 1 && !turn)
        {
          System.out.println("turn");
          new AI_easy();
          column = AI_easy.easy;
        System.out.println(column);
      }
        else if (difficulti == 2 && !turn)
        {
          System.out.println("turn");
          new AI_medium();
          column = AI_medium.medium;
          System.out.println(column);
        }
      
      else 
      {
        
        while(!click)
        {     
          click = Connect4Gui.click;
          if(click){
            click=false;
            column = Connect4Gui.column;
            break;
          } 
        }
        
      }
      
      //System.out.println(column);
      if(column > 7 || column < 1)
      {
        System.out.println("Invalid Choice please try again");
      }else{
        if(board[0][column-1]!=empty){
          System.out.println(board[0][0]); 
        }else{
          break;
        }
      }
    }
    
    if (turn)
    {
      System.out.println ("Player 1 turn");
      firstP.setForeground(Color.white);
      p1t.setForeground(Color.white);
      p2t.setForeground(Color.blue);
      while (j < 6 && board[j][column-1]== empty)
      {
        if (j==5 || board[j+1][column-1]!= empty)
        {
          board[j][column-1] = p1;
          array[j][column-1].changeColor(Color.RED);
          System.out.println("hello");
        }
        j++; 
      }
      turn = false;
    }
    
    else if (!turn)
    {
      if (difficulti ==1)
      {
        firstP.setForeground(Color.white);
        p1t.setForeground(Color.red);
        p2t.setForeground(Color.white);
        
        
        while (j < 6 && board[j][column-1]== empty)
        {
          if (j==5 || board[j+1][column-1]!= empty)
          {
            board[j][column-1] = p2;
            array[j][column-1].changeColor(Color.BLUE);
            System.out.println("hello");
          }
          j++; 
        }
        turn = true;
      }
      
      if (difficulti ==2)
      {
        firstP.setForeground(Color.white);
        p1t.setForeground(Color.red);
        p2t.setForeground(Color.white);
        
        
        while (j < 6 && board[j][column-1]== empty)
        {
          if (j==5 || board[j+1][column-1]!= empty)
          {
            board[j][column-1] = p2;
            array[j][column-1].changeColor(Color.BLUE);
            System.out.println("hello");
          }
          j++; 
        }
        turn = true;
      }
      
      if (difficulti ==3)
      {
        new AI_Hard();
      }
      
      else
      {
        System.out.println ("Player 2 turn");
        firstP.setForeground(Color.white);
        p1t.setForeground(Color.red);
        p2t.setForeground(Color.white);
        while (j < 6 && board[j][column-1]== empty)
        {
          if (j==5 || board[j+1][column-1]!= empty)
          {
            board[j][column-1] = p2;
            array[j][column-1].changeColor(Color.BLUE);
            System.out.println("hello");
          }
          j++; 
        }
      }
      turn = true;
    }
    
    
    for (int i = 0 ; i < board.length ; i++)
    {
      for (int x = 0 ; x < board[i].length ; x++)
      {
        System.out.print(board[i][x]);       
      }
      System.out.println();
    }
    new WinCon();  
    Finish = WinCon.Finish;
  }
}
  
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

public void actionPerformed(ActionEvent event)
{
  String command = event.getActionCommand();
}
}
