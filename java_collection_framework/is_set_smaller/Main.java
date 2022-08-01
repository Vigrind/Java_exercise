import java.util.Comparator;
import java.util.Set;

public class Main{
	public static void main(String[] args) {
		
	}

	public static <T> boolean isSetSmaller(Set<? extends T> set1 , Set<? extends T> set2, Comparator<? super T> comp){
		for (T elem  : set1) {
			for(T elem2 : set2){
				if(comp.compare(elem, elem2) > 0)
					return false;
			}
		}
		return true;
	}
}