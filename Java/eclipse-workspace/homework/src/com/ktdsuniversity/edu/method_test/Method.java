package com.ktdsuniversity.edu.method_test;

public class Method {
	/**
	 * 정수형 파라미터 1개를 받아 제곱해 반환하는 메소드
	 * @param i
	 * @return
	 */
	public int test1(int i) {
		return i*i;
	}
	/**
	 * 정수형 파라미터 1개를 받아 double 형으로 반환하는 메소드
	 * @param i
	 * @return
	 */
	public double test2(int i) {
		return (double)i;
	}
	/**
	 * 정수형 파라미터 1개, 실수형 파라미터 1개를 받아 곱한 결과를 정수형으로 반환하는 메소드
	 * @param i
	 * @param d
	 * @return
	 */
	public int test3(int i,double d) {
		return (int)(i*d);
	}
	/**
	 * 정수형 파라미터 3개를 받아 모두 곱해 출력만 하는 메소드
	 * @param a
	 * @param b
	 * @param c
	 */
	public void test4(int a, int b, int c) {
		System.out.println(a*b*c);
	}
}
