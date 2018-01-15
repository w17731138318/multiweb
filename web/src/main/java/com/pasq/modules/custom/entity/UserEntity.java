package com.pasq.modules.custom.entity;

import java.io.Serializable;
import java.util.Date;
import com.pasq.common.utils.ToStringUtils;



/**
 * 
 * @author 王伟鑫
 * @version 0.1v
 * @email wangweixin@pasq.com
 * @create 2018-01-02 11:08:54
 */
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private String name;
	/*
     * 私有构造器
     */
    public UserEntity() {
	}

	/*
    * 构建新实例
    */
	public static UserEntity newInstance() {
		return new UserEntity();
	}
	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return ToStringUtils.toSimpleString(this);
	}
}
