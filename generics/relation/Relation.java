import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Relation<T,P> {
	List<Node> t = new ArrayList<>();
	
	private class Node{
		T data1;
		P data2;
		public Node(T first,P second){
			data1 = first;
			data2 = second;
		}
	}

	public void put(T first, P second){
		t.add(new Node(first, second));
	}

	public void remove(T first, P second){
		Iterator<Node> iter = t.iterator();
		while(iter.hasNext()){
			Node tmp = iter.next();
			if(tmp.data1.equals(first) && tmp.data2.equals(second))
				iter.remove();
		}
	}

	public Set<P> image(T object){
		Set<P> ret = new HashSet<>();
		for (Node node : t) {
			if(node.data1.equals(object))
				ret.add(node.data2);
		}
		return ret;
	}

	public Set<T> preImage(P object){
		Set<T> ret = new HashSet<>();
		for (Node node : t) {
			if(node.data2.equals(object))
				ret.add(node.data1);
		}
		return ret;
	}
}
