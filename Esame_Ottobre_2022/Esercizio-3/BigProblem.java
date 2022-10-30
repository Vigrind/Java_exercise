import java.util.ArrayList;
import java.util.List;

public class BigProblem extends RuntimeException{
	List<Exception> classExceptions = new ArrayList<>();

	public void add(Exception ex) {
		classExceptions.add(ex);
	}

	@Override
	public String getMessage() {
		String ret = new String();
		for (Exception e : classExceptions) {
			ret = ret + e.getMessage() + '\n';
		}
		return ret;
	}

	public boolean containsChecked() {
		boolean ret = false;
		for ( Exception e  : classExceptions) {
			if(!(e instanceof RuntimeException)) {
				ret = true;
				break;
			}
		}
		return ret;
	}
}
