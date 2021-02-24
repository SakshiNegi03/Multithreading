//Coordinate multiple threads using wait() and notifyAll()

public class Qus14 {
	// process 1
    public void process1(){
        synchronized (this) {
            System.out.println("process 1 Started");
            try {
                wait();  // wait
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("process 1 Done");
        }
    }
   // process 2
    public void process2(){
        synchronized (this) {
            System.out.println("process 2 Started");
            try {
                wait();  // wait
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("process 2 Done");
        }
    }
   // process 3
    public void process3(){
        synchronized (this) {
            System.out.println("process 3 Started");
            try {
                wait();  // wait
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("process 3 Done");
        }
    }
  // process 4
    public void process4(){
        synchronized (this) {
            System.out.println("process 4 Started");
            System.out.println("process 4 Done");
            notifyAll(); // notify all 
        }
    }
    public static void main(String[] args) {
        Qus14 demo = new Qus14();
        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.process1();
            }
        })
        .start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.process2();
            }
        })
        .start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.process3();
            }
        })
        .start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.process4();
            }
        })
        .start();
    }
}