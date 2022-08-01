import java.util.Collection;

public class RunOnSet<T> extends Thread {
	RunnableWithArgs<T> r;
	Collection<T> s;

	public RunOnSet(RunnableWithArgs<T> _r, Collection<T> _s){
		s = _s;
		r = _r;
	}

	@Override
	public void run() {
		for ( T x : s) {
			r.run(x);
		}
	}
}