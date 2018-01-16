package com.pasq.modules.custom.service;

import com.pasq.modules.custom.entity.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author 王伟鑫
 * @version 0.1v
 * @email wangweixin@pasq.com
 * @create 2018-01-02 11:08:54
 */
public interface UserService {
	/**
	 * queryObject
	 * @param id
	 * @return
	 */
	UserEntity queryObject(Long id);

	/**
	 * queryList
	 * @param map
	 * @return
	 */
	List<UserEntity> queryList(Map<String, Object> map);

	/**
	 * queryTotal
	 * @param map
	 * @return
	 */
	int queryTotal(Map<String, Object> map);

	/**
	 * save
	 * @param user
	 */
	void save(UserEntity user);

	/**
	 * update
	 * @param user
	 */
	void update(UserEntity user);

	/**
	 * delete
	 * @param id
	 */
	void delete(Long id);

	/**
	 * deleteBatch
	 * @param ids
	 */
	void deleteBatch(Long[] ids);

	/**
	 * queryObjectByTWO
	 * @param id
	 * @return
	 */
	UserEntity queryObjectByTWO(Long id);
}
