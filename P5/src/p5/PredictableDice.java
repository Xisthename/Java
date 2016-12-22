package p5;

/**
 * Klassen implementerar Dice. Tärningskasten är fÃ¶rutsägbara genom att ett kast 
 * alltid är ett stÃ¶rre än fÃ¶regående. Enda undantaget från denna regel är om 
 * fÃ¶rra kastet visade stÃ¶rsta antalet prickar. Då kommer kastet att visa en prick.
 * @author Rolf Axelsson
 */
public class PredictableDice implements Dice 
{
    private int sides;
    private int lastResult;
    
    /*
     * Skapar en 6-sidig tärning
     **/
    public PredictableDice() 
    {
        this(6); 
    }
         
    /*
     * Skapar en tärning med så många sidor som anges av argumentet.
     * @param sides Antal sidor på tärningen. Antalet sidor måste vara stÃ¶rre 
     * än 0.
     * @throws NegativeSidesException Om värdet på <code>sides</code> är mindre eller
     *                                lika med 0
     **/
    public PredictableDice(int sides) 
    {
        this.sides = sides;
        lastResult = -1;
    }
    
    /*
     * Returnerar antalet sidor på tärningen
     * @return Antalet sidor på tärningen
     **/
    public int getSides() 
    {
        return sides;
    }
    
    // 
    /*
     * Returnerar resultatet av ett tärningskast. Resultatet är altid i intervallet 
     * 1 - <code>sides</code> och i ordningen: 1, 2, 3, ..., sides-1, sides, 1, 2, osv
     * @return Resultatet av tärningskastet
     **/
    public int throwDice() 
    {
        lastResult = (lastResult + 1) % sides; // 0, 1, 2, ..., sides-2, sides-1, 0, 1, osv
        return lastResult + 1; 
    }
}
