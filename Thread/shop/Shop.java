import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Shop<T> {
	private Map<T,Integer> sellObjects = new HashMap<>();

	synchronized public void sell(T object, int price){
		sellObjects.put(object,price);
		notifyAll();
	}

	synchronized public T buy(int offer){
		T ret = null;
		Boolean exit = false;
		while(!Thread.currentThread().isInterrupted()) {
			for (Entry<T,Integer> entry: sellObjects.entrySet()) {
				if(entry.getValue() <= offer){
					exit = true;
					ret = entry.getKey();
					break;
				}
			}
			if(exit) {
				sellObjects.remove(ret);
				break;
			}
			try {
				wait();
			} catch (InterruptedException e){}
		}
		//notifyAll();
		return ret;
	}

	@Override
	synchronized public String toString() {
		return sellObjects.toString();
	}
}
