public class Main {
	public static void main(String[] args) {
		BigProblem bp = new BigProblem();
		bp.add(new RuntimeException("Problem A"));
		bp.add(new Exception("Problem B"));
		bp.add(new InterruptedException("Problem C"));
		System.out.println(bp.containsChecked());
		try {
			throw bp;
		}catch ( Throwable t ) {
			System.out.println(t.getMessage());
		}
	}
}
