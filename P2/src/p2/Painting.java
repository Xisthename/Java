package p2;

public class Painting
{
	private String title, painter; // Installation av variabler
	private int year;
	
	public Painting(String title, String painter, int year) // Konstruktor
	{
		this.title = title;
		this.painter = painter;
		this.year = year;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String getPainter()
	{
		return painter;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public String toString()
	{
		return title + " av " + painter + ", " + year;
	}
}
