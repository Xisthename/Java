package p5;

import java.util.*;

/**
* Klassen SimpleDice representerar en tärning med minst en sida
* @version 1.0
* @author Daniel Petersén
*/

public class SimpleDice implements Dice
{
	private int sides;
	
	/**
	* En konstrukter som tillverkar en tärning med 6 sidor
	*/
	public SimpleDice() 
	{
		sides = 6;
	}
	
	/**
	* Konstukter som tar in sides
	* Sätter sidorna till sides om sides är större än noll annars skapas en tärning med en sida
	* @param sides sidorna på tärningen
	*/
	public SimpleDice(int sides)
	{
		if (sides > 0) 
		{
			this.sides = sides;
		}
		else 
		{
			sides = 1;
		}
	}
	
	/**
	* Returnerar hur många prickar man fick när träningen kastades
	* @return kastet av träningen
	*/
	public int throwDice() 
	{
		return new Random().nextInt(sides) + 1;
	}

	/**
	* Returnerar hur många sidor träningen har
	* @return sides sidorna på tärningen
	*/
	public int getSides() 
	{
		return sides;
	}
}
