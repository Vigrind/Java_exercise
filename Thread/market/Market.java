import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class Market {
	private List<Double> buy = new ArrayList<>();
	private List<Double> sell = new ArrayList<>();

	ArrayBlockingQueue<Double> sellOff = new ArrayBlockingQueue<>(30);

	public void buy (double price){
		Boolean exit = false;
		synchronized(this){
			buy.add(price);
			while(!Thread.currentThread().isInterrupted()){
				notifyAll();
				for (Double s : sell) {
					if(s.compareTo(price) < 0){
						sell.remove(s);
						exit = true;
						break;
					}
				}
				if(exit) break;
				try {
					wait();
				} catch (Exception e) {}
			}
		}
	}

	public void sell(double price){
		Boolean exit = false;
		synchronized(this){
			sell.add(price);
			while(!Thread.currentThread().isInterrupted()){
				notifyAll();
				for (Double b : buy) {
					if(b.compareTo(price) > 0){
						buy.remove(b);
						exit = true;
						break;
					}
				}
				if(exit) break;
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
