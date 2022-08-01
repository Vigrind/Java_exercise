import java.util.HashSet;
import java.util.Set;


public class Type {
    private static Set<String> nameType = new HashSet<>();
    private String name;
	private String superTypeName;
    private Set<Type> type = new HashSet<>();

    public Type(String n) {
		if(nameType.contains(n)) throw new Error();
		this.name = n;
		type.add(this);
		nameType.add(name);
    }


    public Type(String n, Type t){
		if(nameType.contains(n)) throw new Error();
		this.name = n;
		superTypeName = t.name;
		type.add(t);
		type.add(this);
		for (Type elem : t.type) {
			type.add(elem);
		}
	}


    public boolean isSubtypeOf(Type t){
		return type.contains(t);
    }

    @Override
    public String toString(){
		return "Class " + name + " extends " + superTypeName;
    }

	@Override
	public int hashCode() {
		return name.hashCode();
	}
}