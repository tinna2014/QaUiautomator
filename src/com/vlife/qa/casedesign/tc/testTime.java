package com.vlife.qa.casedesign.tc;

import java.text.SimpleDateFormat;
import java.util.Date;

public class testTime {
	public static void main(String args[]){
		SimpleDateFormat formattime1 = new SimpleDateFormat(
				"yyyyMMdd_HHmmss");
		long ctime = System.currentTimeMillis();
		String DIR_NAME = formattime1.format(new Date(ctime));
		System.out.println("formattime1:"+formattime1);
		System.out.println("System.currentTimeMillis()="+System.currentTimeMillis());
		System.out.println("formattime1.format(new Date(ctime))"+DIR_NAME);
	}
}
