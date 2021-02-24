//Coordinate 2 threads using wait() and notify().

public class Qus13 {

    public void process1(){
        synchronized (this) {
            System.out.println("Process 1 Started");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Process 1 Done");
        }
    }

    public void process2(){
        synchronized (this) {
            System.out.println("Process 2 Started");
            System.out.println("Process 2 Done");
            notify();
        }
    }

    public static void main(String[] args) {
        Qus13 test = new Qus13();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.process1();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.process2();
            }
        })
        .start();
    }
}
