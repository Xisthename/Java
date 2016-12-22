package p2;

import java.applet.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class Race 
{
	private PaintWindow window;
	private Car car1 = new Car(null);
	private Car car2 = new Car(null);
	
	public Race(PaintWindow window, Car car1, Car car2) // konstruktor
	{
		this.window = window;
		this.car1 = car1;
		this.car2 = car2;
	}

	public void action() 
	{
        int width = window.getBackgroundWidth();
        int height = window.getBackgroundHeight();
        int startY1 = 150, startY2 = 250, endX = 150, roadHeight = 50;
		window.fillRect(0, 0, width, height, new Color(0, 180, 15));
		window.fillRect(0, startY1, width, roadHeight, Color.GRAY);
		window.fillRect(0, startY2, width, roadHeight, Color.GRAY);
		window.line(endX, startY1, endX, startY2 + roadHeight, Color.WHITE, 5);
        car1.moveTo(width - car1.getWidth(), startY1 + (roadHeight / 2) - (car1.getHeight() / 2));
        car2.moveTo(width - car2.getWidth(), startY2 + (roadHeight / 2) - (car2.getHeight() / 2));
        window.showImage(car1.getImage(), car1.getX(), car1.getY()); // Visar bil1
        window.showImage(car2.getImage(), car2.getX(), car2.getY()); // visar bil2
        Text car1Text = new Text(Integer.toString(car1.getX() + endX));
        Text car2Text = new Text(Integer.toString(car2.getX() + endX));
        car1Text.setBackground(Color.BLUE);
        car2Text.setBackground(Color.RED);
        window.showImage(car1Text, 0, 20); // Visar hur långt bil1 har kvar till målet
      	window.showImage(car2Text, 50, 20); // Visar hur långt bil2 har kvar till målet
    	boolean end = false;
        Random rand = new Random();
        int acce1 = 0;
    	int acce2 = 0;
    	int speed1 = 2;
        int speed2 = 2;
        int acceFrame = 0;
        int acceTime = 5;
        AudioClip clip = null;
        try 
        { 
        	URL url = new File("res/countdown.wav").toURI().toURL();
        	clip = Applet.newAudioClip(url);
        } 
        catch (MalformedURLException e) {}
        clip.play();
        window.pause(5000);
      
        while (end == false) 
        {
        	window.pause(50);
        	
        	if (acceFrame == acceTime) // Går igenom när while statsen har gått ignom 5 gånger osv
        	{
        		acce1 += rand.nextInt(2); // Acceleration ökar antingen med 0 eller 1
            	acce2 += rand.nextInt(2); // Acceleration ökar antingen med 0 eller 1
        		acceFrame = 0;
        	}
        	else 
        	{
        		acceFrame++;
        	}
        	speed1 += acce1; // Ökar speed1 med den nya acceleration
        	speed2 += acce2; // Ökar speed2 med den nya acceleration
        	car1.moveTo(car1.getX() - speed1, car1.getY()); // Flyttar bil1 med speed1
            car2.moveTo(car2.getX() - speed2, car2.getY()); // Flyttar bil2 med speed2
            window.showImage(car1.getImage(), car1.getX(), car1.getY()); // Visar bil1
            window.showImage(car2.getImage(), car2.getX(), car2.getY()); // visar bil2
            car1Text = new Text(Integer.toString(car1.getX() - endX)); // Räknar ut hur långt bil1 har kvar till målet
            car2Text = new Text(Integer.toString(car2.getX() - endX)); // Räknar ut hur långt bil2 har kvar till målet
            car1Text.setBackground(Color.BLUE);
            car2Text.setBackground(Color.RED);
            window.showImage(car1Text, 0, 20); // Visar hur långt bil1 har kvar till målet
          	window.showImage(car2Text, 50, 20); // Visar hur långt bil2 har kvar till målet
            
            
            if (endX > car1.getX()) // Om bil1 har passerat målet går if statsen igenom
            {
            	end = true; // Stoppar while loopen
            	Text winner = new Text("Blue wins!");
            	winner.setBackground(Color.BLUE);
            	window.showImage(winner, (width / 2), 50);
            }
            
            if (endX > car2.getX()) // Om bil2 har passerat målet går if statsen igenom
            {
            	end = true; // Stoppar while loopen
            	Text winner = new Text("Red wins!");
            	winner.setBackground(Color.RED);
            	window.showImage(winner, (width / 2), 50);
            }
        }
	}
}
