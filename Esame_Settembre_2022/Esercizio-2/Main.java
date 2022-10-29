import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();

		for(int i = 0; i < 10; i++) {
			l1.add(i);
			l2.add(i);
		}
		System.out.println(Main.samePosition(l1, l2));
	}

	/*
	 * Non si può fare nei seguenti modi modi:
	 * 
	 * 1)	for(int i = 0; i < l1.size(); i++)
	 * 			if(l1.get(i) == l2.get(i))
	 * 
	 * 2)	for(Object elem : l1)
	 * 			if(l2.contains(elem))
	 * 
	 * Non si può fare nei modi sopra elencati perchè non sono lineari sulla lunghezza delle liste!
	 * In particolare il primo non è lineare in caso di LinkedList come tipo effettivo.
	 */
	public static int samePosition(List<?> l1, List<?> l2) {
		if(l1.size() != l2.size())
			throw new Error();
		
		int count = 0;

		Iterator<?> it1 = l1.iterator();
		Iterator<?> it2 = l2.iterator();

		while(it1.hasNext() && it2.hasNext()) {
			if( it1.next().equals(it2.next()))
				count++;
		}
		return count;
	}
}
