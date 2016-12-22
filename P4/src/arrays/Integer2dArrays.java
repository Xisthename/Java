package arrays;

public class Integer2dArrays
{
	public static String toString(int[][] array) // Metoden tar in en tvådimensionell array och retunerar den som en string
	{
		String res = "{";
		int count = 1;
		
		for (int x = 0; x < array.length; x++)
		{
			res += "{";
			
			for (int y = 0; y < array[x].length; y++)
			{
				if (y == 0)
				{
					res += array[x][y];
				} 
				else 
				{
					res += "," + array[x][y];
				}
			}
			
			if (count == array.length) 
			{
				res += "}";
			}
			else
			{
				res += "},";
			}
			count++;
		}	
		return res += "}";
	}
	
	public static int elements(int[][] array) // Metoden tar in en tvådimensionell och räknar elements:en och retunerar antalet
	{
		int count = 0;
		
		for (int x = 0; x < array.length; x++) 
		{
			for (int y = 0; y < array[x].length; y++)
			{
				count++;
			}
		}
		return count;
	}
	
	public static int max(int[][] array) // Metoden tar in en tvådimensionell och retunerar ut det största värdet i array:en
	{
		int max = 0;
		
		for (int x = 0; x < array.length; x++) 
		{
			for (int y = 0; y < array[x].length; y++)
			{
				if (max < array[x][y])
				{
					max = array[x][y];
				}
			}
		}
		return max;
	}
	
	public static int min(int[][] array) // Metoden tar in en tvådimensionell och retunerar det minsta värdet i array:en
	{
		int min = Integer.MAX_VALUE;
		
		for (int x = 0; x < array.length; x++) 
		{
			for (int y = 0; y < array[x].length; y++)
			{
				if (min > array[x][y])
				{
					min = array[x][y];
				}
			}
		}		
		return min;
	}
	
	public static int sum(int[][] array) // Metoden tar in en tvådimensionell och retunerar summan av alla tal i från array:en
	{
		int sum = 0;
		
		for (int x = 0; x < array.length; x++) 
		{
			for (int y = 0; y < array[x].length; y++)
			{
				sum += array[x][y]; 
			}
		}
		return sum;
	}
	
	public static double average(int[][] array) // Metoden tar in en tvådimensionell och retunerar medelvärdet av array:en 
	{
		double sum = 0;
		double count = 0;
		double average = 0;
		
		for (int x = 0; x < array.length; x++) 
		{
			for (int y = 0; y < array[x].length; y++)
			{
				sum += array[x][y];
				count++;
			}
		}
		average = sum/count;
		return average;
	}
}