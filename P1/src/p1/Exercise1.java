package p1;

import java.util.Random;

import javax.swing.*;

public class Exercise1 
{
	// Deklaration av variabler som anv�nds i programmet
	private int adults, childs, pensioners, totalPrice, averagePrice, divider;
	private int adultPrice = 110, childPrice = 60, pensionerPrice = 80;
	private String res;
	
	public void exercise1a() 
	{
		price(); // Tillkallar metoden �price�
	}
	
	public void price() 
	{
		adults = Integer.parseInt(JOptionPane.showInputDialog("Ange antalet vuxna")); // Inmatningen lagras i �adults�
		childs = Integer.parseInt(JOptionPane.showInputDialog("Ange antalet barn")); // Inmatningen lagras i �childs�
		pensioners = Integer.parseInt(JOptionPane.showInputDialog("Ange antalet pension�rer")); // Inmatningen lagras i �persioners�
		
		if (adults > 0) // Om �adults� �r st�rre �n noll h�nder f�ljande annars h�nder inget
		{	
			totalPrice += adultPrice * adults; // �totalPrice� �kar med �adultPrice� g�nger antalet vuxna
			divider += adults; // �divider� �kar med antalet vuxna
		}
		
		if (childs > 0) // Om �childs� �r st�rre �n noll h�nder f�ljande annars h�nder inget
		{	
			totalPrice += childPrice * childs; // �totalPrice� �kar med �childPrice� g�nger antalet barn
			divider += childs; // �divider� �kar med antalet barn
		}
		
		if (pensioners > 0) // Om �pensioners� �r st�rre �n noll h�nder f�ljande annars h�nder inget
		{	
			totalPrice += pensionerPrice * pensioners; // �totalPrice� �kar med �pensionerPrice� g�nger antalet pension�rer
			divider += pensioners; // �divider� �kar med antalet pension�rer
		}
		
		if (divider != 0) // �divider� f�r inte vara noll. Skulle ge error om man skulle dela med noll.
		{
			averagePrice = totalPrice / divider; // �averagePrice� s�tts till total priset delat med antalet k�pta biljetter
		}
		
		res = "Totala priset �r: " + totalPrice + " kr \n" + "Genomsnittspriset �r: " + averagePrice + " kr";
		JOptionPane.showMessageDialog(null, res); // Utskrift av variblen �res�
	}
	
	public void exercise1b() 
	{
		String storeNumbers = "";
		
		for (int i = 1; i < 100; i += 2) // �i� b�rjar p� ett och �kar med tv� varje g�ng vilkoret �r sant (i < 100)
		{
			storeNumbers += i + " "; // Stringen �storeNumbers� l�gger till variabeln �i� varje g�ng for loopen k�rs
		}
		JOptionPane.showMessageDialog(null, storeNumbers);// Utskrift av variblen �storeNumbers�
	}
	
	public void exercise1c() 
	{
		for (int i = 0; i < 4; i++) // �i� b�rjar p� noll och �kar med ett varje g�ng vilkoret �r sant (i < 4)
		{
			int number = Integer.parseInt(JOptionPane.showInputDialog("Mata in ett tal"));
			String changer;
			
			if (number == 0) // Om �number� �r lika med noll s� �ndras variblen �changer�
			{
				changer = "noll";
			}
			else if (number > 0) // Om �number� �r st�rre �n noll s� �ndras variblen �changer�
			{
				changer = "positivt";
			}
			else // Om �number� inte �r noll och inte st�rre �n noll (D� m�ste �number� vara negativt) s� �ndras variblen �changer�
			{
				changer = "negativt";
			}
			System.out.println("Talet " + number + " �r " + changer); // Utskrivit av lite text och tv� varibler 
		}
	}
	
	public void exercise1d() 
	{
		boolean firstTime = true;
		String storeNumbers = "";
		int min = Integer.parseInt(JOptionPane.showInputDialog("Ange minsta v�rdet")); // Inmatningen lagras i �min�
		int max = Integer.parseInt(JOptionPane.showInputDialog("Ange st�rsta v�rdet")); // Inmatningen lagras i �max�
		
		for (int i = min; i < max; i += 7) // �i� s�tts till min v�rdet och �i� �kar med 7 om vilkoret �r sant (i < max)
		{
			if (firstTime) // Om �firstTime� �r sann h�nder f�ljande annars hoppar den ner till else-satsen
			{
				storeNumbers += i; // �storeNumbers� s�tts till sig sj plus variabeln �i�
				firstTime = false; // �firstTime� s�tts till falskt
			}
			else 
			{
				storeNumbers += ", " + i; // �storeNumbers� s�tts till sig sj plus ett komma och variabeln �i�
			}
		}
		
		if (max > min + 7) // Om max �r st�rre �n (min + 7) h�nder f�ljande utskrift annars inget
		{
			JOptionPane.showMessageDialog(null, storeNumbers); // Utskrift av varibeln �storeNumbers�
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
		
		// o�ndlig loop, raderna 36-42 upprepas tills PaintWindow-f�nstret st�ngs
		while (true) 
		{
			pw.showImage(image, x, y);
			PaintWindow.pause(20); // pausa exekveringen i 20 ms innan n�sta f�rflyttning
			x += dx;
			y += dy;
			
			if (0 > x || x > width - image.getIconWidth()) // Om noll �r st�rre �n x eller om x �r st�rre �n f�nstrets bredd minus bredden av gubben
			{
				dx = -dx; // V�nder om varibeln �dx�. Tex om den �r positiv blir den negativ och tv�rtom
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
		
		// o�ndlig loop, raderna 36-42 upprepas tills PaintWindow-f�nstret st�ngs
		while (true) 
		{
			pw.showImage(image, x, y);
			PaintWindow.pause(20); // pausa exekveringen i 20 ms innan n�sta f�rflyttning
			x += dx;
			y += dy;
			
			if (0 > x || x > width - image.getIconWidth()) // Om noll �r st�rre �n x eller om x �r st�rre �n f�nstrets bredd minus bredden av gubben
			{
				dx = -dx; // V�nder om varibeln �dx�. Tex om den �r positiv blir den negativ och tv�rtom
			}
			
			if (0 > y || y > height - image.getIconHeight()) // Om noll �r st�rre �n y eller om y �r st�rre �n f�nstrets h�jd minus h�jden av gubben
			{
				dy = -dy; // V�nder om varibeln �dy�. Tex om den �r positiv blir den negativ och tv�rtom
			}
		}
	}
}
