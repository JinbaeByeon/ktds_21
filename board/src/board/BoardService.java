package board;

import java.util.ArrayList;
import java.util.List;

public class BoardService {

	public static void main(String[] args) {
		BoardService boardService = new BoardService();
		boardService.create("첫 번째 게시글", "장민창");
		boardService.create("두 번째 게시글", "장민창");
		boardService.create("세 번째 게시글", "장민창");
		boardService.create("네 번째 게시글", "장민창");
		boardService.create("다섯 번째 게시글", "장민창");
		boardService.create("여섯 번째 게시글", "장민창");
		
		boardService.read(0);
		boardService.read(1);
		boardService.read(2);
		boardService.read(3);
		boardService.read(4);
		boardService.read(5);
		
		boardService.update(1, "수정한 게시글 원래는 두 번째 게시글");
		boardService.read(1);
		
		boardService.delete(5);
		
		boardService.read(0);
		boardService.read(1);
		boardService.read(2);
		boardService.read(3);
		boardService.read(4);
		boardService.read(5);
	}
	
	private List<BoardVO> boardList = new ArrayList<>();

	/**
	 * 게시글 등록
	 * 순번은 boardList의 size로 생성
	 * 조회수는 0으로 초기화
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
	 * 게시글 수정
	 * 제목만 수정할 수 있다
	 * @param idx
	 * @param subject
	 */
	public void update(int idx, String subject) {
		BoardVO boardVO = boardList.get(idx);
		boardVO.setSubject(subject);
	}

	/**
	 * 게시글 삭제
	 * @param idx
	 */
	public void delete(int idx) {
		boardList.remove(idx);
	}

	/**
	 * 게시글 조회
	 * @param idx
	 */
	public void read(int idx) {
		if(boardList.size() <= idx) {
			System.out.println(idx + "번 게시글은 존재하지 않습니다.");
			return;
		}
		BoardVO boardVO = boardList.get(idx);
		boardVO.addReadCount();
		System.out.println(boardVO);
	}
}
