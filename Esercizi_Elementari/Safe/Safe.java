public class Safe {
	protected String secret;
	protected int comb;
	protected int count = 0;

	public Safe(int combination, String sec){
		secret = sec;
		comb = combination;
	}

	public String open(int num){
		if(count >= 3) throw new IllegalAccessError();
		if(num == comb) {
			count = 0;
			return secret; 
		}else {
			count++;
			return null;
		}
	}
}
