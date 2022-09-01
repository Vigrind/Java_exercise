public class Cost{
	private String firstProvider;
	private String secondProvider;
	private double callCost;

	public Cost(String fProvider, String sProvider, double cost) {
		firstProvider = fProvider;
		secondProvider = sProvider;
		callCost = cost;
	}

	public double getCost() { return callCost;}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Cost) {
			Cost tmp = (Cost) obj;
			return (firstProvider.equals(tmp.firstProvider) && secondProvider.equals(tmp.secondProvider));
		}
		return false;
	}

	@Override
	public int hashCode() {
		return firstProvider.hashCode() ^ secondProvider.hashCode() ^ (int)callCost;
	}
}