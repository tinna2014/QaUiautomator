package com.vlife.qa.ServerSocket;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

import android.R.integer;

import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.vlife.qa.util.UiAutomatorUtil;

public class SocketCase extends UiAutomatorTestCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new UiAutomatorUtil("Demo", "com.vlife.qa.socket.SocketCase", "testSocket", "1");

	}
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
	}
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}
	public void testSocket(){
		String className=getClass().toString();
		String testName=getName().toString();
		String flag="mms test";
		String mms=className+","+testName+","+flag;
		for(int i=0;i<10;i++){
			sendMMSSocket(i+"***"+mms, "192.168.1.104", 9998);
		}
		
		
	}
	public void sendMMSSocket(String mms,String host,int port){
		Socket client;
		try {
			client=new Socket(host,port);
			
			Writer writer=new OutputStreamWriter(client.getOutputStream());
			writer.write(mms);
			writer.flush();
			writer.close();
			client.close();
			
		} catch (Exception e) {
		}
	}

}
