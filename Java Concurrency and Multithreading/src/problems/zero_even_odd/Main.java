package problems.zero_even_odd;

import java.util.Scanner;

public class Main {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(n);

        Thread zeroThread = new Thread(() -> {
            try {
                zeroEvenOdd.zero();
            } catch (InterruptedException exc) {
                Thread.currentThread().interrupt();
            }
        });

        Thread evenThread = new Thread(() -> {
            try {
                zeroEvenOdd.even();
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        });

        Thread oddThread = new Thread(() -> {
            try {
                zeroEvenOdd.odd();
            } catch(InterruptedException exc) {
                Thread.currentThread().interrupt();
            }
        });

        zeroThread.start();
        evenThread.start();
        oddThread.start();
    }
}
