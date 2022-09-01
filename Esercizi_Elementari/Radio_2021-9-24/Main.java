public class Main {
	public static void main(String[] args) {
		Radio r = new Radio();
		Radio.Channel rail = r.addChannel("Rai_Radio_Uno",89.3);
		Radio.Channel kk = r.addChannel("Radio_Kiss_kiss",101.4);
		Radio.Channel rmc = r.addChannel("Radio_Monte_Carlo",96.4);

		Radio.Channel test = r.nearest("Radio_Kiss_kiss");
		
		for (Radio.Channel c : r) {
			System.out.println(c);
		}
		System.out.println("\n"+test);
	}

}
