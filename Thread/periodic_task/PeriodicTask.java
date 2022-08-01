public class PeriodicTask {
	private volatile long countMill = 0;
	private Runnable r;
	private long time;

	public PeriodicTask(Runnable run, long t){
		r = run;
		time = t;
		startTask();
	}

	private void startTask(){
		new Thread(){
			public void run() {
				while(!Thread.currentThread().isInterrupted()){
					countMill = countMill + time;
					r.run();
					try {
						sleep(time);
					} catch (InterruptedException e) {
						System.out.println(e);
					}
				}
			};
		}.start();
	}

	public long getTotalTime(){
		return countMill;
	}
}
