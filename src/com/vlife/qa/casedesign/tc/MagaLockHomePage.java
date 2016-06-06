package com.vlife.qa.casedesign.tc;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.vlife.qa.base.UiAutomatorBase;
import com.vlife.qa.util.UiAutomatorUtil;

public class MagaLockHomePage extends UiAutomatorTestCase {
	public void launchHomePage() throws UiObjectNotFoundException{
		UiAutomatorBase.launchApp("印度在线");
	}
	
	
	public void testAutoPlay() throws UiObjectNotFoundException{
		UiObject AutoPlay = new UiObject(new UiSelector().text("自动播放"));
		AutoPlay.click();
	}
	
	public void testLockSetting() throws UiObjectNotFoundException{
		UiObject LockSettings = new UiObject(new UiSelector().text("锁屏设置"));
		LockSettings.click();
	}
	
	public void testDailyUpdate() throws UiObjectNotFoundException{
		UiObject DailyUpdate = new UiObject(new UiSelector().text("每日更新"));
		DailyUpdate.click();
	}
	
	public void testOnlyWiFiUpdate() throws UiObjectNotFoundException{
		UiObject WifiUpdata = new UiObject(new UiSelector().text("只在wifi下更新"));
		WifiUpdata.click();
	}
	
	

	public static void main(String args[]){
		String jarName, testClass, testName, androidId;
		jarName = "MagazineHomePage";
		testClass = "com.vlife.qa.casedesign.tc.MagaLockHomePage";
		testName = "launchHomePage";
		androidId = "18";
		new UiAutomatorUtil(jarName, testClass, testName, androidId);
	}
	
	

}
