package board;

/**
 * 게시글 데이터 객체
 * 
 * @author User
 *
 */
public class BoardVO {
	private int number;
	private String subject;
	private String writer;
	private int readCount;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public void addReadCount() {
		++readCount;
	}

	@Override
	public String toString() {
		// 제목,작성자,조회수,순번
		String res = "제목: " + subject + "\n작성자: " + writer + "\n조회수: " + readCount + "\n순번: " + number;
		return res;
	}
}
