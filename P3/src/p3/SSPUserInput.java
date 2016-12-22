package p3;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SSPUserInput extends JPanel
{
	private Font fontButtons = new Font("Curier", Font.PLAIN, 24);
	private JButton stenButton, saxButton, p�seButton, newGameButton, exitButton;
	private SSPController controller;
	
	public SSPUserInput(SSPController controller) // Konstrukter som tar in klassen SSPController
	{
		this.controller = controller;  // S�tter variabeln fr�n klassen till variabeln i konstruktorn
		this.controller.setUserInput(this); // Tillkallar en metod fr�n klassen controller
		this.setPreferredSize(new Dimension(280, 120)); // S�tter en viss storlek p� JPanel:en
		init(); // Tillkallar metoden init
	}
	
	public void init() // Installation av knapparnas text, storlek, knapptryck och l�ggs till i JPanel:en s� man kan se dem
	{
		stenButton = new JButton("STEN");
		saxButton = new JButton("SAX");
		p�seButton = new JButton("P�SE");
		newGameButton = new JButton("Nytt spel");
		exitButton = new JButton("Avsluta");
		
		stenButton.setPreferredSize(new Dimension(80, 30));
		saxButton.setPreferredSize(new Dimension(80, 30));
		p�seButton.setPreferredSize(new Dimension(80, 30));
		newGameButton.setPreferredSize(new Dimension(250, 30));
		exitButton.setPreferredSize(new Dimension(250, 30));
		
		stenButton.addActionListener(new Handler());
		saxButton.addActionListener(new Handler());
		p�seButton.addActionListener(new Handler());
		newGameButton.addActionListener(new Handler());
		exitButton.addActionListener(new Handler());
		
		add(stenButton);
		add(saxButton);
		add(p�seButton);
		add(newGameButton);
		add(exitButton);
	}
	
	public void enableButtons() // Aktiverar tre knappar
	{
		stenButton.setEnabled(true);
		saxButton.setEnabled(true);
		p�seButton.setEnabled(true);
	}
	
	public void disableButtons() // Inaktiverar tre knappar
	{
		stenButton.setEnabled(false);
		saxButton.setEnabled(false);
		p�seButton.setEnabled(false);
	}
	
	private class Handler implements ActionListener
	{
		public void actionPerformed(ActionEvent e) // Metod aktiveras n�r man trycker p� en knapp som tillh�r denna klassen
		{
			if (e.getSource() == stenButton) // Om stenButton blir ner tryckt tillkallas metoden newChoice fr�n klassen controller
			{
				controller.newChoice(0);
			}
			
			if (e.getSource() == saxButton) // Om saxButton blir ner tryckt tillkallas metoden newChoice fr�n klassen controller
			{
				controller.newChoice(1);
			}
			
			if (e.getSource() == p�seButton) // Om p�seButton blir ner tryckt tillkallas metoden newChoice fr�n klassen controller
			{
				controller.newChoice(2);
			}
			
			if (e.getSource() == newGameButton) // Om newGameButton blir ner tryckt tillkallas metoden newGame fr�n klassen controller
			{
				controller.newGame();
			}
			
			if (e.getSource() == exitButton) // Om stenButton blir ner tryckt tillkallas metoden exitGame fr�n klassen controller
			{
				controller.exitGame();
			}
		}
	}
}
