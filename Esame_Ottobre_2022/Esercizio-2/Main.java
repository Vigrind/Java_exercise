import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Map<Integer,String> testMap = new HashMap<>();
		Set<String> result = new HashSet<>();

		testMap.put(1,"ciao");
		testMap.put(2,"ciao");
		testMap.put(3,"domani");
		testMap.put(4,"franco");
		testMap.put(5,"ciao");
		testMap.put(6,"domani");

		duplicateValues(testMap, result);

		System.out.println(result);
		
	}


	//Il metodo può essere fatto molto meglio
	//tipo potreste utilizzare il metodo values, quindi map.values();
	//e fare una cosa del tipo for ( V value : map.values())
	//in alcuni esercizi non metto le soluzioni perfette ( sforzatevi a tovare la perfetta soluzione ;) )
	public static <V> void duplicateValues(Map<?, ? extends V> map, Set<? super V> duplicates) {
		Set<?> set1 = map.keySet();
		Set<?> set2 = map.keySet();

		Iterator<?> iterator1 = set1.iterator();
		Iterator<?> iterator2 = set2.iterator();

		while(iterator1.hasNext()){
			V value = map.get(iterator1.next());
			int count = 0;
			while(iterator2.hasNext()){
				V value2 = map.get(iterator2.next());
				if( value.equals(value2))
					count++;
				if(count == 2){
					duplicates.add(value);
					break;
				}
			}
			iterator2 = set2.iterator();
		}
	}
}