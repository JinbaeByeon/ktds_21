package com.ktdsuniversity.edu.method;

public class Welcome {

	public String greeting() {
		return "안녕하세요";
	}
	
	public String greeting(String name) {
		return name +"님 안녕하세요";
	}
	
	public String greeting(String name, String msg) {
		return name +"님 " + msg;
	}

//	public String greeting(String... args) {
//		String res ="";
//		for(String arg: args) {
//			res += arg;
//		}
//		return res;
//	}
	
	public String greetings(String msg,String[] names) {
		String res ="";
		for(String name: names) {
			res += name + "님, ";
		}
		res += msg;
		return res;
	}
	
	public String greeting(String msg,String... names) {
		String res ="";
		for(String name: names) {
			res += name + "님, ";
		}
		res += msg;
		return res;
	}
}
