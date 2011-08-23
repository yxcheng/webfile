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
 * 处理图片文件的显示
 * 需要传给freemarker的数据有树形目录的信息，图片名称以及图片路径
 * @author 成亚雄
 *
 */
public class ImgController implements Controller{

	/* 
	 * 
	 */
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<FileInfo> fileList=new ArrayList<FileInfo>();
		FileService fileService=new FileService();
		fileList=FileUtil.findAndSave();
//		fileList=new FileService().getAll();
		String path=request.getParameter("path");
//		String path=new FileService().query(name).getPath();
		String name=FileUtil.parseName(path);
//		String name=request.getParameter("name");
		String repath=FileUtil.getRePath(path);
		Map root=new HashMap();
		root.put("list", fileList);
		root.put("filename", name);
		root.put("img",repath);
		root.put("path",path);
		return new ModelAndView("index","root",root);
	}

}
