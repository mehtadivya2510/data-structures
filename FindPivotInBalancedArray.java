//Balanced Array —- Coding

public class FindPivotInBalancedArray {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,6};
        
        System.out.println("Pivot: "+ balancedSum(arr));

    }

    static int balancedSum(int arr[]){
        int arraySum=0;
        for(int item: arr){
            arraySum+=item;
        }
        int sumUntilNow=0;
        for(int i=0;i<arr.length;i++){
            if ((arraySum-arr[i])/2 == sumUntilNow){
                return i;
            }
            sumUntilNow+=arr[i];
        } 
        return -1;
    }
}
