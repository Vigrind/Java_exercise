public class Studente {
	private String nome;
	private String matricola;

	public static class Triennale extends Studente{
		private static String prf;
		public Triennale(String n, String mat){
			super.nome = n;
			super.matricola = mat;
		}
		public static void setPrefisso(String s){
			prf = s;
		}
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Studente){
				Studente s = (Studente)obj;
				return super.nome.equals(s.nome) && this.getClass() == s.getClass() && super.matricola.equals(s.matricola);
			}
			else
				return false;
		}

		@Override
		public String toString(){
			return super.nome + " " + Triennale.prf+"/"+super.matricola;
		}
	}

	public static class Magistrale extends Studente{
		private static String prf;
		public Magistrale(String n,String mat) {
			super.nome = n;
			super.matricola = mat;
		}
		public static void setPrefisso(String s){
			prf = s;
		}

		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Studente){
				Studente s = (Studente)obj;
				return super.nome.equals(s.nome) && this.getClass() == s.getClass() && super.matricola.equals(s.matricola);
			}
			else
				return false;
		}

		@Override
		public String toString(){
			return super.nome + " " + Magistrale.prf+"/"+super.matricola;
		}
	}
}
