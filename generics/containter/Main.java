public class Main{
	public static void main(String[] args) {
		Integer t = 20;
		Integer p = 40;
		Container<Employee> cont1 = new <String>Container<Employee>("ciao");
		Container<Employee> cont2 = new <Integer>Container<Employee>(t);
		Container<Manager> cont3 = new <Integer>Container<Manager>(p);

		//Container<Employee> cont4 = new <Object>Container<Employee>(new Object()); errore compilazione
		//Container<Person> cont5 = new <Integer>Container<Person>(new Integer(42)); errore compilazione

	}
}