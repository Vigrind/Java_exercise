import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Prova {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		Set<Integer> set = new HashSet<>();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);

		Map<String, List<Integer>> map = new HashMap<>();
		map.put("ciao", list);
		System.out.println(map.get("ciao"));

		Type A = new Type("A");
		Type B = new Type("B",A);
		Type C = new Type("C",A);
		Type D = new Type("D",B);
		System.out.println(D);

		System.out.println(B.isSubtypeOf(A));
		System.out.println(D.isSubtypeOf(A));
		System.out.println(B.isSubtypeOf(C));
		Type A2 = new Type("A", D);


	}

	static <T> void atLeast(List<? extends T> list, Set<? super T> set){
		Iterator<? extends T> iter1 = list.iterator();
		
		while(iter1.hasNext()){
			Iterator<? extends T> iter2 = iter1; //bisogna fare una copia
			T elem = iter1.next();
			while(iter2.hasNext()){
				System.out.println(elem + " " + iter2.next());
			}
		}
	}
}

class A {
	private int val;
	public A(int val){
		this.val = val;
	}

	public class B {
		private static int counter = 0;
		private final int id = counter++;
	}

	public Comparator<A> comp(int bias) {
		return (x,y) -> x.val + bias - y.val;
	}
}