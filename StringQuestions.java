public class StringQuestions {
    public  static void patternSearching(String txt, String target){
        int i=0,m=txt.length(),n=target.length();
        while (i<=m-n){
            String sub=txt.substring(i,i+n);
            if(target.equals(sub))
                System.out.println(i);
            i++;
        }

    }
    public static void main(String[] args) {
        patternSearching("AABAACAADAABAABA","AABA");
        patternSearching("GEEKSFORGEEKS","GEEKS");
    }
}
