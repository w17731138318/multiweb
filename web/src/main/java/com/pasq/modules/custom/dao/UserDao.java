package com.pasq.modules.custom.dao;

import com.pasq.modules.custom.entity.UserEntity;
import com.pasq.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author 王伟鑫
 * @version 0.1v
 * @email wangweixin@pasq.com
 * @create 2018-01-02 11:08:54
 */
@Mapper
public interface UserDao extends BaseDao<UserEntity> {
	
}
