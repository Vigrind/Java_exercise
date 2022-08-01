import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main{
	public static void main(String[] args) {
		Set<Integer> x = new HashSet<Integer>();
		for (int i = 0; i < 15000; i++) {
			x.add(i);
		}
		Selector<Integer> oddSelector = new Selector<Integer>() {
		public boolean select(Integer n) {
		return (n%2 != 0);
		}
		};
		Set<Integer> y = null;
		try {
			y = Main.<Integer>concurrentFilter(x, oddSelector);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		for (Integer n: y)
		System.out.println(n);
		
	}

	public static <T> Set<T> concurrentFilter(Set<T> set, Selector<T> s) throws InterruptedException{
		ArrayList<Thread> threads = new ArrayList<>(set.size());
		Set<T> ret = new HashSet<>();
		for (T elem : set) {
			Thread t =  new Thread(){
				public void run() {
					if(s.select(elem))
						synchronized(ret){
							ret.add(elem);
						}
				};
			};
			threads.add(t);
			t.start();
		}

		for (Thread t : threads) {
			t.join();
		}
		return ret;
	}
}

interface Selector<T> {
	boolean select(T x);
}