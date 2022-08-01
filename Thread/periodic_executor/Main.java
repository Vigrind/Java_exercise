public class Main{
	public static void main(String[] args) {
		PeriodicExecutor exec = new PeriodicExecutor(1);
		Runnable r1 = () -> {System.out.println("sono r1");}, r2 = () -> {System.out.println("sono r2");}, r3 = () -> {System.out.println("sono r3");};
		exec.addTask(r1, 5000);
		exec.addTask(r2, 5000);
		exec.addTask(r3, 5000);
	}
}