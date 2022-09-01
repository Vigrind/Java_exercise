import java.util.HashMap;

public class Exchange {
	HashMap<String, Double> val = new HashMap<>();

	public void setPrice(String nameTitle, Double price){
		synchronized(this) {
			val.put(nameTitle,price);
			notifyAll();
		}
	}

	private class HelpThread extends Thread {
		private String nameTitle;
		private Double price;
		private Runnable r;
		private int type;

		public HelpThread(String nameTitle, Double price, Runnable r, int t) {
			this.nameTitle = nameTitle;
			this.price = price;
			this.r = r;
			this.type = t;
		}

		@Override
		public void run() {
			switch (type) {
				case 0:
					synchronized (Exchange.this) {
						while(price.compareTo(Exchange.this.val.get(nameTitle)) > 0) {
							try {
								Exchange.this.wait();
							} catch (InterruptedException e) {
								throw new RuntimeException(e);
							}
						}
						new Thread(r).start();
						Exchange.this.notifyAll();
					}
					break;

				case 1:
					synchronized (Exchange.this) {
						while(price.compareTo(Exchange.this.val.get(nameTitle)) < 0) {
							try {
								Exchange.this.wait();
							} catch (InterruptedException e) {
								throw new RuntimeException(e);
							}
						}
						new Thread(r).start();
						Exchange.this.notifyAll();
					}
					break;
				
					default:
					break;
			}
		}
	}

	public void addLowAlert(String nameTitle, Double price, Runnable r) {
		new HelpThread(nameTitle,price,r,1).start();
	}

	public void addHighAlert(String nameTitle, Double price, Runnable r) {
		new HelpThread(nameTitle, price, r,0).start();
	}

}
