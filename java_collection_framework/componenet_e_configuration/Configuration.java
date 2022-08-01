import java.util.ArrayList;
import java.util.List;

public class Configuration {
	List<Component> conf = new ArrayList<>();
	
	public boolean add(Component c){
		for (Component elem : conf) {
			if(elem.isIncopatible(c)) return false;
		}
		return conf.add(c);
	}
}
