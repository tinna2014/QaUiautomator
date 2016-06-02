package com.vlife.qa.casedesign.performance;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.os.RemoteException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.vlife.qa.logcat.DumpMem2DeviceThread;
import com.vlife.qa.util.TestCaseResult;
import com.vlife.qa.util.UiAutomatorUtil;

public class MemoryLeak extends TestCaseResult {
	String dumpFile = "/Users/mac/Meminfo2.log";
	int n = 5;
	
	public static void main(String args[]){
		String jarName, testClass, testName, androidId;
		jarName = "MemoryLeak";
		testClass = "com.vlife.qa.casedesign.performance.MemoryLeak"; 
		testName = "testMemory";
		androidId = "18";
		
		new UiAutomatorUtil(jarName, testClass, testName, androidId);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
//		new Thread(new Logcat2DeviceThread()).start();
		
	}

	
	public void testUnlock() throws RemoteException{
		UiDevice.getInstance().sleep();
		sleep(2000);
		if(!UiDevice.getInstance().isScreenOn()){
			UiDevice.getInstance().wakeUp();	
		}
		sleep(2000);		
		UiDevice.getInstance().swipe(360, 1200, 360, 500, 20);
		UiDevice.getInstance().swipe(360, 1200, 360, 500, 20);
		sleep(2000);
		
//		
//		System.out.println("----启动adb调用dumpsys---- ");
//		String dumpCmd = "/Applications/Android/sdk/platform-tools/adb shell" + " dumpsys meminfo > " + dumpFile;
//		System.out.println("----dump内存堆栈中...----" + dumpCmd);
//		execCmd(dumpCmd);
		
		
	}
	
	public void tesetUnlock() throws RemoteException{
		
		if(!UiDevice.getInstance().isScreenOn()){
			UiDevice.getInstance().wakeUp();
		}
		
		
	}
	

	public void testMemory() throws RemoteException{
	    for (int i=1; i<=n; i++)
	    {
	    	testUnlock();
			UiDevice.getInstance().takeScreenshot(new File("/sdcard/snap"+i+".png"));
			sleep(2000);
			new Thread(new DumpMem2DeviceThread()).start();

	    }
	    return;
	}
	
	
	public void execCmd(String cmd) {
		System.out.println("----execCmd:  " + cmd);
		try {
			Process p = Runtime.getRuntime().exec(cmd);
			//正确输出流
			InputStream input = p.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					input));
			String line = "";
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
                saveToFile(line, "runlog.log", false);
			}
			//错误输出流
			InputStream errorInput = p.getErrorStream();
			BufferedReader errorReader = new BufferedReader(new InputStreamReader(
					errorInput));
			String eline = "";
			while ((eline = errorReader.readLine()) != null) {
				System.out.println(eline);
                saveToFile(eline, "runlog.log", false);
			}       
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
    public void saveToFile(String text,String path,boolean isClose) {
    	File file=new File("runlog.log");   	
		BufferedWriter bf=null;
		try {
		    FileOutputStream outputStream=new FileOutputStream(file,true);
		    OutputStreamWriter outWriter=new OutputStreamWriter(outputStream);
		    bf=new BufferedWriter(outWriter);
			bf.append(text);
			bf.newLine();
			bf.flush();
			
			if(isClose){
				bf.close();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
