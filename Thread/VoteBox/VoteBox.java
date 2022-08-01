public class VoteBox {
	private Thread t[];
	private int numT;
	private int count = 0;
	private int countTrue = 0;
	private int countFalse = 0;

	public VoteBox(int numThread){
		t = new Thread[numThread];
		numT = numThread;
	}

	public void vote(Boolean vot){
		synchronized(this){
			int occ = 0;
			t[count++] = Thread.currentThread();
			for (Thread thread : t) {
				if( Thread.currentThread() == thread){
					occ++;
					if(occ > 1)
						throw new Error();
				}
			}
			if(vot)
				countTrue++;
			else
				countFalse++;
			notifyAll();
		}
	}

	public Boolean waitForResult(){
		synchronized(this){
			while(count < numT){
				try {
					this.wait();
				} catch (InterruptedException e) {}
			}
			Boolean ret_val;
			if(countFalse < countTrue)
				ret_val = true;
			else
				ret_val = false;
			notifyAll();
			return ret_val;
		}
	}

	synchronized public Boolean isDone(){
		return count == numT;
	} 
}
