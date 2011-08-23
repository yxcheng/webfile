package com.succez.chengyx.webfile.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.succez.chengyx.webfile.service.imp.FileService;
import com.succez.chengyx.webfile.utils.FileUtil;

/**
 * 将修改过的文件保存到原文件中
 * 执行的操作是根据判断请求决定是否保存文件然后跳到相应页面 
 * 不需要使用freemarker模板
 * @author 成亚雄
 *
 */
public class SaveController implements Controller {

	/* 
	 * 判断提交的按钮是保存还是取消，如果是保存将内容写入文件覆盖原有内容
	 * 如果是取消则直接跳到文件显示部分
	 */
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String name=request.getParameter("name");
//		name=new String(name.getBytes("ISO-8859-1"),"UTF-8");
		String path=request.getParameter("path");
		System.out.println(path);
		if(("保存").equals(request.getParameter("button"))){
			String content=request.getParameter("content");
//			String path=new FileService().query(name).getPath();
			FileUtil.saveFile(path,content);
		}
//		response.sendRedirect("showfile.do?name="+name);
		path=URLEncoder.encode(path);
		response.sendRedirect("showfile.do?path="+path);
		return null;
	}

}
