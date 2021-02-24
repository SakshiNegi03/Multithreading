//Increase concurrency with Thread pools using newCachedThreadPool() and newFixedThreadPool().

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Process implements Runnable {
    int id;

    public Process(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Thread 1 name::" + Thread.currentThread().getName() + " Start :" + id);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread 1 name::" + Thread.currentThread().getName() + " End :" + id);
    }
}

class Process1 implements Runnable {
    int id;

    public Process1(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Thread 2 name::" + Thread.currentThread().getName() + " Start :" + id);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread 2 name::" + Thread.currentThread().getName() + " End :" + id);
    }
}

public class Qus9 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService1 = Executors.newFixedThreadPool(4);

        for (int i = 0; i <= 20; i++) {
            executorService.submit(new Process(i));
        }
        executorService.shutdown();

        for (int i = 0; i <= 20; i++) {
            executorService1.submit(new Process1(i));
        }
        executorService1.shutdown();
    }
}
