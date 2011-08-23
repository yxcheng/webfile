package com.succez.chengyx.webfile.controller;

import java.io.File;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 实现文件上传的控制器
 * @author 成亚雄
 *
 */
public class UploadController implements Controller {

	/* 
	 * 
	 */
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		MultipartHttpServletRequest multipartHttpservletRequest=(MultipartHttpServletRequest) request;  
		MultipartFile multipartFile = multipartHttpservletRequest.getFile("uploadFile");
		String name=multipartFile.getOriginalFilename();
		name=new String(name.getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(name);
		String path=request.getParameter("filepath");
		File source=new File("src/main/webapp/"+path+"/"+name);
		if(!source.exists())
			source.createNewFile();
		FileCopyUtils.copy(multipartFile.getBytes(),source);
		response.sendRedirect("hello.do");
		       return null;  
	 }  


}
