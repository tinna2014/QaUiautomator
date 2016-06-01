package com.vlife.qa.tutorial;

import com.android.uiautomator.core.UiCollection;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.vlife.qa.util.UiAutomatorUtil;

public class TestUiCollection extends UiAutomatorTestCase{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String jarName, testClass, testName, androidId;
		jarName="demo";
		testClass="com.vlife.qa.collection.Test";
		testName="testCount";
		androidId="1";
		new UiAutomatorUtil(jarName, testClass, testName, androidId);

	}
	
	public void testDemo1() throws UiObjectNotFoundException{
	    UiCollection collection=new UiCollection(new UiSelector().className("android.widget.ListView"));
	    UiSelector childPattern=new UiSelector().className("android.widget.TextView");
	    String text="Music";	    
	    UiObject music=collection.getChildByText(childPattern, text);
	    music.click();	    	    
	}
	
	public void testDesc() throws UiObjectNotFoundException{
		UiCollection collection=new UiCollection(new UiSelector().resourceId("com.android.dialer:id/top"));
		UiSelector childPattern=new UiSelector().className("android.widget.FrameLayout");
		String text="4";
		UiObject forth=collection.getChildByDescription(childPattern, text);
		forth.click();
	}
	public void testInstance() throws UiObjectNotFoundException{
		UiCollection collection=new UiCollection(new UiSelector().resourceId("com.android.dialer:id/top"));
		UiSelector childPattern=new UiSelector().className("android.widget.FrameLayout");
		UiObject child1=collection.getChildByInstance(childPattern, 0);
		UiObject child0=collection.getChildByInstance(childPattern, 10);
		UiObject child00=collection.getChildByInstance(childPattern, 10);
		UiObject child8=collection.getChildByInstance(childPattern, 7);
		UiObject child6=collection.getChildByInstance(childPattern, 5);
		
		child1.click();
		sleep(500);
		child0.click();
		sleep(500);
		child00.click();
		sleep(500);
		child8.click();
		sleep(500);
		child6.click();
		sleep(500);
		
	}
	public void testCount() throws UiObjectNotFoundException{
		UiCollection collection=new UiCollection(new UiSelector().index(0));
		int textViewCount=collection.getChildCount(new UiSelector().className("android.widget.TextView"));
		System.out.println("TextView Count:"+textViewCount);
		
		UiCollection tableCollection=new UiCollection(new UiSelector().className("android.widget.TableLayout"));
		int tableChildCount=tableCollection.getChildCount();
		System.out.println(tableChildCount);
		
	}

}
