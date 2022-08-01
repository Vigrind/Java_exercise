public class PostOfficeQueue{
	//Object mutex[];
	boolean arr[];
	public PostOfficeQueue(int maxDesk){
		arr = new boolean[maxDesk];
		//mutex = new Object[maxDesk];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = true;
			//mutex[i] = new Object();
		}
	}

 /* 	public void deskStart(int desk){
		synchronized(mutex[desk]){
			arr[desk] = false;
		}
	}

	public void deskFinish(int desk){
		synchronized(mutex[desk]){
			arr[desk] = true;
		}
	}

	public String getFreeDesk(){
		for (int i = 0; i < arr.length; i++) {
			synchronized(mutex[i]){
				if(arr[i]) return "" + i;
			}
		}
		return "No desk aviable";
	}*/
	synchronized public void deskStart(int desk){
		arr[desk] = false;
	}

	synchronized public void deskFinish(int desk){
		arr[desk] = true;
		notifyAll();
	}

	synchronized public int getFreeDesk() {
		while(!Thread.currentThread().isInterrupted()){
			for (int i = 0; i < arr.length; i++) {
					if(arr[i]) return i;
			}
			try {
				wait();
			} catch (InterruptedException e) { System.out.println(e); }
		}
		return -1;
	} 

}