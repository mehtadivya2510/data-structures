class Height{
    public static void main(String[] args){
        Tree t1= constructTree();
        System.out.println(getHeight(t1.root));
    }

    public static Tree constructTree(){
        TreeNode n5= new TreeNode(5);
        TreeNode n6= new TreeNode(6);
        TreeNode n7= new TreeNode(7);
        TreeNode n4= new TreeNode(4, n5, null);
        TreeNode n3= new TreeNode(3, n6, n7);
        TreeNode n2= new TreeNode(2, n4, null);
        TreeNode n1= new TreeNode(1, n2, n3);
        return new Tree(n1);
    }

    public static int getHeight(TreeNode root){
        if(root==null) return 0;
        if (root.left==null && root.right ==null) return 1;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

}

