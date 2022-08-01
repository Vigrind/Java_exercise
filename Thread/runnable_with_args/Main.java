import java.util.Collection;
import java.util.HashSet;
public class Main{
	public static void main(String[] args) {
		Collection<Integer> s = new HashSet<>();
		s.add(3); s.add(13); s.add(88);
		RunnableWithArgs<Integer> r = new RunnableWithArgs<Integer>() {
			@Override
			public void run(Integer s) {
				System.out.println(s/2);
			}
		};
		Thread t = new RunOnSet<Integer>(r, s);
		t.start();
		System.out.println(s);
	}
}

interface RunnableWithArgs<T> {
	public void run(T s);
}