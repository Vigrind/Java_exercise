import java.util.Random;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		ParkingLot p = new ParkingLot(10,5);
		
		new Thread(() -> {
			while(!Thread.currentThread().isInterrupted()) {
				/*
				 * Questo è il thread produttore
				 * produce un auto e la inserisce nel parcheggio
				 * aspetta nel caso il parcheggio è pieno, altrimenti inserisce un'auto
				 * p.carIn non è assegnata a nessuna variabile perchè tanto non mi serve
				 * quello che mi interessa è produrre un auto, ma non voglio nessun riferimento ad essa
				 * per questo motivo non c'è scrtto Pair<Integer,Integer> posto = p.carIn;
				 * 
				 * IMPORTANTE!!!!
				 * Thread.sleep va messo fuori dal synchronized, tanto in quel momento il thread dorme
				 * nel momento in cui si sveglia cercherà da solo di riprendere il monitor di p
				 * stessa cosa vale per il thread consumatore
				 */
				synchronized(p){
					while(p.isFull()){														//vado in wait se il parcheggio è pieno
						try {
							p.wait();
						} catch (InterruptedException e) {}
					}
					p.carIn();																//non assegno p.carIn a nulla, tanto non mi serve
					p.notifyAll();
				}

				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {}
			}
		}).start();

		new Thread(() -> {
			while(!Thread.currentThread().isInterrupted()){
				/*
				 * Questo è il thread consumatore
				 * Nella traccia c'è scritto che non è importante l'ordine delle auto che vengono rimosse dal parcheggio
				 * questo vuol dire che il consumatore prende auto a caso (potrebbe essere la prima, l'ultima la seconda ecc)
				 * Quindi uso la classe Random che genera numer casuali, OVVIAMENTE DEVONO ESSERE NEL RANGE DELLE RIGHE E DELLE COLONNE
				 * Se in quel posto non c'è un'auto, semplicemente p.carOut restituisce null (come da traccia)
				 */
				synchronized(p) {
					while(p.isEmpty()) {														//vado in wait se il parcheggio è vuoto
						try {
							p.wait();
						} catch (Exception e) {}
					}
					Random num = new Random();													//La classe Random è utilizzata per generare numeri randomici
					Pair<Integer,Integer> park = new Pair<>(num.nextInt(10),num.nextInt(5));	//qui utilizzo num per generare numeri randomici
																								//genero da 0 a 9, e da 0 a 5 (La grandezza della mia matrice)
					
					System.out.println(park + ", " + p.carOut(park));
					p.notifyAll();
				}

				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {}
			}
		}).start();
	
	}

}
