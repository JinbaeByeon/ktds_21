package com.ktdsuniversity.edu.todo.controller;

import java.util.Scanner;

import com.ktdsuniversity.edu.todo.service.TodoService;
import com.ktdsuniversity.edu.todo.vo.TodoVO;

public class TodoController {
	private TodoService todoService;

	public TodoController() {
		todoService = new TodoService();
	}

	public void create(Scanner scanner) {
		System.out.println("TODO 명을 입력하세요.");
		String name = scanner.nextLine();
		todoService.create(name);
		System.out.println("아이템이 등록되었습니다.\n");
	}

	public void read(Scanner scanner) {
		System.out.println("조회할 TODO Key를 입력하세요.");

		while (!scanner.hasNextInt()) {
			scanner.next();
			System.out.println("숫자를 입력하세요.");
		}
		int key = scanner.nextInt();
		scanner.nextLine();

		System.out.println(todoService.read(key));
	}

	public void readAll(Scanner scanner) {
		todoService.readAll().forEach(todo -> System.out.println(todo));
	}

	public void update(Scanner scanner) {
		System.out.println("수정할 TODO Key를 입력하세요.");
		while (!scanner.hasNextInt()) {
			scanner.next();
			System.out.println("숫자를 입력하세요.");
		}
		int key = scanner.nextInt();
		scanner.nextLine();

		TodoVO todo = todoService.read(key);
		if (todo == null) {
			System.out.println("아이템이 존재하지 않습니다.\n");
			return;
		}
		
		if (todo.isComplete()) {
			System.out.println("이미 완료된 건입니다. 미완료로 변경할까요? (Y/N)");

		} else {
			System.out.println("미완료된 건입니다. 완료로 변경할까요? (Y/N)");

		}
		String s = scanner.nextLine();
		if(s.equalsIgnoreCase("Y") == todo.isComplete()) {
			todoService.update(key,false);
			System.out.println(todo.getName() + "이 완료되었습니다.\n");
		}else {
			todoService.update(key,true);
			System.out.println(todo.getName() + "이 미완료되었습니다.\n");
		}

	}

	public void delete(Scanner scanner) {
		System.out.println("삭제할 아이템 번호를 입력하세요.");
		while (!scanner.hasNextInt()) {
			scanner.next();
			System.out.println("숫자를 입력하세요.");
		}
		int key = scanner.nextInt();
		scanner.nextLine();

		if (todoService.delete(key)) {
			System.out.println("아이템이 삭제되었습니다.\n");
		} else {
			System.out.println("아이템이 존재하지 않습니다.\n");
			return;
		}
	}

	public void clear(Scanner scanner) {
		if (todoService.clear()) {
			System.out.println("아이템이 전부 삭제되었습니다.\n");
		} else {
			System.out.println("아이템이 존재하지 않습니다.\n");
		}
	}

	public static void main(String[] args) {
		TodoController controller = new TodoController();
		int menu = 0;

		System.out.println("TODO LIST");
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("====================");
			System.out.println("1. 등록\n2. 조회 (1건)\n3. 조회 (모든 건) \n4. 수정\n"
							 + "5. 삭제 (1건)\n6. 삭제 (모든 건) \n7. 종료\n");
			System.out.println("====================");

			System.out.println("메뉴를 입력하세요.");
			while (!scanner.hasNextInt()) {
				scanner.next();
				System.out.println("숫자를 입력하세요.");
			}
			menu = scanner.nextInt();
			scanner.nextLine();

			if (menu == 1) {
				controller.create(scanner);
			} else if (menu == 2) {
				controller.read(scanner);
			} else if (menu == 3) {
				controller.readAll(scanner);
			} else if (menu == 4) {
				controller.update(scanner);
			} else if (menu == 5) {
				controller.delete(scanner);
			} else if (menu == 6) {
				controller.clear(scanner);
			} else if (menu == 7) {
				scanner.close();
				System.out.println("프로그램이 종료되었습니다.");
				break;
			} else {
				System.out.println("존재하지않는 메뉴입니다.\n");
			}
		}

	}
}
