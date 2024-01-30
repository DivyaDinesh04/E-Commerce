package com.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtils {

	/**
	 * This method is used to return Random number
	 * @return
	 */
	public int getRandomNo()
	{
		Random r = new Random();
		int random = r.nextInt(500);
		return random;
	}
	
	/**
	 * This method is used to return System date
	 * @return
	 */
	public String getSystemDate()
	{
		Date dt = new Date();
		String date = dt.toString();
		return date;
	}
	
	/**
	 * This method is used to return system date in format
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date dt = new Date();
		String systemDateInFormat = dateFormat.format(dt);
		return systemDateInFormat;
		
	}
}
