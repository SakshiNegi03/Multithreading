// Running thread by extending thread class 

package multithreading1;
public class ThreadByExtend extends Thread {
    @Override
    public void run() {
        System.out.println("Running Thread ");
    }

    public static void main(String[] args) {
        new ThreadByExtend().start();
    }
}