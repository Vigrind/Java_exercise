public class Book {
	private String title;
	
	public Book(String name) {
		title = name;
	}

	public String getName(){ return title;}

	@Override
	public int hashCode() {
		return title.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Book) {
			Book tmp = (Book) obj;
			return title.equals(tmp.title);
		}
		return false;
	}

	@Override
	public String toString() {
		return title;
	}
}
