package com.succez.chengyx.webfile.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import com.succez.chengyx.webfile.bean.FileInfo;
import com.succez.chengyx.webfile.controller.EditController;
import com.succez.chengyx.webfile.service.imp.FileService;
import com.succez.chengyx.webfile.utils.FileUtil;

/**
 * @author Administrator
 *
 */
public class DBTest {

	public static void main(String[] args) {
/*		FileService fileService=new FileService();
		FileInfo file=fileService.query("hello.txt");
		String content=FileUtil.readFile(file.getPath());
		System.out.println(content);*/
		
		/*System.out.println(file.getPath());
		System.out.println(FileUtil.getRePath(file.getPath()));*/
        
/*        File file=new File("src/main/webapp/resources/text/新.txt");
        if(!file.exists())
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
        FileUtil.saveFile("src/main/webapp/resources/text/新建文档.txt", "怎么找不到文件呢");
//		str=str.replaceAll("\\", "/");
//		System.out.println(str);

		

	}
    public String escape(String str){
    	str=str.replaceAll("<", "&lt;");
    	return str;
    }

	}



