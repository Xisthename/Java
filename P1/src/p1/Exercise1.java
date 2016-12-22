package p1;

import java.util.Random;

import javax.swing.*;

public class Exercise1 
{
	// Deklaration av variabler som används i programmet
	private int adults, childs, pensioners, totalPrice, averagePrice, divider;
	private int adultPrice = 110, childPrice = 60, pensionerPrice = 80;
	private String res;
	
	public void exercise1a() 
	{
		price(); // Tillkallar metoden ’price’
	}
	
	public void price() 
	{
		adults = Integer.parseInt(JOptionPane.showInputDialog("Ange antalet vuxna")); // Inmatningen lagras i ’adults’
		childs = Integer.parseInt(JOptionPane.showInputDialog("Ange antalet barn")); // Inmatningen lagras i ’childs’
		pensioners = Integer.parseInt(JOptionPane.showInputDialog("Ange antalet pensionärer")); // Inmatningen lagras i ’persioners’
		
		if (adults > 0) // Om ’adults’ är större än noll händer följande annars händer inget
		{	
			totalPrice += adultPrice * adults; // ’totalPrice’ ökar med ’adultPrice’ gånger antalet vuxna
			divider += adults; // ’divider’ ökar med antalet vuxna
		}
		
		if (childs > 0) // Om ’childs’ är större än noll händer följande annars händer inget
		{	
			totalPrice += childPrice * childs; // ’totalPrice’ ökar med ’childPrice’ gånger antalet barn
			divider += childs; // ’divider’ ökar med antalet barn
		}
		
		if (pensioners > 0) // Om ’pensioners’ är större än noll händer följande annars händer inget
		{	
			totalPrice += pensionerPrice * pensioners; // ’totalPrice’ ökar med ’pensionerPrice’ gånger antalet pensionärer
			divider += pensioners; // ’divider’ ökar med antalet pensionärer
		}
		
		if (divider != 0) // ’divider’ får inte vara noll. Skulle ge error om man skulle dela med noll.
		{
			averagePrice = totalPrice / divider; // ’averagePrice’ sätts till total priset delat med antalet köpta biljetter
		}
		
		res = "Totala priset är: " + totalPrice + " kr \n" + "Genomsnittspriset är: " + averagePrice + " kr";
		JOptionPane.showMessageDialog(null, res); // Utskrift av variblen ’res’
	}
	
	public void exercise1b() 
	{
		String storeNumbers = "";
		
		for (int i = 1; i < 100; i += 2) // ’i’ börjar på ett och ökar med två varje gång vilkoret är sant (i < 100)
		{
			storeNumbers += i + " "; // Stringen ’storeNumbers’ lägger till variabeln ’i’ varje gång for loopen körs
		}
		JOptionPane.showMessageDialog(null, storeNumbers);// Utskrift av variblen ’storeNumbers’
	}
	
	public void exercise1c() 
	{
		for (int i = 0; i < 4; i++) // ’i’ börjar på noll och ökar med ett varje gång vilkoret är sant (i < 4)
		{
			int number = Integer.parseInt(JOptionPane.showInputDialog("Mata in ett tal"));
			String changer;
			
			if (number == 0) // Om ’number’ är lika med noll så ändras variblen ’changer’
			{
				changer = "noll";
			}
			else if (number > 0) // Om ’number’ är större än noll så ändras variblen ’changer’
			{
				changer = "positivt";
			}
			else // Om ’number’ inte är noll och inte större än noll (Då måste ’number’ vara negativt) så ändras variblen ’changer’
			{
				changer = "negativt";
			}
			System.out.println("Talet " + number + " är " + changer); // Utskrivit av lite text och två varibler 
		}
	}
	
	public void exercise1d() 
	{
		boolean firstTime = true;
		String storeNumbers = "";
		int min = Integer.parseInt(JOptionPane.showInputDialog("Ange minsta värdet")); // Inmatningen lagras i ’min’
		int max = Integer.parseInt(JOptionPane.showInputDialog("Ange största värdet")); // Inmatningen lagras i ’max’
		
		for (int i = min; i < max; i += 7) // ’i’ sätts till min värdet och ’i’ ökar med 7 om vilkoret är sant (i < max)
		{
			if (firstTime) // Om ’firstTime’ är sann händer följande annars hoppar den ner till else-satsen
			{
				storeNumbers += i; // ’storeNumbers’ sätts till sig sj plus variabeln ’i’
				firstTime = false; // ’firstTime’ sätts till falskt
			}
			else 
			{
				storeNumbers += ", " + i; // ’storeNumbers’ sätts till sig sj plus ett komma och variabeln ’i’
			}
		}
		
		if (max > min + 7) // Om max är större än (min + 7) händer följande utskrift annars inget
		{
			JOptionPane.showMessageDialog(null, storeNumbers); // Utskrift av varibeln ’storeNumbers’
		}
	}
	
	public void exercise1e() 
	{
		PaintWindow pw = new PaintWindow();
		Random rand = new Random();
		ImageIcon image = new ImageIcon("res/gubbe.jpg");
		int width = pw.getBackgroundWidth();
		int height = pw.getBackgroundHeight();
		int dx = -3;
		int dy = 0;
		int x = 250;
		int y = rand.nextInt(height - image.getIconHeight());
		
		// oändlig loop, raderna 36-42 upprepas tills PaintWindow-fönstret stängs
		while (true) 
		{
			pw.showImage(image, x, y);
			PaintWindow.pause(20); // pausa exekveringen i 20 ms innan nästa förflyttning
			x += dx;
			y += dy;
			
			if (0 > x || x > width - image.getIconWidth()) // Om noll är större än x eller om x är större än fönstrets bredd minus bredden av gubben
			{
				dx = -dx; // Vänder om varibeln ’dx’. Tex om den är positiv blir den negativ och tvärtom
			}
		}
	}
	
    public void exercise1f() 
	{
    	PaintWindow pw = new PaintWindow();
		Random rand = new Random();
		ImageIcon image = new ImageIcon("res/gubbe.jpg");
		int width = pw.getBackgroundWidth();
		int height = pw.getBackgroundHeight();
		int dx = rand.nextInt(6) - 3; // Min -> (0 - 3 = -3) Max -> (6 - 3 = 3)
		int dy = rand.nextInt(6) - 3; // Min -> (0 - 3 = -3) Max -> (6 - 3 = 3)
		int x = rand.nextInt(500);
		int y = rand.nextInt(height - image.getIconHeight());
		
		// oändlig loop, raderna 36-42 upprepas tills PaintWindow-fönstret stängs
		while (true) 
		{
			pw.showImage(image, x, y);
			PaintWindow.pause(20); // pausa exekveringen i 20 ms innan nästa förflyttning
			x += dx;
			y += dy;
			
			if (0 > x || x > width - image.getIconWidth()) // Om noll är större än x eller om x är större än fönstrets bredd minus bredden av gubben
			{
				dx = -dx; // Vänder om varibeln ’dx’. Tex om den är positiv blir den negativ och tvärtom
			}
			
			if (0 > y || y > height - image.getIconHeight()) // Om noll är större än y eller om y är större än fönstrets höjd minus höjden av gubben
			{
				dy = -dy; // Vänder om varibeln ’dy’. Tex om den är positiv blir den negativ och tvärtom
			}
		}
	}
}
