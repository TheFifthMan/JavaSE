package com.ehi.FileTest;

import java.io.File;
import java.io.IOException;

public class FileDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 直接使用路径
		File file1 = new File("D:"+File.separator+"baiduife"+File.separator+"aaa.txt");
		System.out.println(file1);
		try{
			boolean f = file1.createNewFile();
			System.out.println(f);
		}catch(IOException e){
			
		}
		// 使用(parent,child)
		File parent = new File("D:");
		File file2 = new File(parent,"JavaSE"+File.separator+"a.txt");
		try{
			boolean f = file2.createNewFile();
			System.out.println(f);
		}catch(IOException e){
			
		}
		//使用file协议
		File file3 = new File("file://D://InstallSoftFolder//eclipse//test.txt");
	}

}
