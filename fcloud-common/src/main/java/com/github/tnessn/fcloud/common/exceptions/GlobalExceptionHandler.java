package com.github.tnessn.fcloud.common.exceptions;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.StrLookup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.tnessn.fcloud.common.enums.ErrorCodeEnum;
import com.github.tnessn.fcloud.common.util.I18NUtils;
import com.github.tnessn.fcloud.common.util.Placeholder;
import com.github.tnessn.fcloud.common.util.RespData;

/**
 * 
 * @author huangjinfeng
 */
@ControllerAdvice
public class GlobalExceptionHandler{
	
	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	/**
	 * 处理参数绑定异常
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public RespData<Void> handleMethodArgumentNotValidException(HttpServletRequest req, HttpServletResponse resp, Exception e) {
		setStatus(req,resp);
		MethodArgumentNotValidException be = (MethodArgumentNotValidException) e;
		return handleBindException(be.getBindingResult());
	}
	
	

	/**
	 * 处理参数绑定异常
	 */
	@ExceptionHandler(BindException.class )
	@ResponseBody
	public RespData<Void> handleBindException(HttpServletRequest req, HttpServletResponse resp, Exception e) {
		setStatus(req,resp);
		BindException be = (BindException) e;
		return handleBindException(be.getBindingResult());
	}

	/**
	 * 处理业务层异常
	 */
	@ExceptionHandler(BizException.class)
	@ResponseBody
	public RespData<Void> handleBussinessException(HttpServletRequest req, HttpServletResponse resp, Exception e) {
		setStatus(req,resp);
		BizException bizException = (BizException) e;
		StackTraceElement stackTraceElement = e.getStackTrace()[0];
		LOG.error("【业务异常】类名:{},方法名:{},行数:{}",stackTraceElement.getClassName(),stackTraceElement.getMethodName(),stackTraceElement.getLineNumber());
		ErrorCodeEnum errorCodeEnum = bizException.getErrorCodeEnum();
		if(bizException.getCode()!=null) {
			return RespData.error(bizException.getCode(), bizException.getMsg());
		}
		return RespData.error(errorCodeEnum, bizException.getArgs());
	}

	/**
	 * 处理其他异常
	 */
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public RespData<Void> handleException(HttpServletRequest req, HttpServletResponse resp, Exception e) {
		setStatus(req,resp);
		LOG.error(null,e);
		return RespData.error(ErrorCodeEnum.DEFAULT);
	}

	public RespData<Void> handleBindException(BindingResult bindingResult) {
		List<FieldError> errorList = bindingResult.getFieldErrors();
		List<String> errors = new ArrayList<>(errorList.size());
		for (FieldError error : errorList) {
			StrLookup<String> variableResolver=new StrLookup<String>() {
				@Override
				public String lookup(String key) {
					return StringUtils.defaultString(I18NUtils.getString(key), key);
				}
			};
			String resolveMsg = Placeholder.replace(error.getDefaultMessage(), variableResolver, "{", "}", false);
			errors.add(resolveMsg);
		}
		return RespData.error(ErrorCodeEnum.PARAM_ERROR, String.join("|", errors));
	}
	
	/**
	 * feign內部接口捕获异常
	 * @param req
	 * @param resp
	 */
	private void setStatus(HttpServletRequest req, HttpServletResponse resp) {
		if(req.getRequestURI().contains("/inner")) {
			resp.setStatus(HttpStatus.FORBIDDEN.value());
		}
	}
	
	
}
