import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class LFUCache {

    int capacity;
    HashMap<Integer, FreqNode> hashMap;
    HashMap<Integer, LinkedHashSet<FreqNode>> freqMap;
    int minFreq;
    LFUCache(int capacity){
        this.capacity = capacity;
        hashMap=new HashMap<>(capacity);
        freqMap=new HashMap<>(capacity);
    }

    public void get(int key){
        if (hashMap.containsKey(key)){
            updateFreq(key);
            System.out.println(hashMap.get(key).value);
        }else {
            System.out.println(-1);
        }
    }

    public void updateFreq(int key){
        FreqNode node = hashMap.get(key);
        LinkedHashSet<FreqNode> oldSet=freqMap.get(node.freq);
        oldSet.remove(node);
        if (minFreq==node.freq && oldSet.isEmpty())
            minFreq++;
        node.freq++;
        freqMap.computeIfAbsent(node.freq, f-> new LinkedHashSet<>()).add(node);
    }

    public void put(int key, int value){
        if (hashMap.containsKey(key)){
            hashMap.put(key, new FreqNode(key,value));
            updateFreq(key);
            return;
        }

        if (hashMap.size()==capacity){  //eviction logic
            LinkedHashSet<FreqNode> set = freqMap.get(minFreq);
            FreqNode minFreqNode = set.iterator().next();
            set.remove(minFreqNode);
            hashMap.remove(minFreqNode.key);
        }

        FreqNode newNode= new FreqNode(key,value);
        hashMap.put(key,newNode);
        freqMap.computeIfAbsent(1, f->new LinkedHashSet<>()).add(newNode);
        minFreq=1;
    }

    public static void main(String[] args) {
        LFUCache lfuCache=new LFUCache(2);
        lfuCache.put(1,1);
        lfuCache.put(2,2);
        lfuCache.get(1);
        lfuCache.put(3,3);
        lfuCache.get(2);
        lfuCache.put(4,4);
        lfuCache.get(3);
        lfuCache.get(4);
    }
}

class FreqNode{
    int key;
    int value;
    int freq;
    FreqNode(int key, int value){
        this.key=key;
        this.value=value;
        this.freq=1;
    }

}