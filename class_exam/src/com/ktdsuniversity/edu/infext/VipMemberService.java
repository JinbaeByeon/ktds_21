package com.ktdsuniversity.edu.infext;

public interface VipMemberService extends MemberService {
	
	/**
	 * 포인트 지급
	 * @param point 지급될 포인트
	 */
	public void addPoint(int point);


}
