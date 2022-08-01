import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main{
	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			l1.add(i);
			l2.add(2*i);
		}

		Map<Integer,Integer> map = makeMap(l1, l2);
		System.out.println(map);
	}

	public static <K,V> Map<K,V> makeMap( List<K> l1, List<V> l2 ){
		if(l1.size() != l2.size()) throw new IllegalArgumentException(); 
		
		Set<K> duplicate = new HashSet<>(l1);
		if(duplicate.size() != l1.size()) throw new IllegalArgumentException();
		
		Map<K,V> ret = new HashMap<>();
		Iterator<K> i1 = l1.iterator();
		Iterator<V> i2 = l2.iterator();
		
		while(i1.hasNext() && i2.hasNext()){
			ret.put(i1.next(), i2.next());
		}
		return ret;
	}
}