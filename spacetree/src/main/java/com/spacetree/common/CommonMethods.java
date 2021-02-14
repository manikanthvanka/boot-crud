package com.spacetree.common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommonMethods {

	private CommonMethods() {
		
		
	}
	public static String getCurrentDateAndTime(String formatter) {
		
	   DateTimeFormatter format2 = DateTimeFormatter.ofPattern(formatter);  
	   return LocalDateTime.now().format(format2);   
		
	}
}
