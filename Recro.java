import java.util.Arrays;

public class Recro {
        public int[] twoSum(int[] arr, int target) {
            int temp[]=Arrays.copyOf(arr,arr.length);
            int res[]={-1,-1};
            Arrays.sort(temp);
            int i=0,j=arr.length-1;
            while (i<j){
                if(temp[i]+temp[j]==target){
                    res[0]=temp[i];
                    res[1]=temp[j];
                    break;
                }else if(temp[i]+temp[j]<target){
                    i++;
                }else{
                    j--;
                }
            }

            //find indexes
            for(int k=0;k<arr.length;k++){
                int elem=arr[k];
                if(elem==res[0]){
                    res[0]=k;
                }
                if(res[0]!=k && elem==res[1])
                    res[1]=k;
            }
            return res;
        }

        public String longestPalindrome(String s1) {
            int len=s1.length()+1;
            int arr[][]=new int[len][len];
            StringBuilder str=new StringBuilder(s1);
            str.reverse();
            String s2=new String(str);
            System.out.println(s1+" "+s2);
            for(int i=0;i<len;i++){
                for(int j=0;j<len;j++) {
                    if(i==0||j==0) {
                        arr[i][j] = 0;
                        continue;
                    }
                    if(s1.charAt(i-1)==s2.charAt(j-1)) {
                        arr[i][j]=arr[i-1][j-1]+1;
                    }else {
                        arr[i][j]=Math.max(arr[i-1][j],arr[i][j-1]);
                    }
                }
            }
            int max=arr[len-1][len-1];
            System.out.println(max);
            String res="";
            int i=len-1,j=len-1;
//            while (max>0){
//                if(arr[i][j])
//            }
            return res;
        }

    public static void main(String[] args) {

            Recro r=new Recro();
            int arr[]={3,3};
            int res[]=r.twoSum(arr,6);
            for(int el: res)
            System.out.print(el +" ");

            r.longestPalindrome("babad");

    }
}
