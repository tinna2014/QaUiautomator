package com.vlife.qa.base;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class UiAutomatorBase extends UiAutomatorTestCase{
	
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
		UiObject appToBeLaunched = appViews.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()), application);
		appToBeLaunched.clickAndWaitForNewWindow();		
	}
	
	   public static void ClickCenter() throws UiObjectNotFoundException{
		   int h=UiDevice.getInstance().getDisplayHeight();
		   int w=UiDevice.getInstance().getDisplayWidth();
		   UiDevice.getInstance().click(w/2, h/2);
	   }
	
	public void trace(String message){
		
		System.out.println("### " + message + " ###");
	}
	
	public void assertViewTrue(String... descriptions) throws UiObjectNotFoundException{
		
		for(String description: descriptions){
			trace("Check if View with description: " + description + " is available?");
			UiObject view = new UiObject(new UiSelector().className(View.class.getName()).description(description));
			assertTrue("View with description: " + description + " is not available", view.exists());
		}
	}
	
	protected void assertTextViewTrue(String... texts) throws UiObjectNotFoundException{
		
		for(String text: texts){
			trace("Check if TextView with text: " + text + " is available?");
			UiObject textView = new UiObject(new UiSelector().className(TextView.class.getName()).text(text));
			assertTrue("TextView with text: " + text + " is not available", textView.exists());
		}
	}
	
	protected void assertImageButtonTrue(String... descriptions) throws UiObjectNotFoundException{
		
		for(String description: descriptions){
			trace("Check if ImageButton with description: " + description + " is available?");
			UiObject view = new UiObject(new UiSelector().className(ImageButton.class.getName()).description(description));
			assertTrue("ImageButton with description: " + description + " is not available", view.exists());
		}
	}
}
