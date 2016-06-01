package com.vlife.qa.base;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.os.Build;
import android.os.Environment;
import android.widget.EditText;

import com.android.uiautomator.core.Configurator;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.vlife.qa.util.UiAutomatorUtil;



public class SystemInfo extends UiAutomatorTestCase {
     
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new UiAutomatorUtil("Demo", "com.vlife.qa.uiautomator.base.SystemInfo", "testGetProp", "1");
	
	}
	
	public void testBuild(){
		//BUILD
		System.out.println("BUILD:"+Build.BOARD);
		System.out.println("BUILD:"+Build.BOOTLOADER);
		System.out.println("BUILD:"+Build.BRAND);
		System.out.println("BUILD:"+Build.CPU_ABI);
		System.out.println("BUILD:"+Build.CPU_ABI2);
		System.out.println("BUILD:"+Build.DEVICE);
		System.out.println("BUILD:"+Build.DISPLAY);
		System.out.println("BUILD:"+Build.FINGERPRINT);
		System.out.println("BUILD:"+Build.HARDWARE);
		System.out.println("BUILD:"+Build.HOST);
		System.out.println("BUILD:"+Build.ID);
		System.out.println("BUILD:"+Build.MANUFACTURER);
		System.out.println("BUILD:"+Build.MODEL);
		System.out.println("BUILD:"+Build.PRODUCT);
		System.out.println("BUILD:"+Build.RADIO);
		System.out.println("BUILD:"+Build.SERIAL);
		System.out.println("BUILD:"+Build.TAGS);
		System.out.println("BUILD:"+Build.TIME);
		System.out.println("BUILD:"+Build.TYPE);
		System.out.println("BUILD:"+Build.USER);
		//BUILD.VERSION
		System.out.println("BUILD.VERSION:"+Build.VERSION.CODENAME);
		System.out.println("BUILD.VERSION:"+Build.VERSION.INCREMENTAL);
		System.out.println("BUILD.VERSION:"+Build.VERSION.RELEASE);
		System.out.println("BUILD.VERSION:"+Build.VERSION.SDK_INT);
		//BUILD,VERSION_CODE
		System.out.println("BUILD.VERSION_CODE:"+Build.VERSION_CODES.BASE);
		System.out.println("BUILD.VERSION_CODE:"+Build.VERSION_CODES.BASE_1_1);
		System.out.println("BUILD.VERSION_CODE:"+Build.VERSION_CODES.CUPCAKE);
		System.out.println("BUILD.VERSION_CODE:"+Build.VERSION_CODES.CUR_DEVELOPMENT);
		System.out.println("BUILD.VERSION_CODE:"+Build.VERSION_CODES.DONUT);
		System.out.println("BUILD.VERSION_CODE:"+Build.VERSION_CODES.ECLAIR);
		System.out.println("BUILD.VERSION_CODE:"+Build.VERSION_CODES.ECLAIR_0_1);
		System.out.println("BUILD.VERSION_CODE:"+Build.VERSION_CODES.ECLAIR_MR1);
		System.out.println("BUILD.VERSION_CODE:"+Build.VERSION_CODES.FROYO);
		System.out.println("BUILD.VERSION_CODE:"+Build.VERSION_CODES.GINGERBREAD);
		System.out.println("BUILD.VERSION_CODE:"+Build.VERSION_CODES.GINGERBREAD_MR1);
		System.out.println("BUILD.VERSION_CODE:"+Build.VERSION_CODES.HONEYCOMB);
		System.out.println("BUILD.VERSION_CODE:"+Build.VERSION_CODES.HONEYCOMB_MR1);
		System.out.println("BUILD.VERSION_CODE:"+Build.VERSION_CODES.HONEYCOMB_MR2);
		System.out.println("BUILD.VERSION_CODE:"+Build.VERSION_CODES.ICE_CREAM_SANDWICH);
		System.out.println("BUILD.VERSION_CODE:"+Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1);
		System.out.println("BUILD.VERSION_CODE:"+Build.VERSION_CODES.JELLY_BEAN);
		System.out.println("BUILD.VERSION_CODE:"+Build.VERSION_CODES.JELLY_BEAN_MR1);
		System.out.println("BUILD.VERSION_CODE:"+Build.VERSION_CODES.JELLY_BEAN_MR2);
		System.out.println("BUILD.VERSION_CODE:"+Build.VERSION_CODES.KITKAT);
		
	}
	
	public void testSDK() throws UiObjectNotFoundException{
		int sdk=Build.VERSION.SDK_INT;
		if(sdk>=18){
			Configurator.getInstance().setKeyInjectionDelay(1000);	
		}
		UiObject editText=new UiObject(new UiSelector().className(EditText.class.getName()));
		editText.setText("10086");
		
	}
	
	public void testEnv(){
		System.out.println(Environment.getDataDirectory());
		System.out.println(Environment.getDownloadCacheDirectory());
		System.out.println(Environment.getExternalStorageDirectory());
		System.out.println(Environment.getRootDirectory());
		
		//特定目录
		System.out.println("-------特定目录--------");
		System.out.println(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_ALARMS));
		System.out.println(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM));
		System.out.println(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS));
		System.out.println(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
		System.out.println(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES));
		System.out.println(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC));
		System.out.println(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_NOTIFICATIONS));
		System.out.println(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES));
		System.out.println(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PODCASTS));
		System.out.println(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES));
		
		//列出下载目录下的文件
		File downloadFile=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
		File[] file=downloadFile.listFiles();
		for(File f:file){
			System.out.println(f.getAbsolutePath());
		}
		
	}
	
	public void testGetProp(){
		System.out.println(getProp("ro.config.devicename"));
		System.out.println(getProp("ro.product.manufacturer"));
		System.out.println(getProp("ro.product.locale.language"));
		System.out.println(getProp("ro.product.board"));
		System.out.println(getProp("net.bt.name"));
		System.out.println(getProp("net.hostname"));
	}
	
	/**
	 * 需求：解析系统属性，传入KEY，返回VALUE
	 * @param key
	 * @return
	 */
	public String getProp(String key){
		try {
			Process p=Runtime.getRuntime().exec("getprop");
			InputStream in=p.getInputStream();
			InputStreamReader reader=new InputStreamReader(in);
			BufferedReader buff=new BufferedReader(reader);
			String line="";
			while((line=buff.readLine())!=null){
				//[ro.config.devicename]: [ZTE V5 Max]
				if(line.contains("["+key+"]")){
					String[] s=line.split("\\[");
                    
					return s[2].replaceAll("\\].*", "");
				}
			}
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return "未找到对应KEY!";
	}

}
