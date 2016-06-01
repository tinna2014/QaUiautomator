package com.vlife.qa.base;

import java.util.HashSet;
import java.util.Random;

import android.R.integer;
import android.widget.ListView;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.vlife.qa.util.UiAutomatorUtil;


public class Methor extends BaseCase{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new UiAutomatorUtil("Demo", "com.vlife.qa.base.Methor", "testListCount", "1");
	}
    @Override
    protected void setUp() throws Exception {
    	super.setUp();
    	//launchApp();
    	//launchCalculator();
    	launchApp("文件管理器");   	
    }
    @Override
    protected void tearDown() throws Exception {
    	super.tearDown();
    	exitApp();
    }
    public void testMethor() throws UiObjectNotFoundException{
    	openDial();
    	inputPhoneNum("112");
    	pressDial(true);
    	sleep(2000);
    	hangUp();   	
    }
    public void testRandom() throws UiObjectNotFoundException{
    	for(int i=0;i<5;i++){
    	double one=randomInputData();
    	int operation=getRandomOperation();
    	double two=randomInputData();
    	pressKeyboard("=");
    	double expected=calculator(one,operation,two);
    	assertEquals(expected, getActial(), 0.1);
    	}
    }
  public void testListCount() throws UiObjectNotFoundException{
	  int count=getListCount();
	  System.out.println("List Count:"+count);
  }
  
  public int getListCount() throws UiObjectNotFoundException{
	  HashSet<String> fileName=new HashSet<String>();
	  UiScrollable list=getScrollObjectByClass(ListView.class.getName());
	  UiSelector selector=new UiSelector().className("android.widget.LinearLayout");
	  list.scrollToBeginning(5);
	  boolean flag=false;
	  while(true){
		  int count=list.getChildCount(selector);
		  for(int i=0;i<count;i++){
			  String name=list.getChildByInstance(selector, i)
			  .getChild(new UiSelector().className("android.widget.TextView"))
			  .getText();
			  fileName.add(name);
		  }
		  if(flag){
			  break;
		  }
		  
		  if(!list.scrollForward(80)){
			  flag=true;
		  }
		  
		  
	  }
	  return fileName.size();
  }
  public UiScrollable getScrollObjectByClass(String className){
	  return new UiScrollable(new UiSelector().className(className));
  }
    
    
    
  

}
