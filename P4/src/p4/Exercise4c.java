package p4;

import javax.swing.JOptionPane;

import arrays.Country;
import arrays.ObjectArrays;

public class Exercise4c 
{
	public static void main(String[] args) 
	{
		Exercise4c e4c = new Exercise4c();
	    Country[] countries = {new Country("Guyana", 769095), new Country("Sri Lanka", 20926315), 
	    		new Country("Japan", 126804433), new Country("Ryssland", 143400000), 
	    		new Country("Monaco", 32671), new Country("Moldavien", 4320490)};
	    e4c.testArray(countries);
	}
	
	public void testArray(Object[] array)
	{
		String message = "";
		Country country = new Country("Costa Rica", 4133884);
		message += "toString: " + ObjectArrays.toString(array) + "\n";
		message += "indexOf " + array[4] +": " + ObjectArrays.indexOf(array, array[4]) + "\n";
		message += "indexOf " + country +": " + ObjectArrays.indexOf(array, country) + "\n";
		message += "member " + array[4] +": " + ObjectArrays.member(array, array[4]) + "\n";
		message += "member " + country +": " + ObjectArrays.member(array, new Country("A", 10)) + "\n";
		message += "max: " + ObjectArrays.max(array) + "\n";
		message += "min: " + ObjectArrays.min(array) + "\n";
		JOptionPane.showMessageDialog(null, message);
	}
}
