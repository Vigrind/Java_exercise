import java.util.HashSet;
import java.util.Set;

public class Product {
	private static Set<String> allProductName = new HashSet<>();
	private int price;
	private String name;

	public Product(String name, int price) {
		if(allProductName.add(name)){
			this.name = name;
			this.price = price;
		}
		else
			throw new IllegalArgumentException();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Product) {
			Product tmp = (Product) obj;
			return name.equals(tmp.name);
		}
		return false;
	}

	public int getPrice() { return price;}
	public String getName() { return name;}



}
