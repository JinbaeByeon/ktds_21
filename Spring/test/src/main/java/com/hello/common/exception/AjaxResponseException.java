package com.hello.common.exception;

public class AjaxResponseException extends RuntimeException{

	private static final long serialVersionUID = -1992879179814860340L;

	public AjaxResponseException(String msg) {
		super(msg);
	}
}
