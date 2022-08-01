public class Main{
	public static void main(String[] args) {
		class Test {
			public String nome;
			Test(String n){nome = n;}
			@Override
			public String toString() {
				return nome;
			}
		}

		Test t1 = new Test("t1");
		Test t2 = new Test("t2");
		Test t3 = new Test("t3");
		Test t4 = new Test("t4");
		Test t5 = new Test("t5");
		
		Shop<Test> s = new Shop<>();
		
		new Thread(){
			public void run() {
				Test t = s.buy(1);
				System.out.println(t);
			};
		}.start();
		
		s.sell(t1, 5);
		s.sell(t2,10);
		s.sell(t3,15);
		s.sell(t4,20);
		s.sell(t5,25);

		Test t = s.buy(15);
		System.out.println(t);
		s.sell(t1,0);
		System.out.println(s);
	}
}