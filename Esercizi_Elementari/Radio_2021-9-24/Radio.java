import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Arrays;
import java.util.Comparator;

public class Radio implements Iterable<Radio.Channel> {
	Set<Channel> channels = new HashSet<>();
	
	public Radio(){}

	public Channel addChannel(String channelName, Double frequence) {
		Channel c = new Channel(channelName,frequence);
		if(!channels.contains(c)) {
			channels.add(c);
			return c;
		}
		return null;
	}
	
	public Channel nearest (String channName) {
		Double guessChan = 0.0;
		Channel ret = null;
		
		for (Channel c : channels) {
			if(c.clName.equals(channName))
			guessChan = c.freq.doubleValue();
		}
		
		Double minDistance = 300.0;
		for (Channel c : channels) {
			if(!c.clName.equals(channName)) {
				Double tmp = Math.abs(guessChan - c.freq);
				if(tmp.compareTo(minDistance) < 0) {
					minDistance = tmp.doubleValue();
					ret = c;
				}
			}
		}
		
		return ret;
	}

	@Override
	public Iterator<Channel> iterator() {
		return new Iterator<Channel>() {
			int i = 0;
			Channel [] arr = Arrays.copyOf(channels.toArray(), channels.size(),Channel[].class);
			@Override
			public boolean hasNext() {
				if(i == 0 && i < arr.length) {
					Arrays.sort(arr,Channel.cpByName);
					return true;
				}
				if(i < arr.length)
					return true;
				return false;
			}
		
			@Override
			public Channel next() {
				if(hasNext())
					return arr[i++];
				else throw new NoSuchElementException();
			}
		};
	}
	
	public class Channel {
		private String clName;
		private Double freq;

		private Channel(){};

		private Channel(String channelName, Double frequence) {
			this.clName = channelName;
			this.freq = frequence;
		}

		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Channel) {
				Channel cmp = (Channel) obj;
				return this.freq.equals(cmp.freq);
			}
			return false;
		}

		public static final Comparator<Channel>  cpByName = new Comparator<>() {
			public int compare(Channel o1, Channel o2) {
				return -(o1.clName.compareTo(o2.clName));
			};
		};

		@Override
		public int hashCode() {
			return clName.hashCode() ^ freq.hashCode();
		}

		@Override
		public String toString() {
			return "Channel: " + clName + " - Frequence: " + freq;
		}

	}

}