
package p4;

import javax.swing.JOptionPane;

import arrays.Integer2dArrays;

public class Exercise4b 
{
	public static void main(String[] args) 
    {
    	Exercise4b e4b = new Exercise4b();
        int[][] test1 = {{1,2,3,4}, {-5,-6,-7,-18}, {10,9,8,7}};
        int[][] test2 = {{1,2,3,4,5,6}, {-7,-8,-9}, {2,5,8,11,8}, {6,4}};
        e4b.testArray(test1);
        e4b.testArray(test2);        
    }
	
	public void testArray(int[][] array) 
	{
		String message = "";
		message += "toString: " + Integer2dArrays.toString(array) + "\n";
		message += "elements: " + Integer2dArrays.elements(array) + "\n";
		message += "max: " + Integer2dArrays.max(array) + "\n";
		message += "min: " + Integer2dArrays.min(array) + "\n";
		message += "sum: " + Integer2dArrays.sum(array) + "\n";
		message += "average: " + String.format("%1.2f", Integer2dArrays.average(array)) + "\n";
		JOptionPane.showMessageDialog(null, message);
	}
}
