package p5;

import java.util.*;

/**
* Klassen OrdinaryPlayer �r ett objekt av klassen spelare
* @version 1.0
* @author Daniel Peters�n
*/

public class OrdinaryPlayer extends Player
{
	private Dice dice;
	
	/**
	* Konstukter som tar in name och dice
	* S�tter in namnet och objektet dice s� de kan anv�ndas i klassen
	* @param name namn p� spelaren
	* @param dice ett dice objekt
	*/
	public OrdinaryPlayer(String name, Dice dice) 
	{
		super(name);
		this.dice = dice;
	}
	
	/**
	* Konstukter som tar in name
	* S�tter in namnet s� de kan anv�ndas i klassen
	* @param name namn p� spelaren
	*/
	public OrdinaryPlayer(String name)
	{
		super(name);
		dice = new SimpleDice(6);
	}
	
	/**
	* S�tter objektet dice
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
		SimpleDice t�rning = new SimpleDice(6);
		Player spelare1 = new OrdinaryPlayer("Gustav", t�rning);
		Player spelare2 = new OrdinaryPlayer("Valborg", t�rning);
		Game spel = new Game(spelare1, spelare2);
		spel.play(true);
	}
}
