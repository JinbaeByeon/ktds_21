package com.ktdsuniversity.edu.exceptions;

/**
 * 사용자 예외는 반드시 RuntimeException을 상속받는다.
 * @author User
 *
 */
public class DuplicateMemberIDException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 300748820639462251L;
	
	// 사용자 예외는 필요에 따라 생성자를 overriding 한다
	public DuplicateMemberIDException(String memberID) {
		super(memberID);
	}
	
}
