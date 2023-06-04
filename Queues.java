import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Queues {
    public static void main(String args[]) {
        QueueUsingArray q = new QueueUsingArray(5);
        q.dequeue();
        q.print();
        q.enqueue(58);
        q.enqueue(80);
        q.enqueue(23);
        q.enqueue(58);
        q.enqueue(80);
        q.enqueue(23);
        q.print();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.print();
        q.dequeue(); q.dequeue();

        Queue<Integer> qu=new LinkedList<>();
        qu.add(19); qu.add(76);
        System.out.println(qu);
        qu.remove();
        System.out.println(qu);
        System.out.println(qu.peek()+" "+qu.size());

        //StackUsingQueue
        StackUsingQueue stack=new StackUsingQueue();
        stack.push(66);
        stack.push(34);
        stack.push(23);
        stack.display();
        stack.pop();
        stack.display();

        //LRU cache
        int arr[]={1,2,3,1,4,5};
        // int arr[]={1,2,3,4,5,1,2,5,1,2,3,4,5};
        Queue<Integer> cache=new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            int el=arr[i];
            if (!cache.contains(el)){
                if (cache.size()<4)
                cache.add(el);
                else{
                    cache.poll();
                    cache.add(el);  
                }
            }else{
                cache.remove(el);
                cache.add(el);
            }
        }
        System.out.println(cache);

        //BFS
        int[][] graph= {{0,1,1,0},{0,0,1,0},{1,0,0,1},{0,0,0,1}};
        boolean[] vis=new boolean[4];
        Queue<Integer> bfs=new LinkedList<>();
        bfs.add(2);
        System.out.println();
        while(!bfs.isEmpty()){
            int el=bfs.poll();
            vis[el]=true;
            System.out.print(el+"->");
            for(int j=0;j<4;j++){
                if(!vis[j] && graph[el][j]==1)
                bfs.add(j);
            }
        }

        //Min depth
        Node n4=new Node(4);
        Node n5=new Node(5);
        Node n3=new Node(3);
        Node n2=new Node(2,n4,n5);
        Node n1=new Node(1,n2,n3);
        Tree t=new Tree(n1);

        int minDepth=0;
        if (t.root!=null){
            Queue<Depth> depth=new LinkedList<>();
            depth.add(new Depth(t.root, 1));
            while(!depth.isEmpty()){
                Depth temp=depth.poll();
                if(temp.n.left==null && temp.n.right==null){
                    if(minDepth==0 || minDepth>temp.i)
                    minDepth=temp.i;
                }
                if(temp.n.left!=null){
                    depth.add(new Depth(temp.n.left, temp.i+1));
                }
                if(temp.n.right!=null){
                    depth.add(new Depth(temp.n.right, temp.i+1));
                }
            }

        }
        System.out.println("\nminDepth: "+minDepth);

        //first non-repeating character from a stream of characters
        String A = "geeksforgeeksandgeeksquizfor";
        String ans = FirstNonRepeating(A);
        System.out.print(ans+"\n");
        System.out.println(new StringBuilder("Divya").reverse());
        
    }

    static String FirstNonRepeating(String s){
        String res="";
        HashMap<Character,Integer> map=new HashMap<>();
        Queue<Character> charQueue=new LinkedList<>();
        Character lastKey=s.charAt(0);
        for(int i=0;i<s.length();i++){
            Character ch=s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
                charQueue.remove(ch);
                if(lastKey==ch){
                    lastKey=charQueue.poll();
                }
            }else{
                map.put(ch,1);
                charQueue.add(ch);
            }
            res+=lastKey;
        }
        return res;
    }

    static class QueueUsingArray {
        int[] q;
        private int front;
        private int rear;
        private int size;

        QueueUsingArray(int size) {
            q = new int[size];
            this.size = size;
            front = -1;
            rear = -1;
        }

        int[] enqueue(int el) {
            if (rear >= size-1) {
                System.out.println("Overflow");
            } else if (front == -1) {
                front++;
                rear++;
                q[front] = el;
            } else {
                rear += 1;
                q[rear] = el;
            }
            return q;
        }

        int[] dequeue() {
            if (front < 0 || front>rear) {
                System.out.println("Underflow");
            } else if (rear == 0) {
                front -= 1;
                rear -= 1;
            } else {
                front += 1;
            }
            return q;
        }

        void print() {
            for (int i = front; i <= rear && i>=0; i++) {
                System.out.print(q[i] + " ");
            }
            System.out.println();
        }
    }

    static class StackUsingQueue{
        Queue<Integer> s=new LinkedList<>();
        void push(int e){
            if (s.isEmpty())
            s.add(e);
            else{
                int el=s.poll();
                push(e);
                s.add(el);
            }
        }
        int pop(){
            return s.poll();
        }
        void display(){
            System.out.println(s);
        }
    }

    static class Depth{
        Node n;
        Integer i;
        Depth(Node n,Integer i){ this.n=n; this.i=i;}
    }
    static class Tree{
        Node root;
        Tree(Node r){
            this.root=r;
        }
    }
    static class Node{
        int value;
        Node left=null;
        Node right=null;
        Node(int val){
            this.value=val;
            this.left=null;
            this.right=null;
        }
        Node(int val, Node l, Node r){
            this.value=val;
            this.left=l;
            this.right=r;
        }
    }
}