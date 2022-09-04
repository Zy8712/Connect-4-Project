import java.util.Random;
public class AI_easy {
  public static int easy = 0;
  Random rand = Connect4Gui.rand;
  public AI_easy()
  {    
    easy = rand.nextInt(7)+1;
    System.out.println("AI Picks " +easy +" column");
  }
}