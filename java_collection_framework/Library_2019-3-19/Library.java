import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Library {
	private Set<Book> books = new HashSet<>();
	private LinkedList<Book> loan = new LinkedList<>();

	public boolean addBook(Book b) {
		return books.add(b);
	}

	public boolean loanBook(Book b) {
		if(!loan.contains(b) && books.contains(b)){
			loan.addLast(b);
			return true;
		}
		return false;
	}

	public boolean returnBook(Book b) {
		return loan.remove(b);
	}

	public void printLoans() {
		System.out.println(loan);
	}
}