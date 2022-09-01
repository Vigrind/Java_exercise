public class Main {
	public static void main(String[] args) {
		Studente.Triennale.setPrefisso("N86");
		Studente.Magistrale.setPrefisso("N97");

		Object luca1 = new Studente.Triennale("Luca","004312");
		Object luca2 = new Studente.Triennale("Luca","004312");
		Object anna1 = new Studente.Triennale("Anna","004312");
		Object anna2 = new Studente.Magistrale("Anna","004312");

		System.out.println(luca1.equals(luca2));
		System.out.println(anna1.equals(anna2));
		System.out.println(anna1);
	}
}