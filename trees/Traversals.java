import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Traversals {
    public static void main(String[] args) {
        Tree t1= Height.constructTree();
        preOrder(t1.root);
        System.out.println();
        postOrder(t1.root);
        System.out.println();
        inOrder(t1.root);
        System.out.println();
        levelOrderOrBFS(t1.root);
        System.out.println();
        reverseLevelOrder(t1.root);
        System.out.println();
        zigzagOrSpiral(t1.root);
    }

    //Depth First Traversals(DFS) of a Tree are preorder, postorder, inorder
    public static void preOrder(TreeNode root){
        if(root==null) return;
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void postOrder(TreeNode root){
        if(root==null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }

    public static void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    public static void inOrderIterative(TreeNode root){

    }

    public static void zigzagOrSpiral(TreeNode root){
        Queue<TreeNode> q1= new LinkedList<>();
        Queue<TreeNode> q2= new LinkedList<>();
        Stack<Integer> stack= new Stack<>();
        boolean flag= false;
        q2.add(root);
        while (!q1.isEmpty() || !q2.isEmpty()){
            if (!flag){
                while (!q2.isEmpty()){
                    TreeNode polled= q2.poll();
                    if(polled.left!=null) q1.add(polled.left);
                    if(polled.right!=null) q1.add(polled.right);
                    stack.push(polled.val);
                }
                while (!stack.isEmpty()){
                    System.out.print(stack.pop()+" ");
                }
                flag= true;
            }else {
                while (!q1.isEmpty()){
                    TreeNode polled= q1.poll();
                    if(polled.left!=null) q2.add(polled.left);
                    if(polled.right!=null) q2.add(polled.right);
                    System.out.print(polled.val+" ");
                }
                flag= false;
            }
        }
    }

    public static void boundary(TreeNode root){

    }

    public static void vertical(TreeNode root){
        //using Hashmap
    }

    public static void diagonal(TreeNode root){

    }

    public static void levelOrderOrBFS(TreeNode root){
        if(root==null) return;
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node= queue.poll();
            System.out.print(node.val+" ");
            if(node.left!=null) queue.add(node.left);
            if(node.right!=null) queue.add(node.right);
        }
    }

    public static void reverseLevelOrder(TreeNode root){
        if (root==null) return;
        Queue<TreeNode> queue= new LinkedList<>();
        Stack stack= new Stack<Integer>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node= queue.poll();
            stack.push(node.val);
            if (node.right!=null) queue.add(node.right);
            if (node.left!=null) queue.add(node.left);
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
}
