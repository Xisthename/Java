package p5;

import java.util.*;

/**
* Klassen SimpleDice representerar en t�rning med minst en sida
* @version 1.0
* @author Daniel Peters�n
*/

public class SimpleDice implements Dice
{
	private int sides;
	
	/**
	* En konstrukter som tillverkar en t�rning med 6 sidor
	*/
	public SimpleDice() 
	{
		sides = 6;
	}
	
	/**
	* Konstukter som tar in sides
	* S�tter sidorna till sides om sides �r st�rre �n noll annars skapas en t�rning med en sida
	* @param sides sidorna p� t�rningen
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
	* Returnerar hur m�nga prickar man fick n�r tr�ningen kastades
	* @return kastet av tr�ningen
	*/
	public int throwDice() 
	{
		return new Random().nextInt(sides) + 1;
	}

	/**
	* Returnerar hur m�nga sidor tr�ningen har
	* @return sides sidorna p� t�rningen
	*/
	public int getSides() 
	{
		return sides;
	}
}
