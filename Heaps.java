import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Heaps {
    public static void main(String[] args) {
        int arr[]={10, 4, 5, 90, 120, 80};

        kLargestElements(arr,3);

        String str="abcdaghbckjabac";
        firstKNonRepeatingCharInString(str);
    }

    static void kLargestElements(int arr[],int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>();    //min-heap
        for(int i=0;i<k;i++){
            pq.add(arr[i]);
        }

        for(int i=k;i<arr.length;i++){
            if(arr[i]>pq.peek()){
                pq.poll();
                pq.add(arr[i]);
            }
        }

        System.out.println(pq);
    }
    ArrayList<Integer> getNearestTrees(ArrayList<Integer> trees, ArrayList<Integer> persons) {
        ArrayList<Integer> res=new ArrayList<>();
            for(Integer i: persons){
                int min=Integer.MAX_VALUE;
                for(Integer j: trees){
                    int diff=Math.abs(i-j);
                    min=Math.min(min,diff);
                }
                res.add(min);
            }
        System.out.println(res);
        return res;
    }
    
    
    static void firstKNonRepeatingCharInString(String str){
        PriorityQueue<CharFreq> pq=new PriorityQueue<CharFreq>(new FreqComparator());    //max-heap
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if (map.containsKey(ch))
                map.put(ch, map.get(ch)+1);
            else
                map.put(ch,1);
        }

        for(Character ch: map.keySet()){
            pq.add(new CharFreq(ch, map.get(ch)));
        }

        while(!pq.isEmpty() && pq.peek().freq>1){
            pq.poll();
        }

        System.out.println(pq);

    }

    static class CharFreq{
        Character ch;
        Integer freq;
        Integer index;
        CharFreq(Character ch, Integer freq){
            this.ch=ch;
            this.freq=freq;
        }

        @Override
        public String toString() {
            return ("["+this.ch+" , "+this.freq+"]");
        }
    }

    static class FreqComparator implements Comparator<CharFreq>{
        @Override
        public int compare(CharFreq o1, CharFreq o2) {
            return (o1.freq>o2.freq)?-1:(o1.freq<o2.freq?1:0);
        }
    }
    
}

