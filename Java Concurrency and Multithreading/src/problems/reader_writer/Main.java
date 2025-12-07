package problems.reader_writer;

public class Main {
    static void main() {
        ReaderWriterLock rw = new ReaderWriterLock();

        Runnable read = () -> {
            try {
                System.out.println("Thread : " + Thread.currentThread().getName() + " trying to acquire read lock");
                rw.lockRead();
                System.out.println("Thread : " + Thread.currentThread().getName() + " acquired the read lock. Now reading");
                Thread.sleep(3000);
                System.out.println("Thread : " + Thread.currentThread().getName() + " is releasing the read lock" );
                rw.unlockRead();
            } catch(InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        };

        Runnable write = () -> {
            try {
                System.out.println("Thread : " + Thread.currentThread().getName() + " trying to acquire write lock");
                rw.lockWrite();
                System.out.println("Thread : " + Thread.currentThread().getName() + " acquired the write lock. Now writing");
                Thread.sleep(3000);
                System.out.println("Thread : " + Thread.currentThread().getName() + " is releasing the write lock" );
                rw.unlockWrite();
            } catch(InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        };

        Thread thread1 = new Thread(read, "Reader 1");
        Thread thread2 = new Thread(read, "Reader 2");
        Thread thread3 = new Thread(write, "Writer 1");
        Thread thread4 = new Thread(write, "Writer 2");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }


}
