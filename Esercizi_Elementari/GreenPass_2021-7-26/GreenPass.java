public class GreenPass {
	private Person p;
	private int expiration;

	protected GreenPass(){}

	/*
	 * Il protected al costruttore del GreenPass è stato aggiunto succesivamente
	 * per completare anche la parte opzionale dell'esercizio
	 * bada bene che i campi della classe Person e GreenPass andrebbero rivisti ed aggiustati (ma mi annoio)
	 * ovviamente così l'esercizio funziona ma non è ottimizzato
	*/
	protected GreenPass(Person p,int expiration) {
		this.p = p;
		this.expiration = expiration;
	}

	public boolean isValidOn(int day) {
		if(expiration - day > 0)
			return true;
		return false;
	}

	public boolean belongsTo(Person other) {
		return other.getName().equals(p.getName());
	}
}
