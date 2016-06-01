package com.vlife.qa.base;


public class Data extends UiAutomatorBase{
	
	public static String wlan="";
	public static String QQ="";
	public static String phone="";
	
	
    public void getConfig(){
    	//从文件读取字段，赋值给我我们的变量
    	wlan="";
    	QQ="";
    	phone="";
    }

}
