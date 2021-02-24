// Using Atomic Classes instead of Synchronize method and blocks.

import java.util.concurrent.atomic.AtomicInteger;

public class Qus12 {

    AtomicInteger count = new AtomicInteger();

    public void incrementCount() {
        synchronized (this) {
            count.incrementAndGet();
        }
    }

    public void process1() {
        for (int i = 1; i <= 3000; i++) {
            count.incrementAndGet();
        }
    }

    public void process2() {
        for (int i = 1; i <= 3000; i++) {
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Qus12 synchronizeTest = new Qus12();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizeTest.process1();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizeTest.process2();
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(synchronizeTest.count);
    }

}
