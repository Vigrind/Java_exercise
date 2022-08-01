import java.util.HashSet;
import java.util.Set;


public class GuessTheNumber {
	private int guessNumber;
	private final long duration;
	private volatile Boolean isFinish = false;
	private int maxDistance = Integer.MAX_VALUE;
	private Set<Thread> thread = new HashSet<>();

	public GuessTheNumber(int number,long milliSecond){
		guessNumber = number;
		duration = milliSecond;
		new Thread(){
			@Override
			public void run() {
				try {
					Thread.sleep(duration);
					synchronized(this){
						isFinish = true;
						notifyAll();
					}
				} catch (InterruptedException e) {}
			};
		}.start();
	}

	synchronized public Boolean guessAndWait(int i) throws InterruptedException{
		if(isFinish) return null;
	
		int result = Math.abs(guessNumber - i);
		while(!isFinish){
			wait();
		}

		if(result < maxDistance){
			maxDistance = result;
			thread.clear();
			thread.add(Thread.currentThread());
		
		}else if(result == maxDistance){
			thread.add(Thread.currentThread());
		}
		return thread.contains(Thread.currentThread());
	}
}
