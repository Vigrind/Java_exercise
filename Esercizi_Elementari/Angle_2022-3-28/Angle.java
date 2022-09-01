public class Angle implements Comparable<Angle> {

	protected Double ang;
	private Angle(){}
	private static Rectangle retc = new Rectangle(90.0);

	public static Angle of(Double val){
		if(val.compareTo(90.0) < 0)
			return new Acute(val);
		if(val.compareTo(90.0) > 0)
			return new Octuse(90.0);
		else
			return retc;
	}

	private static class Rectangle extends Angle {
		private Rectangle(Double ang){
			this.ang = ang;
		}
	}

	public static class Octuse extends Angle{
		public Octuse(Double ang) {
			this.ang = ang;
		}
	}

	public static class Acute extends Angle{
		public Acute(Double ang){
			this.ang = ang;
		}
	}
	@Override
	public int compareTo(Angle o) {
		return ang.compareTo(o.ang);
	}

}