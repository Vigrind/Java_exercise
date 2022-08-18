
public class Pair<T1, T2> {
	public T1 first;
	public T2 second;

	public Pair(){}

	public Pair(T1 f, T2 s) {
		first = f;
		second = s;
	}

	@Override
	public String toString() {
		return "(" + first + ", " + second + ")";
	}
}
