import java.util.Iterator;
import java.util.Set;

public class A extends B<Object>{
	private B<?> b;
	private String msg;
	public A(){
		b = new B<Object>(null);
		msg = B.<A>buildMessage(this);
	}

	public Set<? super Number> f(Set<Integer> set1, Set<String> set2){
		for(Integer n : b){
			
		}
	}
}

class B<T> implements Iterable<T>{
	public B(){}
	public B(Object o){}
	public static <T> String buildMessage(T o){String a = null; return a;}
	@Override
	public Iterator<T> iterator() {
		return null;
	}
}