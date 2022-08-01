public class Runn implements Runnable {
	//private static Object x = new Object();
	private static int counter = 0;
	@Override
	public void run() {
		synchronized(this) {
			ciao();
			counter++;
			System.out.println(counter);
		}
	}

	synchronized public void ciao(){}
}