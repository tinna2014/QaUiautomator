package com.vlife.qa.base;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.uiautomator.core.Configurator;
import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class UiAutomatorBase extends UiAutomatorTestCase{
	
	/**
	 * 黑盒方式启动应用-启动器中选择
	 */
	public static void launchApp(String application) throws UiObjectNotFoundException{
		
		UiDevice.getInstance().pressHome();
	    UiObject allAppsButton = new UiObject(new UiSelector().description("Apps"));
		
	    if(allAppsButton.exists()){
	    	allAppsButton.clickAndWaitForNewWindow();
	    }
	          
	    UiObject appsTab = new UiObject(new UiSelector().text("Apps"));
	    if(appsTab.exists()){
	    	appsTab.click();
	    }
	    
		UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));      
	    //设置滑动方向为 horizontal (默认是vertical)
		appViews.setAsHorizontalList();
		//找到要打开的App
		
		Configurator.getInstance().setScrollAcknowledgmentTimeout(2000l);
		UiObject appToBeLaunched = appViews.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()), application,true);
		appToBeLaunched.clickAndWaitForNewWindow();
		Configurator.getInstance().setScrollAcknowledgmentTimeout(200l);
		
	}
	
	/**
	 * 点击屏幕正中
	 */
	public static void ClickCenter() throws UiObjectNotFoundException{
		int h=UiDevice.getInstance().getDisplayHeight();
		int w=UiDevice.getInstance().getDisplayWidth();
		UiDevice.getInstance().click(w/2, h/2);
	}
	
	/**
	 * 海外杂志锁屏通用解锁
	 */
	public static void MagaUnlock() throws UiObjectNotFoundException{
		int h=UiDevice.getInstance().getDisplayHeight();
		int w=UiDevice.getInstance().getDisplayWidth();
		UiDevice.getInstance().swipe(w/2, h/4*3,w/2,h/4,15);
		UiDevice.getInstance().swipe(w/2, h/4*3,w/2,h/4,15);

	}
	
	/**
	 * 华为杂志锁屏通用解锁
	 */
	public static void HuaweiMagaUnlock() throws UiObjectNotFoundException{
		int h=UiDevice.getInstance().getDisplayHeight();
		int w=UiDevice.getInstance().getDisplayWidth();
		UiDevice.getInstance().swipe(w/4, h/2,w/4*3,h/2,15);
		UiDevice.getInstance().swipe(w/4, h/2,w/4*3,h/2,15);

	}
	

}
