package com.vlife.qa.ServerSocket;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	   int port=9998;
	   try {
		final ServerSocket server=new ServerSocket(port);
		System.out.println("The server is running...");
		System.out.println(server);
		
		while(true){
			final Socket socket=server.accept();
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					Reader reader;
					try {
						reader=new InputStreamReader(socket.getInputStream());
						char[] chars=new char[64];
						int len;
						StringBuilder sb=new StringBuilder();
						while((len=reader.read(chars))!=-1){
							sb.append(new String(chars,0,len));
						}
						System.out.println("From client:"+sb);
						
					} catch (Exception e) {
					}
					
				}
			}).start();
			
		}
		
		
		
		
		
		
		
	} catch (IOException e) {		
		e.printStackTrace();
	}

	}

}
