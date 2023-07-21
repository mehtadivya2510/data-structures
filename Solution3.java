import java.util.HashMap;


public class Solution3 {
    static int solution(int N) {
        int arr[]=new int[256];
        int count=0;
        for(int i=0;i<16;i++){
            for(int j=0;j<16;j++){
                arr[count]=(int)(Math.pow(2,i)*Math.pow(3,j));
                count++;
            }
        }

        java.util.Arrays.sort(arr);
        return arr[N-1];
    }

    public static void main(String[] args) {
        System.out.println(solution(10));
    }
}


class Solution {
    public int solution(int[] A) {
        java.util.Arrays.sort(A);
        int index=1;
        for(int i=0;i<A.length;i++){
            if(A[i]==index)
            index++;
        }
        return index;
    }
}

class Solution2 {
    public int solution(String S) {
        HashMap<Character, Integer> hm=new HashMap<>();
        for(int i=0;i<S.length();i++){
            Character ch= S.charAt(i);
            if (hm.containsKey(ch)){
                hm.put(ch, hm.get(ch)+1);
            }else{
                hm.put(ch,1);
            }
        }
        int delete=0;
        for(Character key: hm.keySet()){
            if (hm.get(key)%2!=0)
            delete++;
        }
        return delete;
    }
}