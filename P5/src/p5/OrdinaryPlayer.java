package p5;

import java.util.*;

/**
* Klassen OrdinaryPlayer är ett objekt av klassen spelare
* @version 1.0
* @author Daniel Petersén
*/

public class OrdinaryPlayer extends Player
{
	private Dice dice;
	
	/**
	* Konstukter som tar in name och dice
	* Sätter in namnet och objektet dice så de kan användas i klassen
	* @param name namn på spelaren
	* @param dice ett dice objekt
	*/
	public OrdinaryPlayer(String name, Dice dice) 
	{
		super(name);
		this.dice = dice;
	}
	
	/**
	* Konstukter som tar in name
	* Sätter in namnet så de kan användas i klassen
	* @param name namn på spelaren
	*/
	public OrdinaryPlayer(String name)
	{
		super(name);
		dice = new SimpleDice(6);
	}
	
	/**
	* Sätter objektet dice
	* @param dice objekt
	*/
	public void setDice(Dice dice) 
	{
		this.dice = dice;
	}
	
	/**
	* Retunerar dice objektet
	* @return dice objektet
	*/
	public Dice getDice() 
	{
		return dice;
	}

	/**
	* Retunerar antalet prickar av ett kast
	* @return antal prickar
	*/
	public int throwDice() 
	{
		return new Random().nextInt(dice.getSides()) + 1;
	}
	
	public static void main(String[] args) 
	{
		SimpleDice tärning = new SimpleDice(6);
		Player spelare1 = new OrdinaryPlayer("Gustav", tärning);
		Player spelare2 = new OrdinaryPlayer("Valborg", tärning);
		Game spel = new Game(spelare1, spelare2);
		spel.play(true);
	}
}
