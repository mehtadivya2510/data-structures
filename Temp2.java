import java.util.Stack;

public class Temp2{
    static void display(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[]={2,3,0,6,0,5};
        display(arr);
        int count=0;
        for(int item: arr){
            if (item==0)
            count++;
        }
        int temp[] = {0,0,0,0,0,0};
        for(int i=0;i<arr.length;i++)
        {
            if (arr[i]!=0)
            temp[count++]=arr[i];
        }
        display(temp);


        String input="[{{}}]]}";
        if (input.length()%2!=0)
        System.out.println("Invalid");
        else{
            Stack<Character> st=new Stack<>();
            for(int i=0;i<input.length();i++){
                Character ch=input.charAt(i);
                if (ch=='[' || ch=='{'|| ch=='('){
                    st.push(ch);
                }else if(ch==']'){
                    if(!st.empty() && st.peek()=='[')
                    st.pop();
                    else{
                        System.out.println("Invalid");
                        break;
                    }
                }else if(ch==')'){
                    if(!st.empty() && st.peek()=='(')
                    st.pop();
                    else{
                        System.out.println("Invalid");
                        break;
                    }
                }else if(ch=='}'){
                    if(!st.empty() && st.peek()=='{')
                    st.pop();
                    else{
                        System.out.println("Invalid");
                        break;
                    }
                } 
            }
            // if(st.empty())
            // System.out.println("Valid");
        }
    }
}