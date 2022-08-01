public class ResettableSafe extends Safe{

	public ResettableSafe(int combination, String sec) {
		super(combination, sec);
	}

	public boolean changeKey(int old_num, int new_num){
		if(count >= 3) throw new IllegalAccessError();
		
		if(old_num == comb){
			count = 0;
			return true;
		}else{
			count++;
			return false;
		}
	}
	
}
