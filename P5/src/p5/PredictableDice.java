package p5;

/**
 * Klassen implementerar Dice. T�rningskasten �r föruts�gbara genom att ett kast 
 * alltid �r ett större �n föreg�ende. Enda undantaget fr�n denna regel �r om 
 * förra kastet visade största antalet prickar. D� kommer kastet att visa en prick.
 * @author Rolf Axelsson
 */
public class PredictableDice implements Dice 
{
    private int sides;
    private int lastResult;
    
    /*
     * Skapar en 6-sidig t�rning
     **/
    public PredictableDice() 
    {
        this(6); 
    }
         
    /*
     * Skapar en t�rning med s� m�nga sidor som anges av argumentet.
     * @param sides Antal sidor p� t�rningen. Antalet sidor m�ste vara större 
     * �n 0.
     * @throws NegativeSidesException Om v�rdet p� <code>sides</code> �r mindre eller
     *                                lika med 0
     **/
    public PredictableDice(int sides) 
    {
        this.sides = sides;
        lastResult = -1;
    }
    
    /*
     * Returnerar antalet sidor p� t�rningen
     * @return Antalet sidor p� t�rningen
     **/
    public int getSides() 
    {
        return sides;
    }
    
    // 
    /*
     * Returnerar resultatet av ett t�rningskast. Resultatet �r altid i intervallet 
     * 1 - <code>sides</code> och i ordningen: 1, 2, 3, ..., sides-1, sides, 1, 2, osv
     * @return Resultatet av t�rningskastet
     **/
    public int throwDice() 
    {
        lastResult = (lastResult + 1) % sides; // 0, 1, 2, ..., sides-2, sides-1, 0, 1, osv
        return lastResult + 1; 
    }
}
