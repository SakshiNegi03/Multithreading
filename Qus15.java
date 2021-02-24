//Use Reentrant lock for coordinating 2 threads with signal(), signalAll() and wait().

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Qus15 {

    Lock lock = new ReentrantLock(true);
    Condition condition = lock.newCondition();

    // process 1
    public void process1() {
        try {
            lock.lock();
            System.out.println("process 1 Started");
            condition.await();                                // wait
            System.out.println("process 1 Finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
    // process 2
    public void process2() {
        try {
            lock.lock();
            System.out.println("process 2 Started");
            System.out.println("process 2 Finished");
            condition.signal();                              // signal
        } finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Qus15 test = new Qus15();
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
            	test.process1();
            }
        });
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
            	test.process2();
            }
        });
        a.start();
        b.start();
        a.join();
        b.join();
    }
}
