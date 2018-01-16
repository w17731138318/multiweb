package com.pasq.common.utils;

import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 * 
 * @author wwx
 * @email wangweixin@pasq.com
 * @date 2017年11月29日
 */
public class Results extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	
	public Results() {
		put("code", 0);
	}
	
	public static Results error() {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
	}
	
	public static Results error(String msg) {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
	}
	
	public static Results error(int code, String msg) {
		Results results = new Results();
		results.put("code", code);
		results.put("msg", msg);
		return results;
	}

	public static Results ok(String msg) {
		Results results = new Results();
		results.put("msg", msg);
		return results;
	}
	
	public static Results ok(Map<String, Object> map) {
		Results results = new Results();
		results.putAll(map);
		return results;
	}
	
	public static Results ok() {
		return new Results();
	}

	@Override
	public Results put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
