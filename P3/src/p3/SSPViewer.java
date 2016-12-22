package p3;

import java.awt.*;

import javax.swing.*;

public class SSPViewer extends JPanel
{
	private Font fontLabels = new Font("SansSerif", Font.PLAIN, 15);
	private JLabel infoLabel, playerLabel, playerScoreLabel, playerChoiceLabel, computerLabel, computerScoreLabel, computerChoiceLabel;
	
	public SSPViewer() // Konstrukter som s�tter en specifik storlek p� JPanel:en och tillkallar metoden init
	{
		this.setPreferredSize(new Dimension(280, 120));
		init();
	}
	
	public void init() // Installation av labels s� som storlek, font och l�ggs till i JPanel:en
	{
		infoLabel = new JLabel("F�rst till 3 vinner!");
		playerLabel = new JLabel("player");
		computerLabel = new JLabel("Computer");
		playerScoreLabel = new JLabel("0");
		computerScoreLabel = new JLabel("0");
		playerChoiceLabel = new JLabel();
		computerChoiceLabel = new JLabel();
		
		infoLabel.setFont(new Font("SansSerif", Font.PLAIN, 25));
		playerLabel.setFont(fontLabels);
		computerLabel.setFont(fontLabels);
		playerScoreLabel.setFont(fontLabels);
		computerScoreLabel.setFont(fontLabels);
		playerChoiceLabel.setFont(fontLabels);
		computerChoiceLabel.setFont(fontLabels);
		
		infoLabel.setPreferredSize(new Dimension(200, 40));
		playerLabel.setPreferredSize(new Dimension(100, 20));
		computerLabel.setPreferredSize(new Dimension(100, 20));
		playerScoreLabel.setPreferredSize(new Dimension(100, 20));
		computerScoreLabel.setPreferredSize(new Dimension(100, 20));
		playerChoiceLabel.setPreferredSize(new Dimension(100, 20));
		computerChoiceLabel.setPreferredSize(new Dimension(100, 20));
		
		
		add(infoLabel);
		add(playerLabel);
		add(computerLabel);
		add(playerScoreLabel);
		add(computerScoreLabel);
		add(playerChoiceLabel);
		add(computerChoiceLabel);
	}
	
	public void setInfoLabelText(String text) // S�tter infoLabel:s text till variabeln text
	{
		infoLabel.setText(text);
	}
	
	public void playerChoice(String choice) // S�tter playerChoiceLabel:s text till variabeln choice ("STEN" "SAX" "P�SE")
	{
		playerChoiceLabel.setText(choice);
	}
	
	public void playerScore(int score) // S�tter playerScoreLabel:s text till variabeln score (0, 1, 2, 3)
	{
		playerScoreLabel.setText(Integer.toString(score));
	}
	
	public void computerChoice(String choice) // S�tter computerChoiceLabel:s text till variabeln choice ("STEN" "SAX" "P�SE")
	{
		computerChoiceLabel.setText(choice);
	}
	
	public void computerScore(int score) // S�tter computerScoreLabel:s text till variabeln score (0, 1, 2, 3)
	{
		computerScoreLabel.setText(Integer.toString(score));
	}
}
