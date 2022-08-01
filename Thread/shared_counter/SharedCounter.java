public class SharedCounter {
	private int count = 0;
	
	synchronized public void incr(){
		count++;
		System.out.println("il contatore è al valore: " + count);
		notifyAll();
	}

	synchronized public void decr(){
		if(count > 0){
			count--;
			System.out.println("il contatore è al valore: " + count);
		}
		notifyAll();
	}

	synchronized public void waitForValue(int val) throws InterruptedException {
		while(val != count){
			wait();
		}
		System.out.println("Preso il valore " + val);
	}
}
