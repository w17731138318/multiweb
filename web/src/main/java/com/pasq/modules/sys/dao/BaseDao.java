package com.pasq.modules.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 基础Dao(还需在XML文件里，有对应的SQL语句)
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:31:36
 */
public interface BaseDao<T> {
	/**
	 * save
	 * @param t
	 */
	void save(T t);

	/**
	 * save
	 * @param map
	 */
	void save(Map<String, Object> map);

	/**
	 * saveBatch
	 * @param list
	 */
	void saveBatch(List<T> list);

	/**
	 * update
	 * @param t
	 * @return
	 */
	int update(T t);

	/**
	 * update
	 * @param map
	 * @return
	 */
	int update(Map<String, Object> map);

	/**
	 * delete
	 * @param id
	 * @return
	 */
	int delete(Object id);

	/**
	 * delete
	 * @param map
	 * @return
	 */
	int delete(Map<String, Object> map);

	/**
	 * deleteBatch
	 * @param id
	 * @return
	 */
	int deleteBatch(Object[] id);

	/**
	 * queryObject
	 * @param id
	 * @return
	 */
	T queryObject(Object id);

	/**
	 * queryList
	 * @param map
	 * @return
	 */
	List<T> queryList(Map<String, Object> map);

	/**
	 * queryTotal
	 * @param map
	 * @return
	 */
	int queryTotal(Map<String, Object> map);

	/**
	 * queryTotal
	 * @return
	 */
	int queryTotal();
}
