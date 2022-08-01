import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Main{
	public static void main(String[] args) {
		
	}

	public <T> Collection<T> intersect(Collection<T> c1, Collection<T> c2){
		Collection<T> ret = new ArrayList<>();
		for (T elem : c1) {
			if(c2.contains(elem))
				ret.add(elem);
		}
		return ret;
	}
}