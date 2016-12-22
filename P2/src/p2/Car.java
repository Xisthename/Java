package p2;

import javax.swing.*;

public class Car 
{
    private ImageIcon image;
    private int x;
    private int y;

    public Car(ImageIcon image) 
    {
        this.image = image;
    }
    
    public ImageIcon getImage() 
    {
        return image;
    }
    
    public int getWidth() // Får bredden av bilden
    {
    	return image.getIconWidth();
    }
    
    public int getHeight() // Får höjden av bilden
    {
    	return image.getIconHeight();
    }

    public int getX() 
    {
        return x;
    }

    public int getY() 
    {
        return y;
    }
    
    public void moveTo(int x, int y) 
    {
        this.x = x;
        this.y = y;
    }
}
