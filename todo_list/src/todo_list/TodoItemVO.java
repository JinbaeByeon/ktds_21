package todo_list;

public class TodoItemVO {
	/**
	 * 완료 여부
	 */
	private boolean isComplete;
	/**
	 * 아이템 명
	 */
	private String name;

	public TodoItemVO(String name) {
		setName(name);
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
//		String res = "[ ";
//		if (isComplete) {
//			res += "[X";
//		}
//		res += "] " + name;
//		return res;
		return "[" + (isComplete ? "X" : " ") + "] " + name;

	}
}
