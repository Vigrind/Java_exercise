import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
	public static void main(String[] args)  throws InterruptedException{
		/*LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);

        l2.add(4);
        l2.add(5);
        l2.add(6);

        LinkedList<Integer> l3 = Main.<Integer>merge(l1,l2);
		System.out.println(l3);

		Short s = 10;
		Integer a = 10;
		Double b = 11.0;
		Number aa = a;
		Number bb = b;

		System.out.println( (Object) s == (Object) a ); // NO
		System.out.println(aa == a); // SI
		System.out.println(a.getClass().equals(aa.getClass())); // SI
		System.out.println(aa.getClass().equals(bb.getClass())); // NO
		Object o = s;
		System.out.println(o.getClass().equals(Short.class)); // SI*/

		/*final Object x = new Object();
		final int[] count = new int[1];

		class MyThread extends Thread{
			int id;
			MyThread(int n) {id = n;}
			@Override
			public void run() {
				synchronized(x) {
					count[0]++;
					synchronized (count) {
						count.notify();
					}
					try {
						x.wait();
					} catch (Exception e) {
						//TODO: handle exception
					}
				}
				System.out.println(id);
			}
		}

		Thread t1 = new MyThread(1), t2 = new MyThread(2), t3 = new MyThread(3);
		t1.start(); t2.start(); t3.start();
		synchronized (count) {
			while(count[0] < 3) {
				count.wait();
				System.out.println("Incremento");
			}
		}
		System.out.println("Fatto");
		synchronized (x) {
			x.notifyAll();
		}*/

	}

	public static <T> LinkedList<T> merge(List<T> first, List<T> second) {
		if(first.size() != second.size()) 
			throw new IllegalArgumentException();

		LinkedList<T> ret = new LinkedList<>();
		int i = 0;
		while (i < first.size()) {
			ret.add(first.get(i));
			ret.add(second.get(i));
			i++;
		}
		return ret;
	}

	public static <K> Map<? super K,Integer> coutOccurrences(Collection<? extends K> c) {
		Map<? super K,Integer> ret = new HashMap<>();
		for (K k : c) {
			int incremento = 0;
			for (K k2 : c) {
				if(k.equals(k2)) {
					incremento++;
				}
			}
			ret.put(k,incremento);
		}
		return ret;
	}

	public static <K,V> Set<K> keysWithHighestValue(Map<K,V> map, Comparator<? super V> c) {
		Set<K> ret = new HashSet<>();
		Set<K> it = map.keySet();
		for (K k1 : it) {
			boolean max = true;
			for (K k2 : it) {
				if(c.compare(map.get(k1), map.get(k2)) < 0)
					max = false;
			}
			if(max)
				ret.add(k1);
		}
		return ret;
	}

	public static <S> Set<S> disjoin(Collection<? extends S> a, Collection<? extends S> b) {
		Set<S> ret = new HashSet<>();
		for (S s : a) {
			if(!b.contains(s))
				ret.add(s);
		}
		for (S s2 : b) {
			if(!a.contains(s2))
				ret.add(s2);
		}
		return ret;
	}

	public static <K> void KeysWithValue(Map<K,?> m, Object v, List<? super K> out) {
		Set<K> k = m.keySet();
		for (K k2 : k) {
			if(m.get(k2).equals(v))
				out.add(k2);
		}
	}

	public static <S> void interleave(List<? extends S> l1, List<? extends S> l2, List<? super S> out) {
		int i = 0;
		while( i < l1.size() || i < l2.size()){
			if(i < l1.size())
				out.add(l1.get(i));
			if(i < l2.size())
				out.add(l2.get(i));
			i++;
		}
	}

	public static <T> T findPrevious(Set<? extends T> set, Comparator<? super T> comp, T x){
		Set<T> minX = new HashSet<>();
		T ret = null;
		for (T t : set) {
			if(comp.compare(t, x) < 0)
				minX.add(t);
		}

		ArrayList<T> maxArr = new ArrayList<>(minX);
		ret = maxArr.get(0);
		
		for(T t1 : minX){
			if(comp.compare(t1, ret) > 0) {
				ret = t1;
			}
		}

		return ret;
	}

	public static <T> int countInBetween(T[] arr, Comparator<? super T> comp, T a, T b){
		int num = 0;
		for(T t : arr) {
			if(comp.compare(t,a) > 0 && comp.compare(t, b) < 0)
				num++;
		}
		return num;
	}
}