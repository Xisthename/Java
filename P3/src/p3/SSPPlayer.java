package p3;

import java.util.*;

public class SSPPlayer
{
	public int newChoice()
	{
		Random rand = new Random();
		return rand.nextInt(3); // returnar ett v�rde mellan 0-2
	}
}
