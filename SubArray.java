import java.util.ArrayList;

public class SubArray {
//    static ArrayList<ArrayList>
    public static void main(String[] args) {
        int arr[]={2,5,6,7,9,5,2,3,4,1};
        //2,5,6,7,9,5,2,3,4,1
        //print all subarrays with 2,5 and print numbers in between

        int n=arr.length;
        ArrayList<Integer> res=new ArrayList<>();
        getSubarrays(arr,0,0,arr.length);

    }

    static void getSubarrays(int[] arr, int i, int j, int len){
        if(j==len){
            return;
        }else if(i>j){
            getSubarrays(arr,0,j+1,len);
        }else {
            ArrayList<Integer> list=new ArrayList<>();
            for(int k=i;k<j;k++){
                list.add(arr[k]);
            }
            list.add(arr[j]);
            if(list.contains(2) && list.contains(5)){
                Boolean flag=true;
                for(int k=0;k<list.size();k++){
                    if(list.get(k)>5 || list.get(k)<2)
                        flag=false;
                }
                if(flag)
                    System.out.println(list);
            }
            getSubarrays(arr,i+1,j,len);
        }
        return;
    }
}
