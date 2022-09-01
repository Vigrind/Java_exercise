import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class SortedList <T extends Comparable<T>> implements Iterable<T>, Comparable<T>{
	LinkedList<T> list = new LinkedList<>();

	public boolean add(T val) {
		list.add(val);
		Collections.sort(list);
		return true;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			int i = 0;
			@Override
			public boolean hasNext() {
				if( i < list.size())
					return true;
				return false;
			}

			@Override
			public T next() {
				if(hasNext())
					return list.get(i++);
				return null;
			}
		};
	}

	@Override
	public int compareTo(T o) {
		return list.element().compareTo(o);
	}
}