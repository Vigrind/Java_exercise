import java.util.ArrayList;

public class Curriculum {
	
	private ArrayList<Job> jobs = new ArrayList<>();
	private String name;
	private int currCount = 0;

	public Curriculum(String n) {
		name = n;
	}

	public class Job {
		String job;
		Integer year;
		int count;

		private Job(String j,Integer y, int c ){
			job = j;
			year = y;
			count = c;
		}

		@Override
		public String toString() {
			return job + ": " + year;
		}

		public Job next(){
			int intRet = count + 1;
			Job ret = null;
			try {
				ret = jobs.get(intRet);
			} catch (Exception e) {}
			return ret;
		}
	}

	public Job addJob(String j, Integer y) {
		Job ret = new Job(j, y,currCount++);
		jobs.add(ret);
		return ret;
	}
}
