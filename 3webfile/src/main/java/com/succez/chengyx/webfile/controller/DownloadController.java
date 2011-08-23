package com.succez.chengyx.webfile.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.succez.chengyx.webfile.utils.FileUtil;

/**
 * 负责下载的控制器
 * @author 成亚雄
 *
 */

public class DownloadController implements Controller {

	/*@RequestMapping("download.do")
	public void downloadFile(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
        String fileName=request.getParameter("name");
        String path=request.getParameter("path");
		response.setHeader("Content-Disposition", "attachment;fileName="
				+ fileName);
		InputStream inputStream=null;
		try {
			File file = new File(path);
			System.out.println(path);
			inputStream = new FileInputStream(file);
			OutputStream os = response.getOutputStream();
			byte[] b = new byte[1024];
			int length;
			while ((length = inputStream.read(b)) > 0) {
				os.write(b, 0, length);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				inputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}*/

	/* 
	 * 
	 */
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
        String fileName=request.getParameter("name");
        String path=request.getParameter("path");
        if(fileName==null)
        	fileName=FileUtil.parseName(path);
		response.setHeader("Content-Disposition", "attachment;fileName="
				+ fileName);
		InputStream inputStream=null;
		try {
			File file = new File(path);
//			System.out.println(path);
			inputStream = new FileInputStream(file);
			OutputStream os = response.getOutputStream();
			byte[] b = new byte[1024];
			int length;
			while ((length = inputStream.read(b)) > 0) {
				os.write(b, 0, length);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				inputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
} 

