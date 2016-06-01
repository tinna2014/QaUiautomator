package com.vlife.qa.ui;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class EditText extends UiAutomatorTestCase {
	
	
	public UiObject getEditTextByText(String text){
		return new UiObject(new UiSelector().text(text));
	}
	
	
	public void clearEditText(){
		
	}
	public void setText(){
		
	}
	
	
	

}
