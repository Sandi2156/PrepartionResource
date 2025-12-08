package problems.zero_even_odd;

import java.util.concurrent.Semaphore;

public class ZeroEvenOdd {
    private int n;
    private final Semaphore zeroMutex = new Semaphore(1);
    private final Semaphore oddMutex = new Semaphore(0);
    private final Semaphore evenMutex = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public void zero() throws InterruptedException {
        boolean isEven = false;

        for(int i = 0; i < n; i++) {
            zeroMutex.acquire();
            System.out.print("0");
            if(isEven) {
                evenMutex.release();
            } else {
                oddMutex.release();
            }
            isEven = !isEven;
        }
    }

    public void even() throws InterruptedException {
        for(int i = 2; i <= n; i += 2) {
            evenMutex.acquire();
            System.out.print(i);
            zeroMutex.release();
        }
    }

    public void odd() throws InterruptedException {
        for(int i = 1; i <= n; i += 2) {
            oddMutex.acquire();
            System.out.print(i);
            zeroMutex.release();
        }
    }
}
