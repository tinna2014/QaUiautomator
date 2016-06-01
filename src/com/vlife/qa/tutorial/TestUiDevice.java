package com.vlife.qa.tutorial;



import java.io.File;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.view.Surface;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.vlife.qa.util.UiAutomatorUtil;

public class TestUiDevice extends UiAutomatorTestCase {

   public static void main(String[] agrs){
	   String jarName,testClass,testName,androidId;
	   jarName="UiDevice";
	   testClass="com.vlife.qa.uidevices.UiDeviceDemo";
	   testName="testBrowser";
	   androidId="18";
	   new UiAutomatorUtil(jarName, testClass, testName, androidId);
   }
   public void testPress(){
	   //UiDevice.getInstance().pressMenu();
	   UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_A);
	   UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_B);
	   UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_C);
	   
	   UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_A,1);
	   UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_B,1);
	   UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_C,1);
	   
   }
   public void testClick() throws UiObjectNotFoundException{
	   //UiDevice.getInstance().click(399, 355);
//	   int h=UiDevice.getInstance().getDisplayHeight();
//	   int w=UiDevice.getInstance().getDisplayWidth();
//	   UiDevice.getInstance().click(w/2, h/2);
	   UiObject clock=new UiObject(new UiSelector().resourceId("com.android.deskclock:id/analog_appwidget"));
	   
	   Rect r=clock.getBounds();
	   int x0=r.left;
	   int y0=r.top;
	   int x1=r.right;
	   int y1=r.bottom;
	   
	   int centerx=r.centerX();
	   int centery=r.centerY();
	   
	   System.out.println("["+x0+","+y0+"]");
	   System.out.println("["+x1+","+y1+"]");
	   
	   
	   
   }
   public void testDragAndSwipe(){
	   //[252,1704][444,1896]
//	   int startX, startY, endX, endY, steps;
//	   startX=(444-252)/2+252;
//	   startY=(1896-1704)/2+1704;
//	   endX=startX;
//	   endY=startY-500;
//	   steps=100;
//	   UiDevice.getInstance().drag(startX, startY, endX, endY, steps);
	   
//	   int h=UiDevice.getInstance().getDisplayHeight();
//	   int w=UiDevice.getInstance().getDisplayWidth();
//	   UiDevice.getInstance().swipe(w-50, h/2, 50, h/2, 10);
	   
	   //277,318   746,335  784,814   221,840
	   Point p1=new Point();
	   Point p2=new Point();
	   Point p3=new Point();
	   Point p4=new Point();
	   
	   p1.x=277;p1.y=318;
	   p2.x=746;p2.y=335;
	   p3.x=784;p3.y=814;
	   p4.x=221;p4.y=840;
	   
	   Point[] pp={p1,p2,p3,p4};
	   
	   UiDevice.getInstance().swipe(pp, 50);
	   
	 
	   
   }
   
   public void testOrientation() throws RemoteException{
	   UiDevice.getInstance().setOrientationLeft();
	   UiDevice.getInstance().setOrientationRight();
	   
	   
	   if(UiDevice.getInstance().isNaturalOrientation()){
		   UiDevice.getInstance().setOrientationLeft();
	   }
	   
	   int a=UiDevice.getInstance().getDisplayRotation();
	   if(a==Surface.ROTATION_0){
		   
	   }
   if(a==Surface.ROTATION_90){
		   
	   }
   if(a==Surface.ROTATION_180){
	   
   }
   if(a==Surface.ROTATION_270){
	   
   }
	   
   }
   
public void testWakeupAndSleep() throws RemoteException{
	if(!UiDevice.getInstance().isScreenOn()){
		//UiDevice.getInstance().sleep();
		UiDevice.getInstance().wakeUp();
	}
	
}
public void testScreen(){
	UiDevice.getInstance().takeScreenshot(new File("/sdcard/test1.png"));	
}
public void testIdle(){
	//[828,1704][1020,1896]
	
	UiDevice.getInstance().click(950, 1800);
	UiDevice.getInstance().waitForIdle(20000);	
}
public void testGetPackage(){
	String packageName=UiDevice.getInstance().getCurrentPackageName();
	System.out.println(packageName);
	
	UiDevice.getInstance().openNotification();
	sleep(3000);
	UiDevice.getInstance().openQuickSettings();
	
	UiDevice.getInstance().dumpWindowHierarchy("n.xml");
	
	
}
	
public void testBrowser() throws RemoteException, UiObjectNotFoundException{
	//灭屏-》亮屏->解锁->单击浏览器->单击网址输入框->输入www.baidu.com->按回车键->旋转屏幕->截图
	UiDevice.getInstance().sleep();
	sleep(2000);
	if(!UiDevice.getInstance().isScreenOn()){
		UiDevice.getInstance().wakeUp();
	}
	sleep(2000);
	UiDevice.getInstance().swipe(357, 1258, 357, 669, 10);
	UiDevice.getInstance().pressHome();
	sleep(2000);

	UiSelector B2 = new UiSelector().text("浏览器");
	UiObject Browser = new UiObject (B2);
	
	Browser.click();
	sleep(3000);
	UiObject textbox = new UiObject(new UiSelector().resourceId("com.android.browser:id/search_hint"));
	textbox.click();
	sleep(2000);
	UiDevice.getInstance().pressDelete();
	sleep(2000);
	UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_W);
	sleep(500);
	UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_W);
	sleep(500);
	UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_W);
	sleep(500);
	UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_PERIOD);
	sleep(500);
	UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_B);
	sleep(500);
	UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_A);
	sleep(500);
	UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_I);
	sleep(500);
	UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_D);
	sleep(500);
	UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_U);
	sleep(500);
	UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_PERIOD);
	sleep(500);
	UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_C);
	sleep(500);
	UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_O);
	sleep(500);
	UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_M);
	sleep(500);
	
	UiDevice.getInstance().pressEnter();
	sleep(2000);
	UiDevice.getInstance().setOrientationLeft();
	sleep(2000);
	UiDevice.getInstance().takeScreenshot(new File("/sdcard/browser.png"));
	
	


}

}