package com.vlife.qa.base;

import java.util.Random;

import android.os.RemoteException;

import com.android.uiautomator.core.UiCollection;
import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.vlife.qa.util.UiAutomatorUtil;


public class Regex extends UiAutomatorTestCase{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new UiAutomatorUtil("Demo", "com.vlife.qa.base.Demo", "testzhuti", "18");

	}
	
	public void testzhuti() throws UiObjectNotFoundException, RemoteException{
		if(!UiDevice.getInstance().isScreenOn()){
			UiDevice.getInstance().wakeUp();
		}
		UiDevice.getInstance().swipe(753, 2559, 753, 1379, 20);
		UiObject zhuti = new UiObject(new UiSelector().text("主题美化"));
		zhuti.click();
	}
	
	public void testClock() throws UiObjectNotFoundException{
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressHome();
		
		UiObject clock=new UiObject(new UiSelector().resourceIdMatches("com.android.deskclock:id/analog_appwidget"));
		UiObject alarm=new UiObject(new UiSelector().descriptionMatches("闹钟"));
		UiObject add=new UiObject(new UiSelector().descriptionMatches("添加闹钟"));
		UiObject done=new UiObject(new UiSelector().textMatches("完成"));
		
		UiCollection time=new UiCollection(new UiSelector().classNameMatches(".*ListView"));
		
		
		//add
		clock.clickAndWaitForNewWindow();
		alarm.click();
		add.click();
		done.click();
		sleep(1500);
		//clock.clickAndWaitForNewWindow();
		
		alarm.click();
		add.click();
		done.click();
		//修改第二个
		
		UiObject twoObject=time
				.getChildByInstance(new UiSelector().textMatches(".*\\d+:\\d+"), 1);
		twoObject.click();
		done.click();
		
		
		
		
		//删除
		UiObject delObject=time.getChildByInstance(new UiSelector().descriptionMatches("删除闹钟"), 1);
		sleep(2000);
		UiDevice.getInstance().swipe(600, 600, 600, 1700, 20);
		sleep(1500);
		alarm.click();
		delObject.click();
		sleep(2000);
		
		
		assertTrue(!twoObject.exists());
		
		
		
		
	}
	
 public void testContact() throws UiObjectNotFoundException{
	 UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressHome();
		
		UiObject contact=new UiObject(new UiSelector().textMatches("联系人|People"));
		UiObject add=new UiObject(new UiSelector().descriptionMatches("添加联系人|Add\\sContact"));
		UiObject name=new UiObject(new UiSelector()
		.classNameMatches(".*EditText")
		.textMatches("姓名|Name"));
		UiObject phone=new UiObject(new UiSelector()
		.classNameMatches(".*EditText")
		.textMatches("电话|Phone"));
		UiObject done=new UiObject(new UiSelector().textMatches("完成|Done"));
		
		contact.clickAndWaitForNewWindow();
		add.clickAndWaitForNewWindow();
		String nameStr="a"+new Random().nextInt(100);
		name.setText(nameStr);
		phone.setText("18888888888");
		done.click();
		sleep(3000);
		assertTrue(new UiObject(new UiSelector().textMatches(nameStr)).exists());
		
		
		
		
		
 }
 
 public void testDialog() throws UiObjectNotFoundException{
	 clickDialog(true);
 }
	
 public void clickDialog(boolean yn) throws UiObjectNotFoundException{
	 UiObject y=new UiObject(new UiSelector().textMatches("是|确认|确定|Y|OK"));
	 UiObject n=new UiObject(new UiSelector().textMatches("否|同意|取消|N|Cancel"));
	 
	 if(yn){
		
			y.click();

	 }else{
		
			n.click();
		
	 }
	 
 }

}
