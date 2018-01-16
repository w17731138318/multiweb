package com.pasq.common.exception;

import com.pasq.common.utils.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理器
 * 
 * @author wwx
 * @email wangweixin@pasq.com
 * @date 2017年11月29日
 */
@RestControllerAdvice
public class ResultsExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 自定义异常
	 */
	@ExceptionHandler(ResultsException.class)
	public Results handleRRException(ResultsException e){
		Results results = new Results();
		results.put("code", e.getCode());
		results.put("msg", e.getMessage());

		return results;
	}

	@ExceptionHandler(DuplicateKeyException.class)
	public Results handleDuplicateKeyException(DuplicateKeyException e){
		logger.error(e.getMessage(), e);
		return Results.error("数据库中已存在该记录");
	}

	@ExceptionHandler(Exception.class)
	public Results handleException(Exception e){
		logger.error(e.getMessage(), e);
		return Results.error();
	}
}
