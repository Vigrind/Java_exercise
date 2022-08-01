public class Main{
	public static void main(String[] args) {
		VoteBox b = new VoteBox(3);
		
		new Thread(){
			public void run() {
				b.waitForResult();
				System.out.println(b.isDone());
			};
		}.start();
		
		b.vote(true);
		System.out.println(b.isDone());
		
		new Thread() {
			public void run() {
				b.vote(false);
			};
		}.start();
		
		new Thread() {
			public void run() {
				b.vote(true);
			};
		}.start();

	}
}