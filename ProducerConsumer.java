import java.util.LinkedList;
 
public class ProducerConsumer {
    public static void main(String[] args)
        throws Exception
    {

        final HelperPC pc = new HelperPC();
 
        // Producer thread
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    pc.produce();
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        });
 
        // Consumer thread
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    pc.consume();
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        });
 
        t1.start();
        t2.start();
 
        t2.join();
        t1.join();
    }

    public static class HelperPC {
 
        LinkedList<Integer> buffer = new LinkedList<>();
        int capacity = 3;
 
        public void produce() throws Exception
        {
            int value = 0;
            while (true) {
                synchronized (this)
                {
                    
                    while (buffer.size() == capacity)
                        wait();
 
                    System.out.println("Producer output : "+ value);
 
                    buffer.add(value++);
 
                    notify();

                    Thread.sleep(1000);
                }
            }
        }
 
        public void consume() throws Exception
        {
            while (true) {
                synchronized (this)
                {
                    
                    while (buffer.size() == 0)
                        wait();

                    int value = buffer.poll();
 
                    System.out.println("Consumer output : "+ value);
 
                    notify();
 
                    Thread.sleep(1000);
                }
            }
        }
    }
}