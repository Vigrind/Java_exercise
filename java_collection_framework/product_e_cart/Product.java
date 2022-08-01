import java.util.HashSet;
import java.util.Set;

public class Product {
	private static Set<String> nameAllprod = new HashSet<>();
	private String name;
	private int price;
	
	public Product(String description, int value) {
		if(nameAllprod.add(description)){
			name = description;
			price = value;
		}
		else throw new IllegalArgumentException();
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Product)) return false;
		Product tmp = (Product)obj;
		return name.equals(tmp.name);
	}

	public int getPrice(){return price;}
}
