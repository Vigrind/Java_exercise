package scelta_firma;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main{
	public static void main(String[] args) {
		List<Integer> prova = new ArrayList<>();
		Map<String,Object> map = new HashMap<>();
		List<Object> ret;
		
	}

	public static <K,V> List<V> allValues(Map<? extends K,? extends V> map, List<? extends K> keys){
		List<V> ret = new ArrayList<>();
		Set<?> l = map.keySet();
		for (K k : keys) {
			if(l.contains(k))
				ret.add(map.get(k));
		}
		return ret;
	}
}