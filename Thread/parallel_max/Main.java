import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Main{
	public static void main(String[] args) {
		List<Integer> l1 = new LinkedList<>();
		List<Integer> l2 = new ArrayList<>();

		Comparator<Integer> comp = (Integer c1,Integer c2) -> {
			return c1.compareTo(c2);
		};

		for (int i = 0; i < 10; i++) {
			l1.add(i);
		}

		for (int i = 0; i < 25; i++) {
			l2.add(i);
		}

		System.out.println(Main.<Integer>parallelMax(l1, l2, comp));
	}

	public static <T> T parallelMax(Iterable<? extends T> t1, Iterable<? extends T> t2, Comparator<? super T> comp){
		ArrayList<T> max = new ArrayList<>(2);

		Thread tMax1 = new Thread(){
			@Override
			public void run() {
				T max1 = t1.iterator().next();
				for (T elem : t1) {
					if(comp.compare(max1, elem) < 0)
						max1 = elem;
				}
				synchronized(max){
					max.add(max1);
				}
			}
		};

		Thread tMax2 = new Thread(){
			@Override
			public void run() {
				T max2 = t2.iterator().next();
				for (T elem : t2) {
					if(comp.compare(max2, elem) < 0)
						max2 = elem;
				}
				synchronized(max){
					max.add(max2);
				}
			}
		};

		tMax1.start();
		tMax2.start();

		try {
			tMax1.join();
			tMax2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return comp.compare(max.get(0), max.get(1)) > 0 ? max.get(0) : max.get(1);
	}
}