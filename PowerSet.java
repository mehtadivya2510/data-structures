import java.util.ArrayList;

public class PowerSet {
    static void powerSet(int arr[], int n, ArrayList<Integer> res){
        if(n==0){
            System.out.println(res);
            return;
        }
        res.add(arr[n-1]);
        powerSet(arr, n-1, res);
        res.remove(res.size()-1);
        powerSet(arr, n-1, res);
    }
    public static void main(String[] args) {
        int arr[]={1,2,3};
        ArrayList<Integer> res=new ArrayList<>();
        powerSet(arr, arr.length,res);

    }
}
