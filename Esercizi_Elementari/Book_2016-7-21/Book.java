import java.util.LinkedList;

public class Book implements Comparable<Book>{
	private int capNumber = 0;
	LinkedList<Chapter> chapter = new LinkedList<>();

	public void addChapter(String name, String contenuto) {
		chapter.addLast(new Chapter(name, contenuto, ++capNumber));
	}

	public Book clone() {
		Book ret = new Book();
		ret.capNumber = capNumber;
		ret.chapter.addAll(this.chapter);
		return ret;
	}

	private class Chapter {
		String nameChapter;
		String cont;
		int num;

		public Chapter(String name, String contenuto, int numChapter){
			nameChapter = name;
			cont = contenuto;
			num = numChapter;
		}
	}

	public String getChapterContent(int numChapter) {
		for ( Book.Chapter i : chapter) {
			if(numChapter == i.num){
				return i.cont;
			}
		}
		return null;
	}

	public String getChapterTitle(int numChapter) {
		for ( Book.Chapter i : chapter) {
			if(numChapter == i.num){
				return i.nameChapter;
			}
		}
		return null;
	}

	@Override
	public int compareTo(Book o) {
		if(capNumber == o.capNumber)
			return 0;
		else if(capNumber > o.capNumber)
			return 1;
		else
			return -1;
	}
}
