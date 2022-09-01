public class Main {
	public static void main(String[] args) {
		Exchange borsa = new Exchange();
		borsa.setPrice("MaxiCom", 10.56);
		borsa.setPrice("MegaCorp", 18.2);
		borsa.setPrice("SuperMarkt", 3.91);

		borsa.addLowAlert("MegaCorp", 17.5, () -> {System.out.println("MegaCorp lowAlert");});
		borsa.addHighAlert("MaxiCom", 12.0, () -> {System.out.println("MaxiCom highAlert 12");});
		borsa.addHighAlert("MaxiCom", 20.0, () -> {System.out.println("MaxiCom highAlert 20");});
		borsa.setPrice("MaxiCom", 12.3);
		borsa.setPrice("MaxiCom", 23.0);
	}
}