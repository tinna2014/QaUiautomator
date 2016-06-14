package com.vlife.qa.casedesign.tc;

import java.util.Arrays;

import android.content.res.Configuration;
import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
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
		UiObject Dailer = new UiObject(new UiSelector().resourceIdMatches(".*magazine_panel_menu_mic_id"));
		if (!Dailer.exists()){
			UiAutomatorBase.ClickCenter();		
		}
		Dailer.clickAndWaitForNewWindow();
		AssertTrue2Apps.OpenDialer();
		sleep(2000);

	}
	
	public void test2Next() throws RemoteException, UiObjectNotFoundException{
		
		String[] WallpaperName = new String[10];
		System.out.println("==================测试下一张");
		UiDevice.getInstance().sleep();
		sleep(2000);
		if(!UiDevice.getInstance().isScreenOn()){
			UiDevice.getInstance().wakeUp();
		}
		sleep(2000);
		UiObject Next = new UiObject(new UiSelector().resourceIdMatches(".*magazine_panel_menu_next_id"));

		if (!Next.exists()){
			UiAutomatorBase.ClickCenter();
		}
		System.out.println("==================next存在性"+Next.exists());
		sleep(1000);		
		for(int i = 0; i<10; i++)
		{
			Next.click();
			sleep(2000);
			UiObject TextName = new UiObject(new UiSelector().resourceIdMatches(".*magazine_title_text_view_id"));
			if(TextName.exists()){
				WallpaperName[i] = TextName.getText();
			}
			
		}		
		sleep(1000);
		UiAutomatorBase.ClickCenter();
		sleep(1000);		
		System.out.println(Arrays.asList(WallpaperName));
		boolean allsame = true;
		for(int i = 1; i < WallpaperName.length; ++i)
		{
			if(WallpaperName[0] != WallpaperName[i])
			{
				allsame = false;
				break;
			}
		}
		System.out.println(Arrays.asList(allsame));
		assertTrue(!allsame);
	}
	
	public void test3Setting() throws RemoteException, UiObjectNotFoundException{
		System.out.println("==================测试进入Settings");
		UiDevice.getInstance().sleep();
		sleep(2000);
		if(!UiDevice.getInstance().isScreenOn()){
			UiDevice.getInstance().wakeUp();
		}
		sleep(2000);
		UiObject Setting = new UiObject(new UiSelector().resourceIdMatches(".*magazine_panel_menu_settings_id"));		

		if (!Setting.exists()){
			UiAutomatorBase.ClickCenter();
			UiAutomatorBase.ClickCenter();

		}	
		sleep(1000);	
		Setting.clickAndWaitForNewWindow();
		sleep(2000);
		UiScrollable Settings = new UiScrollable(new UiSelector().className("android.widget.ScrollView"));
		boolean findlast = Settings.scrollIntoView(new UiSelector().text("VLife lockscreen"));
		assertTrue(findlast);

	}
	
	public void test4Camera() throws RemoteException, UiObjectNotFoundException{
		System.out.println("==================测试进入Camera");
		UiDevice.getInstance().sleep();
		sleep(2000);
		if(!UiDevice.getInstance().isScreenOn()){
			UiDevice.getInstance().wakeUp();
		}
		sleep(2000);
		UiObject Camera = new UiObject(new UiSelector().resourceIdMatches(".*magazine_panel_menu_camera_id"));
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
		UiObject MoreButton = new UiObject(new UiSelector().textMatches("查看更多|Check more"));
		if (MoreButton.exists()){
			MoreButton.clickAndWaitForNewWindow();
		}
		sleep(2000);
		AssertTrue2Apps.OpenBrowser();
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
