package Esercizio_0;

public class A {
	private int x = 30;
	
	public int ritornaX(){return x;}

	private class B {
		private int y;
	}

	public static class C extends A {
		private int z;
	}

	public Object f(final int n) {
		class Locale {
			private int m = n;
		}
		return new Locale();
	}
	public static void main(String[] args) {
		A a = new A();
		B b = a.new B();
		A.C c = new A.C();
		Object o = a.f(7);
		Test t = new Test();
		System.out.println(t.ritornaX());
		Thread principale = Thread.currentThread();
		System.out.println(principale);
		System.out.println("ciao");
	}
}

class Test extends A {
	private int c = ritornaX();
	public void stampa(){
		System.out.println();
	}
}