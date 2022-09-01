public class Main {
	public static void main(String[] args) {
		Cartella c = new Cartella();
		c.printCartella();
		int num = (int) (Math.random()*(90-1+1)+1);
		while(c.segna(num) != Cartella.Victory.AMBO) {
			num = (int) (Math.random()*(90-1+1)+1);
		}
		System.out.println(c.segna(num));
	}
}
