public class Temp {
    public static void main(String[] args) {
        int arr[]={0,2,0,4};
        int output[]={0,0,0,0};
        int product=1;
        int count=0,index=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                index=i;
                count++;
            }else{
                product=product*arr[i];
            }
            
        }
        if(count==0){
            for(int i=0;i<arr.length;i++){
                output[i]=product/arr[i];
            }
        }else if (count==1){
            output[index]=product;
        }

        for(int i=0;i<output.length;i++){
            System.out.print(output[i]+" ");
        }
    }
}
