import java.util.HashSet;
import java.util.Set;

public class SafeSet<T>{
	private Set<T> data = new HashSet<>();
	private Set<T> trash = new HashSet<>();

	synchronized public boolean add(T arg0) {
		for (T x : trash) {
			if(x.equals(arg0)){
				T ob = x;
				trash.remove(x);
				return data.add(ob);
			}
		}
		return data.add(arg0);
	}

	synchronized public boolean contains(T arg0){
		return data.contains(arg0);
	}

	synchronized public boolean remove(T arg0){
		if(trash.contains(arg0)){
			return trash.remove(arg0);
		
		}else if(data.contains(arg0)){
			trash.add(arg0);
			return data.remove(arg0);
		}
		return false;
	}

}