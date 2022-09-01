import java.util.ArrayList;

public class Cart {
	ArrayList<Product> prod = new ArrayList<>();

	public void add(Product p) {
		prod.add(p);
	}

	public int totalPrice() {
		int cont = 0;
		for(Product p : prod) {
			cont = p.getPrice() + cont;
		}
		return cont;
	}

	public void remove(Product p) {
		prod.remove(p);
	}
}
