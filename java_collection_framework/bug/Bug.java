import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Bug {
	private static Map<String,Set<Bug>> assigned = new HashMap<>();
	private static Set<Bug> unAssigned = new HashSet<>();

	private String name;
	private String devName;

	public Bug(String bugName){
		name = bugName;
		unAssigned.add(this);
	}

	public void assignTo(String nameDeveloper){
		if(unAssigned.contains(this))
			unAssigned.remove(this);
		
		if(assigned.containsKey(nameDeveloper)){
			assigned.get(nameDeveloper).add(this);
		}else{
			Set<Bug> bugs = new HashSet<>();
			bugs.add(this);
			assigned.put(nameDeveloper,bugs);
		}
		devName = nameDeveloper; // alla fine perchè è un set e se aggiungo devName cambia l'hashcode e non trova l'elemento giusto
	}

	public static Set<Bug> getUnassigned(){
		Set<Bug> ret = unAssigned;
		return ret;
	}

	public static Set<Bug> getAssignedTo(String nameDeveloper){
		Set<Bug> ret = assigned.get(nameDeveloper);
		return ret;
	}

	@Override
	public int hashCode() {
		if(devName != null)
			return name.hashCode() ^ devName.hashCode();
		else
			return name.hashCode();
	}

	@Override
	public String toString() {
		return name + " ,assigned to " + devName;
	}


}
