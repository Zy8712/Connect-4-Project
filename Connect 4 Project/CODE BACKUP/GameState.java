import java.awt.Color;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;

class GameState extends JFrame implements ActionListener
{
  int[][] board;
  int column = Connect4Gui.column;
  boolean click = Connect4Gui.click;
  Scanner input = new Scanner(System.in);
  int difficulti = HomePage.difficulti;
  JLabel p1t = Connect4Gui.p1t;
  JLabel p2t = Connect4Gui.p2t;
  JLabel firstP = Connect4Gui.firstP;
  
  
  public GameState()
  {
    boolean turn = Connect4Gui.turn;
    board = Connect4Gui.board;
    int empty = Connect4Gui.empty;
    int p1 = Connect4Gui.p1;
    int p2 = Connect4Gui.p2;
    int counter = WinCon.counter;
    int counter2 = WinCon.counter2;
    boolean Finish= false;
    draw[][] array = Connect4Gui.array;
    
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
        new AI_medium();
        
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

public void actionPerformed(ActionEvent event)
{
  String command = event.getActionCommand();
}
}

