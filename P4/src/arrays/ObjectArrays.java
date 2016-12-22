package arrays;

public class ObjectArrays
{
	public static String toString(Object[] array) // Metoden tar in en array och returnerar objektet som en string 
	{
		String vektor = "{" + array[0]; //först talet
		
		for (int i = 1; i < array.length; i++)
		{
			vektor += "," + array[i];					
		}
		vektor += "}";
		return vektor;
	}
	
	/*
	 * Metoden tar in en array och ett element och om de matchar då retuneras positionen och om de inte matchar
	 * så retuneras -1
	 * */
	public static int indexOf(Object[] array, Object elem)
	{
		int count = -1 ;
		
		for (int i = 0; i < array.length; i++) 
		{
			if (elem.equals(array[i])) 
			{ 
				count = i;
				break;
			}
			else 
			{
				count = -1;
			}
		}
		return count;
	}

	/*
	 * Metoden tar in en array och ett element och om de matchar då retuneras true och om de inte matchar
	 * så retuneras false
	 * */
	public static boolean member(Object[] array, Object elem)
	{
		boolean bool = false;
		
		for (int i = 0; i < array.length; i++) 
		{
			if (elem.equals(array[i]))
			{ 
				bool = true;
			}
		}
		return bool;
	}

	public static Object max(Object[] array) // tar in en array av ett objekt och retunar det objekt som har mest invånare
	{
		Object res = array[0]; 
		Comparable comp; 
		
		for (int i = 0; i < array.length; i++)
		{
			comp = (Comparable)array[i]; 
			
			if (comp.compareTo(res) > 0)
			{
				res = comp;
			}
		}
		return res;
	}

	public static Object min(Object[] array) // tar in en array av ett objekt och retunar det objekt som har minst invånare
	{
		Object res = array[0]; 
		Comparable comp; 
		
		for (int i = 0; i < array.length; i++)
		{
			comp = (Comparable)array[i]; 
			
			if (comp.compareTo(res) < 0)
			{
				res = comp;
			}
		}
		return res;
	}
}
