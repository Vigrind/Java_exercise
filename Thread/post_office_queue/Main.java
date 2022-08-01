public class Main {
	public static void main(String[] args) {
		PostOfficeQueue poq = new PostOfficeQueue(5);
		poq.deskStart(0);
		poq.deskStart(1);
		poq.deskStart(2);
		poq.deskStart(3);
		poq.deskStart(4);
		new Thread( () -> poq.deskFinish(4) ).start();
		System.out.println(poq.getFreeDesk());
	}
}
