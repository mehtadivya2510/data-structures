package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CreatingThreads {
    public static void main(String[] args) {
        //Thread class & Runnable interface
        Thread t1=new Thread1();
        Thread t2=new Thread(new Thread2());

        //lambda expr
        Thread t3= new Thread(()-> {
            System.out.println("Inside thread3 ");
        });

        //Executor service - thread pool
        Thread t4=new Thread(()->{
            System.out.println("Inside t4");
        },"Thread4");
        Thread t5=new Thread(()->{
            System.out.println("Inside t5");
        }, "Thread5");
        ExecutorService pool= Executors.newFixedThreadPool(2);
        pool.submit(t4); //submit used for callable or future tasks
        pool.execute(t5); // execute used for runnable tasks
        pool.shutdown();

        t1.start();
        t2.start();
        t3.start();
    }
}

class Thread1 extends Thread{
    @Override
    public void run() {
        System.out.println("Inside thread1");
    }
}

class Thread2 implements Runnable{

    @Override
    public void run() {
        System.out.println("Inside thread2");
    }
}
