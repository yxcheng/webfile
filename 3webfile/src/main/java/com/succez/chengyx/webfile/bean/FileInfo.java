package com.succez.chengyx.webfile.bean;

/**
 * 这个类用来描述文件层次结构，是一个javabean。
 * 其成员变量与前端dtree的变量相对应，供前台js读取动态生成树形目录
 * @author 成亚雄
 *
 */
public class FileInfo {
    /*
     * 文件编号
     */
	int id;
	
	/*
	 * 文件名
	 */
	String filename;
	
	/*
	 * 父文件夹编号
	 */
	int pid;
	
	/*
	 * 该文件在dtree中所对应的url
	 */
	String url;
	
	/*
	 * 图标
	 */
    String icon;
    
	/*
	 * 文件的存放路径
	 */
	String path;
	
	
	/**
	 * setter和getter
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * 无参构造方法
	 */
	public FileInfo() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	
	
}
