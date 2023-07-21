import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

final class Emp {
    private final int i;
    private final String name;

    private Emp(int i,String name){ 
        this.i=i;
        this.name=name;
    }

    public Emp getEmp(int i, String name){
        return new Emp(i, name);
    }

    static class LinkedList<T>{
        Node<T> head;
        LinkedList(){
            this.head=null;
        }
        LinkedList(Node<T> head){
            this.head=head;
        }

        public Node<T> insert(T data){
            if (head==null)
            return new Node<>(data,null);
            else{
                Node<T> temp=head;
                while(temp.next!=null){
                    temp=temp.next;
                }
                temp.next=new Node<>(data,null);
            }
            return head;
        }
    }
    static class Node<T>{
        T data;
        Node<T> next;
        Node(T data, Node<T> next){
            this.data=data;
            this.next=next;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>(Arrays.asList(2,4,6,7,9,0));
        list.stream().forEach(el->System.out.println(el));

        TestBuilder builder=new TestBuilder();
        Test t= builder.setB("ABC").buildTest();

        LinkedList<Integer> intList=new LinkedList<>();
        LinkedList<String> strList=new LinkedList<>();
        intList.insert(23);
        intList.insert(78);
        intList.insert(54);

        strList.insert("ACVC");
        strList.insert("TYJJN");
        strList.insert("YBJ");
        System.out.println(intList);

        char ch='a';
        System.out.println(ch+" "+(int)ch);
        int num=98;
        System.out.println(num+" "+(char)num);

        String str="Divya";
        char strArray[]=str.toCharArray();
        for(char c:strArray) System.out.print(c+" ");
        System.out.println("\n"+str+" ");
        String str2= new String(strArray);
        System.out.println(str2);

        longestSubstringWithoutRepitition("GEEKSFORGEEKS");
        longestSubstringWithoutRepitition("BBBB");


    }

    static void longestSubstringWithoutRepitition(String s){
        HashSet<Character> hs=new HashSet<>();
        int maxLen=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!hs.contains(ch)){
                hs.add(ch);
            }else{
                hs=new HashSet<>();
                hs.add(ch);
            }
            maxLen=Math.max(maxLen, hs.size());
        }
        System.out.println(hs);
        System.out.println("maxLen: "+maxLen);

    }

    static class Singleton{
        private int data;
        private Singleton s;
        private Singleton(int a){
            this.data=a;
        }

        public synchronized Singleton getSingletonObject(int a){
            if (s==null)
            return new Singleton(a);
            return s;
        }

    }

    static class Test{
        int a; 
        String b;

        Test(int a,String b){
            this.a=a;
            this.b=b;
        }

    }

    static class TestBuilder{
        int a; 
        String b;

        TestBuilder setA(int a){
            this.a=a;
            return this;
        }

        TestBuilder setB(String b){
            this.b=b;
            return this;
        }

        Test buildTest(){
            return new Test(a,b);
        }
    }
    
}
