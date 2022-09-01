import java.util.HashMap;
import java.util.Map;

public class Cartella {
	public enum Victory {
		AMBO,
		TERNO,
		QUATERNA,
		CINQUINA,
		TOMBOLA
	}
	private int [][] c = new int[3][5];
	Map<Integer,Integer> point = new HashMap<>();

	public Cartella() {
		createCartella();
		createPointMap();
	}

	private void createPointMap() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				point.put(c[i][j],Integer.valueOf(0));
			}
		}
	}
	public Victory segna(int val) {
		if(point.get(val) != null) {
			point.put(val,point.get(val)+1);
			if(point.get(val).intValue() == 2)
				return Victory.AMBO;
	
			else if(point.get(val).intValue() == 3)
				return Victory.TERNO;
			
			else if(point.get(val).intValue() == 4)
				return Victory.QUATERNA;
	
			else if(point.get(val).intValue() == 5)
				return Victory.TOMBOLA;
		}
		return null;
	}


	private int createRandomNumber() {
		int max = 90, min = 1;
		int ret =(int) (Math.random()* (max-min+1) + min);
		return ret;
	}

	private void createCartella() {
		for(int i = 0; i < 3; ++i) {
			for(int j = 0; j < 5; ++j) {
				int insertNum = createRandomNumber();
				while(existsDecimal(i, insertNum)) {
					insertNum = createRandomNumber();
				}
				c[i][j] = insertNum;
			}
		}
		
	}

	private boolean existsDecimal(int numRow,int insertNumber) {
		int decNum = decimal(insertNumber);
		for(int i = numRow; i < 5; ++i) {
			int exst = decimal(c[numRow][i]);
			if(exst == decNum)
				return true;
		}
		return false;
	}

	private int decimal(int num) {
		int lastDigit = 0;
		if(num >= 10) {
			while(num > 0) {
				lastDigit = num % 10;
				num = num / 10;
			}
		} else if(num == 0) return -1;
		return lastDigit;
	}

	public void printCartella() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(c[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
}