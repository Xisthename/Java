package p5;

/**
* Klassen TestDice är tillför att kasta en tärning eller låta en spelar kasta en tärning
* @version 1.0
* @author Daniel Petersén
*/

public class TestDice 
{
	public static void main(String[] args)
	{
		TestDice.test(new SimpleDice(6), 1000000);
		TextWindow.println();
		TestDice.test(new SimpleDice(4), 1000000);
		TestDice.test(new OrdinaryPlayer("Rut", new SimpleDice(6)), 1000000);
		TextWindow.println(); 
		TestDice.test(new Cheater("Fuffe", new SimpleDice(6)), 1000000);
	}
	
	/**
	* Metoden tar in objektet dice och en int nbrOfThrows
	* @param dice en tärning
	* @param nbrOfThrows antal kast
	*/
	public static void test(Dice dice, int nbrOfThrows) 
	{
		int[] res = new int[dice.getSides()];
		int aThrow;
		TextWindow.println("----- " + nbrOfThrows + " kast " +  " med " + dice.getSides() + "-sidig tärning -----");
		
		for (int i = 0; i < nbrOfThrows; i++) 
        {
			aThrow = dice.throwDice();
            res[aThrow - 1]++;
        }
        TestSimpleDice.printResult(res);
	}
	
	/**
	* Metoden tar in objektet dice och en int nbrOfThrows
	* @param player en spelare
	* @param nbrOfThrows antal kast
	*/
	public static void test(Player player, int nbrOfThrows) 
	{
		Dice dice = null;
		
		if (player instanceof OrdinaryPlayer) 
		{
			OrdinaryPlayer op = (OrdinaryPlayer)player;
	        dice = op.getDice();
		}
		else if (player instanceof Cheater) 
		{
			Cheater op = (Cheater)player;
	        dice = op.getDice();
		}
		int sides = dice.getSides(), aThrow;
		int[] result = new int[sides];
        TextWindow.println("----- " + nbrOfThrows + " kast av " + player.getName() + 
                " med " + sides + "-sidig tärning -----");
        
        for (int i = 0; i < nbrOfThrows; i++) 
        {
            aThrow = player.throwDice();
            result[aThrow - 1]++;
        }
        TestSimpleDice.printResult(result);
	}
}
