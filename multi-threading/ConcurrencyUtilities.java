package multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class ConcurrencyUtilities {

    public static void main(String[] args) throws InterruptedException {

        //CountDownLatch - Allows one or more threads to wait until a set of operations completes.
        countDownLatch();

        //CyclicBarrier - Allows multiple threads to wait for each other at a barrier point, then proceed together.
        cyclicBarrier();

        //Sempahores - Controls number of threads accessing a resource at the same time.
        semaphores();
    }

    public static void countDownLatch() throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(3);

        Runnable task = ()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Inside task: "+Thread.currentThread().getName());
            countDownLatch.countDown();
        };

        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();

        countDownLatch.await();
        System.out.println("All tasks finished");
    }

    public static void semaphores(){
        Semaphore semaphore=new Semaphore(2);
        Runnable task3=()->{
            try{
                semaphore.acquire();
                System.out.println("Started "+Thread.currentThread().getName());
                Thread.sleep(1000);
                System.out.println("Completed "+Thread.currentThread().getName());
                semaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        for (int i = 0; i < 5; i++) {
            new Thread(task3).start();
        }
    }

    public static void cyclicBarrier(){
        CyclicBarrier barrier = new CyclicBarrier(3,
                () -> System.out.println("All threads reached barrier"));

        Runnable task2 = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " waiting");
                barrier.await();
                System.out.println(Thread.currentThread().getName() + " proceeding");
            } catch (Exception e) {}
        };

        new Thread(task2).start();
        new Thread(task2).start();
        new Thread(task2).start();
    }
}

