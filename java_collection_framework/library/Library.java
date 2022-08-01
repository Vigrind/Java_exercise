import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Library {
	Set<Book> books = new HashSet<>();
	ArrayList<Book> loan = new ArrayList<>();

	public boolean addBook(Book b){
		return books.add(b);
	}

	public boolean loanBook(Book b){
		if(!books.contains(b)) throw new IllegalArgumentException();
		if(loan.contains(b)) return false;
		
		loan.add(b);
		return true;
	}

	public boolean returnBook(Book b){
		if(!loan.contains(b)) throw new IllegalArgumentException();
		loan.remove(b);
		return true;
	}

	public void printLoans(){
		System.out.println(loan);
	}
}
