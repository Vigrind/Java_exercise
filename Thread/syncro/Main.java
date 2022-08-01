public class Main{
	public static void main(String[] args) {
		Runn r = new Runn();
		//Runn r2 = new Runn();
		//Runn r3 = new Runn();

		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		Thread t3 = new Thread(r);

		t1.start();
		r.ciao();
		t2.start();
		t3.start();
	}
}