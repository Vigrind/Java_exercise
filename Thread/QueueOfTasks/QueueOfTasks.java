import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class QueueOfTasks {
	private LinkedList<Runnable> list = new LinkedList<>();
	private BlockingQueue<Thread> threadBloking = new ArrayBlockingQueue<>(1);
	
	public void add(Runnable r) {
		/*
		 * Il thread che chiama add
		 * come prima cosa aggiunge un elemento alla coda della lista
		 */
		synchronized(list) {
			list.addLast(r);
		}

		/*
		 * Creo un Thread per non bloccare il chiamante della funzione add
		 * in questo caso sarebbe il thread main
		*/
		new Thread() {
			@Override
			public void run() {
				/*
				 * Creo Thread che esegue il runnable
				 * che si trova alla testa della lista
				 */
				Thread t = new Thread() {
					@Override
					public void run() {
						/*
						 * Creo un Runnable fuori synchronized perchè non voglio aspettare
						 * l'esecuzione di tutto il run prima di uscire dal blocco synchronized
						 * Esempio:
						 * synchronized(list) {
						 *  	list.removeFirst().run()----->Questo non va bene perchè per uscire dal blocco
						 *  								  devo aspettare che finisca il run
						 * }
						 */
						Runnable runThread;
						synchronized (list) {
							runThread = list.removeFirst();
						}
						runThread.run();
						threadBloking.remove(this); //il thread si elemina dalla blokingQueue
					};
				};

				/*
				 * Aggiungo il thread appena creato alla blokingQueue
				 * E poi lo starto
				 */
				try {
					threadBloking.put(t);
					t.start();
				} catch (InterruptedException e) {e.printStackTrace(); return;}
			}
		}.start();
	}
}