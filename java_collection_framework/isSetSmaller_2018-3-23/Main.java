import java.util.Comparator;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		/*
		 * Per testare creare un Comparator di Set di qualsiasi tipo
		 * fare l'override del metodo compare e poi passare tutto a isSetSmaller
		 * Es:
		 * public static final Comparator<Set<Integer>> comp = new Comparator<>(() ->{.....})
		*/
	}

	public static <T> boolean isSetSmaller(Set<T> s1, Set<T> s2, Comparator<Set<T>> comp){
		if(comp.compare(s1, s2) < 1)
			return true;
		return false;
	
	}
}