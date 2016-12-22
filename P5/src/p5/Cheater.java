package p5;

import java.util.*;

/**
* Klassen SimpleDice representerar en t�rning med minst en sida
* @version 1.0
* @author Daniel Peters�n
*/

public class Cheater extends Player
{
	private Dice dice;
	
	/**
	* Konstukter som tar in ett namn och en t�rning
	* @param name s�tts till namnet p� spelaren
	* @param dice s�tts till spelarens tr�ning
	*/
	public Cheater(String name, Dice dice) 
	{
		super(name);
		this.dice = dice;
	}
	
	/**
	* Konstukter som tar in ett namn och skapar en 
	* @param name s�tts till namnet p� spelaren
	*/
	public Cheater(String name) 
	{
		super(name);
		dice = new SimpleDice(6);
	}
	
	/**
	* dice s�tts till spelarens tr�ning 
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
	 * �kar antalet prickar ungef�r varanan g�ng om man inte f�r h�gst antal prickar
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
