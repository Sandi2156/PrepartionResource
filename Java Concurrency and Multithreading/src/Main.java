class MyThread1 extends Thread {
    public MyThread1(String name) {
        super(name);
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.println("Thread: " + Thread.currentThread().getName() + " " + i);
        }
    }
}

class MyThread2 implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.println("Thread: " + Thread.currentThread().getName() + " " + i);
        }
    }
}

public class Main {
    public static void main() {
        System.out.println("Main thread is starting");

//        Thread thread1 = new MyThread1("Superman");
//        thread1.start();
//
//        Thread thread2 = new Thread(new MyThread2(), "Spiderman");
//        thread2.start();
//
//        Thread thread3 = new Thread(() -> {
//            for(int i = 0; i < 5; i++) {
//                System.out.println("Thread: " + Thread.currentThread().getName() + " " + i);
//            }
//        }, "hawkeye");
//        thread3.start();




        System.out.println("Main thread is exiting");
    }
}