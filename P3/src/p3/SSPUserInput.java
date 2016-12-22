package p3;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SSPUserInput extends JPanel
{
	private Font fontButtons = new Font("Curier", Font.PLAIN, 24);
	private JButton stenButton, saxButton, påseButton, newGameButton, exitButton;
	private SSPController controller;
	
	public SSPUserInput(SSPController controller) // Konstrukter som tar in klassen SSPController
	{
		this.controller = controller;  // Sätter variabeln från klassen till variabeln i konstruktorn
		this.controller.setUserInput(this); // Tillkallar en metod från klassen controller
		this.setPreferredSize(new Dimension(280, 120)); // Sätter en viss storlek på JPanel:en
		init(); // Tillkallar metoden init
	}
	
	public void init() // Installation av knapparnas text, storlek, knapptryck och läggs till i JPanel:en så man kan se dem
	{
		stenButton = new JButton("STEN");
		saxButton = new JButton("SAX");
		påseButton = new JButton("PÅSE");
		newGameButton = new JButton("Nytt spel");
		exitButton = new JButton("Avsluta");
		
		stenButton.setPreferredSize(new Dimension(80, 30));
		saxButton.setPreferredSize(new Dimension(80, 30));
		påseButton.setPreferredSize(new Dimension(80, 30));
		newGameButton.setPreferredSize(new Dimension(250, 30));
		exitButton.setPreferredSize(new Dimension(250, 30));
		
		stenButton.addActionListener(new Handler());
		saxButton.addActionListener(new Handler());
		påseButton.addActionListener(new Handler());
		newGameButton.addActionListener(new Handler());
		exitButton.addActionListener(new Handler());
		
		add(stenButton);
		add(saxButton);
		add(påseButton);
		add(newGameButton);
		add(exitButton);
	}
	
	public void enableButtons() // Aktiverar tre knappar
	{
		stenButton.setEnabled(true);
		saxButton.setEnabled(true);
		påseButton.setEnabled(true);
	}
	
	public void disableButtons() // Inaktiverar tre knappar
	{
		stenButton.setEnabled(false);
		saxButton.setEnabled(false);
		påseButton.setEnabled(false);
	}
	
	private class Handler implements ActionListener
	{
		public void actionPerformed(ActionEvent e) // Metod aktiveras när man trycker på en knapp som tillhör denna klassen
		{
			if (e.getSource() == stenButton) // Om stenButton blir ner tryckt tillkallas metoden newChoice från klassen controller
			{
				controller.newChoice(0);
			}
			
			if (e.getSource() == saxButton) // Om saxButton blir ner tryckt tillkallas metoden newChoice från klassen controller
			{
				controller.newChoice(1);
			}
			
			if (e.getSource() == påseButton) // Om påseButton blir ner tryckt tillkallas metoden newChoice från klassen controller
			{
				controller.newChoice(2);
			}
			
			if (e.getSource() == newGameButton) // Om newGameButton blir ner tryckt tillkallas metoden newGame från klassen controller
			{
				controller.newGame();
			}
			
			if (e.getSource() == exitButton) // Om stenButton blir ner tryckt tillkallas metoden exitGame från klassen controller
			{
				controller.exitGame();
			}
		}
	}
}
