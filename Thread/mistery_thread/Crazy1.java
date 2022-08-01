public class Crazy1 {
	public static void main(String[] args) throws InterruptedException {
		/*final Object x = new Object(), y = new Object();
		Thread t1 = new Thread(() -> {
			synchronized (x) {
				try {
					x.wait();
					synchronized (y) {
						y.notify();
					}
				} catch (Exception e) {
					return;
				} finally {
					System.out.println("t1");
				}														//t2 main t1 / main t1 t2 -> main t2 t1 /
			}
		});
		Thread t2 = new Thread(() -> {
			synchronized (y) {
				try {
					y.wait();
				} catch (Exception e) {
					return;
				} finally {
					System.out.println("t2");
				}
			}
		});
		t1.start();
		t2.start();
		synchronized (y) {
			y.notify();
		}
		System.out.println("main");*/
	
		/*Short s = 10;
		Integer a = 10;
		Float f = new Float(10f);
		Number aa = a;
		Object o = f;
		System.out.println( (Object)s == (Object)a );
		System.out.println( (s+1) == (a+1) );
		System.out.println(aa == a);
		System.out.println(a.getClass().equals(aa.getClass()));
		System.out.println(o.getClass().equals( f .getClass()));
		System.out.println(o.getClass().equals(Object.class));*/


		Short s = 10;
		Double b = 11.0;
		Integer a = 10;
		Number bb = b;
		Number aa = a;
		System.out.println(aa == a);
		System.out.println(a.getClass().equals(aa.getClass()));
		System.out.println(aa.getClass().equals(bb.getClass()));
		Object o = s;
		System.out.println(o.getClass().equals(Short.class));
		System.out.println( ((Object) s) == ((Object) a) );
	}
}
