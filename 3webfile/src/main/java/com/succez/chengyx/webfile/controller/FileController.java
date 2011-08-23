package com.succez.chengyx.webfile.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.succez.chengyx.webfile.bean.FileInfo;
import com.succez.chengyx.webfile.service.imp.FileService;
import com.succez.chengyx.webfile.utils.FileUtil;

/**
 * 处理文本文件的显示，将文件内容放在一个div里面
 * 需要传给freemarker的数据有树形目录的信息，文件名和文件内容
 * @author 成亚雄
 *
 */
public class FileController implements Controller{

	/* 
	 * 
	 */
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<FileInfo> fileList=new ArrayList<FileInfo>();
		FileService fileService=new FileService();
//		fileList=new FileService().getAll();
		fileList=FileUtil.findAndSave();
		String path=request.getParameter("path");
		path=new String(path.getBytes("UTF-8"),"UTF-8");
//		FileInfo temp=fileService.query(name);
		String name=FileUtil.parseName(path);
		String content=FileUtil.readFile(path);
		String editContent=FileUtil.edit(content);
		@SuppressWarnings("rawtypes")
		Map root=new HashMap();
		root.put("list", fileList);
		root.put("filename", name);
		root.put("content", content);
		root.put("editContent", editContent);
		root.put("path", path);
		return new ModelAndView("index","root",root);
	}

}
