package Jagadish2;

public class ThreadUnsync {

    public static void main(String[] args) throws InterruptedException {

        A a = new A();

        Thread t1 = new Thread(() -> {

            for (int i = 1; i <= 10000; i++) {
                a.finalCount();
            }
        });

        Thread t2 = new Thread(() -> {

            for (int i = 1; i <= 10000; i++) {
                a.finalCount();
            }
        });

        t1.start();

        t2.start();

        t1.join();

        t2.join();

        System.out.println(a.count);

    }

}

class A {
    int count;

    public synchronized void finalCount() {
        count++;
    }
}
