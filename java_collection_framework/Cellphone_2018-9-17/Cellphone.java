import java.util.HashSet;
import java.util.Set;

public class Cellphone {
	private String provider;
	private String phoneNum;
	private static Set<Cost> costCall = new HashSet<>();
	
	public Cellphone(String nomeProvider, String phone) {
		provider = nomeProvider;
		phoneNum = phone;
	}

	public static void setCost(String firstProvider, String secondProvider, double cost) {
		costCall.add(new Cost(firstProvider,secondProvider,cost));
	}

	public double getCost(Cellphone cel, int min){
		double efctvCost = 0;
		Cost costToFind = new Cost(provider, cel.provider, 0);
		for (Cost cost : costCall) {
			if(cost.equals(costToFind)){
				efctvCost = min*cost.getCost();
				return efctvCost;
			}
		}
		throw new IllegalArgumentException();
	}


}