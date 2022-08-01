import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Accumulator <T extends Number>{
	List<T> positives = new ArrayList<>();
	List<T> negatives = new ArrayList<>();

	public void add(T number){
		if(number.doubleValue() > 0){
			positives.add(number);
		}
		else if(number.doubleValue() < 0){
			negatives.add(number);
		}else {
			positives.add(number);
			negatives.add(number);
		}
	}

	public Iterable<T> positives(){
		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				return positives.iterator();
			}
		};
	}

	public Iterable<T> negatives(){
		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				return negatives.iterator();
			}
		};
	}

	public double sum(){
		double tot = 0;
		for (T  p: positives) {
			tot = tot + p.doubleValue();
		}
		for (T n : negatives) {
			tot = tot + n.doubleValue();
		}
		return tot;
	}
}