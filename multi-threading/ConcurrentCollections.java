package multithreading;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentCollections {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> arrayList=new ArrayList<>();
//        CopyOnWriteArrayList<Integer> arrayList=new CopyOnWriteArrayList<>();

        for (int i=0;i<10;i++){
            arrayList.add((int) (Math.random()*100));
        }
        System.out.println(arrayList);

        Iterator<Integer> iterator= arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            arrayList.add(39);  //ConcurrentModificationException
        }
    }
}
