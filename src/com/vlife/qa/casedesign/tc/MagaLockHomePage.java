package com.vlife.qa.casedesign.tc;

import java.util.Arrays;

import android.os.Build;
import android.os.RemoteException;

import com.android.uiautomator.core.Configurator;
import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.vlife.qa.base.ResumeHome;
import com.vlife.qa.base.UiAutomatorBase;
import com.vlife.qa.util.UiAutomatorUtil;

public class MagaLockHomePage extends UiAutomatorTestCase {
	
	UiScrollable Settings = new UiScrollable(new UiSelector().className("android.widget.ScrollView"));
	
	public void test0launchHomePage() throws UiObjectNotFoundException{
		
		ResumeHome.home();
		UiAutomatorBase.launchApp("VLife");
		sleep(3000);
		UiObject more = new UiObject(new UiSelector().className("android.widget.ImageView").instance(1));
		if(more.exists()){
			sleep(2000);
			more.click();
		}
		sleep(2000);
		UiObject SettingsInMore = new UiObject(new UiSelector().text("Settings"));
		SettingsInMore.clickAndWaitForNewWindow();
	}
	
	public void test1LockSettingOff() throws UiObjectNotFoundException, RemoteException{
		UiObject LockSettings = Settings.getChildByText(new UiSelector().className("android.widget.TextView"),"VLife lockscreen");
		UiObject button = new UiObject(new UiSelector().className("android.widget.CompoundButton").index(0));
		if (button.isChecked()){
			button.click();
		}
		UiDevice.getInstance().sleep();
		sleep(2000);
		UiDevice.getInstance().wakeUp();
		sleep(2000);
		String LockPackage = UiDevice.getInstance().getCurrentPackageName();
		boolean result = LockPackage.contains("com.vlife.stage") || LockPackage.contains("com.vlife") || LockPackage.contains("com.vlife.magazine.lock");
		assertTrue(!result);
		
	}
	
	public void test2LockSettingOn() throws UiObjectNotFoundException, RemoteException{
		UiDevice.getInstance().sleep();
		sleep(2000);
		UiDevice.getInstance().wakeUp();
		sleep(2000);
		if(Build.BRAND.contains("HUAWEI")){
			UiAutomatorBase.HuaweiMagaUnlock();
		}else {
			UiAutomatorBase.MagaUnlock();
		}
		UiObject LockSettings = Settings.getChildByText(new UiSelector().className("android.widget.TextView"),"VLife lockscreen");
		UiObject button = new UiObject(new UiSelector().className("android.widget.CompoundButton").instance(0));
		if (!button.isChecked()){
			button.click();
		}
		sleep(2000);
		UiDevice.getInstance().sleep();
		sleep(2000);
		UiDevice.getInstance().wakeUp();
		sleep(2000);
		String LockPackage = UiDevice.getInstance().getCurrentPackageName();
		boolean result = LockPackage.contains("com.vlife.stage") || LockPackage.contains("com.vlife") || LockPackage.contains("com.vlife.magazine.lock");
		assertTrue(result);
		
	}
	
	public void test3AutoPlayOff() throws UiObjectNotFoundException, RemoteException{

		String[] WallpaperName = new String[4];
		UiDevice.getInstance().sleep();
		sleep(2000);
		UiDevice.getInstance().wakeUp();
		sleep(2000);
		UiAutomatorBase.MagaUnlock();
		UiObject AutoPlay = Settings.getChildByText(new UiSelector().className("android.widget.TextView"), "Auto play");
		UiObject button = new UiObject(new UiSelector().className("android.widget.CompoundButton").instance(1));
		if(button.isChecked()){
			sleep(2000);
			button.click();
		}
		sleep(2000);
		UiDevice.getInstance().sleep();
		sleep(2000);
		if(!UiDevice.getInstance().isScreenOn()){
			UiDevice.getInstance().wakeUp();
		}
		sleep(2000);
		
		for(int i = 0; i<4; i++)
		{
			UiDevice.getInstance().wakeUp();
			sleep(2000);
			UiObject TextName = new UiObject(new UiSelector().resourceIdMatches(".*magazine_title_text_view_id"));
			if(TextName.exists()){
				WallpaperName[i] = TextName.getText();
			}
			sleep(2000);
			UiDevice.getInstance().sleep();
			sleep(2000);

		}
			
		System.out.println(Arrays.asList(WallpaperName));
		boolean allsame = true;
		for(int i = 1; i < WallpaperName.length; ++i)
		{
			if(!WallpaperName[0].equals(WallpaperName[i]))
			{
				allsame = false;
				break;
			}
		}
		System.out.println(allsame);
		assertTrue(allsame);
		
	}
	
	public void test4AutoPlayOn() throws UiObjectNotFoundException, RemoteException{

		String[] WallpaperName = new String[4];
		UiDevice.getInstance().sleep();
		sleep(2000);
		UiDevice.getInstance().wakeUp();
		sleep(2000);
		UiAutomatorBase.MagaUnlock();
		UiObject AutoPlay = Settings.getChildByText(new UiSelector().className("android.widget.TextView"), "Auto play");
		UiObject button = new UiObject(new UiSelector().className("android.widget.CompoundButton").instance(1));
		if(!button.isChecked()){
			sleep(2000);
			button.click();
		}
		sleep(2000);
		UiDevice.getInstance().sleep();
		sleep(2000);
		if(!UiDevice.getInstance().isScreenOn()){
			UiDevice.getInstance().wakeUp();
		}
		sleep(2000);
		
		for(int i = 0; i<4; i++)
		{
			UiDevice.getInstance().wakeUp();
			sleep(2000);
			UiObject TextName = new UiObject(new UiSelector().resourceIdMatches(".*magazine_title_text_view_id"));
			if(TextName.exists()){
				WallpaperName[i] = TextName.getText();
			}
			sleep(2000);
			UiDevice.getInstance().sleep();
			sleep(2000);

		}
			
		System.out.println(Arrays.asList(WallpaperName));
		boolean allsame = true;
		for(int i = 1; i < WallpaperName.length; ++i)
		{
			if(!WallpaperName[0].equals(WallpaperName[i]))
			{
				allsame = false;
				break;
			}
		}
		System.out.println(allsame);
		assertTrue(!allsame);
		sleep(1000);
		UiDevice.getInstance().sleep();
		sleep(2000);
		if(!UiDevice.getInstance().isScreenOn()){
			UiDevice.getInstance().wakeUp();
		}
		sleep(2000);
		UiAutomatorBase.MagaUnlock();
		
	}
	
	
	public void test5CheckforNewUI() throws UiObjectNotFoundException{
		UiObject Check = Settings.getChildByText(new UiSelector().className("android.widget.TextView"), "Check for new wallpapers");
		Check.click();
		
	}
	
	public void test5DailyUpdateUI() throws UiObjectNotFoundException{
		UiObject DailyUpdate = Settings.getChildByText(new UiSelector().className("android.widget.TextView"), "Enable daily wallpaper");
		DailyUpdate.click();
	}
	
	public void test6OnlyWiFiUpdateUI() throws UiObjectNotFoundException{
		UiObject WifiUpdata = Settings.getChildByText(new UiSelector().className("android.widget.TextView"),"Download only wifi");
		WifiUpdata.click();
	}
	
	public void test7CloseSysLock() throws UiObjectNotFoundException{
		UiObject CloseSysLock = Settings.getChildByText(new UiSelector().className("android.widget.TextView"),"Close system lockscreen");
		CloseSysLock.clickAndWaitForNewWindow();
		sleep(1000);
		UiDevice.getInstance().pressBack();
	}
	
	public void test8RemoveDoubleLock() throws UiObjectNotFoundException{
		UiObject Remove = Settings.getChildByText(new UiSelector().className("android.widget.TextView"),"Remove double lockscreen");
		Remove.clickAndWaitForNewWindow();
		sleep(3000);
		UiDevice.getInstance().pressBack();
	}
	
	public void test9EMUnlock() throws UiObjectNotFoundException{
		Settings.getChildByText(new UiSelector().className("android.widget.TextView"), "Emergency Unlock").click();
	}
	
	public static void main(String args[]){
		String jarName, testClass, testName, androidId;
		jarName = "MagazineHomePage";
		testClass = "com.vlife.qa.casedesign.tc.MagaLockHomePage";
		testName = "";
		androidId = "18";
		new UiAutomatorUtil(jarName, testClass, testName, androidId);
	}
	
	

}
