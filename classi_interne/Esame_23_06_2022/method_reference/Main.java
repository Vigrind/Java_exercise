import method_reference.Account;

public class Main {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			Runnable a = new Runnable() {
				@Override
				public void run() {}
			};
			System.out.println(a);
		}

		final int j = 0;
		for (int i = 0; i < 5; i++) {
			Runnable r = () ->{
				System.out.println(j);
			};
			System.out.println(r);
		}
	}
}
