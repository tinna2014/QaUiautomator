package com.vlife.qa.logcat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Logcat2DeviceThread implements Runnable{
	public BufferedWriter bW=null;
	private String pathDir="/mnt/sdcard/testtest";
	private String path="";
	@Override
	public void run() {
		path=pathDir+File.separator+"meminfo2.txt";
		try {
			Runtime.getRuntime().exec("logcat -c");
			Runtime.getRuntime().exec("mkdir "+pathDir);
			Runtime.getRuntime().exec("touch "+path);
			
			Process process=Runtime.getRuntime().exec("dumpsys meminfo");
//			Process process2=Runtime.getRuntime().exec("dumpsys meminfo");
			InputStream inputStream=process.getInputStream();
			InputStreamReader in=new InputStreamReader(inputStream);
			BufferedReader reader=new BufferedReader(in);
			String line="";
			while((line=reader.readLine())!=null){
				System.out.println(line);
				saveFile(line, path);
			}
			
		} catch (Exception e) {
		}
		
	}
	
	public BufferedWriter saveFile(String line,String path) {
	
		File file=new File(path);
		try {
			FileOutputStream stream=new FileOutputStream(file,true);
			OutputStreamWriter out=new OutputStreamWriter(stream);
			bW=new BufferedWriter(out);
			bW.append(line);
			bW.newLine();
			bW.flush();
			
		} catch (Exception e) {
		}
		
		
		return bW;
	}

}
