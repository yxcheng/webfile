package com.succez.chengyx.webfile.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.succez.chengyx.webfile.bean.FileInfo;

/**
 * 这个类用来遍历文件目录将其信息填到数据库中
 * 此外也提供文件读取等功能
 * @author 成亚雄
 *
 */
public class FileUtil {
	/*
	 * 用来给文件编号
	 */
	static int id=1;
	
	/*
	 * 用来存放遍历的文件夹或文件信息
	 */
	static List<FileInfo> fileList=new ArrayList<FileInfo>();
	
	/*
	 * 根目录
	 */
	static String rootpath="src/main/webapp/resources";
	
	/**
	 * 遍历根目录，并将信息保存在一个List中并保存
	 * @return 
	 */
	public static List<FileInfo> findAndSave(){
		File root=new File(rootpath);
		id=1;
		fileList.clear();
		find(root,0);
		return fileList;
	}
	
	/**
	 * 递归遍历根目录，并将信息保存至数据库
	 */
	public static void find(File f,int pid){
		if(f==null)
			return ;
		if(f.isFile()){
			add(f,pid,1);
			return;
		}
		if(f.isDirectory()){
			int temppid=add(f,pid,0);
			File[] files=f.listFiles();
			for(File file:files)
				find(file,temppid);
		}
	}
	
	/*
	 *将File对象映射到FileInfo对象并加入List 
	 *并根据flag来决定是否添加url信息，如果是文件夹就不填
	 *是文件就要填
	 */
	public static int add(File f,int pid,int flag){
		FileInfo temp=new FileInfo();
		temp.setId(id++);
		temp.setPid(pid);
		temp.setFilename(f.getName());
        String path=f.getPath();
        path=path.replaceAll("\\\\","/");
		temp.setPath(path);
		if(flag==1){
			if(isImg(f.getName())){
//				temp.setUrl("showimg.do?name="+f.getName());
			    temp.setUrl("showimg.do?path="+path);
			    temp.setIcon("img/pic.gif");
			}

			else if(isText(f.getName())){
				temp.setUrl("showfile.do?path="+path);
				temp.setIcon("img/"+
						f.getName().substring(f.getName().lastIndexOf('.')+1)
						+".gif");
//				temp.setUrl("showfile.do?name="+f.getName());
			}
			else
				temp.setUrl("download.do?path="+path);
		}
		else temp.setIcon("img/folder.gif");	
		fileList.add(temp);
		return temp.getId();
	}
	
	/*
	 * 判断文件是不是图片
	 */
	public static boolean isImg(String name){
		if(name.endsWith(".jpg")||
		   name.endsWith(".png")||
		   name.endsWith(".gif")||
			name.endsWith(".bmp"))
		return true;
		return false;
	}
	
	/*
	 * 判断是不是文本文件，判断条件需要根据需要更新
	 */
	public static boolean isText(String name){
		if(name.endsWith(".txt")||
		   name.endsWith(".html")||
		   name.endsWith(".java")||
		   name.endsWith(".cpp")||
           name.endsWith(".c"))
		return true;
		return false;
	}
	/*
	 * 根据路径寻找文件并读取其中内容返回，针对文本文件，返回内容用于显示在html页面中
	 */
	public static String readFile(String path){
		File file=new File(path);
		if(file==null)
			return null;
		StringBuilder content=new StringBuilder();
		BufferedReader reader=null;
		try {
			reader=new BufferedReader(new FileReader(file));
			String line=reader.readLine();
			while(line!=null){
				line=escape(line);
				content.append(line).append("<br>").append("");
				line=reader.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return content.toString();
	}
	/**
	 *将通过readFile方法所得到的信息编辑一下
	 *变成纯文本的内容，用于编辑和保存
	 *
	 */
	public static String edit(String content ) {
		content=content.replaceAll("<p>", "");
		content=content.replaceAll("<br>", "\r\n");
		return content;
	}

	/**
	 * 对字符进行转义，针对html文件等
	 */
	public static String escape(String str){
    	str=str.replaceAll("<", "&lt;");
    	str=str.replaceAll(">", "&gt;");
    	str=str.replaceAll("\"", "&quot;");
    	return str;
    }
	
	/**
	 * 根据path找到文件并用content覆盖原有内容
	 * @param name
	 * @param content
	 */
	public static void saveFile(String path, String content) {
		File file=new File(path);
		if(file==null)
			return ;
		BufferedWriter writer=null;
		try {
			writer=new BufferedWriter(new FileWriter(file));
			writer.write(content, 0, content.length());
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * 根据完全路径寻找相对路径，因为在项目文件夹里面根目录从src开始
	 * 而在前台根目录从webapp开始，因此需要做一些转换
	 * @param path
	 * @return
	 */
	public static String getRePath(String path) {
		return path.substring(path.indexOf("resources"));
	}

	/**
	 * 根据路径解析出文件名
	 */
	public static String parseName(String path) {
		return path.substring(path.lastIndexOf('/')+1);
	}
	


	
}
