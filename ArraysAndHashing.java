import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ArraysAndHashing {
	static int[] twoSum(int[] arr, int target) {
		LinkedList<Integer> list=new LinkedList<Integer>();
		for(int val: arr)
			list.add(val);
		Arrays.sort(arr);
		int res[]=new int[2];
		int i=0, j=arr.length-1;
		while(i<j){
			if(arr[i]+arr[j]==target){
				res[0]=arr[i];
				res[1]=arr[j];
				break;
			}else if(arr[i]+arr[j] > target){
				j--;
			}else{
				i++;
			}
		}
		res[0]=list.indexOf(res[0]);
		res[1]=list.lastIndexOf(res[1]);
		Arrays.sort(res);
		return res;
	}

	static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res=new LinkedList<>();
        Map<String,List<String>> hash=new HashMap<>();
        for (String val: strs) {
        	String temp=new String(val);
        	char str[]=temp.toCharArray();
        	Arrays.sort(str);
        	temp= new String(str);
        	if(hash.get(temp)==null) {
        		// hash.put(temp, new LinkedList<>(List.of(val)));
        	}else {
        		List<String> list=hash.get(temp);
        		list.add(val);
        		hash.put(temp,list);
        	}
        }
        for(String key: hash.keySet()) {
        	res.add(hash.get(key));
        }
        System.out.println(res);
        return res;
	}
	
	public static void main(String args[]){
		int[] temp=twoSum(new int[]{3,2,4}, 6);
		System.out.printf("[%d  %d]\n",temp[0], temp[1]);
		
		String strs[]=new String[]{"eat","tea","tan","ate","nat","bat"};
		groupAnagrams(strs);
	}
}