import javax.swing.*;
import java.awt.*;

public class draw extends JPanel{

	Color myColor = Color.WHITE;
	
	public void drawing(){
		repaint();
		
		
	}
	
	public void paint(Graphics g){
		super.paint(g);
		
	       g.setColor(myColor);

g.fillOval(0, 0, 100, 100);
	}

public void changeColor(Color newColor){
	myColor=newColor;
	repaint();

}

	
}
