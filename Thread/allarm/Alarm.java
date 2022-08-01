public class Alarm{
	Help h;
	public Alarm(long t){
		h = new Help(t);
	}

	public void anomalyStart(){
		try {
			h.t.start();
		} catch (Exception e) {
			return;
		}
	}

	public void anomalyEnd(){
		h.t.interrupt();
	}

	private class Help {
		Thread t;
		public Help(long millsecond){
			t = new Thread(){
				@Override
				public void run() {
					try {
						Thread.sleep(millsecond * 1000);
					} catch (InterruptedException e) {
						System.out.println(e);
						return;
					}
					System.out.println("Allarme!");
				}
			};
		}
	}


}