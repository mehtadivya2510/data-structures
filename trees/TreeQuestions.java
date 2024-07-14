public class TreeQuestions {
    public static void main(String[] args) {
        //array representation of tree
    }

    public static void printRootToLeaf(TreeNode root){

    }

    public static void largestSubtreeSum(TreeNode root){

    }

    public static void lca(int v1, int v2, TreeNode root){

    }

    public static boolean lcaUtil(int v1, TreeNode node){
        if(node==null) return false;
        if(node.val==v1) return true;
        return lcaUtil(v1,node.left) || lcaUtil(v1, node.right);
    }

    public static void distanceBetweenTwoNodes(TreeNode root){

    }

    public static Boolean isSubtree(TreeNode root){

    }

    public static void isBST(TreeNode root){

    }
}
