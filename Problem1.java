// Given an array of strings strs , group the anagrams together. You can return the answer in any order.
// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
// typically using all the original letters exactly once.

// Input: strs = ["Eat","Tea","Tan","ate","nat","bat"]
// Output: [["bat"],["nat","Tan"],["ate","Eat","Tea"]] 


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Problem1{ 

    public static void groupAnagrams(String[] str){ //NMlogM
        HashMap<String, ArrayList<String>> hm=new HashMap<>();
        for(int i=0;i<str.length;i++){
            String item=new String(str[i]);
            char[] ch=item.toLowerCase().toCharArray();
            Arrays.sort(ch);
            String sortedString="";
            for(char character: ch){
                sortedString+=character;
            }
            
            if(!hm.containsKey(sortedString)){
                ArrayList<String> list=new ArrayList<>();
                list.add(str[i]);
                hm.put(sortedString, list);
            }else{
                ArrayList<String> temp=hm.get(sortedString);
                temp.add(str[i]);
                hm.put(sortedString, temp);
            }
        }
        System.out.println(hm);
    }

    public static void groupAnagramsTest(){

    }

    public static void main(String[] args) {
        String strs[] = {"Eat","Tea","Tan","ate","nat","bat"};
        groupAnagrams(strs);
    }
}
