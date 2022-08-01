public class Studente {
	private String nome;
	private String matricola;

	public Studente(String n, String m){
		nome = n;
		matricola = m;
	}

	public static class Triennale extends Studente{
		private static String t_prefisso;
		public static void setPrefisso(String pref){
			t_prefisso = pref;
		}

		public Triennale(String n, String m){
			super(n, t_prefisso + '/' + m);
		}

	}

	public static class Magistrale extends Studente {
		private static String m_prefisso;
		public static void setPrefisso(String pref){
			m_prefisso = pref;
		}

		public Magistrale(String n, String m){
			super(n, m_prefisso + '/' + m);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Studente)) return false;

		Studente tmp = (Studente)obj;
		return this.nome.equals(tmp.nome) && this.matricola.equals(tmp.matricola);
	}
}