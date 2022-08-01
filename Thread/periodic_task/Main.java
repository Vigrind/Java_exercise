import javax.sound.midi.Soundbank;

public class Main{
	public static void main(String[] args) {
		Runnable r = new Runnable() {
			public void run() {
				System.out.println("Ciao!");
			}
		};
		PeriodicTask a = new PeriodicTask(r, 2000);
		
	}
}