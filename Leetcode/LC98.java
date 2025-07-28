package Leetcod;

public class LC98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root,null,null);
    }

    private boolean isValidBSTHelper(TreeNode node, Integer min, Integer max) {
        if (node==null) {
            return true;
        }

            if (min!=null && node.val<=min){
                return false;
            }
            if (max!=null && node.val>=max){
                return false;
            }

        return isValidBSTHelper(node.left,min, node.val)&&isValidBSTHelper(node.right, node.val,max);
    }
} class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}

