import java.util.HashSet;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) {
		Set<Integer> x = new HashSet<Integer>();
		x.add(1); x.add(7); x.add(5);
		
		Predicate<Integer> isOdd = new Predicate<Integer>() {
			public boolean test(Integer n) {
				return (n%2 != 0);
			}
		};
		
		Set<Integer> y = Main.<Integer>concurrentFilter(x, isOdd);
		for (Integer t : y) {
			System.out.println(t);
		}
	}

	public static <T> Set<T> concurrentFilter(final Set<? extends T> n,final Predicate<? super T> p){
		final Set<T> ret = new HashSet<>();
		class MyThread extends Thread{
			T element;
			MyThread(T elem){element = elem;}
			@Override
			public void run() {
				synchronized(ret){
					ret.add(element);
				}
			}
		}
		int i = 0;
		MyThread[] elem = new MyThread[n.size()];
		for (T x : n) {
			if(p.test(x)){
				elem[i] = new MyThread(x);
				elem[i++].start();
			}
		}
		for(int j = 0; j < i; j++){
			try {
				elem[j].join();
			} catch (InterruptedException e) {}
		}
		return ret;
	}
}

interface Predicate<T> {
	public boolean test(T n);
}