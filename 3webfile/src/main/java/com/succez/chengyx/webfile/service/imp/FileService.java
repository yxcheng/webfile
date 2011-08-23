package com.succez.chengyx.webfile.service.imp;

import java.util.List;

import org.hibernate.Session;

import com.succez.chengyx.webfile.bean.FileInfo;
import com.succez.chengyx.webfile.service.BaseService;
import com.succez.chengyx.webfile.utils.HibernateUtil;

/**
 * 针对FileInfo类的服务类，实现crud等方法
 * @author 成亚雄
 *
 */
public class FileService implements BaseService<FileInfo>  {

	/* 
	 * 增加操作
	 */
	public void save(FileInfo file) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(file);
        session.getTransaction().commit();

		
	}

	/* 
	 * 
	 */
	public void delete(FileInfo t) {
		// TODO Auto-generated method stub
		
	}

	/* 
	 * 
	 */
	public void update(FileInfo t) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(t);
        session.getTransaction().commit();
	}

	/* 
	 * 
	 */
	public FileInfo query(String name) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<FileInfo> fileList=session.createQuery
        		("select file from FileInfo as file where file.filename="+"'"+name+"'").list();
        return fileList.get(0);
		
	}
	/* 
	 * 
	 */
	public List<FileInfo> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<FileInfo> fileList=session.createQuery("select file from FileInfo as file").list();
        return fileList;
	}









}
