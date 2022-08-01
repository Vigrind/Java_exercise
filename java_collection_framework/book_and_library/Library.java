import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Library {
	private Map<String,Set<Book>> tagBooks = new HashMap<>();
	private Set<Book> books = new HashSet<>();

	public class Book{
		private String title;
		private String author;

		public Book(String t, String a){
			title = t;
			author = a;
		}

		public void addTag(String tag){
			if(tagBooks.containsKey(tag))
				tagBooks.get(tag).add(this);
			else{
				Set<Library.Book> addSet = new HashSet<>();
				addSet.add(this);
				tagBooks.put(tag, addSet);
			}
		}

		@Override
		public String toString() {
			return title + ", " + author;
		}

		@Override
		public int hashCode() {
			return title.hashCode() ^ author.hashCode();
		}
	}

	public Library.Book addBook(String t, String a){
		Library.Book ret = new Library.Book(t, a);
		books.add(ret);
		return ret;
	}

	public Set<Library.Book> getBooksByTag(String tag){
		Set<Library.Book> ret = tagBooks.get(tag);
		return ret;
	}
}
