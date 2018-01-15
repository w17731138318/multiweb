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
	
	UserEntity queryObject(Long id);
	
	List<UserEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(UserEntity user);
	
	void update(UserEntity user);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

	UserEntity queryObjectByTWO(Long id);
}
