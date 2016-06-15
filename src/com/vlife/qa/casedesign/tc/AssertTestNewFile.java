package com.vlife.qa.casedesign.tc;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.vlife.qa.util.TestCaseResult;
import com.vlife.qa.util.UiAutomatorUtil;

public class AssertTestNewFile extends TestCaseResult{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new UiAutomatorUtil("AssertFile", "com.vlife.qa.base.AssertTestNewFile", "testNewFile", "18");
	}
	
	@Override
	protected void setUp() throws Exception {
		
		super.setUp();
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressHome();
		
		UiObject app=new UiObject(new UiSelector().description("应用"));
		UiObject file=new UiObject(new UiSelector().text("文件管理器"));
		
		app.clickAndWaitForNewWindow();
		file.clickAndWaitForNewWindow();
		//assert
		String packageName=UiDevice.getInstance().getCurrentPackageName();
		assertEquals("filebrowser","com.cyanogenmod.filemanager", packageName);

	}
	
	public void testNewFile() throws UiObjectNotFoundException{
		UiObject testDirName=new UiObject(new UiSelector().text("test"));
		UiScrollable listView=new UiScrollable(new UiSelector().className("android.widget.ListView"));
		UiObject dos=new UiObject(new UiSelector().description("操作"));
		UiObject newDirName=new UiObject(new UiSelector().text("新建文件夹"));
		UiObject editDirName=new UiObject(new UiSelector().classNameMatches(".*EditText"));
		UiObject okBtn=new UiObject(new UiSelector().text("确定"));
		boolean find=listView.scrollIntoView(testDirName);
		if(find){
			fail("test目录已经存在！");
		}
		dos.click();
		newDirName.click();
		editDirName.setText("test");
		okBtn.click();
		boolean findLast=listView.scrollIntoView(testDirName);
		assertTrue(findLast);
		
		
		
	}
	@Override
	protected void tearDown() throws Exception {		
		super.tearDown();
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressHome();
	}
	
	

}
