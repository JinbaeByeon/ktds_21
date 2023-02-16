package com.ktdsuniversity.edu.todo.vo;

public class TodoVO implements VO{
	String name;
	boolean isComplete;
	
	public TodoVO(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}	
	@Override
	public String toString() {
		return "[" + (isComplete ? "X" : " ") + "] " + name;
	}
}
