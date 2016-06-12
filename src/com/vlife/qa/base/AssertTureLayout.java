package com.vlife.qa.base;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class AssertTureLayout extends UiAutomatorTestCase {
	
	/**
	 * TraceLog快速标识
	 */
	public static void trace(String message){
		
		System.out.println("### " + message + " ###");
	}
	
	/**
	 * 判断测试完成后，某个view是否出现（view通过description检测）
	 */
	public static void assertViewTrue(String... descriptions) throws UiObjectNotFoundException{
		
		for(String description: descriptions){
			trace("Check if View with description: " + description + " is available?");
			UiObject view = new UiObject(new UiSelector().className(View.class.getName()).description(description));
			assertTrue("View with description: " + description + " is not available", view.exists());
		}
	}
	
	/**
	 * 判断测试完成后，某个TextView是否出现（view通过text检测）
	 */
	protected static void assertTextViewTrue(String... texts) throws UiObjectNotFoundException{
		
		for(String text: texts){
			trace("Check if TextView with text: " + text + " is available?");
			UiObject textView = new UiObject(new UiSelector().className(TextView.class.getName()).text(text));
			assertTrue("TextView with text: " + text + " is not available", textView.exists());
		}
	}
	
	/**
	 * 判断测试完成后，某个Image是否出现（通过description）
	 */
	protected void assertImageButtonTrue(String... descriptions) throws UiObjectNotFoundException{
		
		for(String description: descriptions){
			trace("Check if ImageButton with description: " + description + " is available?");
			UiObject view = new UiObject(new UiSelector().className(ImageButton.class.getName()).description(description));
			assertTrue("ImageButton with description: " + description + " is not available", view.exists());
		}
	}
}
