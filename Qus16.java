//Create a deadlock and Resolve it using tryLock().

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Qus16 {

    Lock lock1 = new ReentrantLock(true);
    Lock lock2 = new ReentrantLock(true);

    public void acquireLock(Lock lock1, Lock lock2){

        boolean acquireLock1= lock1.tryLock();
        boolean acquireLock2= lock2.tryLock();

        if(acquireLock1 && acquireLock2){
            return;
        }

        if(acquireLock1){
            lock1.unlock();
        }

        if(acquireLock2){
            lock2.unlock();
        }

    }

    public void process1(){
        acquireLock(lock1,lock2);
        System.out.println("lock 1 process 1");
        System.out.println("lock 2 process 1");

        try {
            lock2.unlock();
            lock1.unlock();
        }catch (Exception e){
            System.out.println("Problem in unlocking lock by process1!");
        }
    }

    public void process2(){
        acquireLock(lock2,lock1);
        System.out.println("lock 1 process 2");
        System.out.println("lock 2 process 2");
        try {
            lock1.unlock();
            lock2.unlock();
        }catch(Exception e){
            System.out.println("Problem in unlocking lock by process2");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Qus16 demo = new Qus16();
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                demo.process1();
            }
        });
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                demo.process2();
            }
        });
        a.start();
        b.start();
        a.join();
        b.join();
    }
}