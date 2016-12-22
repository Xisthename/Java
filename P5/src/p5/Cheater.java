package p5;

import java.util.*;

/**
* Klassen SimpleDice representerar en tärning med minst en sida
* @version 1.0
* @author Daniel Petersén
*/

public class Cheater extends Player
{
	private Dice dice;
	
	/**
	* Konstukter som tar in ett namn och en tärning
	* @param name sätts till namnet på spelaren
	* @param dice sätts till spelarens träning
	*/
	public Cheater(String name, Dice dice) 
	{
		super(name);
		this.dice = dice;
	}
	
	/**
	* Konstukter som tar in ett namn och skapar en 
	* @param name sätts till namnet på spelaren
	*/
	public Cheater(String name) 
	{
		super(name);
		dice = new SimpleDice(6);
	}
	
	/**
	* dice sätts till spelarens träning 
	* @param dice objektet
	*/
	public void setDice(Dice dice) 
	{
		this.dice = dice;
	}
	
	/**
	* @return dice objektet
	*/
	public Dice getDice() 
	{
		return dice;
	}

	/**
	 * Ökar antalet prickar ungefär varanan gång om man inte får högst antal prickar
	 * @return value antal prickar efter ett kast
	 */
	public int throwDice() 
	{
		Random random = new Random();
		int value = random.nextInt(dice.getSides()) + 1;
		
		if (value != dice.getSides()) 
		{
			if (random.nextBoolean() == true) 
			{
				value++;
			}
		}
		return value;
	}
	
	public static void main(String[] args) 
	{
		Player spelare1 = new OrdinaryPlayer("Viktor", new SimpleDice(6));
		Player spelare2 = new Cheater("Signe", new SimpleDice(6));
		Game spel = new Game(spelare1, spelare2);
		TextWindow.println("\nResultatet av tio spel");
		
		for (int i = 0; i < 10; i++) 
		{
			spel.play(false); 
		}
	}
}
