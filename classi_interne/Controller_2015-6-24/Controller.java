import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Controller {
	HashMap<Function,Boolean> functions = new HashMap<>();
	
	public Function addFunction(String s) {
		Function addF = new Function(s);
		functions.put(addF,false);
		return addF;
	}

	public void printOn(){
		Set<Function> f = functions.keySet();
		for (Function x : f) {
			if(functions.get(x) == true)
				System.out.println(x);
		}
	}
	
	public class Function {
		private String name;
		private Set<Function> incompatible = new HashSet<>();
		public Function(String s) {
			name = s;
		}

		public void turnOn() {
			for (Function x : incompatible) {
				functions.replace(x, false);
			}
			functions.replace(this, true);
		}

		public void turnOff() {
			functions.replace(this, false);
		}

		public void setIncompatible(Function f){
			incompatible.add(f);
			f.incompatible.add(this);
		}

		@Override
		public String toString() {
			return name;
		}
	}
}
