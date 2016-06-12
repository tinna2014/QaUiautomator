package com.vlife.qa.casedesign.tc;

import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.vlife.qa.base.AssertTrue2Apps;
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
	
	
	public void test1Dail() throws RemoteException, UiObjectNotFoundException{
		System.out.println("==================测试Dailer");
		UiDevice.getInstance().sleep();
		sleep(2000);
		if(!UiDevice.getInstance().isScreenOn()){
			UiDevice.getInstance().wakeUp();
		}
		sleep(2000);
		UiObject Dailer = new UiObject(new UiSelector().className("android.widget.ImageView").index(0));
		if (!Dailer.exists()){
			UiAutomatorBase.ClickCenter();		
		}
		Dailer.clickAndWaitForNewWindow();
		sleep(2000);

	}
	
	public void test2Next() throws RemoteException, UiObjectNotFoundException{
		System.out.println("==================测试下一张");
		UiDevice.getInstance().sleep();
		sleep(2000);
		if(!UiDevice.getInstance().isScreenOn()){
			UiDevice.getInstance().wakeUp();
		}
		sleep(2000);
		System.out.println("==================唤醒屏幕了");

		UiObject Next = new UiObject(new UiSelector().className("android.widget.ImageView").instance(1));

		if (!Next.exists()){
			UiAutomatorBase.ClickCenter();
		}
		System.out.println("==================next存在性"+Next.exists());

		sleep(1000);		
		for(int i = 0; i<20; i++)
		{
			Next.click();

		}
		
		sleep(1000);
		UiAutomatorBase.ClickCenter();
		sleep(1000);		
		
	}
	
	public void test3Setting() throws RemoteException, UiObjectNotFoundException{
		System.out.println("==================测试进入Settings");
		UiDevice.getInstance().sleep();
		sleep(2000);
		if(!UiDevice.getInstance().isScreenOn()){
			UiDevice.getInstance().wakeUp();
		}
		sleep(2000);
		UiObject Setting = new UiObject(new UiSelector().className("android.widget.ImageView").instance(2));		

		if (!Setting.exists()){
			UiAutomatorBase.ClickCenter();
			UiAutomatorBase.ClickCenter();

		}	
		sleep(1000);	
		Setting.clickAndWaitForNewWindow();
		sleep(2000);

	}
	
	public void test4Camera() throws RemoteException, UiObjectNotFoundException{
		System.out.println("==================测试进入Camera");
		UiDevice.getInstance().sleep();
		sleep(2000);
		if(!UiDevice.getInstance().isScreenOn()){
			UiDevice.getInstance().wakeUp();
		}
		sleep(2000);
		UiObject Camera = new UiObject(new UiSelector().className("android.widget.ImageView").instance(3));
		if (!Camera.exists()){
			UiAutomatorBase.ClickCenter();
		}
		sleep(1000);
		Camera.clickAndWaitForNewWindow();
		AssertTrue2Apps.OpenCamera();
		sleep(2000);

	}
	
	public void test5CheckMore() throws RemoteException, UiObjectNotFoundException{
		System.out.println("==================测试“查看更多”链接跳转");
		UiDevice.getInstance().sleep();
		sleep(2000);
		if(!UiDevice.getInstance().isScreenOn()){
			UiDevice.getInstance().wakeUp();
		}
		sleep(2000);
		UiObject MoreButton = new UiObject(new UiSelector().text("查看更多"));
		if (MoreButton.exists()){
			MoreButton.clickAndWaitForNewWindow();
		}
		
		sleep(2000);

	}
	
	public static void main(String args[]){
		String jarName, testClass, testName, androidId;
		jarName = "ButtonOnPanel";
		testClass = "com.vlife.qa.casedesign.tc.MagaLockButtonOnPanelTestCase";
		testName = "test4Camera";
		androidId = "18";
		new UiAutomatorUtil(jarName, testClass, testName, androidId);
	}
	
	
}
