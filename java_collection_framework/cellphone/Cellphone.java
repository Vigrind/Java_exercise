import java.util.HashSet;
import java.util.Set;

public class Cellphone{
	private static Set<Cost> cost = new HashSet<>();
	private String provider;
	private String numCell;

	private static class Cost{
		private String firstProvider;
		private String secondProvider;
		private Double constCall;

		public Cost(String fProvider, String sProvider, Double cst){
			firstProvider = fProvider;
			secondProvider = sProvider;
			constCall = cst;
		}

		@Override
		public int hashCode() {
			return firstProvider.hashCode() ^ secondProvider.hashCode() ^ constCall.hashCode();
		}
	}

	public Cellphone(String prov, String num){
		provider = prov;
		numCell = num;
	}

	public static void setCost(String fProvider, String sProvider, Double cst){
		cost.add(new Cost(fProvider,sProvider,cst));
	}

	public double getCost(Cellphone cel, int min){
		double efctvConst = 0;
		for (Cost c : cost) {
			if(c.firstProvider.equals(provider) && c.secondProvider.equals(cel.provider)){
				efctvConst = min * c.constCall;
				return efctvConst;
			}
		}
		throw new IllegalArgumentException();
	}
}