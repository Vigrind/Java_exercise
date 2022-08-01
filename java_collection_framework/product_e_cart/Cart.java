import java.util.ArrayList;
import java.util.List;

public class Cart {
	List<Product> products = new ArrayList<>();
	
	public void add(Product product){
		products.add(product);
	}

	public void remove(Product product){
		products.remove(product);
	}

	public int totalPrice(){
		int total = 0;
		for (Product p : products) {
			total = total + p.getPrice();
		}
		return total;
	}
}
