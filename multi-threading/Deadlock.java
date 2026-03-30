package multithreading;

public class Deadlock {
    public static void main(String[] args) throws InterruptedException {
        Shared s1=new Shared();
        Shared s2=new Shared();
        T1 t1=new T1(s1,s2);
        T2 t2=new T2(s1,s2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}

class T1 extends Thread{
    Shared s1;
    Shared s2;
    T1(Shared s1, Shared s2){
        this.s1=s1;
        this.s2=s2;
    }

    @Override
    public void run() {
        s1.test1(s2);
    }
}

class T2 extends Thread{
    Shared s1;
    Shared s2;
    T2(Shared s1, Shared s2){
        this.s1=s1;
        this.s2=s2;
    }

    @Override
    public void run() {
        s2.test1(s1);
    }
}

class Shared{
    public synchronized void test1(Shared s){
        System.out.println("Inside test1");
        s.test2();
    }

    public synchronized void test2(){
        System.out.println("Inside test2");
    }
}