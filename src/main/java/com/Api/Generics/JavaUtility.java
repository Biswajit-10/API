package com.Api.Generics;

import java.util.Random;

public class JavaUtility {
	
	public static int getRanDomNum() {
		Random ran = new Random();
		      int num =  ran.nextInt(2000);
			return num;
	}
}
