package todo_list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoItemService {
	private List<TodoItemVO> todoItemList;
	
	public TodoItemService() {
		todoItemList = new ArrayList<>();
	}

	public List<TodoItemVO> getTodoItemList() {
		return todoItemList;
	}

	public void setTodoItemList(List<TodoItemVO> todoItemList) {
		this.todoItemList = todoItemList;
	}
	/**
	 * 추가
	 * 
	 * @param name 추가할 아이템 명
	 */
	public void add(String name) {
		todoItemList.add(new TodoItemVO(name));
	}

	/**
	 * 수정
	 * 
	 * @param idx        수정할 List의 index
	 * @param isComplete 완료 여부
	 */
	public void update(int idx, boolean isComplete) {
		todoItemList.get(idx).setComplete(isComplete);
	}

	/**
	 * 삭제
	 * 
	 * @param idx 삭제할 List의 index
	 */
	public void delete(int idx) {
		todoItemList.remove(idx);
	}

	/**
	 * 조회 (모든 아이템을 조회한다)
	 */
	public void read() {
//		for (TodoItemVO todoItemVO : todoItemList) {
//			System.out.println(todoItemVO);
//		}

		todoItemList.forEach(item -> System.out.println(item));
		System.out.println("총 " + todoItemList.size() + "개의 아이템이 조회되었습니다.\n");
	}

	public static void main(String[] args) {
		TodoItemService todoItemService = new TodoItemService();
		int menu = 0;
		System.out.println("TODO LIST");
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("====================");
			System.out.println("1. 등록\n2. 수정\n3. 삭제 \n4. 조회 \n5. 종료");
			System.out.println("====================");

			System.out.println("메뉴를 입력하세요.");
			while (!scanner.hasNextInt()) {
				scanner.next();
				System.out.println("숫자를 입력하세요.");
			}
			menu = scanner.nextInt();
			scanner.nextLine();

			if (menu == 1) {
				// 등록
				System.out.println("TODO 명을 입력하세요.");
				String name = scanner.nextLine();
				todoItemService.add(name);
				System.out.println("아이템이 등록되었습니다.\n");

			} else if (menu == 2) {
				// 수정
				System.out.println("수정할 아이템 번호를 입력하세요.");
				while (!scanner.hasNextInt()) {
					scanner.next();
					System.out.println("숫자를 입력하세요.");
				}
				int idx = scanner.nextInt();
				scanner.nextLine();
				List<TodoItemVO> todoItemList = todoItemService.getTodoItemList();
				if (idx < 0 || idx >= todoItemList.size()) {
					System.out.println("아이템이 존재하지 않습니다.\n");
					continue;
				}

				System.out.println("아이템이 완료되었다면 \"Y\"를 눌러주세요");
				String s = scanner.nextLine();
				String name = todoItemList.get(idx).getName();
				if (s.equalsIgnoreCase("Y")) {
					todoItemService.update(idx, true);
					System.out.println(name + "이 완료되었습니다.\n");

				} else {
					todoItemService.update(idx, false);
					System.out.println(name + "이 미완료되었습니다.\n");
				}

			} else if (menu == 3) {
				// 삭제
				System.out.println("삭제할 아이템 번호를 입력하세요.");
				while (!scanner.hasNextInt()) {
					scanner.next();
					System.out.println("숫자를 입력하세요.");
				}
				int idx = scanner.nextInt();
				scanner.nextLine();

				if (idx < 0 || idx >= todoItemService.todoItemList.size()) {
					System.out.println("아이템이 존재하지 않습니다.\n");
					continue;
				}
				todoItemService.delete(idx);
				System.out.println("아이템이 삭제되었습니다.\n");

			} else if (menu == 4) {
				// 조회
				todoItemService.read();

			} else if (menu == 5) {
				scanner.close();
				System.out.println("프로그램이 종료되었습니다.");
				break;
			} else {
				System.out.println("존재하지않는 메뉴입니다.\n");
			}
		}

	}


}
