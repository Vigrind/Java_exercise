import java.util.HashSet;
import java.util.Set;

public class Component {
	Type tp;
	String name;
	Set<String> incompatible = new HashSet<>();

	public Component(Type t, String description){
		tp = t;
		name = description;
	}

	public void setIncompatible(Component c){
		incompatible.add(c.name);
		c.incompatible.add(name);
	}

	public boolean isIncopatible(Component c){
		return incompatible.contains(c.name) || tp.toString().equals(c.tp.toString());
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Component)) return false;
		Component tmp = (Component)obj;
		return name.equals(tmp.name);
	}
}
