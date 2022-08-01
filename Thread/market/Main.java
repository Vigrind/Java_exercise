public class Main{
	public static void main(String[] args) {
		Market m = new Market();
		
		new Thread(()->{
			try {
				m.buy(10.0);
				System.out.println("Thread 1");
			} catch (Exception e) {
				//TODO: handle exception
			}
		}).start();

		new Thread(()->{
			try {
				m.sell(15.50);
				System.out.println("Thread 2");
			} catch (Exception e) {
				//TODO: handle exception
			}
		}).start();

		new Thread(()->{
			try {
				m.sell(12.0);
				System.out.println("Thread 3");
			} catch (Exception e) {
				//TODO: handle exception
			}
		}).start();
		
		new Thread(()->{
			try {
				m.buy(13.0);
				System.out.println("Thread 4");
			} catch (Exception e) {
				//TODO: handle exception
			}
		}).start();

		new Thread(()->{
			try {
				m.buy(11.0);
				System.out.println("Thraed 5");
			} catch (Exception e) {
				//TODO: handle exception
			}
		}).start();

		new Thread(()->{
			try {
				m.sell(9.50);
				System.out.println("Thread 6");
			} catch (Exception e) {
				//TODO: handle exception
			}
		}).start();
	}
}