import java.util.Collections;
import java.util.PriorityQueue;

public class Heap {
    public static void main(String[] args) {
        int arr[]={10, 5, 4, 3, 48, 6, 2, 33, 53, 10};
        KthSmallest(arr,4);

        arr = new int[]{198, 76, 544, 123, 154, 675};
        minimumProductOfKIntegers(arr,2);
    }

    static void KthSmallest(int arr[], int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder()); //max-heap
        for (int val: arr){
            pq.add(val);
            if (pq.size()>k)
                pq.poll();
        }
        System.out.println("Kth smallest: "+pq.peek());
    }

    static void minimumProductOfKIntegers(int arr[], int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder()); //max-heap
        for (int val: arr){
            pq.add(val);
            if (pq.size()>k)
                pq.poll();
        }
        int product=1;
        while (!pq.isEmpty()){
            product=product* pq.poll();
        }
        System.out.println("Min product: "+product);
    }
}
