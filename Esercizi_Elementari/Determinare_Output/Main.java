import java.util.Comparator;

public class Main {
	@SuppressWarnings("removal")
	public static void main(String[] args) {
		Short s = 10;
		Integer a = 10;
		Float f = new Float(10F);
		Number aa = a;
		Object o = f;

		/*
		* getClass() controlla il tipo effettivo dell'ogetto non il tipo dichairato
		*/
		System.out.println((Object)s == (Object)a); //NO
		System.out.println((s+1) == (a+1)); //SI
		System.out.println(aa == a); // SI
		System.out.println(a.getClass().equals(aa.getClass())); //SI
		System.out.println(o.getClass().equals( f .getClass())); //SI
		System.out.println(o.getClass().equals(Object.class)); //NO

	}

	public static <T> Comparator<T> combine(Comparator<T> a, Comparator<T> b){
		Comparator<T> comp = new Comparator<T>() {
			@Override
			public int compare(T o1, T o2) {
				if(a.compare(o1, o2) != 0)
					return a.compare(o1, o2);
				else
					return b.compare(o1, o2);
			}
		};
		return comp;
	}
}