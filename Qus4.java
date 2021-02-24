//Using  shutdown() and shutdownNow() to observe the difference.

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Qus4 {
    public static void main(String[] args) {

        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        try {
            executorService1.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread 1.1");
                }
            });

            executorService1.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000L);
                    }catch (InterruptedException e){
                        System.out.println("Thread 1.2 Interrupted!");
                    }
                    System.out.println("Thread 1.2");
                }
            });
        } 
        
        // using shutdown
        finally {
            executorService1.shutdown();
        }
        
        System.out.println(executorService1.isShutdown());
        System.out.println(executorService1.isTerminated());
        System.out.println("-----");

        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        try {
            executorService2.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread 2.1");
                }
            });

            executorService2.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000L);
                    }catch (InterruptedException e){
                        System.out.println("Thread 2.2 Interrupted!");
                    }
                    System.out.println("Thread 2.2");
                }
            });
        } 
        
        // using shut down now
        finally {
            executorService2.shutdownNow();
        }
        
        System.out.println(executorService2.isShutdown());
        System.out.println(executorService2.isTerminated());
    }
}