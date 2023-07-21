import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    Queue<Integer> q1=new LinkedList<>();
    Queue<Integer> q2=new LinkedList<>();

    public void push(int el){
        q1.add(el);
    }

    public int pop(){
        if (q1.isEmpty())
            return -1;   //returing -1 in case of Underflow
        while (q1.size() != 1) {
            q2.add(q1.remove());
        }
 
        int temp=q1.remove();
 
        //swapping
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;

        return temp;
    }

    
    public int peek(){
        if (q1.isEmpty())
            return -1;
 
        while (q1.size() != 1) {
            q2.add(q1.remove());
        }
 
        int temp = q1.peek();
 
        q1.remove();
        q2.add(temp);

        //swapping
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;

        return temp;
    }

    public static void main(String[] args) {
        StackUsingQueue s = new StackUsingQueue();
        s.push(18);
        s.push(24);
        s.push(93);

        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.peek());
    }
}

