package com.ktdsuniversity.admin.common.exception.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ktdsuniversity.admin.common.api.vo.APIResponseVO;
import com.ktdsuniversity.admin.common.api.vo.APIStatus;
import com.ktdsuniversity.admin.common.exception.APIArgsException;
import com.ktdsuniversity.admin.common.exception.APIException;


@RestControllerAdvice({"com.ktdsuniversity","org.springframework"})
public class ExceptionController {

	private Logger logger =LoggerFactory.getLogger(ExceptionController.class);

	@ExceptionHandler(APIException.class)
	public APIResponseVO handleAPIException(APIException e) {
		return new APIResponseVO(APIStatus.FAIL,e.getMessage(),e.getErrorCode(),"/");
	}
	
	@ExceptionHandler(APIArgsException.class)
	public APIResponseVO handleRuntimeException(APIArgsException e) {
		return new APIResponseVO(APIStatus.MISSING_ARGS,e.getMessage(),e.getErrorCode(),"/");
	}
	
}
