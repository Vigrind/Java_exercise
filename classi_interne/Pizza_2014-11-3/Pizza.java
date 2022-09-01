import java.util.HashSet;
import java.util.Set;

public class Pizza implements Comparable<Pizza>, Cloneable {
	Set<Ingrediente> setIng = new HashSet<>();
	
	public Pizza(){}

	public static enum Ingrediente{
		POMODORO("Pomodoro",100),
		MOZZARELLA("Mozzarella",200),
		AGLIO("Aglio",50);

		private String name;
		private int calorie;
		private Ingrediente(String n,int c){
			name = n;
			calorie = c;
		}
	};

	public void addIngrediente(Ingrediente ing){
		setIng.add(ing);
	}

	@Override
	public int compareTo(Pizza o) {
		int count_this = 0;
		int count_o = 0;
		for (Ingrediente x : setIng) {
			count_this = count_this + x.calorie;
		}
		for (Ingrediente x : o.setIng) {
			count_o = count_o + x.calorie;
		}
		if(count_this < count_o) 
			return - 1;
		else if(count_this > count_o) 
			return 1;
		else 
			return 0;
	}

	@Override
	protected Pizza clone() throws CloneNotSupportedException {
		Pizza nuova = (Pizza)super.clone();
		nuova.setIng.addAll(this.setIng);
		return nuova;
	}
}
