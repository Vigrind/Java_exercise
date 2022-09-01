import java.util.ArrayList;

public class RotatingList<T> {
	ArrayList<T> list = new ArrayList<>();
	
	public boolean add(T val) {
		return list.add(val);
	}

	public void rotateRight() {
		T tmp = list.get(list.size() - 1);
		for(int i = list.size() - 1; i > 0; i--) {
			list.set(i,list.get(i-1));
		}
		list.set(0,tmp);
	}

	public void rotateLeft() {
		T tmp = list.get(0);
		for(int i = 0; i < list.size() - 1; i++) {
			list.set(i,list.get(i+1));
		}
		list.set(list.size() - 1, tmp);
	}

	@Override
	public String toString() {
		return list.toString();
	}
}