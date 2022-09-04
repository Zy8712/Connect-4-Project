import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.Timer;
import javax.swing.*;

class WinCon extends JFrame 
{
  public static int counter = 0;
  public static int counter2 =0;
  public static boolean Finish;
  public static boolean check = AI_medium.check;
  public static int medium = AI_medium.medium;
  public static int med_column;
  public static int hard = AI_Hard.hard;
  public static int hard_column;
  public static boolean checkhard = AI_Hard.checkhard;
  int[][] board;
  public static boolean p1w=false, p2w=false, tiew=false;
  
  
  public WinCon()
  {
    int p1 = Connect4Gui.p1;
    int p2 = Connect4Gui.p2;
    board = Connect4Gui.board;
    
    System.out.println("Hello" );
    for (int i = 0; i < board.length ; i++)
    {
      for (int j = board[i].length-1; j >= 0 ; j--)
      {
        if (board[i][j] == p1)
        {
          System.out.println(i);
          System.out.println(j);
          System.out.println ("Player 1 Search");
          Searchp1 (board, i, j, counter);
        }
        else if (board[i][j] == p2)
        {
          Searchp2 (board, i , j, counter2);
        }
      }
    }
  }
  
  ////////////////////////////////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////////////////////////////// 
  public static boolean Searchp1(int[][] board, int i, int j, int counter) 
  {
    if (j < 4 && board[i][j+1]== 1)
    {
      return Search_right(board,i,j+1,counter);
    }
    else if (j< 4 && i > 2 && board[i-1][j+1]==1)
    {
      return Search_upright(board,i-1, j+1, counter);
    }
    else if (i > 2 && board[i-1][j]== 1)
    {
      return Search_up (board,i-1, j,counter);
    }
    
    else if (j > 2 && i > 2 && board [i-1][j-1]==1)
    {
      return Search_upleft (board,i-1, j-1,counter);
    }
    else
    {
      counter = 0;
      return false;
    }
    
    
  }
  public static boolean Search_right (int[][] board,int i, int j, int counter)
  {
    System.out.println(counter);
    
    if(counter==0){
      counter=2;
      medium =2;
    }
    if (counter ==4)
    {
      System.out.println("Player 1 Wins");
      p1w=true;
      new gMessage();
      Finish=true;
      return true;
    }
    if (medium == 3 && board[i][j+1] == 0)
    {
      med_column = j+1;
      check = true;
    }
    if (board[i][j+1] == 1)
    {
      medium++;
      counter++;
      Search_right(board,i,j+1,counter);
    }
    medium =0;
    counter =0;
    return false;
  }
  public static boolean Search_up (int[][] board,int i, int j, int counter)
  {
    if(counter==0){
      counter=2;
      medium =2;
    }
    if (counter ==4)
    {
      System.out.println("Player 1 Wins");
      p1w=true;
      new gMessage();
      Finish=true;
      return true;
    }
    if (medium == 3 && board[i-1][j]== 0)
    {
      med_column = j;
      check = true;
    }
    if (board[i-1][j] == 1)
    {
      medium++;
      counter++;
      Search_up(board,i-1,j,counter);
    }
    medium =0;
    counter=0;
    return false;
    
  }
  public static boolean Search_upright (int[][] board,int i, int j, int counter)
  { 
    if(counter==0){
      counter=2;
    }
    if (counter ==4)
    {
      System.out.println("Player 1 Wins");
      p1w=true;
      new gMessage();
      Finish=true;
      return true;
    }
    if (medium == 3 && board[i-1][j+1]== 0)
    {
      med_column = j+1;
      check = true;
    }
    if (board[i-1][j+1] == 1)
    {
      counter++;
      Search_upright(board,i-1,j+1,counter);
    }
    counter=0;
    return false;
    
  }
  public static boolean Search_upleft(int[][] board, int i, int j, int counter)
  {
    if(counter==0){
      counter=2;
      medium = 2;
    }
    if (counter ==4)
    {
      System.out.println("Player 1 Wins");
      p1w=true;
      new gMessage();
      Finish=true;
      return true;
    }
    if (medium == 3 && board[i-1][j-1]== 0)
    {
      med_column = j-1;
      check = true;
    }
    if (board[i-1][j-1] == 1)
    {
      medium++;
      counter++;
      
      Search_upleft(board,i-1,j-1,counter);
    }
    medium=0;
    counter=0;
    return false;
  }
  
  ////////////////////////////////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////////////////////////////
  //////////////////////////////////////////////////////////////////////////////////////////////
  public static boolean Searchp2(int[][] board, int i, int j, int counter2) 
  {
    if (j < 4 && board[i][j+1]== 2)
    {
      return Search2_right (board,i,j+1,counter2);
    }
    else if (j< 4 && i > 2 && board[i-1][j+1]==2)
    {
      return Search2_upright(board,i-1, j+1, counter2);
    }
    else if (i >2 && board[i-1][j]== 2)
    {
      return Search2_up (board,i-1, j,counter2);
    }
    else if (j > 2 && i >2 && board[i-1][j-1]==2)
    {
      return Search2_upleft (board,i-1, j-1,counter2);
    }
    else
    {
      counter2 = 0;
      return false;
    }
  }
  
  public static boolean Search2_right (int[][] board,int i, int j, int counter2)
  {
    
    if(counter2==0){
      counter2=2;
      medium =2;
    }
    if (counter2 ==4)
    {
      System.out.println("Player 2 Wins");
      p2w=true;
      new gMessage();
      Finish=true;
      return true;
    }
    if (medium == 3 && board[i][j+1]== 0)
    {
      med_column = j+1;
      check = true;
    }
    if (board[i][j+1] == 2)
    {
      counter2++;
      medium++;
      Search2_right(board,i,j+1,counter2);
    }
    medium=0;
    counter2=0;
    return false;
  }
  public static boolean Search2_up (int[][] board,int i, int j, int counter2)
  {
    if(counter2==0){
      counter2=2;
      medium=2;
    }
    if (counter2 ==4)
    {
      System.out.println("Player 2 Wins");
      p2w=true;
      new gMessage();
      Finish=true;
      return true;
    }
    if (medium == 3 && board[i-1][j]== 0)
    {
      med_column = j;
      check = true;
    }
    if (board[i-1][j] == 2)
    {
      medium++;
      counter2++;
      Search2_up(board,i-1,j,counter2);
    }
    medium=0;
    counter2=0;
    return false;
    
  }
  public static boolean Search2_upright (int[][] board,int i, int j, int counter2)
  {
    if(counter2==0){
      counter2=2;
    }
    if (counter2 ==4)
    {
      System.out.println("Player 2 Wins");
      p2w=true;
      new gMessage();
      Finish=true;
      return true;
    }
    if (medium == 3 && board[i-1][j+1]== 0)
    {
      med_column = j+1;
      check = true;
    }
    if (board[i-1][j+1] == 2)
    {
      medium++;
      counter2++;
      Search2_upright(board,i-1,j+1,counter2);
    }
    medium=0;
    counter2=0;
    return false;
    
  }
  public static boolean Search2_upleft(int[][] board, int i, int j, int counter2)
  {
    if(counter2==0){
      counter2=2;
    }
    if (counter2 ==4)
    {
      System.out.println("Player 2 Wins");
      p2w=true;
      new gMessage();
      Finish=true;
      return true;
    }
    if (medium == 3 && board[i-1][j-1]== 0)
    {
      med_column = j-1;
      check = true;
    }
    if (board[i-1][j-1] == 2)
    {
      medium++;
      counter2++;
      Search2_upleft(board,i-1,j-1,counter2);
    }
    medium=0;
    counter2=0;
    return false;
  }
  
  public static boolean TIE (int [][] board, int z )
  {
    for (z = 0; z < board[0].length; z++)
    {
      if (board[0][z] == 0)
      {
        break;
      }
      if (z == board[0].length -1)
      {
        System.out.println("tie");
        tiew=true;
        new gMessage();
        Finish=true;
        return true;
      }
    }
    
    return false;
  }
}
