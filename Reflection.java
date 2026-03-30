import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Reflection {
    public static void main(String[] args) {
        try{
            Class c = Class.forName("LFUCache");
            Method[] methods = c.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method.getName()+" "+method.getParameterCount());
            }
        }catch (ClassNotFoundException ex){
            System.out.println("Class no found");
        }
        Teacher t1=new Teacher("Priya",34,"HR");
        System.out.println(t1);

        //lambda func
        Shape rect=(a,b)->a*b;
        Shape square=(a,b)->a*a;
        Shape circle=(a,b)->3.14*a*a;
        System.out.println(rect.area(3,5));
        System.out.println(square.area(4,4));
        System.out.println(circle.area(10,10));


        //concurrent colections
        CopyOnWriteArrayList<Student> students=new CopyOnWriteArrayList<>();
        students.add(new Student("Prerna",12));
        students.add(new Student("Hussain",16));
        students.add(new Student("Piyush",22));
        students.add(new Student("Aamir",11));
        Iterator<Student> i = students.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }

        ConcurrentHashMap<String,Integer> concurrentHashMap=new ConcurrentHashMap<>();
        concurrentHashMap.put("Diya",29);
        concurrentHashMap.put("Neha",23);
        concurrentHashMap.put("Shweta",25);
        System.out.println(concurrentHashMap);

        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        // Thread 1: Iterates over the list
        Thread thread1 = new Thread(() -> {
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                try {
                    System.out.println("Reading: " + iterator.next());
                    // Simulate some work and concurrency
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Thread 2: Modifies the list
        Thread thread2 = new Thread(() -> {
            try {
                // Wait for a moment to ensure iteration has started
                Thread.sleep(500);
                list.add("Grape"); // This modification is safe
                System.out.println("Modified: Added Grape to the list");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
    }
}
sealed class A permits B{

}
non-sealed class B extends A{

}
class C extends B implements Comparator<C> {
    @Override
    public int compare(C o1, C o2) {
        return 0;
    }
}
record Teacher(String name, int age, String dept){}

@FunctionalInterface
interface Shape{
    double area(int len, int breadth );
}