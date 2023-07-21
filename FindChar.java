import java.util.*;

public class FindChar {

    public static String solution(String S) {
        Set<Character> lowerSet=new HashSet<Character>();
        Set<Character> upperSet=new HashSet<Character>();
        for(int i=0;i<S.length();i++){
            Character ch=S.charAt(i);
            if(ch>='a'&& ch<='z')
            lowerSet.add(ch);
            else
            upperSet.add(ch);
        }

        Character res=null;
        for(Character ch: upperSet){
            if (lowerSet.contains(Character.toLowerCase(ch))){
                if (res==null || ch>res)
                res=ch;
            }
        }
        if (res==null)
        return "NO";
        return res.toString();
    }

    public int solution2(int[] P, int[] S) {
        int res = 0;
        int totalPass=0;
        for(int item: P)
        totalPass+=item;

        //reverse
        for(int i = 0; i < S.length / 2; i++) {
            int j = S[i];
            S[i] = S[S.length - i - 1];
            S[S.length - i - 1] = j;
        }

        for(int item: S){
            if(totalPass-item>0){
                totalPass = totalPass - item;
                res+=1;
            }
            else{
                res+=1;
            }
        }
        return res;

    }

    public static int solution3(int[] prices) {
        int max=0;
        Boolean flag=true;
        for (int i = 0; i < prices.length-1; i++) {
            if(flag){
                if(prices[i]>prices[i+1]){
                    max+=prices[i];
                    flag=!flag;
                }else
                continue;
            }else{
                if(prices[i]<prices[i+1]){
                    max-=prices[i];
                    flag=!flag;
                }else
                continue;
            }
        }
        if (((Integer)max).toString().length()>9){
            String str=((Integer)max).toString();
            return Integer.parseInt((str.substring(str.length()-9)));
        }

        if (flag)
        max+=prices[prices.length-1];
        return max;
    }



    public static void main(String[] args) {
            System.out.println(solution("aaBabcDaA"));

            System.out.println(solution3(new int[]{1000000000,1,2,2,1000000000,1,1000000000}));
    }
}


// def solution(P, S):
//     totalPass = sum(P)
//     res = 0
//     S.sort(reverse=True)
//     for i in S:
//         if totalPass - i > 0:
//             totalPass = totalPass - i
//             res += 1
//         else:
//             res += 1
//             return res