public class Main{
	public static void main(String[] args) {
		periodicJob(() -> {System.out.println("ciao");},2000);
		while(!Thread.currentThread().isInterrupted()){
			System.out.println("Porco Dio");
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				return;
			}
		}
	}
	public static void periodicJob(Runnable r, long millis){
		new Thread(){
			@Override
			public void run() {
				while(!Thread.currentThread().isInterrupted()){
					new Thread(r).start();
					try{
						Thread.sleep(millis);
					} catch (Exception e){
						return;
					}
				}
			}
		}.start();
	}
}