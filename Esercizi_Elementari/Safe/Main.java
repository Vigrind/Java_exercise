public class Main{
	public static void main(String[] args) {
		ResettableSafe s = new ResettableSafe(2381313, "L’assassino␣e’␣il␣maggiordomo.");
		System.out.println(s.open(887313));
		System.out.println(s.open(13012));
		System.out.println(s.changeKey(12,34));
		System.out.println(s.open(2381313));
		System.out.println(s.open(13012));

	}
}