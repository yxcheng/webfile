package com.succez.chengyx.webfile.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.succez.chengyx.webfile.service.imp.FileService;
import com.succez.chengyx.webfile.utils.FileUtil;

/**
 * 处理文件编辑的控制器
 * 需要传给freemarker模板的数据是文件名和文件内容
 * @author 成亚雄
 *
 */
public class EditController implements Controller{

	/* 
	 * 
	 */
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String name=request.getParameter("name");
//		String content=FileUtil.readFile(new FileService().query(name).getPath());
		String content=request.getParameter("editContent");
		String path=request.getParameter("path");
//		content=FileUtil.edit(content);
		Map root=new HashMap();
		root.put("path", path);
		root.put("filename", name);
		root.put("content", content);
		return new ModelAndView("edit","root",root);
		
	}

}
