package p3;

import java.awt.*;
import javax.swing.*;

public class SSPStart 
{
	public static void main(String[] args) // Startar programmet och skapar två frames av två olika klasser
	{
		SSPPlayer player = new SSPPlayer();
		SSPViewer viewer = new SSPViewer();
		SSPController controller = new SSPController(player, viewer);
		SSPUserInput userInput = new SSPUserInput(controller);
		JFrame frame1 = new JFrame("SSPUserInput");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setResizable(false);
		frame1.setLocationRelativeTo(null);
		frame1.setLocation(frame1.getX() - frame1.getWidth(), frame1.getY() - frame1.getHeight());
		frame1.add(userInput);
		frame1.pack();
		frame1.setVisible(true);
		JFrame frame2 = new JFrame("SSPViewer");
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setResizable(false);
		frame2.setLocationRelativeTo(null);
		frame2.setLocation(frame2.getX() - frame2.getWidth(), frame2.getY() - frame2.getHeight() - frame1.getHeight() - 20);
		frame2.add(viewer);
		frame2.pack();
		frame2.setVisible(true);
	}
}
