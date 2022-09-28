public class A {
	public int val;
	public static boolean flag = true;

	public A(int val) {
		this.val = val;
		flag = !flag;
	}

	private class B {
		private int secret;
		public B() { val++; }
	}

	public Runnable makeTask(String msg) {
		return () -> System.out.println(msg);
	}

	public static void main(String[] args) {
		A a1 = new A(10);
		A a2 = new A(20);
		A.B b1 = a1.new B();
		A.B b2 = a2.new B();
		Object c = a1.makeTask("Bla_Bla");
	}
}