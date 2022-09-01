import java.util.HashSet;
import java.util.Set;

public class Library {

	Set<Book> books= new HashSet<>();
	
	public Book addBook(String title, String author) {
		Book ret = new Book(title, author);
		books.add(ret);
		return ret;
	}

	public Set<Book> getBooksByTag(String tag) {
		Set<Book> ret = new HashSet<>();
		/*
		 * La traccia vuole che questo metodo sia costante
		 * La ricerca del tag è costante essendo un hashSet, ma c'è il for che scorre sui libri
		 * Una soluzione potrebbe essere creare un hashMap che contiene il tag come key e come value un set di libri
		 * HashMap<String,Set<Book>, dove String è il tag.
		 * Non ho usato tale soluzione perchè non so se consona, un giorno scoprirò il modo giusto per rendere tutto costante
		*/
		for (Book book : books) {
			if(book.tags.contains(tag))
				ret.add(book);
		}
		return ret;
	}

	public class Book {
		private String title;
		private String author;
		Set<String> tags = new HashSet<>();

		public Book(String title, String author) {
			this.title = title;
			this.author = author;
		}

		public void addTag(String tag) {
			tags.add(tag.toLowerCase());
		}

		@Override
		public int hashCode() {
			return title.hashCode() ^ author.hashCode() ^ tags.hashCode();
		}

		@Override
		public String toString() {
			return title + ", by " + author;
		}
	}
}