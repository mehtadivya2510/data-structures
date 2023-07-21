// Given the root of a binary tree, determine if it is a valid binary search tree (BST).

// A valid BST is defined as follows:

// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem3 {
    static ArrayList<Integer> in =new ArrayList<>(); 
    public static Boolean validBST(Node root){
        inOrder(root);
        for(int i=0;i<in.size()-1;i++){
            if(in.get(i)> in.get(i+1)){
                return false;
            }
        }
        return true;
    }

    public static void inOrder(Node root){
        if (root==null)
        return;
        inOrder(root.left);
        in.add(root.value);
        inOrder(root.right);
    }
 
    public static void main(String[] args) {
        // Node n1=new Node(1, null, null);
        // Node n3=new Node(3, null, null);
        // Node n2=new Node(2, n1, n3);
        // Tree t=new Tree(n2);

        // System.out.println("validBST: "+validBST(t.root));

        Node n7=new Node(7, null, null);
        Node n1=new Node(1, null, n7);
        Node n3=new Node(13, null, null);
        Node n6=new Node(16, null,null);
        Node n4=new Node(14, n3, n6);
        Node n5=new Node(10, n1, n4);

        Tree t=new Tree(n5);

        System.out.println("validBST: "+validBST(t.root));

        ArrayList<Integer> list=new ArrayList<>(Arrays.asList(2,6,8,9,23,12));
        List<Integer> list2=list.stream().filter(el-> el>=10).map(el->el*el).collect(Collectors.toList());
        System.out.println(list2);

    }

    static class Tree{
        Node root;
        Tree(Node root){
            this.root=root;
        }
    }

    static class Node{
        int value;
        Node left,right;
        Node(int val,Node left,Node right){
            this.value=val;
            this.left=left;
            this.right=right;
        }
    }
}
