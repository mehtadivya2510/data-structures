import java.util.Arrays;

public class ArrayExample {
    public static void main(String[] args) {
        int arr[]={10, 4, 5, 90, 80, 120};
        print(arr);
        waveArray(arr);
        print(arr);
    }

    static void twoProduct(int arr[],int product){
        int i=0,j=arr.length;
        Arrays.sort(arr);
        //for positive elements of the array
        while (i<j){
            if(arr[i]*arr[j]==product){
                System.out.println(i+" "+j);
                break;
            }else if(arr[i]*arr[j]<product){
                i++;
            }else {
                j--;
            }
        }
        //if neg elements present, use HASHING---- O(N)
    }

    static void waveArray(int arr[]){
        boolean flag=false;
        for(int i=0;i<arr.length-1;i++){
            if (!flag){
                if(arr[i]<arr[i+1])
                swap(i, i+1, arr);
            }else{
                if(arr[i]>arr[i+1])
                swap(i, i+1, arr);
            }
            flag=!flag;
        }  
    }
    static void swap(int i,int j, int arr[]){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    static void print(int arr[]){
        for(int item: arr){
            System.out.print(item+"-->");
        }
        System.out.println();
    }
}
