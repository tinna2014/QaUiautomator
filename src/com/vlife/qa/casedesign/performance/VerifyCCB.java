package com.vlife.qa.casedesign.performance;

import java.io.File;

import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.vlife.qa.util.UiAutomatorUtil;

public class VerifyCCB extends UiAutomatorTestCase {
	public void testCCB() throws RemoteException, UiObjectNotFoundException{
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressHome();
		
		UiDevice.getInstance().sleep();
		if(!UiDevice.getInstance().isScreenOn()){
			UiDevice.getInstance().wakeUp();
		}
		
		UiDevice.getInstance().swipe(100,1600, 600, 1600, 10);
		
		UiObject demo = new UiObject(new UiSelector().text("EngineActivityDemo"));
		demo.click();
		
		UiDevice.getInstance().sleep();
		if(!UiDevice.getInstance().isScreenOn()){
			UiDevice.getInstance().wakeUp();
		}
		
		UiObject buttonSwitch = new UiObject(new UiSelector().className("android.widget.ImageView"));
		for (int i=0;i<=6;i++){
			buttonSwitch.click();
			UiDevice.getInstance().takeScreenshot(new File("/sdcard/picture"+i+".png"));
		}
	}
	
	public static void main(String args[]){
		String jarName, testClass, testName, androidId;
		jarName = "ccb";
		testClass = "com.vilfe.qa.testcase.VerifyCCB";
		testName = "testCCB";
		androidId = "18";
		new UiAutomatorUtil(jarName, testClass, testName, androidId);
	}

}
