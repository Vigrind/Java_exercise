public class Main {
	public static void main(String[] args) {
		WiFi manager = new WiFi();
		WiFi.Network home = manager.addNetwork("Vodafone", -40.5);
		WiFi.Network hotel = manager.addNetwork("Hotel_Vesuvio", -53.5);
		WiFi.Network neighbor = manager.addNetwork("Casa_Esposito", -48.95);
		neighbor.updateStrength(-39.6);
		WiFi.Network x = manager.strongest();
		System.out.println(x);

		for(WiFi.Network n : manager) {
			System.out.println(n);
		}
	}
}
