package com.vlife.qa.base;

import java.util.Random;

import android.view.KeyEvent;
import android.widget.TextView;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class BaseCase extends UiAutomatorTestCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	  
    public void inputPhoneNum(String num) throws UiObjectNotFoundException{
    	if(num.matches("\\d+")){
    		for(int i=0;i<num.length();i++){
    			getObjectByTextClass(num.charAt(i)+"", TextView.class.getName())
    			.click();
    			sleep(100);
    		}
	
    	}else{
    		fail("input num error");
    	}
	
    }
    public void pressDial(boolean is){
    	pressKeyCode(KeyEvent.KEYCODE_ENTER, 1);
    }
    public void hangUp(){
    	pressKeyCode(KeyEvent.KEYCODE_ENDCALL, 1);
    }
    
    public void openDial() throws UiObjectNotFoundException{
    	getObjectByDesc("拨号键盘").click();
    }
    public void exitApp(){
    	pressKeyCode(KeyEvent.KEYCODE_BACK, 3);
    	pressKeyCode(KeyEvent.KEYCODE_HOME, 1);
    }
    public void launchApp() throws UiObjectNotFoundException {
		exitApp();
		getObjectByText("拨号").clickAndWaitForNewWindow();
	}
    public UiObject getObjectByTextClass(String text,String className){
    	return new UiObject(new UiSelector().text(text).className(className));
    }
		
	
    public UiObject getObjectByDesc(String desc) {
		return new UiObject(new UiSelector().description(desc));
	}
    public UiObject getObjectByText(String text){
    	return new UiObject(new UiSelector().text(text));
    }
    public void pressKeyCode(int keyCode,int time){
    	for(int i=0;i<time;i++){
    	UiDevice.getInstance().pressKeyCode(keyCode);
    	}
    }
    
    //calculator
    public double getActial() throws UiObjectNotFoundException {
    	String result=getObjectByClass("android.widget.EditText")
    	.getText();
    	if(result.contains("减")){
    		result=result.replace("减", "-");
    	}
    	if(result.contains("点")){
    		result=result.replace("点", ".");
    	}
    	return Double.valueOf(result);
		
	}
    public double calculator(double one,int operation,double two){
    	switch (operation) {
		case 1:
			return one+two;
		case 2:
			return one-two;
		case 3:
			return one*two;
		case 4:
			return one/two;
		default:
			break;
		}
    	
    	return -10000;
    }
    public int getRandomOperation() throws UiObjectNotFoundException{
    	int ran=new Random().nextInt(1000);
    	if(ran<250){
    		pressKeyboard("+");
    		return 1;
    	}else if (ran>=250&&ran<500) {
    		pressKeyboard("−");
    		return 2;
		}
    	else if (ran>=500&&ran<750) {
    		pressKeyboard("×");
    		return 3;
		}
    	else if (ran>=750) {
    		pressKeyboard("÷");
    		return 4;
		}
    	return -1;
    }
    public void launchCalculator() throws UiObjectNotFoundException{
    	exitApp();
    	getObjectByDesc("应用").clickAndWaitForNewWindow();
    	getObjectByText("计算器").clickAndWaitForNewWindow();	
    }
    public void launchApp(String app) throws UiObjectNotFoundException{
    	exitApp();
    	sleep(500);
    	getObjectByDesc("应用").clickAndWaitForNewWindow();
    	getObjectByText(app).clickAndWaitForNewWindow();	
    }
    public double randomInputData() throws UiObjectNotFoundException{
    	int num=0;
    	while(num==0){
    		num=new Random().nextInt(100);
    	}
    	String s=num+"";
    	for(int i=0;i<s.length();i++){
    		pressKeyboard(s.charAt(i)+"");
    	}
    	return Double.valueOf(num);
    	
    }
    public void pressKeyboard(String text) throws UiObjectNotFoundException{
    	getObjectByTextClass(text, "android.widget.Button").click();
    }
    public UiObject getObjectByClass(String className){
    	return new UiObject(new UiSelector().className(className));
    }

}
