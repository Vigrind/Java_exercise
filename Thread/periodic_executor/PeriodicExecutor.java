
public class PeriodicExecutor{
	private final Thread[] threads;
	
	public PeriodicExecutor(int numThread){
		threads = new Thread[numThread];
		for (int i = 0; i < numThread; i++) {
			threads[i] = new Thread();
		}
	}
	
	public void addTask(Runnable r, long tempo){//Da aggiustare
		new Thread(){
			@Override
			public void run(){
				while(!Thread.currentThread().isInterrupted()){
					synchronized (threads){
						boolean exit = false;
						for(int i = 0; i < threads.length; i++){
							exit = false;
							if(!threads[i].isAlive()){
								threads[i] = new Thread(){
									@Override
									public void run(){
										r.run();
										try{ Thread.sleep(tempo); } catch (InterruptedException e){}
									}
								};
								threads[i].start();
								try {threads[i].join();} catch (InterruptedException e) {e.printStackTrace();}
								exit = true;
								break;
							}
						}
						if(!exit){
							System.out.println("Sono in wait");
							try{threads.wait();}catch (InterruptedException e){}
						}
						threads.notifyAll();
					}
				}
			}
		}.start();
	}
}