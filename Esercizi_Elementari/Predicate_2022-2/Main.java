import java.util.Comparator;

public class Main {
	public static void main(String[] args) {
		//Da testare ma dovrebbe funzionare

		A a1 = new A();
		A a2 = new A.B();
		A.C c1 = a1.new C();
		A.C c2 = a2.new C();
		System.out.println("o");
	}

	public static <S> Comparator<S> combine(Comparator<? super S> a, Comparator<? super S> b){
		return new Comparator<S>() {
			@Override
			public int compare(S o1, S o2) {
				if(a.compare(o1, o2) < 0) {
					return a.compare(o1, o2);
				}
				return b.compare(o1, o2);
			}
		};
	}
}

class A {
	public int n = 0;
	private A myself = this;
	public static class B extends A{
		int i = 1;
	}
	public class C {
		int j = 2;
	}
}