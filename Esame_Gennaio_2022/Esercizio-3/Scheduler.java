import java.util.PriorityQueue;
import java.util.Queue;

/*
 * A primo acchitto avevo pensato di usare una TreeMap, ma c'erano alcuni problemi
 * In una TreeMap tutto è ordinato secondo le chiavi, quindi fare una TreeMap<Integer,Thread> può sembrare una soluzine
 * per prendere gli elementi in ordine ( dal più piccolo al più grande ), eppure questa soluzione non va bene perche:
 * ---Si può inserire un solo elemento con quella priorità, inserendone un secondo il precedente verrebbe sovrascitto essendo una Map
 * 
 * Quindi è logico pensare ad un'altra struttura.
 * Seguendo le API presentate al corso, bastava usare una coda e fare un sort ogni qual volta si inseriva un elemento
 * in modo tale da tenere ordinati i tasK con priorità maggiore
 * Java offre le PriorityQueue che fanno esattamente questo, senza avere il bisogno di farlo a mano
 * 
 * C'è la classe Element che contiene un runnable ed un intero ( che rappresenta la priorità )
 * Element implementa Comparable per darle un ordinamento naturale (che viene usato o dagli argomenti di sort o dalla PrioriyQueue)
 * in questo modo ho una coda ordinata in modo decrescente (secondo il compareTo di Element )
 * 
 * A questo punto il gioco è fatto, mi basta tenere un Thread corrente che esegue ogni runable della coda, 1 alla volta
 * all'interno di un ciclo while che continua fin quando la coda non è vuota o fin quando non viene chiamato il metodo stop.
 * 
 * Per sincronizzare stop e start ho utilizzato la variabile isOk, che alla fine di start viene messa a true
 * perchè una volta interrotto start, dopo posso richiamarlo.
 * 
 * Tutto questo esercizio poteva esser fatto meglio? CERTAMENTE!!
 * 
 */

public class Scheduler {

	private Queue<Element> q = new PriorityQueue<>(); //Element contiene un Runnable ed un int
	private volatile boolean isOk = true;
	private Thread currentTask;

	synchronized void addTask(Runnable r, int priority) {
		Element e = new Element(r, priority);
		synchronized (q) {
			q.add(e);
		}
	}

	public void start () {
		new Thread() {
			
			public void run() {
				while(isOk) {
					synchronized (q) {
						if(q.isEmpty()) 
							return;
					}
					
					synchronized (this) {
						currentTask = new Thread( () -> {
							Runnable runTask = null;
							synchronized (q) {
								if(q.isEmpty())
									return;
								runTask = q.remove().r;
							}
							runTask.run();
						});
	
						currentTask.start();
						try {
							currentTask.join();
						} catch (InterruptedException e) {e.printStackTrace();}
					}
				}
			};
			isOk = true;
		}.start();

	}

	public void stop () {
		isOk = false;
		synchronized (this) {
			if(currentTask != null && !currentTask.isInterrupted())
				currentTask.interrupt();
		}
	}

	private class Element implements Comparable<Element> {
		Runnable r;
		int priority;

		Element(Runnable r, int priority) {
			this.r = r;
			this.priority = priority;
		}

		@Override
		public int compareTo(Scheduler.Element arg0) {
			if(priority == arg0.priority )
				return 0;
			if(priority < arg0.priority)
				return 1;
			else
				return -1;
		}

		@Override
		public String toString() {
			return r.toString() + "priority: " + priority;
		}
	}

}
