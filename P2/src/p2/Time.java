package p2;

import java.util.*;

public class Time 
{
	private Calendar cal = Calendar.getInstance(); // Installation av variabler
	private int hour = cal.get(Calendar.HOUR);
	private int minute = cal.get(Calendar.MINUTE);
	private int second = cal.get(Calendar.SECOND);
	
	public int getHour()
	{
		return hour;
	}

	public int getMinute()
	{
		return minute;
	}

	public int getSecond()
	{
		return second;
	}
	
	public String toString()
	{
		return hour + ":" + minute + ":" + second;
	}

	public void update()
	{
		cal.setTime(new Date());
		hour = cal.get(Calendar.HOUR);
		minute = cal.get(Calendar.MINUTE);
		second = cal.get(Calendar.SECOND);
	}
}
