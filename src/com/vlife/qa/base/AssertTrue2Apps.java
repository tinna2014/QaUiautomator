package com.vlife.qa.base;

import android.os.Build;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class AssertTrue2Apps extends UiAutomatorTestCase {

	static String BrowserPackageName=UiDevice.getInstance().getCurrentPackageName();
	static String SettingPackageName=UiDevice.getInstance().getCurrentPackageName();
	static String DialerPackageName=UiDevice.getInstance().getCurrentPackageName();
	static String CameraPackageName=UiDevice.getInstance().getCurrentPackageName();

	
	public static boolean OpenBrowser(){
		if(Build.BRAND.contains("vivo")){
			assertEquals("JumpToBrowser", "com.vivo.browser", BrowserPackageName);
			
		} else if (Build.BRAND.contains("ZTE")){
			assertEquals("JumpToBrowser", "com.android.browser", BrowserPackageName);
			
		} else{
			assertEquals("JumpToBrowser", "com.android.browser", BrowserPackageName);
		
		}		
		return false;
	}
	
	public static boolean OpenSettings(){
		if(Build.BRAND.contains("vivo")){
			assertEquals("JumpToSettingss", "com.android.settings", SettingPackageName);
			
		} else if (Build.BRAND.contains("ZTE")){
			assertEquals("JumpToSettingss", "com.android.settings", SettingPackageName);
			
		} else{
			assertEquals("JumpToSettingss", "com.android.settings", SettingPackageName);
		
		}
		return false;
	}
	
	public static boolean OpenDialer(){
		if(Build.BRAND.contains("vivo")){
			assertEquals("JumpToDialer", "com.android.dialer", DialerPackageName);
			
		} else if (Build.BRAND.contains("ZTE")){
			assertEquals("JumpToDialer", "com.android.contacts", DialerPackageName);
			
		} else{
			assertEquals("JumpToDialer", "com.android.dialer", DialerPackageName);
		
		}
		return false;
	}
	
	public static boolean OpenCamera(){
		if(Build.BRAND.contains("vivo")){
			assertEquals("JumpToCamera", "com.android.contacts", CameraPackageName);
			
		} else if (Build.BRAND.contains("ZTE")){
			assertEquals("JumpToCamera", "com.android.contacts", CameraPackageName);
			
		} else{
			assertEquals("JumpToCamera", "com.android.contacts", CameraPackageName);
		
		}
		return false;
	}
	
}
