package bulletin_board;

import java.util.ArrayList;
import java.util.List;

public class BulletinBoard {
	private List<Bulletin> bulletins = new ArrayList<>();

	public void create(String title, String writer, int number, int hits) {
		Bulletin bulletin = new Bulletin();
		bulletin.setTitle(title);
		bulletin.setWriter(writer);
		bulletin.setNumber(number);
		bulletin.setHits(hits);

		bulletins.add(bulletin);
	}

	public void view(int idx) {
		Bulletin bulletin = bulletins.get(idx);
		bulletin.addHits();
		System.out.println(bulletin);
	}

	public void update(int idx, String title) {
		Bulletin bulletin = bulletins.get(idx);
		bulletin.setTitle(title);
	}

	public void delete(int idx) {
		bulletins.remove(idx);
	}

	public static void main(String[] args) {
		BulletinBoard bBoard = new BulletinBoard();
		bBoard.create("a", "김", 0, 0);
		bBoard.view(0);
		bBoard.update(0, "b");

		bBoard.view(0);
		bBoard.view(0);
		bBoard.view(0);
	}
}
