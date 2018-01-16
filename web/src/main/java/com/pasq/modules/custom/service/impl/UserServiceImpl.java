package com.pasq.modules.custom.service.impl;

import com.pasq.datasources.DataSourceName;
import com.pasq.datasources.annotation.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.pasq.modules.custom.dao.UserDao;
import com.pasq.modules.custom.entity.UserEntity;
import com.pasq.modules.custom.service.UserService;

/**
 *
 * @author 王伟鑫
 * @version 0.1v
 * @create 2018/1/16 13:46
 * @see
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Override
	@Cacheable(value = "userentity",key = "#root.caches[0].name + ':'+#p0")
	public UserEntity queryObject(Long id){
		return userDao.queryObject(id);
	}
	@Override
	@DataSource(name = DataSourceName.TWO)
	public UserEntity queryObjectByTWO(Long id){
		return userDao.queryObject(id);
	}
	@Override
	public List<UserEntity> queryList(Map<String, Object> map){
		return userDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return userDao.queryTotal(map);
	}
	
	@Override
	@CachePut(value = "userentity",key = "#root.caches[0].name + ':'+#p0.id")
	public void save(UserEntity user){
		userDao.save(user);
	}
	
	@Override
	@CachePut(value = "userentity",key = "#root.caches[0].name + ':'+#p0.id")
	public void update(UserEntity user){
		userDao.update(user);
	}
	
	@Override
	@CacheEvict(value = "userentity",key = "#root.caches[0].name + ':'+#p0")
	public void delete(Long id){
		userDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		userDao.deleteBatch(ids);
	}
	
}
