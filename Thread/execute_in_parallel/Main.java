import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main{
	public static void main(String[] args) {
		Runnable r1 = () ->{
			try {
				Thread.sleep(2000);
			} catch (Exception e) {}
			System.out.println("sono r1");
		};
		Runnable r2 = () ->{System.out.println("sono r2");};
		Runnable r3 = () ->{System.out.println("sono r3");};

		Runnable r[] = new Runnable[3];
		r[0] = r1;
		r[1] = r2;
		r[2] = r3;

		try {
			Main.executeInParallel(r, 5);
		} catch (Exception e) {}
	}

	public static void executeInParallel (Runnable run[], int k) throws InterruptedException{
		BlockingQueue<Thread> buff = new ArrayBlockingQueue<>(k);
		for(Runnable r : run){
			Thread t = new Thread(){
				public void run() {
					r.run();
					buff.remove(this);
				};
			};
			buff.put(t);
			t.start();
		}
	}
}
