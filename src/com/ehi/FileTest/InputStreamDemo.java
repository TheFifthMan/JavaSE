package com.ehi.FileTest;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringBufferInputStream;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 读取文件内容到流
 * 
 * */
public class InputStreamDemo {
	private static File file = new File("."+File.separator+"resources"+File.separator+"test.txt");
	public static void readFromFile(){
		try{
			//相应的管道流
			InputStream input = new FileInputStream(file);
			Long fileLength = file.length();
			//载体
			byte[] b = new byte[fileLength.intValue()];
			//文件输出到这个载体中
			input.read(b);
			//将这个数组转换为数组
			System.out.println(new String(b));
			input.close();
		}catch(FileNotFoundException e){
			System.out.println(e.getStackTrace());
		}catch(IOException e){
			System.out.println(e.getStackTrace());
		}
	}
	//FileInputStream类和FileOutputStream类
	public static void writeToFile() throws Exception{
		File file2 = new File("."+File.separator+"resources"+File.separator+"test2.txt");
		file2.createNewFile();
		InputStream input = new FileInputStream(file);
		OutputStream out = new FileOutputStream(file2);
		byte[] b = new byte[1024];
		while(input.read(b)!=-1){
			out.write(b);
		}
		System.out.println(new String(b));
		input.close();
		out.close();
	}
	//保存图片
	public static void writeToImages() throws Exception{
		//new一个URL对象  
	    URL url = new URL("http://www.51gjie.com/Images/image1/lkqixikw.lqs.jpg");
	    //打开链接  
	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	    //设置请求方式为"GET"  
	    conn.setRequestMethod("GET");
	    //超时响应时间为5秒  
	    conn.setConnectTimeout(5 * 1000);
	    //通过输入流获取图片数据  
	    InputStream inStream = conn.getInputStream();
	    //得到图片的二进制数据，以二进制封装得到数据，具有通用性  
	    byte[] data = readInputStream(inStream);
	    OutputStream imageFile = new FileOutputStream("."+File.separator+"resources"+File.separator+"example.jpg");
	    imageFile.write(data);
	    imageFile.close();
	}
	//封装函数
	private static byte[] readInputStream(InputStream inStream) throws IOException {
		// TODO Auto-generated method stub
		ByteArrayOutputStream out = new ByteArrayOutputStream();
	    byte[] buffer = new byte[1024];
	    int len = 0;
		while((len = inStream.read(buffer))!=-1){
	    	out.write(buffer, 0, len);
	    };
	    inStream.close();
	    out.close();
	    return out.toByteArray();

	}
	//BufferedInputStream 
	public static void readBufferedStream() throws Exception{
		InputStream in = new FileInputStream(file);
		StringBuffer bi = new StringBuffer();
		
	}
	
	
	//Writer 和Reader 类
	public static void WriteToFile2() throws Exception{
		File file3 = new File("."+File.separator+"resources"+File.separator+"test3.txt");
		file3.createNewFile();
		Writer wr = null;
		//标识可以追加内容
		wr = new FileWriter(file3,true);
		wr.write("Hello World test3 >> file3 ");
		
		// 打开test.txt，读取内容写入
		Reader rd = new FileReader(file);
		
		while(rd.read()!=-1){
			
		}
		wr.close();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//writeToFile();
			readBufferedStream();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
