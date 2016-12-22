package p3;

import javax.swing.JOptionPane;

public class SSPController 
{
	private SSPPlayer computerPlayer;
	private SSPViewer viewer;
	private SSPUserInput userInput;
	private int playerScore, computerScore;
	private boolean gameWon;
	
	public SSPController(SSPPlayer computerPlayer, SSPViewer viewer) // Konstruktor som tar in tre klasser
	{
		this.computerPlayer = computerPlayer; // Sätter variabeln från klassen till variabeln i konstruktorn
		this.viewer = viewer; // Sätter variabeln från klassen till variabeln i konstruktorn
		init(); // Tillkallar metoden init
	}
	
	public void setUserInput(SSPUserInput userInput)
	{
		this.userInput = userInput; // Sätter variabeln från klassen till variabeln i metoden
	}
	
	public void init() // Installation av variabler
	{
		playerScore = 0;
		computerScore = 0;
		gameWon = false;
	}
	
	public void newGame() // Startar ett nytt spel
	{
		if (gameWon) // Om någon har vunnit så går if-statsen igenom
		{
			viewer.setInfoLabelText("Först till 3 vinner!"); // Tillkallar en metod från klassen viewer med följande string
			userInput.enableButtons(); // Tillkallar en metod som aktiverar knappar
			gameWon = false; // Sätter gameWon till false
		}
		viewer.playerChoice(""); // Tillkallar en metod som visar spelarens val och inget val ska finnas när ett nytt spel startas
		viewer.computerChoice(""); // Tillkallar en metod som visar datorns val och inget val ska finnas när ett nytt spel startas
		playerScore = 0; // Sätter spelarens poäng till noll
		computerScore = 0; // Sätter datorns poäng till noll
		viewer.playerScore(playerScore); // Tillkallar en metod som visar spelarens poäng
		viewer.computerScore(computerScore); // Tillkallar en metod som visar datorns poäng
	}
	
	public void newChoice(int playerChoice) // Tar in ett val och skriver ut det och tillkallar metoderna computerChoice och logic
	{
		if (playerChoice == 0) // Val noll ger STEN
		{
			viewer.playerChoice("STEN");
		}
		else if (playerChoice == 1) // Val ett ger SAX
		{
			viewer.playerChoice("SAX");
		}
		else if (playerChoice == 2) // Val två ger PÅSE
		{
			viewer.playerChoice("PÅSE");
		}
		int computerChoice = computerPlayer.newChoice(); // skapar och sätter en variabel till vad metoden newChoice returnar
		computerChoice(computerChoice); // Tillkallar metoden computerChoice och sätter in datornsval i metoden
		logic(playerChoice, computerChoice); // Tillkallar metoden logic som tar in spelarens val och datorns val
		
	}
	
	public void computerChoice(int computerChoice) // Tar in ett val och skriver ut det
	{
		if (computerChoice == 0) // Val noll ger STEN
		{
			viewer.computerChoice("STEN");
		}
		else if (computerChoice == 1) // Val ett ger SAX
		{
			viewer.computerChoice("SAX");
		}
		else if (computerChoice == 2) // Val två ger PÅSE
		{
			viewer.computerChoice("PÅSE");
		}
	}
	
	public void logic(int pChoice, int cChoice) // Tar in spelarens val och datorns val och ger ut poäng om valen är olika
	{
		if (pChoice == 0 && cChoice == 1 || pChoice == 1 && cChoice == 2 || pChoice == 2 && cChoice == 0) // Poäng till player
		{
			playerScore++; // Spelarens poäng ökar med ett 
			viewer.playerScore(playerScore); // Tillkallar en metod i klassen viewer som sen skriver ut spelarens poäng
			
			if (playerScore == 3) // Om spelaren har tre i poäng så vinner spelaren
			{
				userInput.disableButtons(); // Tillkallar en metod som inaktiverar knappar
				gameWon = true; // Sätter variabeln gameWon till true
				viewer.setInfoLabelText("Player won!");
			}
		}
		else if (cChoice == 0 && pChoice == 1 || cChoice == 1 && pChoice == 2 || cChoice == 2 && pChoice == 0) // Poäng ti ll computer
		{
			computerScore++; // Datorns poäng ökar med ett 
			viewer.computerScore(computerScore); // Tillkallar en metod i klassen viewer som sen skriver ut datorns poäng
			
			if (computerScore == 3) // Om Datorn har tre i poäng så vinner datorn
			{
				userInput.disableButtons(); // Tillkallar en metod som inaktiverar knappar
				gameWon = true; // Sätter variabeln gameWon till true
				viewer.setInfoLabelText("Computer won!");
			}
		}
	}
	
	public void exitGame() // Stänger av programmet
	{
		System.exit(0);
	}
}
