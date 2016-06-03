package com.vlife.qa.casedesign.tc;

import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.vlife.qa.util.UiAutomatorUtil;

public class MonkeyTools extends UiAutomatorTestCase {
	public void testUnlock() throws RemoteException{
		UiDevice.getInstance().sleep();
		sleep(2000);
		if(!UiDevice.getInstance().isScreenOn()){
			UiDevice.getInstance().wakeUp();
		}
		sleep(2000);
		UiDevice.getInstance().swipe(600, 1300, 600, 550, 20);
		UiDevice.getInstance().swipe(600, 1300, 600, 550, 20);
		sleep(2000);
		UiDevice.getInstance().sleep();
		sleep(2000);
		if(!UiDevice.getInstance().isScreenOn()){
			UiDevice.getInstance().wakeUp();
		}		
	}
	
	public void testWakeup() throws RemoteException{
		for(int i = 1; i<10; i++){
			UiDevice.getInstance().sleep();
			sleep(2000);
			if(!UiDevice.getInstance().isScreenOn()){
				UiDevice.getInstance().wakeUp();
			}
			sleep(1000);
		}
	}
	
	public void testOpenNotification() throws RemoteException{
		for(int i = 1; i<10; i++){
			UiDevice.getInstance().openNotification();	
			UiDevice.getInstance().pressBack();
			sleep(1000);
		}
	}
	
	public static void main(String args[]){
		String jarName, testClass, testName, androidId;
		jarName = "monkeytools";
		testClass = "com.vlife.qa.casedesign.tc.MonkeyTools";
		testName = "";
		androidId = "18";
		new UiAutomatorUtil(jarName, testClass, testName, androidId);
	}

}
