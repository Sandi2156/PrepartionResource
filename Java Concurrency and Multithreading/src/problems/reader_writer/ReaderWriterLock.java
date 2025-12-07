package problems.reader_writer;

import java.util.concurrent.Semaphore;

public class ReaderWriterLock {
    private int readerCount = 0;
    private final Semaphore readMutex = new Semaphore(1);
    private final Semaphore wrtMutex = new Semaphore(1);

    public void lockRead() throws InterruptedException {
        readMutex.acquire();

        readerCount++;

        if(readerCount == 1) {
            wrtMutex.acquire();
        }

        readMutex.release();
    }

    public void unlockRead() throws InterruptedException {
        readMutex.acquire();

        readerCount--;

        if(readerCount == 0) {
            wrtMutex.release();
        }

        readMutex.release();
    }

    public void lockWrite() throws InterruptedException {
        wrtMutex.acquire();
    }

    public void unlockWrite() throws InterruptedException {
        wrtMutex.release();
    }
}
