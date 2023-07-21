import java.util.*;

public class SlidingWindow {

    public static  void substringWithDistinctCharacter(String str, int k ){
        if(k>str.length())
            return;
        Map<Character,Integer> map=new HashMap<>();
        for (int i=0;i<k;i++){
            char ch= str.charAt(i);
            if(map.get(ch)==null)
                map.put(ch,1);
            else
                map.put(ch, map.get(ch)+1);
        }
        if(map.size()==k)
            System.out.println(map.keySet());

        for(int i=k;i<str.length();i++){
            char ch= str.charAt(i);
            char charTobeRemoved=str.charAt(i-k);
            int val=map.get(charTobeRemoved);
            if(val==1){
                map.remove(charTobeRemoved);
            }else
                map.put(charTobeRemoved,map.get(charTobeRemoved)-1);

            if(map.get(ch)==null) {
                map.put(ch, 1);
            }else {
                map.put(ch, map.get(ch)+1);
            }
            if(map.size()==k)
                System.out.println(map.keySet());
        }
    }

    public  static void sortArray(String[] s1, String s2[]){
    }

    public static void subarrayWithGivenSum(int[] arr, int target){
        int i=0,start=0,end=-1;
        int sum=0;
        while (i < arr.length && start<arr.length) {
            if(sum+arr[i]==target){
                end=i;
                for(int j=start;j<=end&&j<arr.length;j++)
                    System.out.print(arr[j]+" ");
                System.out.println("Found");
                return;
            }else if(sum+arr[i]<target){
                sum+=arr[i];
                i++;
            }else {
                sum-=arr[start];
                start++;
            }
        }
        System.out.println("Not found");
    }

    public static void allSubarrays(int arr[]){

    }
    public static void allSubsequences(int arr[],int n, ArrayList<Integer> res){      //powerSet
        if(n==arr.length){
            System.out.print(res+"  ");
            return;
        }
        res.add(arr[n]);
        allSubsequences(arr,n+1,res);
        res.remove(res.size()-1);
        allSubsequences(arr,n+1,res);
    }
    public static void allSubstrings(String str){

    }
    public static void allSubsequences(String str,int n, String res){      //powerSet
        if(n==0){
            System.out.print(res+"  ");
            return;
        }
        res+=str.charAt(n-1);
        allSubsequences(str,n-1,res);
        res=res.substring(0,res.length()-1);
        allSubsequences(str,n-1,res);
    }

    //asked in Adobe
    public static void slidingWindowMaximum(int arr[],int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());  //max heap
        for(int i=0;i<k;i++){
            pq.add(arr[i]);
        }
        System.out.print(pq.peek()+" ");
        for(int i=k;i<arr.length;i++){
            pq.remove(arr[i-k]);
            pq.add(arr[i]);
            System.out.print(pq.peek()+" ");
        }
    }

    public static void reverseWords(String str){
        System.out.println("\n"+str);
        String s[]= str.split(" ");
        Stack<String> stack=new Stack<>();
        for(String el: s){
            stack.push(el);
        }
        String res="";
        while (!stack.empty()){
            res+=stack.pop()+" ";
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        substringWithDistinctCharacter("abcdabbcdc",3);

        subarrayWithGivenSum(new int[]{ 15, 2, 4, 8, 9, 5, 10, 23,34 },0);

        sortArray(new String[]{"Giraffe","Camel","Tiger","Monkey","Rhino"}, new String[]{"Milk","Guava","Rust","Teeth","Crow"});

        ArrayList<Integer> arrSubsequences=new ArrayList<>();
        allSubsequences(new int[]{1,2,3},0,arrSubsequences);

        System.out.println();
        String input="abc";
        allSubsequences(input,input.length(),"");

        System.out.println();
        slidingWindowMaximum(new int[]{1,3,-1,-3,5,3,6,7},3);

        reverseWords("Hello my name is Divya");

    }
}
