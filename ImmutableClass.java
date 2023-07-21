import java.util.HashMap;

final class ImmutableClass {
    private final int temp;
    public ImmutableClass(int temp){
        this.temp=temp;
    }

    public int getTemp(){
        return temp;
    }
    public static void main(String[] args) {
        AB a=new AB();
        Thread t1=new Thread();
        Thread t2=new Thread();
        t1.start();
        t2.start();

        System.out.println(2 + 3 + "hello");    //5hello

        System.out.println("hello" + 2 + 3);    //hello23

        System.out.println("hello" + 2 * 3);    //hello6


        String str= "pwwkweww";
        HashMap<Character, Integer> hm=new HashMap<>();
        int length=0;
        int longest=-1;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if (!hm.containsKey(ch)){
                hm.put(ch, i);
                length++;   
            }else{
                length=1;
                hm=new HashMap<>();
                hm.put(ch, i);
            }
            longest=Math.max(length,longest);
        }
        System.out.println(longest);
    
    }
    
}

class AB{
    synchronized public void m3(){
        //parallel execution
    }
    synchronized static public void m1(){
        //m1 will execute earlier
    }
    public void m2(){
        //m2 might wait
    }
}


// Given a string s, find the length of the longest substring without repeating characters.

// Example 1:
// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.

// Example 2:
// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.

// Example 3:
// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.