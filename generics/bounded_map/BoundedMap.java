import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class BoundedMap<T,P> {
	private Map<T,P> hashMap;
	private Map<T,Integer> countGet;
	private int cap;
	private int size = 0;

	public BoundedMap(int capacity){
		hashMap = new HashMap<>(capacity);
		countGet = new HashMap<>();
		cap = capacity;
	}

	public void put(T key, P value){
		if(size == cap && !hashMap.containsKey(key)){
			T removeKey = maxGet();
			hashMap.remove(removeKey);
			countGet.remove(removeKey);
			size--;
		}
		
		if(!countGet.containsKey(key)) countGet.put(key, 0);
		hashMap.put(key,value);
		size++;
	}

	public P get(T key){
		try {
			countGet.put(key,countGet.get(key)+1);
			return hashMap.get(key);
			
		} catch (NullPointerException e) {
			return null;
		}
	}

	private T maxGet(){
		T ret = null;
		int min = Integer.MAX_VALUE;
		for (Entry<T,Integer> elem : countGet.entrySet()) {
				if(elem.getValue() < min){
				min = elem.getValue();
				ret = elem.getKey();
			}
		}
		return ret;
	}
}
