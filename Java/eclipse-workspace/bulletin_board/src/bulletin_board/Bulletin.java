package bulletin_board;

public class Bulletin {
	String title;
	String writer;
	int number;
	int hits;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}
	
	public void addHits() {
		++hits;
	}
	@Override
	public String toString() {
		String res = "제목: " + title + "(작성자: " + writer + ") No." + 
					 number + " 조회수 " + hits;
		return res;
	}

}
