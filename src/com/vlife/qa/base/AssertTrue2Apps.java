package com.vlife.qa.base;

import android.os.Build;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class AssertTrue2Apps extends UiAutomatorTestCase {
	
	public static boolean OpenBrowser(){
		
		String PackageName=UiDevice.getInstance().getCurrentPackageName();

		if(Build.BRAND.contains("vivo")){
			assertEquals("JumpToBrowser", "com.vivo.browser", PackageName);
			
		} else if (Build.BRAND.contains("ZTE")){
			assertEquals("JumpToBrowser", "com.android.browser", PackageName);
			
		} else{
			assertEquals("JumpToBrowser", "com.android.browser", PackageName);
		
		}		
		return false;
	}
	
	public static boolean OpenSettings(){
		
		String PackageName=UiDevice.getInstance().getCurrentPackageName();
		
		if(Build.BRAND.contains("vivo")){
			assertEquals("JumpToSettingss", "com.android.settings", PackageName);
			
		} else if (Build.BRAND.contains("ZTE")){
			assertEquals("JumpToSettingss", "com.android.settings", PackageName);
			
		} else{
			assertEquals("JumpToSettingss", "com.android.settings", PackageName);
		
		}
		return false;
	}
	
	public static boolean OpenDialer(){
		
		String PackageName=UiDevice.getInstance().getCurrentPackageName();

		if(Build.BRAND.contains("vivo")){
			assertEquals("JumpToDialer", "com.android.dialer", PackageName);
			
		} else if (Build.BRAND.contains("ZTE")){
			assertEquals("JumpToDialer", "com.android.contacts", PackageName);
			
		} else if (Build.BRAND.contains("HUAWEI")){
			assertEquals("JumpToDialer", "com.android.contacts", PackageName);
		
		} else{
			assertEquals("JumpToDialer", "com.android.contacts", PackageName);
		
		}
		return false;
	}
	
	public static boolean OpenCamera(){
		
		String PackageName=UiDevice.getInstance().getCurrentPackageName();
		
		if(Build.BRAND.contains("vivo")){
			assertEquals("JumpToCamera", "com.android.camera", PackageName);
			
		} else if (Build.BRAND.contains("ZTE")){
			assertEquals("JumpToCamera", "com.android.camera", PackageName);
			
		} else if (Build.BRAND.contains("HUAWEI")){
			assertEquals("JumpToDialer", "com.huawei.camera", PackageName);
		
		} else{
			assertEquals("JumpToCamera", "com.android.camera", PackageName);
		
		}
		return false;
	}
	
}
