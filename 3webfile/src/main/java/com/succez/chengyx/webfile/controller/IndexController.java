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
 * 这个控制器负责主页面模板的生成
 * 需要传给freemarker的数据有树形目录的信息以及预定义好的一张图片的路径
 * @author 成亚雄
 *
 */
public class IndexController implements Controller{

	/* 
	 * 处理方法
	 */
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		List<FileInfo> fileList=new ArrayList<FileInfo>();
//		fileList=new FileService().getAll();
		fileList=FileUtil.findAndSave();
		@SuppressWarnings("rawtypes")
		Map root=new HashMap();
		root.put("list", fileList);
//		root.put("filename", null);
//		return new ModelAndView("index","treeList",fileList);
		return new ModelAndView("index","root",root);
	}

}
