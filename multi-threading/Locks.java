package multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class Locks {
    public static void main(String[] args) {
        SharedResource s1=new SharedResource();
        SharedResource s2=new SharedResource();

        ThreadLock1 t1=new ThreadLock1(s1,s2);
        ThreadLock2 t2=new ThreadLock2(s1,s2);

        t1.start();
        t2.start();
    }
}

class ThreadLock1 extends Thread{
    SharedResource s1;
    SharedResource s2;
    ThreadLock1(SharedResource s1, SharedResource s2){
        this.s1=s1;
        this.s2=s2;
    }

    @Override
    public void run() {
        s1.test1(s2);
    }
}
class ThreadLock2 extends Thread{
    SharedResource s1;
    SharedResource s2;
    ThreadLock2(SharedResource s1, SharedResource s2){
        this.s1=s1;
        this.s2=s2;
    }

    @Override
    public void run() {
        s2.test1(s1);
    }
}
class SharedResource{
    public void test1(SharedResource s){
        ReentrantLock reentrantLock=new ReentrantLock();
        if (reentrantLock.tryLock()){
            try {
                reentrantLock.lock();
                System.out.println("Inside test1");
                s.test2();
            }finally {
                reentrantLock.unlock();
            }
        }
    }

    public void test2(){
        ReentrantLock reentrantLock=new ReentrantLock();
        try {
            reentrantLock.lockInterruptibly();
            System.out.println("Inside test2");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            reentrantLock.unlock();
        }

    }
}