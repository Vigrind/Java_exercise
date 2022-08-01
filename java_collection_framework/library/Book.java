public class Book {
	private String name;
	public Book(String name){
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Book)) return false;
		Book tmp = (Book)obj;
		return name.equals(tmp.name);
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}
}
