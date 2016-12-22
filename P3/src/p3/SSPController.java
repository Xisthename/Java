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
		this.computerPlayer = computerPlayer; // S�tter variabeln fr�n klassen till variabeln i konstruktorn
		this.viewer = viewer; // S�tter variabeln fr�n klassen till variabeln i konstruktorn
		init(); // Tillkallar metoden init
	}
	
	public void setUserInput(SSPUserInput userInput)
	{
		this.userInput = userInput; // S�tter variabeln fr�n klassen till variabeln i metoden
	}
	
	public void init() // Installation av variabler
	{
		playerScore = 0;
		computerScore = 0;
		gameWon = false;
	}
	
	public void newGame() // Startar ett nytt spel
	{
		if (gameWon) // Om n�gon har vunnit s� g�r if-statsen igenom
		{
			viewer.setInfoLabelText("F�rst till 3 vinner!"); // Tillkallar en metod fr�n klassen viewer med f�ljande string
			userInput.enableButtons(); // Tillkallar en metod som aktiverar knappar
			gameWon = false; // S�tter gameWon till false
		}
		viewer.playerChoice(""); // Tillkallar en metod som visar spelarens val och inget val ska finnas n�r ett nytt spel startas
		viewer.computerChoice(""); // Tillkallar en metod som visar datorns val och inget val ska finnas n�r ett nytt spel startas
		playerScore = 0; // S�tter spelarens po�ng till noll
		computerScore = 0; // S�tter datorns po�ng till noll
		viewer.playerScore(playerScore); // Tillkallar en metod som visar spelarens po�ng
		viewer.computerScore(computerScore); // Tillkallar en metod som visar datorns po�ng
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
		else if (playerChoice == 2) // Val tv� ger P�SE
		{
			viewer.playerChoice("P�SE");
		}
		int computerChoice = computerPlayer.newChoice(); // skapar och s�tter en variabel till vad metoden newChoice returnar
		computerChoice(computerChoice); // Tillkallar metoden computerChoice och s�tter in datornsval i metoden
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
		else if (computerChoice == 2) // Val tv� ger P�SE
		{
			viewer.computerChoice("P�SE");
		}
	}
	
	public void logic(int pChoice, int cChoice) // Tar in spelarens val och datorns val och ger ut po�ng om valen �r olika
	{
		if (pChoice == 0 && cChoice == 1 || pChoice == 1 && cChoice == 2 || pChoice == 2 && cChoice == 0) // Po�ng till player
		{
			playerScore++; // Spelarens po�ng �kar med ett 
			viewer.playerScore(playerScore); // Tillkallar en metod i klassen viewer som sen skriver ut spelarens po�ng
			
			if (playerScore == 3) // Om spelaren har tre i po�ng s� vinner spelaren
			{
				userInput.disableButtons(); // Tillkallar en metod som inaktiverar knappar
				gameWon = true; // S�tter variabeln gameWon till true
				viewer.setInfoLabelText("Player won!");
			}
		}
		else if (cChoice == 0 && pChoice == 1 || cChoice == 1 && pChoice == 2 || cChoice == 2 && pChoice == 0) // Po�ng ti ll computer
		{
			computerScore++; // Datorns po�ng �kar med ett 
			viewer.computerScore(computerScore); // Tillkallar en metod i klassen viewer som sen skriver ut datorns po�ng
			
			if (computerScore == 3) // Om Datorn har tre i po�ng s� vinner datorn
			{
				userInput.disableButtons(); // Tillkallar en metod som inaktiverar knappar
				gameWon = true; // S�tter variabeln gameWon till true
				viewer.setInfoLabelText("Computer won!");
			}
		}
	}
	
	public void exitGame() // St�nger av programmet
	{
		System.exit(0);
	}
}
