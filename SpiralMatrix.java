public class SpiralMatrix {
    public static void main(String[] args) {
        int arr[][]={{1,2,3},{4,5,6},{7,8,9}};
        // 1 2 3 6 9 8 7 4 5
        int m=arr.length;
        int n=arr[0].length;
        int i,k=0,j=0;
        System.out.print(arr[k][j]+" ");
        while(k<m && j<n){
            for(i=1;i<n;++i){
                System.out.print(arr[k][i]+" ");
            }
            k++;
            for(i=k;i<m;++i){
                System.out.print(arr[i][n-1]+" ");
            }
            n--;
            if(k<m){
                for(i=n-1;i>=j;--i){
                    System.out.print(arr[m-1][i]+" ");
                }
                m--;
            }
            if(j<n){
                for(i=m-1;i>=k;--i){
                    System.out.print(arr[i][j]+" ");
                }
                j++;
            }
        }

    }

}
