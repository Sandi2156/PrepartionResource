package semaphore.binary_semaphore;
import java.util.concurrent.Semaphore;

public class Main {
    private static final Semaphore mutex = new Semaphore(1);

    private static void accessCriticalSection() {
        try {
            System.out.println("Thread " + Thread.currentThread().getName() + " trying to access CS");
            mutex.acquire();
            System.out.println("Thread " + Thread.currentThread().getName() + " inside critical section");
            Thread.sleep(3000);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        } finally{
            System.out.println("Thread " + Thread.currentThread().getName() + " is releasing the lock");
            mutex.release();
        }
    }

    static void main() {
        Thread t1 = new Thread(() -> {
            accessCriticalSection();
        }, "superman");
        Thread t2 = new Thread(() -> {
            accessCriticalSection();
        }, "spiderman");

        t1.start();
        t2.start();

    }
}
