import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
    public static void main(String[] args){
        QueueOfTasks q = new QueueOfTasks();
        Runnable r1 = new Runnable() {
            public void run() {
                try { Thread.sleep(2000); }
                catch (InterruptedException e) { return;
                }
                System.out.println("Io␣adoro␣i␣thread!");
            }
        };
        Runnable r2 = new Runnable() {
            public void run() {
                System.out.println("Io␣odio␣i␣thread!");
            }
        };
        q.add(r1);
        q.add(r1);
        q.add(r2);
        System.out.println("fatto.");
    }
}
