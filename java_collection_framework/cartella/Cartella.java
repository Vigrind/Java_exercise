import java.util.Random;

public class Cartella {
	private int cart[][] = new int[3][5];
	
	public Cartella(){
		int i = 0;
		int j = 0;
		while(i < 3){
			while(j < 5){
				Random random = new Random();
				int randomNumber = random.nextInt(90) + 1;
				while(isPresent(i,randomNumber)){
					randomNumber = random.nextInt(90) + 1;
				}
				cart[i][j] = randomNumber;
				j++;
			}
			j = 0;
			i++;
		}
	}

	private boolean isPresent(int rig, int myNumb){
		for (int i = 0; i < 5; i++) {
			if((myNumb / 10) == (cart[rig][i] / 10)) return true;
		}
		return false;
	}

	public void print() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(cart[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
