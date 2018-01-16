package com.pasq.common.exception;

/**
 * 自定义异常
 * 
 * @author wwx
 * @email wangweixin@pasq.com
 * @date 2017年11月29日
 */
public class ResultsException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
    private String msg;
    private int code = 500;
    
    public ResultsException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public ResultsException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}
	
	public ResultsException(String msg, int code) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}
	
	public ResultsException(String msg, int code, Throwable e) {
		super(msg, e);
		this.msg = msg;
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	
}
