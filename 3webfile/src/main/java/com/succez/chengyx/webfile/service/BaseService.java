package com.succez.chengyx.webfile.service;

import java.util.List;

/**
 * service的顶层接口，提供基本的crud操作，遵从spring的面向接口编程的理念
 * @param <T>
 * @auhor 成亚雄
 * @param 
 *
 */
public interface BaseService<T> {

	abstract public  void  save(T t);
	abstract public  void delete(T t);
	abstract public  void update(T t );
	abstract public   T   query(String str);
	abstract public  List<T> getAll();
}
