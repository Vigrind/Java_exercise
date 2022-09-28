public class Main {
	public static void main(String[] args) throws InterruptedException {
		Scheduler s = new Scheduler();
		s.addTask( () -> { System.out.println("world"); }, 10 );
		s.addTask( () -> { System.out.print("hello "); }, 20 );
		s.addTask( () -> { try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();} } , 15);

		s.start();
		Thread.sleep(1000);
		s.stop();
	}
}
