public class Main{
	public static void main(String[] args) {
		SharedCounter s = new SharedCounter();
		s.decr();
		s.incr();
		new Thread(()->{s.decr();}).start();
		new Thread(()->{s.decr();}).start();
		new Thread(()->{s.incr();}).start();
		new Thread(()->{s.incr();}).start();
		new Thread(()->{try{s.waitForValue(3);}catch(InterruptedException e){}}).start();
		new Thread(()->{s.incr();}).start();
		new Thread(()->{s.incr();}).start();
		new Thread(()->{try{s.waitForValue(2);}catch(InterruptedException e){}}).start();
		new Thread(()->{s.incr();}).start();
		new Thread(()->{try{s.waitForValue(1);}catch(InterruptedException e){}}).start();
		new Thread(()->{s.decr();}).start();
		new Thread(()->{s.decr();}).start();
		new Thread(()->{try{s.waitForValue(0);}catch(InterruptedException e){}}).start();
		s.decr();
		s.decr();
		s.decr();
		s.decr();
		s.decr();
	}

}