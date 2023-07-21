import java.util.ArrayList;
import java.util.Arrays;

public class Problem {

    public static void main(String[] args) {
        int arr[]={-1,-1,0,1,2,4};

        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        int n=arr.length;
        for(int i=0;i<n-2;i++){
            int j=i+1,k=n-1;
            while(j<k){
                int sum=arr[i]+arr[j]+arr[k];
                if (sum==0){
                    res.add(new ArrayList<>(Arrays.asList(arr[i],arr[j],arr[k])));
                    break;
                }
                else if (sum>0){
                    k--;
                }else{
                    j++;
                }
            }
        }
        System.out.println(res);
    }
    
}
