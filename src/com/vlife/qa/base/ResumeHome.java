package com.vlife.qa.base;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class ResumeHome extends UiAutomatorTestCase {
	public void home ()
	{
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressBack();
		sleep(200);
		UiDevice.getInstance().pressHome();
		
	}

}
