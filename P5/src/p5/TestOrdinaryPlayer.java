package p5;
import javax.swing.*;

public class TestOrdinaryPlayer 
{
	public static void main( String[] args ) 
    {
        Player player1 = new OrdinaryPlayer("Stefan" , new SimpleDice(8));
        Player player2 = new OrdinaryPlayer("Signe");
        TestOrdinaryPlayer.roll(player1, 1000000);
        TestOrdinaryPlayer.roll(player2, 50);
        ((OrdinaryPlayer) player1).setDice(new SimpleDice(3));
        TestOrdinaryPlayer.roll(player1, 10);
    }
	
    public static void roll(Player player, int antalKast) 
    {
        // Typ konvertera referensen till "Referens till OrdinaryPlayer"
        OrdinaryPlayer op = (OrdinaryPlayer)player;
        // Anv�nda OrdinaryPlayer-referensen f�r att erh�lla spelarens Dice-objekt
        // H�r g�r det inte att anv�nda Player-referensen (player) eftersom metoden 
        // getDice() inte �r deklarerad i klassen Player (eller i Object).
        Dice dice = op.getDice();
        int sides = dice.getSides(), aThrow;
        // Skapa en array f�r att r�kna antalet 1:or, 2:or ocv som t�rningen visar vid kasten nedan 
        int[] result = new int[sides];
        TextWindow.println( "----- " + antalKast + " kast av " + player.getName() + 
                " med " + sides + "-sidig t�rning -----" );
        
        for (int i = 0; i < antalKast; i++) 
        {
            // L�ta spelaren kasta sin t�rning
            aThrow = player.throwDice();
            // Öka r�knare f�r antalet prickar i kastet.
            result[aThrow - 1]++;
        }
        // Utskrift av antalet 1:r, 2:or osv
        TestSimpleDice.printResult(result);
    }
}
