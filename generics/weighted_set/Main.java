import java.util.ArrayList;
import java.util.List;

public class Main{
	public static void main(String[] args) {
		/*WeightedSet<Object> set = new BasicWeightedSet2<>();
		set .add(Double.valueOf(3.14), 100);
		set .add(new Object(), 5);
		set .add("Skylar", 50);
		set .add("Jesse", 5);
		System.out. println ( set );
		WeightedSet<Object> set10 = set.atLeast(10);
		System.out. println (set10);
		set .add("Walter", 60);
		System.out. println ( set );
		System.out. println (set10);

		WeightedSet<Object> set11 = set10.atLeast(1);
		System.out.println(set11);*/
		/*A a1 = new A(null);
		A a2 = new A(a1);
		A.B b = a1.new B();
		Object x = a1.makeObj(42);
		A.B y = (A.B) a2.makeObj(42);	*/
		ArrayList<Integer> a1 = new ArrayList<>();
		Main.test(a1);
	}
	public static void test(List<? super Integer> l1){}
}


class A {
	int cacca;
	private A other;
	public A(A other) {
		this . other = other;
	}
	public class B {
	private static int counter = 0;
	private int id = counter++;
	}
	public Object makeObj(int val) {
		return new B() {
			private int j = val;
		};
	}
	}