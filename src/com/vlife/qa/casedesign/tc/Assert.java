package com.vlife.qa.casedesign.tc;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.vlife.qa.util.TestCaseResult;
import com.vlife.qa.util.UiAutomatorUtil;




public class Assert extends TestCaseResult {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new UiAutomatorUtil("Assert", "com.vlife.qa.base.Assert", "testsam", "18");
		
	}
	public void testEquals(){
		
		assertEquals(5, add(2,3));
		
	}
	public void testEqualsDouble(){
		
		assertEquals(0.3333, Double.valueOf(1)/3, 0.0001);
	}
	public int add(int a,int b){
		return a+b;
	}
	public void testBoolean(){
		
		boolean is=false;
		assertTrue(is);
	}
	public void testSame(){
		int a=100;
		int b=100;
		Integer c=new Integer(100);
		
		//assertSame(a, b);
		//assertSame(a, c);
		assertEquals((Object)a, c);
		
		// ==   equals

	}
	public void testFail(){
		
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressMenu();
		UiDevice.getInstance().pressHome();
		fail("package name:"+UiDevice.getInstance().getCurrentPackageName());
		UiDevice.getInstance().pressBack();
		UiDevice.getInstance().pressMenu();
		UiDevice.getInstance().pressHome();
	}

}
