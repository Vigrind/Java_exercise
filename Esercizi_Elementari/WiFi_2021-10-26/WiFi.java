import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class WiFi implements Iterable<WiFi.Network>{
	Set<Network> networks = new HashSet<>();

	public Network addNetwork(String ssid, double strength) {
		Network net = new Network(ssid, strength);
		if(networks.add(net))
			return net;
		return null;
	}

	@Override
	public Iterator<WiFi.Network> iterator() {
		return new Iterator<WiFi.Network> () {
			Network [] arr = Arrays.copyOf(networks.toArray(), networks.size(),Network[].class);
			int i = 0;

			@Override
			public boolean hasNext() {
				if(i == 0 && arr.length != 0) {
					Arrays.sort(arr,Network.comByIntensity);
					return true;
				}
				if(i < arr.length)
					return true;
				return false;
			}

			@Override
			public WiFi.Network next() {
				if(hasNext())
					return arr[i++];
				throw new NoSuchElementException();
			}
		};
	}

	public Network strongest() {
		Network [] arr = Arrays.copyOf(networks.toArray(), networks.size(), Network[].class);
		double max = arr[0].signal;
		Network ret = arr[0];
		for(int i = 0; i < arr.length; ++i) {
			if(arr[i].signal > max) {
				max = arr[i].signal;
				ret = arr[i];
			}
		}
		return ret;
	}

	public class Network {
		private String networkName;
		private double signal;
		
		protected Network(String name, double strength) {
			networkName = name;
			signal = strength;
		}

		public static final Comparator<Network> comByIntensity = new Comparator<>(){
			public int compare(Network o1, Network o2) {
				if(o1.signal < o2.signal)
					return -1;
				else if (o1.signal > o2.signal)
					return 1;
				else
					return 0;
			};
		};

		public void updateStrength(double newStrength) {
			for(Network n : networks) {
				if(n.networkName.equals(this.networkName))
					n.signal = newStrength;
			}
		}

		@Override
		public int hashCode() {
			return networkName.hashCode() ^ (int)signal;
		}

		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Network) {
				Network tmp = (Network) obj;
				return this.networkName.equals(tmp.networkName);
			}
			return false;
		}

		@Override
		public String toString() {
			return networkName + " (" + signal + ")";
		}
	}
}