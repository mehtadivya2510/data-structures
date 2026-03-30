package multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        PCHelper pc=new PCHelper();
        Thread t1=new Thread(()->{
            try {
                pc.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2=new Thread(()->{
            try {
                pc.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}

class PCHelper{
    private int capacity=3;
    private int counter=0;
    LinkedList<Integer> list=new LinkedList<>();
    public void produce() throws InterruptedException {
        while (true){
            synchronized(this){
                if (list.size() < capacity) {
                    System.out.println("Producing : " + counter);
                    list.add(counter++);
                    notify();
                } else {
                    wait();
                    notify();
                }
            }
            Thread.sleep(500);
        }
    }

    public void consume() throws InterruptedException {
        while (true){
            synchronized (this){
                if (list.size() == 0) {
                    wait();
                    notify();
                } else {
                    System.out.println("Consuming : " + list.poll());
                    notify();
                }
            }
            Thread.sleep(500);
        }
    }
}