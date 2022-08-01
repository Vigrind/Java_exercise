public class Main {
	public static void main(String[] args) {
		SafeSet<String> a = new SafeSet<>();

		/*new Thread( 
				() -> {
					a.remove("Stronzo");
					a.add("ciao");
					a.add("pippo");
					a.add("Carmela");
		}).start();

		new Thread(
				()->{
					System.out.println(a.contains("ciao"));
					a.add("Marco");
		}).start();

		new Thread(
				()->{
					a.remove("Marco");
					System.out.println(a.contains("Pippo"));
					System.out.println(a.contains("Marco"));
		}).start();*/

		System.out.println(a.add("ciao"));
		System.out.println(a.add("mondo"));
		System.out.println(a.remove("ciao"));
		System.out.println(a.contains("ciao"));
		System.out.println(a.remove("ciao"));
		System.out.println(a.contains("ciao"));
	}
}
