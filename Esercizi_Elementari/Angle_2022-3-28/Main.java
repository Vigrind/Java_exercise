import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
	public static void main(String[] args) {
		Angle a = Angle.of(30.0);
		Angle.Acute b = new Angle.Acute(20.0);
		Angle c = Angle.of(90.0);
		Angle d = Angle.of(90.0);
		Angle.Octuse e = (Angle.Octuse) Angle.of(120.5);
		System.out.println(a == b);
		System.out.println(a.getClass() == b.getClass());
		System.out.println(c == d);
		System.out.println(a.compareTo(b));


		A a1 = new A();
		A a2 = new A();
		Object x = a1.makeObj(42);
		A.B y = new A.B();
		System.out.println(x.getClass());

		ArrayList<Integer> arr1 = new ArrayList<>();
		ArrayList<Integer> arr2 = new ArrayList<>();

		for(int i = 0; i < 10; ++i){
			arr1.add(i);
		}

		for(int i = 0; i < 15; ++i){
			arr2.add(i);
		}

		Comparator<Integer> comp = (first,second)->{
			return first.compareTo(second);
		};

		Integer result = Main.<Integer>parallelMax(arr1, arr2, comp);
		System.out.println(result);
	}

	
	public static <T> T parallelMax(Iterable<? extends T> t1, Iterable<? extends T> t2, Comparator<? super T> comp) {
		Callable<T> call = () -> {
			T cMax1 = t1.iterator().next();
			for (T it : t1) {
				if(comp.compare(cMax1, it) < 0)
					cMax1 = it;
			}
			return cMax1;
		};

		Callable<T> call2 = () -> {
			T cMax2 = t2.iterator().next();
			for(T it2 : t2) {
				if (comp.compare(cMax2, it2) < 0)
					cMax2 = it2;
			}
			return cMax2;
		};
		ExecutorService ex = Executors.newFixedThreadPool(2);
		Future<T> result1 = ex.submit(call);
		Future<T> result2 = ex.submit(call2);
		T max1 = null;
		T max2 = null;
		try {
			max1 = result1.get();
			max2 = result2.get();
			ex.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(comp.compare(max1, max2) < 0)
			return max2;
		else
			return max1;
	}

	public static void prova(List<? extends Number> p){}
}

class A {
	public int n = 0;
	public A() {
		n++;
	}

	public static class B {
		private int i = 1;
	}

	public Object makeObj(int val) {
		return new B() {
			private int j = val;
		};
	}
}