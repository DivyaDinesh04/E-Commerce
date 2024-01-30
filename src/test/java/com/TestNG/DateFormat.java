package com.TestNG;

import org.testng.annotations.Test;

import com.genericUtility.JavaUtils;

public class DateFormat {

	@Test
	public void dateTest()
	{
		JavaUtils j = new JavaUtils();
		String res = j.getSystemDateInFormat();
		System.out.println(res);
	}
}
