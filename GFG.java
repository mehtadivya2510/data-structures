public class GFG {

	// Function to segregate even
	// odd numbers
	static void arrayEvenAndOdd(
			int arr[], int n)
	{

		int i = 0, j = n-1;
		//        while (j != n) {
		//            if (arr[j] % 2 == 0)
		//            {
		//                i++;
		//      
		//                // Swapping even and
		//                // odd numbers
		//                int temp = arr[i];
		//                arr[i] = arr[j];
		//                arr[j] = temp;
		//            }
		//            j++;
		//        }

		while (i<n && j>=0 && i<=j) {
			if (arr[i] % 2 == 0){
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j--;
			}else if (arr[i] % 2 != 0){
				i++;	
			}
		}


		for (int k = 0; k < n; k++)
			System.out.print(arr[k] + " ");
	}

	static void segregateEvenOddWithOrder(int[] arr) {
	    int countEven = 0;
	    int length = arr.length;
	    for (int i = 0; i < length; i++) {
	        if (arr[i]%2 == 0){
	            countEven++;
	        }
	    }
	    int i = 0;
	    int j = i+1;
	    while (i != countEven){
	        if (arr[i]%2 == 0){
	            i++;
	            j = i + 1;
	        }else if (arr[i]%2 == 1 && j < length){
	            int temp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = temp;
	            j++;
	        }
	    }
	    
	    for (int k = 0; k < arr.length; k++)
			System.out.print(arr[k] + " ");
	}
	    
	public static void main(String args[])
	{
		int arr[] = { 21,4,6,8,9,18,1,6,14,1,90};
		int n = arr.length;
		arrayEvenAndOdd(arr, n);
		System.out.println();
		segregateEvenOddWithOrder(arr);
		
	}
}
