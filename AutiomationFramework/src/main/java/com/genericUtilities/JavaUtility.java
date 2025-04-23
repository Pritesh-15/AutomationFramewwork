package com.genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

	/**
	 * this class consists of generic methods related to java
	 * @author Pritesh
	 * 
	 */

public class JavaUtility {
	
	/**
	 * this method will return current system date in specific format
	 * @return
	 */
	
	public static String getSystemDateInFormat() 
	{
		Date d=new Date();
		SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		String date=sf.format(d);
		return date;
			
	}

}
