public class Main {
	public static void main(String[] args) {
		SortedList<Integer> l = new SortedList<>();
		l.add(20); l.add(100); l.add(3); l.add(35); l.add(1);
		for (Integer i : l) {
			System.out.println(i);
		}
	}
}
