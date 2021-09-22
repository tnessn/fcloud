package com.github.tnessn.fcloud.common.exceptions;

import com.github.tnessn.fcloud.common.enums.ErrorCodeEnum;

/**
 * 
 * @author huangjinfeng
 */
public class BizException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final Object[] args;

	private final ErrorCodeEnum errorCodeEnum;

	private final Integer code;

	private final String msg;

	public BizException(ErrorCodeEnum errorCodeEnum, Object... args) {
		super(errorCodeEnum.getCode().toString());
		this.errorCodeEnum = errorCodeEnum;
		this.args = args;
		this.code = null;
		this.msg = null;
	}

	public BizException(Integer code, String msg) {
		super(String.valueOf(code));
		this.code = code;
		this.msg = msg;
		this.errorCodeEnum = null;
		this.args = null;
	}

	public Object[] getArgs() {
		return args;
	}

	public ErrorCodeEnum getErrorCodeEnum() {
		return errorCodeEnum;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

}
