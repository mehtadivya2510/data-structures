package multithreading;


class BankAccount{

    // Shared variable
    private int balance;
    BankAccount(int balance){
        this.balance=balance;
    }

    // Synchronized method
    public synchronized void deposit(int amount){
        balance+=amount;
    }

    // Synchronized block
    public void withdraw(int amount){
        synchronized (this){
            balance-=amount;
        }
    }

    public int getBalance() {
        return balance;
    }
}

public class Synchronization{

    public static void main(String[] args){

        BankAccount bankAccount=new BankAccount(1000);

        Thread t1=new Thread(()->{
            for (int i=0;i<5;i++){
                bankAccount.deposit(100);
                System.out.println("After deposit, balance:"+bankAccount.getBalance());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2=new Thread(()->{
            for (int i=0;i<5;i++){
                bankAccount.withdraw(200);
                System.out.println("After withdrawal, balance:"+bankAccount.getBalance());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}