import java.util.Random;


public class AI_medium 
{
 public static int medium =0;
 public static int med_column = WinCon.med_column;
 Random rand = Connect4Gui.rand;
 boolean turn = Connect4Gui.turn;
 public static boolean check = false;
 public AI_medium()
 {
  new WinCon();
  med_column= WinCon.med_column;
  medium = med_column;
  check = WinCon.check;
  System.out.println ("AI Picks " + medium +"column");
  System.out.println(check);
  
  if (!check)
  {
   int column = rand.nextInt(7)+1;  
   medium = column;
   System.out.println("AI Picks " + medium +"column");
  }
  turn = false;
 }
}
