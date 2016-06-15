package com.vlife.qa.tutorial;

import android.view.View;
import android.widget.TextView;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.vlife.qa.util.UiAutomatorUtil;

public class TestUiSelector extends UiAutomatorTestCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String jarName, testClass, testName, androidId;
		jarName="Demo";
		testClass="com.vlife.qa.tutorial.TestUiSelector";
		testName="testDemo";
		androidId="19";
	new UiAutomatorUtil(jarName, testClass, testName, androidId);

	}
	
	public void testDemo() throws UiObjectNotFoundException{
		//找到对象---点击对象
		UiSelector l=new UiSelector().text("通讯录");
		UiObject object=new UiObject(l);
		object.click();
		
	}
	public void testMatches() throws UiObjectNotFoundException{
		//通讯录
		//完全匹配：通讯录
		//包含匹配：讯录
		//正则匹配：.*讯.*
		//起始匹配：通讯
		
		//UiSelector l=new UiSelector().textContains("讯录");
		  UiSelector l=new UiSelector().textMatches(".*讯.*");
//		UiSelector l=new UiSelector().textStartsWith("通讯");
		UiObject object=new UiObject(l);
		object.click();		
		
	}
	
	public void test2(){
		UiSelector checkmore = new UiSelector().className("android.widget.TextView").index(0);
		UiSelector checkmore2 = new UiSelector().className("android.widget.TextView").index(4);
		UiSelector checkmore3 = new UiSelector().text("Check more");


		
	}
	public void testDesc() throws UiObjectNotFoundException{
		//完全匹配：应用
		//UiSelector selector=new UiSelector().description("应用");
		//包含匹配:应
		//UiSelector selector=new UiSelector().descriptionContains("应");
		//正则匹配
		//UiSelector selector=new UiSelector().descriptionMatches("应.*");
		//起始匹配
		UiSelector selector=new UiSelector().descriptionStartsWith("应");
		UiObject object=new UiObject(selector);
		object.click();
		TextView.class.getName();
		
	}
	public void testClassAndPackage() throws UiObjectNotFoundException{
		//完全匹配
		//UiSelector selector=new UiSelector().className("android.view.View").instance(5);
		//正则方式
		//UiSelector selector=new UiSelector().classNameMatches(".*View").instance(7);
		//class.getName
//		UiSelector selector=new UiSelector().className(View.class.getName()).instance(5);
//		UiObject object=new UiObject(selector);
//		object.click();
		
		UiSelector selector=new UiSelector().packageName("com.android.deskclock");						
		
	}
	public void testIndex() throws UiObjectNotFoundException{
		//城市按钮
		UiSelector selector=new UiSelector().className("android.widget.ImageButton").index(0);
		UiObject object=new UiObject(selector);
		object.click();
		sleep(2000);
		UiDevice.getInstance().pressBack();
		sleep(2000);
		//更多选项
		UiSelector more=new UiSelector().className("android.widget.ImageButton").instance(1);
		UiObject objectMore=new UiObject(more);
		objectMore.click();
		
	}

	public void testProperty() throws UiObjectNotFoundException{
//		UiObject swtichObj=new UiObject(new UiSelector().checkable(true));
//		swtichObj.click();
		
//		UiObject swtichObj=new UiObject(new UiSelector().checked(true));
//		swtichObj.click();
		
		//enable
//		UiObject send=new UiObject(new UiSelector().enabled(false));		
//		System.out.println("CLASS NAME:"+send.getClassName());
		
		//focused
//		UiObject focusedObj=new UiObject(new UiSelector().focused(true));
//		focusedObj.setText("abcd");
		
		//longclick
//		UiObject longclick=new UiObject(new UiSelector().longClickable(true).index(4));
//		longclick.click();
		
		//scrollable
		UiScrollable scrollable=new UiScrollable(new UiSelector().scrollable(true));
		scrollable.scrollForward();
		sleep(1000);
		scrollable.scrollForward();
		sleep(1000);
		scrollable.scrollForward();
		sleep(1000);
		
	}
	public void testNode() throws UiObjectNotFoundException{
		//childselector
//		UiScrollable scrollable=new UiScrollable(new UiSelector()
//		.scrollable(true).childSelector(new UiSelector().text("Android")));		
//		scrollable.click();
		
		//formParent
		UiObject parentObj=new UiObject(new UiSelector()
		.resourceId("com.cyanogenmod.filemanager:id/navigation_view_details_item")
		.fromParent(new UiSelector().className("android.widget.LinearLayout").index(1)));
		parentObj.click();
	}
	public void testId() throws UiObjectNotFoundException{
//		UiObject home=new UiObject(new UiSelector().resourceId("android:id/home"));
//		home.click();
		
//		UiObject download=new UiObject(new UiSelector()
//		.resourceId("com.cyanogenmod.filemanager:id/navigation_view_details_item")
//		.index(3));
//		
//		download.click();
		
		UiObject download=new UiObject(new UiSelector()
		.resourceIdMatches(".*navigation_view_details_item")
		.index(3));		
		download.click();
		
		
		
		
	}

}
