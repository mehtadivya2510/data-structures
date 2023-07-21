import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
 int val;
 TreeNode left;
 TreeNode right;
 TreeNode() {}
 TreeNode(int val) { this.val = val; }
 TreeNode(int val, TreeNode left, TreeNode right) {
 this.val = val;
 this.left = left;
 this.right = right;
 }

 void deepestSum(TreeNode root){
    int sum=0;
    if( root==null)
    sum=0;
    int maxLevel=0;
    Queue<Temp> q=new LinkedList<>();

    q.add(new Temp(root,0));
    while(!q.isEmpty()){
        Temp node=q.poll();
        maxLevel=Math.max(maxLevel,node.level);
        if (node.root.left!=null){
            q.add(new Temp(node.root.left, node.level+1));
        }
        if (node.root.right!=null){
            q.add(new Temp(node.root.right, node.level+1));
        }

    }


 }
 public static void main(String[] args) {
    
 }

 class Temp{
    TreeNode root;
    int level;
    Temp(TreeNode root, int level){
        this.root=root;
        this.level=level;
    }
 }
}
