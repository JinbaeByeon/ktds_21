package todo_list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoItemService {
	private List<TodoItemVO> todoItemList;

	public TodoItemService() {
		todoItemList = new ArrayList<>();
	}

	public static void main(String[] args) {
		TodoItemService todoItemService = new TodoItemService();

		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("====================");
			System.out.println("1. 등록\n2. 수정\n3. 삭제 \n4. 조회 \n5. 종료");
			System.out.println("====================");

			System.out.println("메뉴를 입력하세요.");
			int menu = (int)Integer.parseInt(scanner.nextLine());

			if (menu == 1) {
				// 등록
				System.out.println("TODO 명을 입력하세요.");
				String name = scanner.nextLine();
				todoItemService.add(name);
				System.out.println("아이템이 등록되었습니다.\n");

			} else if (menu == 2) {
				// 수정
				System.out.println("수정할 아이템 번호를 입력하세요.");
				int idx = Integer.parseInt(scanner.nextLine());
				
				if (idx < 0 || idx >= todoItemService.todoItemList.size()) {
					System.out.println("아이템이 존재하지 않습니다.\n");
					continue;
				}

				System.out.println("아이템이 완료되었다면 Y를 눌러주세요");
				String s = scanner.nextLine();
				String name = todoItemService.todoItemList.get(idx).getName();
				if (s.equals("Y")|| s.equals("y")) {
					todoItemService.update(idx, true);
					System.out.println(name + "이 완료되었습니다.\n");

				} else {
					todoItemService.update(idx, false);
					System.out.println(name + "이 미완료되었습니다.\n");
				}

			} else if (menu == 3) {
				// 삭제
				System.out.println("삭제할 아이템 번호를 입력하세요.");
				int idx = Integer.parseInt(scanner.nextLine());

				if (idx < 0 || idx >= todoItemService.todoItemList.size()) {
					System.out.println("아이템이 존재하지 않습니다.\n");
					continue;
				}
				todoItemService.delete(idx);
				System.out.println("아이템이 삭제되었습니다.\n");

			} else if (menu == 4) {
				// 조회
				todoItemService.read();
				System.out.println("총 " + todoItemService.todoItemList.size() + "개의 아이템이 조회되었습니다.\n");

			} else {
				System.out.println("프로그램이 종료되었습니다.");
				break;
			}
		}

	}

	public void add(String name) {
		todoItemList.add(new TodoItemVO(name));
	}

	public void update(int idx, boolean isComplete) {
		todoItemList.get(idx).setComplete(isComplete);
	}

	public void delete(int idx) {
		todoItemList.remove(idx);
	}

	public void read() {
		todoItemList.forEach(item -> System.out.println(item));
	}

}
