import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class FiltredSet<T> {
	private Set<T> set = new HashSet<>();
	Predicate<T> pred;

	public FiltredSet(Predicate<T> p){
		pred = p;
	}

	public boolean add(T val){
		if(pred.test(val)){
			return set.add(val);
		}
		return false;
	}

	public boolean contains(Object val) {
		return set.contains(val);
	}

	public boolean remove(Object val) {
		return set.remove(val);
	}

	public FiltredSet<T> intersect(FiltredSet<T> other){
		Predicate<T> p = new Predicate<T>(){
			@Override
			public boolean test(T t) {
				return pred.test(t) && other.pred.test(t);
			}
		};

		FiltredSet<T> ret = new FiltredSet<>(p);
		for (T t : set) {
			if(other.set.contains(t))
				ret.add(t);
		}
		return ret;
	}
}