package com.hello.common.exception.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hello.common.exception.AjaxResponseException;

@ControllerAdvice({"com.hello","org.springframework"})
public class ExceptionController {
	
	private Logger logger =LoggerFactory.getLogger(ExceptionController.class);

	@ExceptionHandler(AjaxResponseException.class)
	@ResponseBody
	public Map<String,Object> handleAjaxResponseException(AjaxResponseException e) {
		Map<String,Object> ajaxError = new HashMap<>();
		ajaxError.put("status", "fail");
		ajaxError.put("message", e.getMessage());
		return ajaxError;
	}
	
	@ExceptionHandler(RuntimeException.class)
	public String handleRuntimeException(RuntimeException e, Model model) {
		String message = "예외 발생 : "+ e.getMessage();
		logger.info(message);
		model.addAttribute("message",message);
		return "errors/500";
	}
	
	@ExceptionHandler(Exception.class)
	public String handleNoHandlerFoundException(Exception e) {
		return "errors/404";
	}
	
	
}
