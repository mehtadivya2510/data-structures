import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

public class Epam {
    static int maxPathSum=0;
    static void groupAnagrams(){

    }

    static void moveListbyKPlaces(int k){
        LinkedList list=new LinkedList<>();
        list.add(Arrays.asList(56,98,22,89,43,6,15));
        for(int i=0;i<k;i++){

        }
        System.out.println(list);
        
    }

    static int maxPathSumInTree(Node root){
        if(root==null)
        return 0;
        int left=maxPathSumInTree(root.left);
        int right=maxPathSumInTree(root.right);
        int temp1= Math.max(root.value,root.value+Math.max(left, right));
        int temp2=Math.max(temp1,root.value+left+right);
        maxPathSum=Math.max(maxPathSum, temp2);
        return temp1;
    }

    public static void main(String[] args) {


        Node n1=new Node(19);
        Node n2=new Node(34);
        Node n6=new Node(89);
        Node n7=new Node(14);
        Node n3=new Node(46,n1,n2);
        Node n4=new Node(88,n6,n7);
        Node n5=new Node(23, n3,n4);
        Tree t=new Tree(n5);

        moveListbyKPlaces(3);
        maxPathSumInTree(t.root);
        System.out.println("maxPathSumInTree: "+maxPathSum);
        
    }

    static class Tree{
        Node root=null;
        Tree(Node root){
            this.root=root;
        }
    }

    static class Node{
        int value;
        Node left;
        Node right;
        Node(int val,Node l, Node r){
            this.value=val;
            this.left=l;
            this.right=r;
        }
        Node(int val){
            this.value=val;
            this.left=null;
            this.right=null;
        }
    }
    
}

