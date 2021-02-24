// Using  sleep and join methods with thread.

public class Qus2 {
    
    public static void main(String[] args) throws InterruptedException{
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println("Running 1st Thread");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000L);
                    System.out.println("Running 2nd Thread");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
  // using sleep method
        a.start();
        b.start();
        
 // using join method 
        a.join();
        b.join();

        System.out.println("stopped.........");

    }
}