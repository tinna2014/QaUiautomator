package com.vlife.qa.tutorial;

import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.vlife.qa.util.UiAutomatorUtil;

public class TestUiScrollable extends UiAutomatorTestCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String jarName, testClass, testName, androidId;
		jarName="Test";
		testClass="com.vlife.qa.Scrollable.Test";
		testName="testTheme";
		androidId="18";
	    new UiAutomatorUtil(jarName, testClass, testName, androidId) ; 

	}
	
	public void testTheme() throws RemoteException, UiObjectNotFoundException{
//		UiDevice.getInstance().sleep();
//		if(!UiDevice.getInstance().isScreenOn()){
//			UiDevice.getInstance().wakeUp();
//		}
		UiScrollable pager = new UiScrollable(new UiSelector().resourceId("com.meizu.customizecenter:id/viewpager"));
		pager.flingToEnd(30);
		
	}
	
	public void testSerchResult(){
		UiScrollable SearchResult = new UiScrollable(new UiSelector().resourceId("com.meizu.customizecenter:id/grid_view"));
	}
	public void testFling() throws UiObjectNotFoundException{
		UiScrollable scroll=new UiScrollable(new UiSelector().className("android.widget.ListView"));
		//scroll.flingBackward();
		//scroll.flingForward();
		//scroll.flingToBeginning(20);
		scroll.flingToEnd(30);
	}
	public void testScroll() throws UiObjectNotFoundException{
		UiScrollable scroll=new UiScrollable(new UiSelector().className("android.widget.ListView"));
//		UiObject baiQiang=scroll.getChildByText(new UiSelector().className("android.widget.TextView"), "白强");
//	   baiQiang.click();
	   
	   scroll.getChildByInstance(new UiSelector().className("android.widget.TextView"), 25).click();
	   
	
	}
	public void testSwipCount() throws UiObjectNotFoundException{
		UiScrollable scroll=new UiScrollable(new UiSelector().className("android.widget.ListView"));
		UiObject textView=new UiObject(new UiSelector().text("曹君"));
		scroll.setMaxSearchSwipes(50);
		scroll.scrollIntoView(textView);
		textView.click();
		
		System.out.println("默认最大滚动次数："+scroll.getMaxSearchSwipes());
		
		
	}
	public void testDeadZoon() throws UiObjectNotFoundException{
		UiScrollable scroll=new UiScrollable(new UiSelector().className("android.widget.ListView"));
		double dead=scroll.getSwipeDeadZonePercentage();
		System.out.println("不滑动区域百分比："+dead);
		scroll.setSwipeDeadZonePercentage(0.50);
		scroll.scrollForward();
	}
	public void testScrollForward() throws UiObjectNotFoundException{
		
		UiScrollable scroll=new UiScrollable(new UiSelector().className("android.widget.ListView"));
		//scroll.setSwipeDeadZonePercentage(0.1);
		//scroll.scrollForward(5000);
		scroll.scrollBackward(20);
		
	}
	public void testScrollIntoView() throws UiObjectNotFoundException{
		UiScrollable scroll=new UiScrollable(new UiSelector().className("android.widget.ListView"));
		UiSelector selector=new UiSelector().text("白蕾");
		UiObject object=new UiObject(selector);
		//scroll.scrollIntoView(selector);
		//scroll.scrollIntoView(object);
		//scroll.scrollTextIntoView("白蕾");
		//scroll.scrollDescriptionIntoView("白蕾的快速联系人照片");
		
		//scroll.scrollToBeginning(50,5);
		scroll.scrollToEnd(50,5);
				
	}
public void testVertical() throws UiObjectNotFoundException{
	UiScrollable scroll=new UiScrollable(new UiSelector().className("android.support.v4.view.ViewPager"));
    scroll.setAsHorizontalList();
    scroll.scrollBackward();
    sleep(2000);
    scroll.scrollForward();
    sleep(2000);
    scroll.setAsVerticalList();
    scroll.scrollForward();

}

}
