import java.util.LinkedList;
import java.util.Queue;

public class Trees {
    static int depth=0;
    static int size=0;
    static int diameter=0;
    public static void main(String[] args) {
        Node n1=new Node(19);
        Node n2=new Node(34);
        Node n6=new Node(89);
        Node n7=new Node(14);
        Node n3=new Node(46,n1,n2);
        Node n4=new Node(88,n6,n7);
        Node n5=new Node(23, n3,n4);
        Tree t=new Tree(n5);

        inorder(t.root);
        System.out.println();
        preorder(t.root);
        System.out.println();
        levelOrder(t.root);
        System.out.println("\nDepth: "+depth);
        System.out.println("\nSize: "+size);

        System.out.println("Is foldable: "+foldable(n5,n5));

        diameterOfTree(t.root,0);
        System.out.println("Diameter Of Tree: "+diameter);

        System.out.println(lca(19, 34,t.root).value);
        System.out.println(lca(23, 89,t.root).value);
        System.out.println(lca(19, 14,t.root).value);

        System.out.println(distanceBetweenNodes(19, 34,t.root));
        System.out.println(distanceBetweenNodes(23, 89,t.root));
        System.out.println(distanceBetweenNodes(19, 14,t.root));
        System.out.println(distanceBetweenNodes(19, 46,t.root));
    }

    static int distanceBetweenNodes(int n1,int n2,Node root){
        Node lca=lca(n1, n2, root);
        return (findDis(lca, n1, 0) + findDis(lca, n2, 0));
    }

    static int findDis(Node root,int val, int d){
        if (root==null) return 0;
        if (root.value==val)
        return d;
        int l=findDis(root.left,val,d+1);
        int r=findDis(root.right,val,d+1);
        return l>0?l:r;
    }

    static Node lca(int n1,int n2,Node root){
        if (root==null) return null;
        if(root.value==n1 || root.value==n2)
        return root;
        Node checkLeft=lca(n1,n2,root.left);
        Node checkRight=lca(n1,n2,root.right);
        if (checkLeft!=null && checkRight!=null)
        return root;
        return checkLeft!=null?checkLeft:checkRight;
    }


    static int diameterOfTree(Node root,int d){
        if (root==null)
        return 0;
        int leftD=diameterOfTree(root.left, d);
        int rightD=diameterOfTree(root.right, d);
        d=d+Math.max(leftD, rightD);
        diameter=Math.max(diameter, d);
        return Math.max(leftD, rightD);
    } 
    static Boolean foldable(Node n1,Node n2){
        if (n1==null && n2 ==null)
        return true;
        if (n1==null || n2 ==null)
        return false;
        return foldable(n1.left, n2.right) && foldable(n1.right, n2.left);
    }

    static void levelOrder(Node root){
        if (root==null)
        return;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        depth++;
        while(!q.isEmpty()){
            Node temp=q.poll();
            if(temp.left!=null || temp.right!=null)
            depth++;
            if (temp.left!=null)
            q.add(temp.left);
            if (temp.right!=null)
            q.add(temp.right);
            System.out.print(temp.value+"-->");
        }
    }

    static void preorder(Node root){
        if (root==null)
        return;
        size++;
        System.out.print(root.value+"-->");
        preorder(root.left);
        preorder(root.right);
    }

    static void inorder(Node root){
        if (root==null)
        return;
        inorder(root.left);
        System.out.print(root.value+"-->");
        inorder(root.right);
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
