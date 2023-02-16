package com.ktdsuniversity.edu;

/**
 * 잘못된 단어를 입력한 경우 혹은 "포기"를 입력한 경우 던질 예외
 * @author User
 *
 */
public class ExitWordException extends RuntimeException {
	private static final long serialVersionUID = 2003169993243251102L;
	
	public ExitWordException() {
		super();
	}
	
	public ExitWordException(String msg) {
		super(msg);
	}	
}
