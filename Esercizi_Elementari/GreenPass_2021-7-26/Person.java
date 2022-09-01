/*
 * L'estenzione alla classe persone è statta aggiunta succesivamente ( come per la classe GreenPass)
 * Prestare attenzione al fatto che gli attributi andrebbbero rivisti
 * ovviamente così l'esercizio funziona ma non è ottimizzato
*/

public class Person extends GreenPass{
	private String name;
	private int dateVaccinate;
	private int count = 0;

	public Person(String name) {
		this.name = name;
	}

	public GreenPass vaccinate(int day) {
		++count;
		dateVaccinate = day;
		return new GreenPass(this, count >= 2 ? 270 : 180);
	}

	public String getName() {return name;}
	public int getDateVaccinate() {return dateVaccinate;}
}