package todo_list;

public class TodoItemVO {
	boolean isComplete;
	String name;

	public TodoItemVO(String name) {
		this.name = name;
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
		String res = "[";
		if (isComplete) {
			res += "X";
		} else {
			res += " ";
		}
		res += "] " + name;
		
		return res;
	}
}
