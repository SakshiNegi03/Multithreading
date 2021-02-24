// Runnable thread by implementing runnable interface

package multithreading1;
public class ThreadByRunable implements Runnable{

    @Override
    public void run() {
        System.out.println("Runnable Thread");
    }
    
    public static void main(String[] args) {
        new Thread(new ThreadByRunable()).start();
    }
}
