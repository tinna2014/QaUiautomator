package com.vlife.qa.casedesign.tc;

import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.vlife.qa.base.UiAutomatorBase;
import com.vlife.qa.util.TestCaseResult;
import com.vlife.qa.util.UiAutomatorUtil;

public class MagaLockButtonOnPanelTestCase extends TestCaseResult {
	/*
	 * Testlink用例编号：

	锁屏界面底部四个panel跳转测试
	
	预置条件：1、应用Vlife杂志锁屏
	执行步骤：
	1、亮灭屏-打开panel-点击拨号。   
	2、亮灭屏-打开panel-点击下一张。
	3、亮灭屏-打开panel-点击设置。
	4、亮灭屏-打开panel-点击相机。
	5、亮灭屏-点击“查看更多”。



	 */
	public void testDail() throws RemoteException, UiObjectNotFoundException{
		UiDevice.getInstance().sleep();
		sleep(2000);
		if(!UiDevice.getInstance().isScreenOn()){
			UiDevice.getInstance().wakeUp();
		}
		sleep(2000);
		UiObject panel = new UiObject(new UiSelector().resourceId("android.widget.LinearLayout").index(4));
		UiObject Dailer = new UiObject(new UiSelector().className("android.widget.ImageView").index(0));
		if (!panel.exists()){
			UiAutomatorBase.ClickCenter();
		}		sleep(1000);	
		Dailer.clickAndWaitForNewWindow();
		sleep(2000);

	}
	
	public void testNext() throws RemoteException, UiObjectNotFoundException{
		UiDevice.getInstance().sleep();
		sleep(2000);
		if(!UiDevice.getInstance().isScreenOn()){
			UiDevice.getInstance().wakeUp();
		}
		sleep(2000);
		UiObject panel = new UiObject(new UiSelector().resourceId("android.widget.LinearLayout").index(4));
		UiObject Next = new UiObject(new UiSelector().className("android.widget.ImageView").index(1));
		if (!panel.exists()){
			UiAutomatorBase.ClickCenter();
		}
		sleep(1000);		
		for(int i = 0; i<20; i++)
		Next.click();
		sleep(1000);
		UiAutomatorBase.ClickCenter();
		sleep(1000);
		
	}
	
	public void testSetting() throws RemoteException, UiObjectNotFoundException{
		UiDevice.getInstance().sleep();
		sleep(2000);
		if(!UiDevice.getInstance().isScreenOn()){
			UiDevice.getInstance().wakeUp();
		}
		sleep(2000);
		UiObject panel = new UiObject(new UiSelector().resourceId("android.widget.LinearLayout").index(4));
		UiObject Setting = new UiObject(new UiSelector().className("android.widget.ImageView").index(2));
		if (!panel.exists()){
			UiAutomatorBase.ClickCenter();
		}	
		sleep(1000);	
		Setting.click();
		sleep(2000);

	}
	
	public void testCamera() throws RemoteException, UiObjectNotFoundException{
		UiDevice.getInstance().sleep();
		sleep(2000);
		if(!UiDevice.getInstance().isScreenOn()){
			UiDevice.getInstance().wakeUp();
		}
		sleep(2000);
		UiObject panel = new UiObject(new UiSelector().resourceId("android.widget.LinearLayout").index(4));
		UiObject Camera = new UiObject(new UiSelector().className("android.widget.ImageView").index(3));
		if (!panel.exists()){
			UiAutomatorBase.ClickCenter();
		}
		sleep(1000);
		Camera.click();
		sleep(2000);

	}
	
	public void testCheckMore() throws RemoteException, UiObjectNotFoundException{
		UiDevice.getInstance().sleep();
		sleep(2000);
		if(!UiDevice.getInstance().isScreenOn()){
			UiDevice.getInstance().wakeUp();
		}
		sleep(2000);
		UiObject MoreButton = new UiObject(new UiSelector().text("查看更多"));
		if (MoreButton.exists()){
			MoreButton.click();
		}
		sleep(1000);

	}
	
	public static void main(String args[]){
		String jarName, testClass, testName, androidId;
		jarName = "ButtonOnPanel";
		testClass = "com.vlife.qa.casedesign.tc.MagaLockButtonOnPanelTestCase";
		testName = "";
		androidId = "18";
		new UiAutomatorUtil(jarName, testClass, testName, androidId);
	}
	
	
}
