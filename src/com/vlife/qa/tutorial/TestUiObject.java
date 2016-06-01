package com.vlife.qa.tutorial;

import android.graphics.Point;
import android.view.KeyEvent;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.vlife.qa.util.UiAutomatorUtil;

public class TestUiObject extends UiAutomatorTestCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
       String jarName, testClass, testName, androidId;
       jarName="uiobject";
       testClass="com.vlife.qa.object.Test";
       testName="testExist";
       androidId="1";
       new UiAutomatorUtil(jarName, testClass, testName, androidId);

	}
	
	public void testClick() throws UiObjectNotFoundException{
		UiObject clock=new UiObject(new UiSelector()
		.resourceId("com.android.deskclock:id/analog_appwidget"));		
		//clock.click();
		//clock.clickAndWaitForNewWindow();
//		clock.clickBottomRight();
//		sleep(3000);
//		UiDevice.getInstance().pressBack();
//		sleep(1000);
//		clock.clickTopLeft();
//		sleep(3000);
//		UiDevice.getInstance().pressBack();
//		sleep(1000);
		
		//longclick
		
		//clock.longClick();
		UiDevice.getInstance().swipe(533, 612, 535, 615, 500);	
	}
	public void testDrag() throws UiObjectNotFoundException{
//		UiObject object1=new UiObject(new UiSelector().text("联系人"));
//		UiObject object2=new UiObject(new UiSelector().text("图库"));
//		//object1.dragTo(350,1704-500, 10);
//		//object1.dragTo(object2, 30);
//		object1.swipeUp(5);
		
		UiObject recent=new UiObject(new UiSelector()
		.resourceId("com.android.systemui:id/app_thumbnail_image"));		
		
		recent.swipeLeft(10);
				
	
	}
	
	public void testSetText() throws UiObjectNotFoundException{
//		UiObject edit=new UiObject(new UiSelector()
//		.resourceId("com.android.mms:id/embedded_text_editor"));
//		
//		edit.setText("qwertyuiop");
//		sleep(2000);
//		edit.clearTextField();
		
		//接收者
		UiObject r=new UiObject(new UiSelector()
		.resourceId("com.android.mms:id/recipients_editor"));
		UiObject w=new UiObject(new UiSelector().text("接收者"));
		r.setText("kkkkkkkkkkkkk");
		//将光标移动到行尾，使用backspace进行删除
		UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_MOVE_END);
		while(!w.exists()){
		UiDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_DEL);
		}
		//将光标移动到行首，使用delete键来删除
	
	}
	public void testGet() throws UiObjectNotFoundException{
		UiObject r=new UiObject(new UiSelector()
		.resourceId("com.android.mms:id/recipients_editor"));
		
		String rec=r.getText();
		
		System.out.println("HINT:"+rec);
		System.out.println("CLASS:"+r.getClassName());
		System.out.println("PACKAGE_Name:"+r.getPackageName());
		System.out.println("PACKAGE_Name:"+r.getPackageName());
		System.out.println("DESC:"+r.getContentDescription());
		System.out.println("RECT:"+r.getBounds().left);
		assertEquals("接收者", rec);
		
	}
	public void testNode() throws UiObjectNotFoundException{
		UiObject down=new UiObject(new UiSelector()
		.resourceId("com.cyanogenmod.filemanager:id/navigation_view_details_item")
		.index(3));
		
//		UiObject download=down.getChild(new UiSelector()
//		.resourceId("com.cyanogenmod.filemanager:id/navigation_view_item_name"));
//		
//		download.click();
		
		UiObject music=down.getFromParent(new UiSelector()
		.resourceId("com.cyanogenmod.filemanager:id/navigation_view_details_item").index(5));
		
		music.click();
		
		
	}
	public void testIs() throws UiObjectNotFoundException{
	   UiObject wlan=new UiObject(new UiSelector()
	   .resourceId("com.android.settings:id/switchWidget"));
	   
	   if(!wlan.isChecked()){
		 wlan.click();  
	   }
	

	}
public void testGesture() throws UiObjectNotFoundException{
	UiObject object=new UiObject(new UiSelector()
	.resourceId("com.android.gallery3d:id/photopage_bottom_controls"));
	
	//object.pinchIn(80, 20);
	//object.pinchOut(80, 20);
	
	Point startPoint1, startPoint2, endPoint1, endPoint2;
	startPoint1=new Point();
	startPoint2=new Point();
	endPoint1=new Point();
	endPoint2=new Point();
	
	startPoint1.x=157;startPoint1.y=183;
	startPoint2.x=122;startPoint2.y=455;
	
	endPoint1.x=948;endPoint1.y=195;
	endPoint2.x=930;endPoint2.y=493;

	object.performTwoPointerGesture(startPoint1, startPoint2, endPoint1, endPoint2, 50);
    

}

  public void testExist() throws UiObjectNotFoundException{
	  UiObject l=new UiObject(new UiSelector().text("联系人"));
	  if(l.exists()){
		  l.click();
	  }
	  UiObject create=new UiObject(new UiSelector().text("创建新联系人"));
	  if(create.waitForExists(5000)){
		  System.out.println("没有任何联系人，需要创建");
		  create.click();
		  //创建步骤。。。。
	  }
  }
}
