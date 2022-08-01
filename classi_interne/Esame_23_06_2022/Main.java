 public class Main{
	public static void main(String[] args) {
		A a5 = new A(5);
		A a10 = new A(10);
		A.B b = a10.new B();
		A.B c = a10.new B();
		Runnable x = a5.makeObj("Hello");
		Object y = a5.makeObj("Bye");
		x.run();
	}
 }

 class  A{
	private final int id;
	public A(int id){
		this.id = id;
	}

	public class B {
		private int id2 = id+1;
	}

	public Runnable makeObj(String msg){
		return () ->{
			int c = 3;
			System.out.println(id + "" + msg + c);
		};
	}
}