package com.example.DownloadUtility;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 *  DownloadUtility
 */
public class RunTestOne extends Thread {
	
	HttpClient client = null;
	PostMethod method = null;
	
	public void run() {
	
		long startTime = System.currentTimeMillis();
		String runTestCode = "160809_3S_4";
		
		try{

			String fileURL = "https://wpt.appedo.com/export.php?bodies=1&pretty=1&test="+runTestCode;
			//String saveDir = "http://localhost:8082/DownloadUtility/ReceiveFileServlet";
			String saveDir = "/home/prakash";
			HttpDownloadUtility.downloadFile(fileURL, saveDir);
		}catch(Exception e){
			System.out.println(""+e);
		}finally{
			System.out.println((System.currentTimeMillis()-startTime)+"ms");
		}
		
	}
	public static void main(String args[]){
		new RunTestOne().start();
	}
}