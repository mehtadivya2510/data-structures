public class DynamicProg {
    static void minNumberOfjumps(int arr[]){
        int jumps=0,farthest=0,currentFarthest=0;
        for(int i=0;i<arr.length;i++){
            farthest=Math.max(farthest,i+arr[i]);
            if(i==currentFarthest){
                jumps++;
                currentFarthest=farthest;
            }
        }
        System.out.println("Min Number Of jumps: "+jumps);
    }

    public static void main(String[] args) {
        minNumberOfjumps(new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9});
    }
}
