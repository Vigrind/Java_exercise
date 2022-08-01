public class Range<T extends Comparable<T>>{
	private T max, min;
	public Range(T mMin, T mMax){
		min = mMin;
		max = mMax;
	}

	public boolean isInside(T x){
		return x.compareTo(min) >= 0 && x.compareTo(max) <= 0;
	}

	public boolean isOverlapping(Range<T> x){
		if(this.equals(x)) return true;
		if(max.compareTo(x.min) >= 0 && min.compareTo(x.max) <= 0 ) return true;
		return false;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Range)) return false;
		Range<?> tmp = (Range<?>)obj;
		return min.equals(tmp.min) && max.equals(tmp.max);
	}

	@Override
	public int hashCode() {
		return max.hashCode() ^ min.hashCode();
	}
}