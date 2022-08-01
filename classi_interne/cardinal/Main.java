public class Main{
	public static void main(String[] args) {
		System.out.println((27+16)%32);
	}
}


enum Cardinal{
	N(1),
	NNE(3),
	NE(5),
	ENE(7),
	E(9),
	ESE(11),
	SE(13),
	SSE(15),
	S(17),
	SSO(19),
	SO(21),
	OSO(23),
	O(25),
	ONO(27),
	NO(29),
	NNO(31);
	int val;
	Cardinal(int v){
		val = v;
	}

	public Boolean isOpposite(Cardinal o){
		return (val+16)%32 == o.val;
	}

	public Cardinal mix(Cardinal o) throws Exception{
		if(isOpposite(o)) throw new Exception();
		
	}
}