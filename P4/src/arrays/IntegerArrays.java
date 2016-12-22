package arrays;

public class IntegerArrays 
{
	public static String toString(int[] array) // Metod som tar in en int array och retunerar en string av array:en
	{
		String vektor = "{" + array[0]; // Sätter in en Klämma och först talet av array:en i variabeln vektor
		
		for (int i = 1; i < array.length; i++) // En loop som lägger till saker från array:en till variabeln vektor
		{
			vektor += "," + array[i];					
		}
		vektor += "}"; // Lägger till en slut klämma till string variabeln vektor
		return vektor;
	}
	
	public static int max(int[] array) // Metoden tar in en array och return:ar det största värdet i array:en
	{
		int max = 0;
		
		for (int i = 0; i < array.length; i++) // Loopar igenom hela array:en
		{
			if (max < array[i]) // Om värdet med index nummert är större än max så sätts det till det största talet
			{
				max = array[i];				
			}
		}		
		return max; // Retunerar int variabeln max
	}
	
	public static int min(int[] array) // Metoden tar in en array och retunerar det minsta värdet i array:en
	{
		int min = Integer.MAX_VALUE; // Borde kalla på metoden max härs men man vill inte att metoder ska va beroende av varandra
		
		for (int i = 0; i < array.length; i++) // Om värdet med index nummert är mindre än min så sätts det till det minsta talet
		{
			if (min > array[i])
			{
				min = array[i];
			}
		}		
		return min; // Retunerar int variabeln min
	}
	
	public static int sum(int[] array) // Metoden lägger in alla värden i array:en en int och retunerar
	{
		int sum = 0;
		
		for (int i = 0; i < array.length; i++) // Loopar igenom hela array:en
		{
			sum += array[i]; // Variabeln sum ökar med värdet som ligger i varje position i array:en
		}		
		return sum;
	}
	
	public static double average(int[] array) // Metoden tar in en array och retunerar en double som är medelvärdet av array:en
	{
		double average = 0;
		double sum = 0;
		
		for (int i = 0; i < array.length; i++)  // Loopar igenom hela aray:em
		{
			sum += array[i];  // Variabeln sum ökar med värdet som ligger i varje position i array:en
		}		
		average = sum / array.length; // Variabeln average sätts till summan av alla tal i array:en delat med antalet i array:en
		return average; // Retunerar variabeln average
	}
	
	public static int range(int[] array) // Metoden tar in en array och retunerar skillnaden mellan det största och minsta talet
	{
		int max = 0;
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < array.length; i++) 
		{
			if (max < array[i]) 
			{
				max = array[i];				
			}
			
			if (min > array[i])
			{
				min = array[i];
			}
		}		
		int range = max - min;			
		return range;
	}
	
	public static int[] copy(int[] array) // Metoden kopierar array:en som kommer in och skickar ut en copy av den
	{
		int[] copy = array;
		return copy;
	}
	
	public static int[] sortAsc(int[] array) // Metoden får in en array och soterar den från minst till störst sen retunerar array:en
	{
		for (int i = 0; i < array.length - 1; i++)
		{
			if (array[i] > array[i + 1])
			{
				int temp =  array[i];
				array[i] = array[i + 1];
				array[i + 1] = temp;
				i = -1;
			}		
		}
		return array;
	}
	
	public static int[] sortDesc(int[] array)// Metoden får in en array och soterar den från störst till minst sen retunerar array:en
	{
		for (int i = array.length - 1; i > 0; i--)
		{
			if (array[i] > array[i - 1])
			{
				int temp =  array[i];
				array[i] = array[i - 1];
				array[i - 1] = temp;
				i = array.length;
			}
		}
		return array;
	}
}
