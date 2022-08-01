public class Main {
	public static void main(String[] args) {
		Alarm a = new Alarm(5);
		a.anomalyStart();
		a.anomalyStart();
		a.anomalyEnd();
		new Thread(){
			public void run() {
				a.anomalyEnd();
			};
		}.start();
	}
}
