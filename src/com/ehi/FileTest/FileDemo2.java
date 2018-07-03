package com.ehi.FileTest;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 几个概念
 * 1. File的直接父类是Object
 * 2. 一个File对象就是表示磁盘上的目录或者文件
 * 3. File类可以做到跨平台，因此使用File.separator做为分隔符
 * 4. File直接处理文件和文件系统
 * 5. File描述了文件本身的属性
 * 6. File对象用于获取磁盘文件的相关性
 * 7. File对像用于浏览目录层次的结构
 * 8. File对象没有指定如何读取或者写入文件
 * */
class FileNameFilter implements FilenameFilter{
    @Override
    public boolean accept(File dir, String name) {
        //这里可以配置一个正则
        return name.endsWith(".java");
    }


}
public class FileDemo2 {
    public static void main(String args[]){
        //代表当前路径目录
        File file= new File(".");
        File[] files = file.listFiles();
        //列举当前文件夹下面的文件和文件夹
        for(File f:files){
            //System.out.println(f.getName());
        }
        //过滤文件
        File[] files2 = file.listFiles(new FileNameFilter());
        for(File f:files2){
            if(f.isDirectory()){
                f.listFiles(new FileNameFilter());
            }
            System.out.println("files2:"+f.getName());
        }

    }
}
