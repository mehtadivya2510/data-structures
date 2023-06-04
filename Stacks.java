import java.util.Stack;

public class Stacks {
    static Stack<Integer> st=new Stack<>();

    public static void main(String[] args) {
        //Reverse st using recursion
        for (int i=0;i<=25;i=i+5){st.push(i);}
        System.out.println("Original Stack");
 
        System.out.println(st);
 
        reverseStack();
 
        System.out.println("Reversed Stack");
 
        System.out.println(st);

        Stack<Integer> input=new Stack<>();
        Stack<Integer> output=new Stack<>();
        input.push(34);
        input.push(3);
        input.push(31);
        input.push(98);
        input.push(92);
        input.push(23);

        System.out.println("Before sorting: "+input);
        while(!input.isEmpty()){
            if(output.isEmpty())
                output.push(input.pop());
            else{
                sortStack(output,input.pop());
            }
        }
        System.out.println("After sorting: "+output);

        int temp=2467;
        System.out.println(Integer.toString(temp));

        int price[] = { 10, 4, 5, 90, 120, 80 };
        stockSpan(price);

        nextGreaterElement(price);

        int hist[] = { 3, 5, 1, 7, 5, 9 };
        histogram(hist);

    }

    static void minStack(){
        
    }

    static void sortStack(Stack<Integer> st,Integer el){
        if(st.isEmpty()){
            st.push(el);
            return;
        }
        if(st.peek()<=el){
            st.push(el);
        }else{
            int top=st.pop();
            sortStack(st, el);
            st.push(top);
        }
    }


    static void histogram(int[] hist){
        Stack<Integer> s=new Stack<>();
        int maxArea=0;
        s.push(0);
        int i;
        for(i=1;i<hist.length;i++){
            while(!s.empty() && hist[s.peek()]>hist[i]){
                int el=hist[s.pop()];
                int area= s.empty()?(el*i):el*(i-s.peek()-1);
                if(area>maxArea)
                maxArea=area;
            }
            s.push(i);
        }
        System.out.println(i);
        while(!s.empty()){
            int el=hist[s.pop()];
            int area= s.empty()?(el*i):el*(i-s.peek()-1);
            if(area>maxArea)
            maxArea=area;
        }
        System.out.println("maxArea: "+maxArea);

    }
    
    static void nextGreaterElement(int[] input){
        int nge[]=new int[input.length];

        Stack<Integer> s=new Stack<>();
        s.push(0);
        for(int i=1;i<input.length;i++){
            int curr=input[i];
            while(!s.empty() && curr>input[s.peek()]){
                nge[s.pop()]=curr;
            }
            s.push(i);
        }
        while(!s.empty()){
            nge[s.pop()]=-1;
        }

        System.out.print("Next Greater Element: ");
        for(int i=0;i<nge.length;i++){
            System.out.print(nge[i]+"-->");
        }
        System.out.println();

    }

    static void stockSpan(int[] price){
        int res[]=new int[price.length];
        res[0]=1;
        Stack<Integer> s=new Stack<>();
        s.push(0);
        for(int i=1;i<price.length;i++){
            int curr=price[i];
            
            if(curr>=price[s.peek()]){
                while(!s.empty() && curr>=price[s.peek()]){
                    s.pop();
                }
            }
            if(s.empty())
            res[i]=i+1;
            else
            res[i]=i-s.peek();
            s.push(i);
        }

        System.out.print("Stock Span res: ");
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+"-->");
        }
        System.out.println();
    }

    static void reverseStack(){
        if(st.isEmpty()){
            return;
        }
        int el=st.pop();
        reverseStack();
        insertIntoStack(el);
    }

    static void insertIntoStack(int el){
        if(st.isEmpty()) st.push(el);
        else{
            int temp=st.pop();
            insertIntoStack(el);
            st.push(temp);
        }
    }

}
