package com.vlife.qa.logcat;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.vlife.qa.util.UiAutomatorUtil;


public class LogcatCase extends UiAutomatorTestCase{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new UiAutomatorUtil("Demo", "com.vlife.qa.logcat.LogcatCase", "testLog", "1");

	}
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		new Thread(new Logcat2DeviceThread()).start();
		
	}
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	public void testLog(){
		for(int i=0;i<30;i++){
			UiDevice.getInstance().pressMenu();
		}
		
	}
	

}
