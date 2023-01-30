package board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardService {

	public static void main(String[] args) {
		BoardService boardService = new BoardService();

		// 1. 등록, 2. 수정, 3. 삭제, 4. 조회, 그 외. 루프문 탈출
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("1. 등록\n2. 수정\n3. 삭제 \n4. 조회 \n5. 종료");
			int menu = scanner.nextInt();
			scanner.nextLine();
			if (menu == 1) {
				// 등록
				System.out.println("제목 입력 ");
				String subject = scanner.nextLine();
				System.out.println("작성자 입력 ");
				String writer = scanner.nextLine();

				boardService.create(subject, writer);
			} else if (menu == 2) {
				// 수정
				System.out.println("인덱스 입력");
				int idx = scanner.nextInt();
				scanner.nextLine();
				if(idx >= boardService.boardList.size()) {
					continue;
				}
				
				System.out.println("제목 입력");
				String subject = scanner.nextLine();

				boardService.update(idx, subject);

			} else if (menu == 3) {
				// 삭제
				System.out.println("인덱스 입력");
				int idx = scanner.nextInt();
				scanner.nextLine();
				if(idx >= boardService.boardList.size()) {
					continue;
				}

				boardService.delete(idx);

			} else if (menu == 4) {
				// 조회
				boardService.readAll();
				System.out.println("모든 게시글을 조회하였습니다.");
			} else {
				break;
			}
		}

	}

	private List<BoardVO> boardList = new ArrayList<>();

	/**
	 * 게시글 등록 순번은 boardList의 size로 생성 조회수는 0으로 초기화
	 * 
	 * @param subject
	 * @param writer
	 */
	public void create(String subject, String writer) {
		BoardVO boardVO = new BoardVO();
		boardVO.setNumber(boardList.size());
		boardVO.setSubject(subject);
		boardVO.setWriter(writer);
		boardVO.setReadCount(0);
		boardList.add(boardVO);
	}

	/**
	 * 게시글 수정 제목만 수정할 수 있다
	 * 
	 * @param idx
	 * @param subject
	 */
	public void update(int idx, String subject) {
		BoardVO boardVO = boardList.get(idx);
		boardVO.setSubject(subject);
	}

	/**
	 * 게시글 삭제
	 * 
	 * @param idx
	 */
	public void delete(int idx) {
		boardList.remove(idx);
	}

	/**
	 * 게시글 조회
	 * 
	 * @param idx
	 */
	public void read(int idx) {
		if (boardList.size() <= idx) {
			System.out.println(idx + "번 게시글은 존재하지 않습니다.");
			return;
		}
		BoardVO boardVO = boardList.get(idx);
		boardVO.addReadCount();
		System.out.println(boardVO);
	}

	/**
	 * 게시글 전체 조회
	 */
	public void readAll() {
		boardList.forEach(board -> System.out.println(board));

//		for(int i=0;i<boardList.size();++i) {
//			System.out.println(boardList.get(i));
//		}

//		for(BoardVO board: boardList) {
//			System.err.println(board);
//		}
	}
}
