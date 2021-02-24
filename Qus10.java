//Use Synchronize method to enable synchronization between multiple threads trying to access method at same time.

public class Qus10 {
    int count;
    synchronized public void incrementCount() {
        count++;
    }

    public void process1() {
        for (int i = 1; i <= 2000; i++) {
            incrementCount();
        }
    }

    public void process2() {
        for (int i = 1; i <= 2000; i++) {
            incrementCount();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Qus10 synchronizeTest = new Qus10();

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