package p5;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class TextWindow 
{
	private static JFrame frame = new JFrame();
	private static JTextArea ta = new JTextArea();
	private static JScrollPane sp = new JScrollPane(ta);
	
	static 
	{
		frame.setTitle("TextWindow");
		frame.setBounds(50, 50, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ta.setFont(new Font("Monospaced", Font.PLAIN, 12));
		ta.setEditable(false);
		((DefaultCaret)ta.getCaret()).setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		frame.getContentPane().add(sp);
		frame.setVisible(true);
	}
	
	public static void setText(String txt)  
	{
		ta.setText(txt);
		JScrollBar bar = sp.getVerticalScrollBar();
		bar.setValue(bar.getMaximum()-bar.getVisibleAmount());
	}

	public static void setText(Object obj)
	{
		setText(obj.toString());
	}
	
	public static void append(String txt) 
	{
		ta.append(txt);
	}
	
	public static void append(Object obj)
	{
		append(obj.toString());
	}
	
	public static void println() 
	{
		append("\n");
	}
	
	public static void println(String txt)
	{
		append(txt + "\n");
	}
	
	public static void println(Object obj) 
	{
		println(obj.toString());
	}
}
