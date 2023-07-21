import org.jcp.xml.dsig.internal.SignerOutputStream;

class Table{  
    synchronized static void printTable(int n){//method not synchronized 
        { 
       for(int i=1;i<=5;i++){ 
         System.out.println(n*i);  
         try{  
          Thread.sleep(400);  
         }catch(Exception e){System.out.println(e);}  
       }
    }
     }  
    }  
      
    class MyThread1 extends Thread{  
    Table t;  
    MyThread1(Table t){  
    this.t=t;  
    }  
    public void run(){  
    t.printTable(5);  
    }  
      
    }  
    class MyThread2 extends Thread{  
    Table t;  
    MyThread2(Table t){  
    this.t=t;  
    }  
    public void run(){
    t.printTable(100);  
    }  
    }  
      
    class Thread3 extends Thread{
      public void run(){
        for(int i=1;i<=5;i++)
        {System.out.println(i +" "+ this.getName());
        try{
          Thread.sleep(100);
        }catch(Exception e){}}
      }
    }
    class TestSynchronization1{  
    public static void main(String args[]) throws  Exception{
    // Table obj = new Table();
    // Table obj2 = new Table();//only one object  
    // MyThread1 t1=new MyThread1(obj);  
    // MyThread2 t2=new MyThread2(obj2); 
    
    // Thread t=new Thread(new Runnable() {
    //     public void run(){}
    // });
    // t1.start();  
    // t2.start();

        Runnable r=()->{
            System.out.println("Inside runnable");
        };
        Thread th3=new Thread(r);
    
        Thread t3= new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=5;i++)
                {System.out.println(i +" t3");}
            }
        });
        Thread t4= new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t3.join();
                } catch (InterruptedException e) {}
                for(int i=1;i<=5;i++)
                {System.out.println(i +" t4");}
            }
        });
        Thread t5= new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t4.join();
                } catch (InterruptedException e) {}
                for(int i=1;i<=5;i++)
                {System.out.println(i +" t5");}
            }
        });
//        t3.start();
//        t4.start();
//        t5.start();

        t3.join();
        t4.join();
        t5.join();

        t3.setPriority(10);

//        t3.join();
//        t4.join();
//        System.out.println("In main thread");

        //print num in sequence
        Sequence sq=new Sequence();
        Thread th1=new Thread(sq);
        Thread th2=new Thread(sq);

        th1.start();th2.start();

    }
    static  class Sequence implements  Runnable{
        static int counter=0;
        public static synchronized void increment() throws InterruptedException {
            counter++;
            System.out.println(counter+" "+Thread.currentThread().getName());
            Thread.sleep(1000);
        }

        @Override
        public void run() {
            try {
                while (counter<11)
                increment();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

  }  