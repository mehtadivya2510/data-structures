import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    LinkedHashMap<Integer,Integer> map;
    int capacity;
    LRUCache(int capacity){
        this.capacity=capacity;
        map= new LinkedHashMap<>(capacity);
    }

    public void get(int key){
        if (map.containsKey(key)){
            int value= map.remove(key);
            map.put(key,value);
            System.out.println(value);;
        }else System.out.println(-1);;
    }

    public void put(int key, int value){
        if (!map.containsKey(key)){
            if (map.size()<capacity){
                map.put(key,value);
            }else {
                Map.Entry<Integer,Integer> firstEntry =map.firstEntry();
                map.remove(firstEntry.getKey());
                map.put(key,value);
            }
        }else {
            map.remove(key);
            map.put(key,value);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache=new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        lruCache.get(2);
        lruCache.put(4,4);
        lruCache.get(3);
        lruCache.get(4);
        lruCache.put(5,5);
    }
}
